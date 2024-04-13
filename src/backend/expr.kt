package backend

abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
}

class NoneExpr(): Expr() {
    override fun eval(runtime:Runtime) = None
}

class ParenthesizedExpression(private val expression: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        return expression.eval(runtime)
    }
}

enum class Operator {
    ADD, SUB, MUL, DIV
}

class Arithmetic(val operator: Operator, val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftResult = left.eval(runtime)
        val rightResult = right.eval(runtime)

        // Handle string concatenation for multiply operation.
        if (operator == Operator.MUL && leftResult is StringData && rightResult is IntData) {
            return StringData(leftResult.value.repeat(rightResult.value))
        }

        if (operator == Operator.MUL && leftResult is IntData && rightResult is StringData) {
            return StringData(rightResult.value.repeat(leftResult.value))
        }

        // Ensure both operands are IntData for arithmetic operations.
        if (leftResult !is IntData || rightResult !is IntData) {
            throw RuntimeException("Non-integer operands for arithmetic operation")
        }

        return when (operator) {
            Operator.ADD -> IntData(leftResult.value + rightResult.value)
            Operator.SUB -> IntData(leftResult.value - rightResult.value)
            Operator.MUL -> IntData(leftResult.value * rightResult.value)  // Numeric multiplication.
            Operator.DIV -> IntData(leftResult.value / rightResult.value)
        }
    }
}

class Assign(val name: String, val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val value = expr.eval(runtime)
        runtime.symbolTable[name] = value
        return None
    }
}

class Deref(
    val name:String
): Expr() {
    override fun eval(runtime:Runtime):Data {
        val v = runtime.symbolTable[name]
        if(v != null) {
            return v
        } else {
            return None
        }
    }
}

class Invoke(
    val funcname: String,
    val arguments: List<Expr>
) : Expr() {
    override fun eval(runtime:Runtime): Data {
        val f = runtime.symbolTable[funcname]
        if(f == null) {
            throw Exception("$funcname does not exist.")
        }
        if(f !is FunctionData) {
            throw Exception("$funcname is not a function.")
        }
        if(arguments.size != f.parameters.size) {
            throw Exception("$funcname expects ${f.parameters.size} arguments, but ${arguments.size} given.")
        }
        
        // evaluate each argument to a data
        val argumentData = arguments.map {
            it.eval(runtime)
        }

        // create a subscope and evaluate the body using the subscope
        return f.body.eval(runtime.subscope(
            f.parameters.zip(argumentData).toMap()
        ))
    }
}

class Block(val exprs:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data
    = exprs.map { it.eval(runtime) }.last()
}

class FunctionDef(val name: String, val parameters: List<String>, val body: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val functionData = FunctionData(name, parameters, body)
        runtime.symbolTable[name] = functionData
        return None
    }
}

class Loop(val init: Assign, val condition: Expr, val post: Assign, val body: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        init.eval(runtime)
        while ((condition.eval(runtime) as BooleanData).value) {
            body.eval(runtime)
            post.eval(runtime) // Correctly increment the loop variable.
        }
        return None
    }
}


class StringLiteral(val lexeme:String):Expr() {
    private val strippedValue = lexeme.trim('"')

    override fun eval(runtime: Runtime): Data =
        StringData(strippedValue)
}

class IntLiteral(val lexeme:String):Expr() {
    override fun eval(runtime:Runtime):Data 
    = IntData(Integer.parseInt(lexeme))
}

class BooleanLiteral(val lexeme:String):Expr() {
    override fun eval(runtime:Runtime): Data = 
    BooleanData(lexeme.equals("true"))
}

class Print(
    val exprs: List<Expr>
): Expr() {
    override fun eval(runtime:Runtime): Data {
        exprs.forEach {
            val data = it.eval(runtime)
            println(data)
        }
        return None
    }
}

class Concat(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftEval = left.eval(runtime)
        val rightEval = right.eval(runtime)

        // Ensure both sides are string data; otherwise, you may want to handle type mismatches.
        if (leftEval is StringData && rightEval is StringData) {
            return StringData(leftEval.value + rightEval.value)
        } else {
            // Handle error or perform type coercion as necessary.
            throw RuntimeException("Concatenation operands must be strings.")
        }
    }
}

enum class CmpOperators {
    LT,
    GT,
    LTEQ,
    GTEQ,
    EQ,
}

class Cmp(
    val op:CmpOperators,
    val left:Expr,
    val right:Expr
) : Expr() {
    override fun eval(runtime:Runtime): Data {
        val x:Data = left.eval(runtime)
        val y:Data = right.eval(runtime)

        if(x is IntData && y is IntData) {
            val result = when(op) {
                CmpOperators.LT -> x.value < y.value
                CmpOperators.GT -> x.value > y.value
                CmpOperators.EQ -> x.value == y.value
                CmpOperators.LTEQ -> x.value <= y.value
                CmpOperators.GTEQ -> x.value >= y.value
            }
            return BooleanData(result)
        } else {
            throw Exception("Cannot perform comparison")
        }
    }
}

class Ifelse(
    val cond: Expr,
    val trueExpr: Expr,
    val falseExpr: Expr
) : Expr() {
    override fun eval(runtime:Runtime): Data {
        val result = cond.eval(runtime) as BooleanData
        return if(result.value) {
            trueExpr.eval(runtime)
        } else {
            falseExpr.eval(runtime)
        }
    }
}

enum class Type {
    NUMBER,
    STRING,
    BOOLEAN
}