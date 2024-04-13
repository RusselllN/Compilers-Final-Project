package backend

abstract class Expr {
    abstract fun eval(runtime:Runtime):Data
    abstract fun typeCheck(runtime: Runtime): Type
}

class NoneExpr(): Expr() {
    override fun eval(runtime:Runtime) = None
    override fun typeCheck(runtime: Runtime) = Type.NONE
}

class ParenthesizedExpression(private val expression: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        return expression.eval(runtime)
    }

    override fun typeCheck(runtime: Runtime): Type {
        return expression.typeCheck(runtime)
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

    override fun typeCheck(runtime: Runtime): Type {
        val leftType = left.typeCheck(runtime)
        val rightType = right.typeCheck(runtime)

        if (leftType != Type.NUMBER && rightType != Type.NUMBER) {
            throw RuntimeException("Non-integer operands for arithmetic operation")
        }

        return Type.NUMBER
    }
}

class Assign(val name: String, val expr: Expr, val type: Type?) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val value = expr.eval(runtime)
        if (value.type != type) {
            throw RuntimeException("Type mismatch: ${value.type} and ${type}")
        }
        runtime.symbolTable[name] = value
        return None
    }

    override fun typeCheck(runtime: Runtime): Type {
        val exprType = expr.typeCheck(runtime)
        if (type != null && exprType != type) {
            throw RuntimeException("Type mismatch: $exprType and $type")
        }
        return exprType
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

    override fun typeCheck(runtime: Runtime): Type {
        val v = runtime.symbolTable[name]
        if(v != null) {
            return v.type
        } else {
            throw RuntimeException("Variable $name not found.")
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

    override fun typeCheck(runtime: Runtime): Type {
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

        val argumentTypes = arguments.map {
            it.typeCheck(runtime)
        }

        val expectedTypes = f.parameters.map { Type.STRING }
        if(argumentTypes != expectedTypes) {
            throw Exception("Argument types do not match. Expected: $expectedTypes, but found: $argumentTypes")
        }

        return f.returnType
    }
}

class Block(val exprs:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data
    = exprs.map { it.eval(runtime) }.last()

    override fun typeCheck(runtime: Runtime): Type {
        return exprs.map { it.typeCheck(runtime) }.last()
    }
}

class FunctionDef(val name: String, val parameters: List<String>, val body: Expr, val returnType: Type) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val functionData = FunctionData(name, parameters, body, returnType)
        runtime.symbolTable[name] = functionData
        return None
    }

    override fun typeCheck(runtime: Runtime): Type {
        val subscope = runtime.subscope(mapOf(name to FunctionData(name, parameters, body, returnType)))
        return body.typeCheck(subscope)
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

    override fun typeCheck(runtime: Runtime): Type {
        val conditionType = condition.typeCheck(runtime)

        if (conditionType != Type.BOOL) {
            throw RuntimeException("Condition must be a boolean")
        }

        return conditionType
    }
}


class StringLiteral(val lexeme:String):Expr() {
    private val strippedValue = lexeme.trim('"')

    override fun eval(runtime: Runtime): Data =
        StringData(strippedValue)

    override fun typeCheck(runtime: Runtime): Type = Type.STRING
}

class IntLiteral(val lexeme:String):Expr() {
    override fun eval(runtime:Runtime):Data 
    = IntData(Integer.parseInt(lexeme))

    override fun typeCheck(runtime: Runtime): Type = Type.NUMBER
}

class BooleanLiteral(val lexeme:String):Expr() {
    override fun eval(runtime:Runtime): Data = 
    BooleanData(lexeme.equals("true"))

    override fun typeCheck(runtime: Runtime): Type = Type.BOOL
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

    override fun typeCheck(runtime: Runtime): Type {
        exprs.forEach {
            it.typeCheck(runtime)
        }
        return Type.NONE
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

    override fun typeCheck(runtime: Runtime): Type {
        val leftType = left.typeCheck(runtime)
        val rightType = right.typeCheck(runtime)

        if (!(leftType == Type.STRING && rightType == Type.NUMBER) && 
            !(leftType == Type.NUMBER && rightType == Type.STRING) && 
            !(leftType == Type.STRING && rightType == Type.STRING)) {
            throw RuntimeException("Expecting at least one string and a number or two strings. Found: $leftType and $rightType")
        }

        return Type.STRING
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

    override fun typeCheck(runtime: Runtime): Type {
        val leftType = left.typeCheck(runtime)
        val rightType = right.typeCheck(runtime)

        if (leftType != rightType) {
            throw RuntimeException("Error: Cannot compare ${leftType} to ${rightType}")
        }

        return Type.BOOL
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

    override fun typeCheck(runtime: Runtime): Type {
        val condType = cond.typeCheck(runtime)
        val trueType = trueExpr.typeCheck(runtime)
        val falseType = falseExpr.typeCheck(runtime)

        if (condType != Type.BOOL) {
            throw RuntimeException("Condition must be a boolean.")
        }

        if (trueType != falseType) {
            throw RuntimeException("Type mismatch in if-else expression.")
        }

        return trueType
    }
}

enum class Type {
    NUMBER,
    STRING,
    BOOL,
    FUNC, 
    NONE
}