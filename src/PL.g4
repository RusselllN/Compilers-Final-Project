grammar PL;

@header {
import backend.*;
}

@members {
}

program returns [Expr expr]
    : stmt=statement* EOF {
        List<Expr> stmtList = new ArrayList<Expr>();
        for (StatementContext stmtCtx : ((ProgramContext)_localctx).statement()) {
            stmtList.add(stmtCtx.statementResult);
        }
        $expr = new Block(stmtList);
    }
;
    
statement returns [Expr statementResult]
    : assignment SEMICOLON { $statementResult= $assignment.var; }
    | expression SEMICOLON { $statementResult= $expression.expressionValue; }
    | printStatement SEMICOLON { $statementResult= $printStatement.printValue; }
    | loop { $statementResult= $loop.loopResult; }
    | funDef { $statementResult= $funDef.funcResult; }
    | ifStatement { $statementResult = $ifStatement.ifelseResult; }
    ;
    
block returns [Block blockValue]
    : { List<Expr> stmtList = new ArrayList<Expr>(); }
      (statement { stmtList.add($statement.statementResult); })*
      { $blockValue = new Block(stmtList); }
    ;

    
expression returns [Expr expressionValue, Type t]
    : OPEN_BRACE expression CLOSE_BRACE {$expressionValue = new ParenthesizedExpression($expression.expressionValue); $t = $expression.t;}
    | e1=expression ADD e2=expression {
        $expressionValue = new Arithmetic(Operator.ADD, $e1.expressionValue, $e2.expressionValue);
        $t = Type.NUMBER;
    }
    | e1=expression SUB e2=expression {
        $expressionValue = new Arithmetic(Operator.SUB, $e1.expressionValue, $e2.expressionValue);
        $t = Type.NUMBER;
    }
    | e1=expression MUL e2=expression {
        $expressionValue = new Arithmetic(Operator.MUL, $e1.expressionValue, $e2.expressionValue);
        $t = Type.NUMBER;
    }
    | e1=expression DIV e2=expression {
        $expressionValue = new Arithmetic(Operator.DIV, $e1.expressionValue, $e2.expressionValue);
        $t = Type.NUMBER;
    }
    | e1=expression LT e2=expression {
        $expressionValue = new Cmp(CmpOperators.LT, $e1.expressionValue, $e2.expressionValue);
        $t = Type.BOOL;
    }
    | e1=expression GT e2=expression {
        $expressionValue = new Cmp(CmpOperators.GT, $e1.expressionValue, $e2.expressionValue);
        $t = Type.BOOL;
    }
    | e1=expression EQ e2=expression {
        $expressionValue = new Cmp(CmpOperators.EQ, $e1.expressionValue, $e2.expressionValue);
        $t = Type.BOOL;
    }
    | e1=expression LTEQ e2=expression {
        $expressionValue = new Cmp(CmpOperators.LT, $e1.expressionValue, $e2.expressionValue);
        $t = Type.BOOL;
    }
    | e1=expression GTEQ e2=expression {
        $expressionValue = new Cmp(CmpOperators.GT, $e1.expressionValue, $e2.expressionValue);
        $t = Type.BOOL;
    }
    | invoke { $expressionValue = $invoke.invokeValue; $t = Type.FUNC;}
    | ID { 
        $expressionValue = new Deref($ID.text);
    }
    | NUMERIC { $expressionValue = new IntLiteral($NUMERIC.text); $t = Type.NUMBER; }
    | STRING { $expressionValue = new StringLiteral($STRING.text); $t = Type.STRING; }
    | BOOLEAN { $expressionValue = new BooleanLiteral($BOOLEAN.text); $t = Type.BOOL; }
    // If both tyes are not string, then we have a problem
    | e1=expression CONCAT e2=expression {
        if ($e1.t != Type.STRING && $e2.t != Type.STRING) {
            throw new IllegalArgumentException("Type mismatch: at least one operand of a CONCAT operation must be a string");
        }
        $expressionValue = new Concat($e1.expressionValue, $e2.expressionValue);
        $t = Type.STRING;
    }
    ;

invoke returns [Invoke invokeValue]
    : ID OPEN_BRACE expressions CLOSE_BRACE {
        $invokeValue = new Invoke($ID.text, $expressions.expressionListValue);
    }
    ;
    
assignment returns [Assign var]
    : ID EQUAL expression {
        $var = new Assign($ID.text, $expression.expressionValue, $expression.t);
    }
    ;
    
loop returns [Loop loopResult]
    : FOR_STATEMENT OPEN_BRACE ID 'in' from=NUMERIC RANGE to=NUMERIC CLOSE_BRACE OPEN_BLOCK block CLOSE_BLOCK { 
            $loopResult = new Loop(
                new Assign($ID.text, new IntLiteral($from.text), Type.NUMBER),
                new Cmp(CmpOperators.LTEQ, new Deref($ID.text), 
                new IntLiteral($to.text)), 
                new Assign($ID.text, new Arithmetic(Operator.ADD, new Deref($ID.text), new IntLiteral("1")), Type.NUMBER), 
                $block.blockValue
            ); 
        }
    ;
    
ifStatement returns [Ifelse ifelseResult]
    : IF_STATEMENT expression OPEN_BLOCK ifBlock=block CLOSE_BLOCK (ELSE_STATEMENT OPEN_BLOCK elseBlock=block CLOSE_BLOCK)? {
        Expr elseExpr = $ifBlock.blockValue != null ? $elseBlock.blockValue : new NoneExpr();
        $ifelseResult = new Ifelse($expression.expressionValue, $ifBlock.blockValue, elseExpr);
    }
    ;

    
funDef returns [FunctionDef funcResult]
    : FUNC_STATEMENT  id=ID OPEN_BRACE p=params CLOSE_BRACE OPEN_BLOCK block CLOSE_BLOCK { 
            $funcResult = new FunctionDef($id.text, $p.paramList, $block.blockValue, Type.NONE); 
        }
    ;
    
printStatement returns [Print printValue]
    : PRINT OPEN_BRACE (expressions | (expression CONCAT expression)*) CLOSE_BRACE { $printValue = new Print($expressions.expressionListValue); }
    ;
    
params returns [List<String> paramList]
    : { $paramList = new ArrayList<>(); } 
      (ID { $paramList.add($ID.text); } 
      (COMMA ID { $paramList.add($ID.text); })* )
    ;

expressions returns [List<Expr> expressionListValue]
    : { $expressionListValue = new ArrayList<Expr>(); } 
      (expression { $expressionListValue.add($expression.expressionValue); } 
      (COMMA expression { $expressionListValue.add($expression.expressionValue); })* )
    ;

type returns [Type t]
    : TYPE_NUMBER { $t = Type.NUMBER; }
    | TYPE_STRING { $t = Type.STRING; }
    | TYPE_BOOLEAN { $t = Type.BOOL; }
    ;

// Types
TYPE_NUMBER : 'number';
TYPE_STRING : 'string';
TYPE_BOOLEAN : 'bool';

// Statements
FOR_STATEMENT : 'for';
FUNC_STATEMENT : 'function';
PRINT : 'print';
IF_STATEMENT : 'if';
ELSE_STATEMENT : 'else';

RANGE : '..';

CONCAT : '++';
// NUMERIC : ('0'..'9')+ ('.' ('0'..'9')*)?;
NUMERIC : ('0'..'9')+;
STRING : '"' ('\\"' | ~'"')* '"';
BOOLEAN : 'true' | 'false';
ID : ('a'..'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
EQUAL : '=';
LT : '<' ;
GT : '>' ;
EQ : '==' ;
LTEQ : '<=' ;
GTEQ : '>=' ;
OPEN_BRACE : '(';
CLOSE_BRACE : ')';
OPEN_BLOCK : '{';
CLOSE_BLOCK : '}';
COMMA : ',';
SEMICOLON : ';';



COMMENT      : '/*' .*? '*/' -> skip;

WHITESPACE : [ \t\r\n]+ -> skip;
