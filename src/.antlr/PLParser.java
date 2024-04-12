// Generated from /home/levi/csci4020/Compilers-Final-Project/src/PL.g4 by ANTLR 4.13.1

import backend.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, FOR_STATEMENT=2, FUNC_STATEMENT=3, PRINT=4, IF_STATEMENT=5, ELSE_STATEMENT=6, 
		RANGE=7, CONCAT=8, NUMERIC=9, STRING=10, BOOLEAN=11, ID=12, ADD=13, SUB=14, 
		MUL=15, DIV=16, EQUAL=17, LT=18, GT=19, EQ=20, LTEQ=21, GTEQ=22, OPEN_BRACE=23, 
		CLOSE_BRACE=24, OPEN_BLOCK=25, CLOSE_BLOCK=26, COMMA=27, SEMICOLON=28, 
		COMMENT=29, WHITESPACE=30;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_expression = 3, 
		RULE_assignment = 4, RULE_loop = 5, RULE_ifStatement = 6, RULE_funDef = 7, 
		RULE_printStatement = 8, RULE_params = 9, RULE_expressions = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "block", "expression", "assignment", "loop", 
			"ifStatement", "funDef", "printStatement", "params", "expressions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'in'", "'for'", "'function'", "'print'", "'if'", "'else'", "'..'", 
			"'++'", null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'='", "'<'", 
			"'>'", "'=='", "'<='", "'>='", "'('", "')'", "'{'", "'}'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "FOR_STATEMENT", "FUNC_STATEMENT", "PRINT", "IF_STATEMENT", 
			"ELSE_STATEMENT", "RANGE", "CONCAT", "NUMERIC", "STRING", "BOOLEAN", 
			"ID", "ADD", "SUB", "MUL", "DIV", "EQUAL", "LT", "GT", "EQ", "LTEQ", 
			"GTEQ", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_BLOCK", "CLOSE_BLOCK", "COMMA", 
			"SEMICOLON", "COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public StatementContext stmt;
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8396348L) != 0)) {
				{
				{
				setState(22);
				((ProgramContext)_localctx).stmt = statement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);

			        List<Expr> stmtList = new ArrayList<Expr>();
			        for (StatementContext stmtCtx : ((ProgramContext)_localctx).statement()) {
			            stmtList.add(stmtCtx.statementResult);
			        }
			        ((ProgramContext)_localctx).expr =  new Block(stmtList);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Expr statementResult;
		public AssignmentContext assignment;
		public ExpressionContext expression;
		public PrintStatementContext printStatement;
		public LoopContext loop;
		public FunDefContext funDef;
		public IfStatementContext ifStatement;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(PLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((StatementContext)_localctx).assignment = assignment();
				setState(32);
				match(SEMICOLON);
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).assignment.var; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				((StatementContext)_localctx).expression = expression(0);
				setState(36);
				match(SEMICOLON);
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).expression.expressionValue; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				((StatementContext)_localctx).printStatement = printStatement();
				setState(40);
				match(SEMICOLON);
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).printStatement.printValue; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				((StatementContext)_localctx).loop = loop();
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).loop.loopResult; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				((StatementContext)_localctx).funDef = funDef();
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).funDef.funcResult; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				((StatementContext)_localctx).ifStatement = ifStatement();
				 ((StatementContext)_localctx).statementResult =  ((StatementContext)_localctx).ifStatement.ifelseResult; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public Block blockValue;
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> stmtList = new ArrayList<Expr>(); 
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8396348L) != 0)) {
				{
				{
				setState(55);
				((BlockContext)_localctx).statement = statement();
				 stmtList.add(((BlockContext)_localctx).statement.statementResult); 
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((BlockContext)_localctx).blockValue =  new Block(stmtList); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expr expressionValue;
		public ExpressionContext e1;
		public ExpressionContext expression;
		public Token ID;
		public ExpressionsContext expressions;
		public Token NUMERIC;
		public Token STRING;
		public Token BOOLEAN;
		public ExpressionContext e2;
		public TerminalNode OPEN_BRACE() { return getToken(PLParser.OPEN_BRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(PLParser.CLOSE_BRACE, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode NUMERIC() { return getToken(PLParser.NUMERIC, 0); }
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(PLParser.BOOLEAN, 0); }
		public TerminalNode ADD() { return getToken(PLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PLParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(PLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PLParser.DIV, 0); }
		public TerminalNode LT() { return getToken(PLParser.LT, 0); }
		public TerminalNode GT() { return getToken(PLParser.GT, 0); }
		public TerminalNode EQ() { return getToken(PLParser.EQ, 0); }
		public TerminalNode LTEQ() { return getToken(PLParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(PLParser.GTEQ, 0); }
		public TerminalNode CONCAT() { return getToken(PLParser.CONCAT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(66);
				match(OPEN_BRACE);
				setState(67);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(68);
				match(CLOSE_BRACE);
				((ExpressionContext)_localctx).expressionValue =  new ParenthesizedExpression(((ExpressionContext)_localctx).expression.expressionValue); 
				}
				break;
			case 2:
				{
				setState(71);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(72);
				match(OPEN_BRACE);
				setState(73);
				((ExpressionContext)_localctx).expressions = expressions();
				setState(74);
				match(CLOSE_BRACE);
				 ((ExpressionContext)_localctx).expressionValue =  new Invoke((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).expressions.expressionListValue); 
				}
				break;
			case 3:
				{
				setState(77);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).expressionValue =  new Deref((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 4:
				{
				setState(79);
				((ExpressionContext)_localctx).NUMERIC = match(NUMERIC);
				 ((ExpressionContext)_localctx).expressionValue =  new IntLiteral((((ExpressionContext)_localctx).NUMERIC!=null?((ExpressionContext)_localctx).NUMERIC.getText():null)); 
				}
				break;
			case 5:
				{
				setState(81);
				((ExpressionContext)_localctx).STRING = match(STRING);
				 ((ExpressionContext)_localctx).expressionValue =  new StringLiteral((((ExpressionContext)_localctx).STRING!=null?((ExpressionContext)_localctx).STRING.getText():null)); 
				}
				break;
			case 6:
				{
				setState(83);
				((ExpressionContext)_localctx).BOOLEAN = match(BOOLEAN);
				 ((ExpressionContext)_localctx).expressionValue =  new BooleanLiteral((((ExpressionContext)_localctx).BOOLEAN!=null?((ExpressionContext)_localctx).BOOLEAN.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(88);
						match(ADD);
						setState(89);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(16);
						((ExpressionContext)_localctx).expressionValue =  new Arithmetic(Operator.ADD, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(93);
						match(SUB);
						setState(94);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(15);
						((ExpressionContext)_localctx).expressionValue =  new Arithmetic(Operator.SUB, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(98);
						match(MUL);
						setState(99);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(14);
						((ExpressionContext)_localctx).expressionValue =  new Arithmetic(Operator.MUL, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(103);
						match(DIV);
						setState(104);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(13);
						((ExpressionContext)_localctx).expressionValue =  new Arithmetic(Operator.DIV, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(108);
						match(LT);
						setState(109);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(12);
						((ExpressionContext)_localctx).expressionValue =  new Cmp(CmpOperators.LT, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(113);
						match(GT);
						setState(114);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(11);
						((ExpressionContext)_localctx).expressionValue =  new Cmp(CmpOperators.GT, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(118);
						match(EQ);
						setState(119);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(10);
						((ExpressionContext)_localctx).expressionValue =  new Cmp(CmpOperators.EQ, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(123);
						match(LTEQ);
						setState(124);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(9);
						((ExpressionContext)_localctx).expressionValue =  new Cmp(CmpOperators.LTEQ, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(128);
						match(GTEQ);
						setState(129);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(8);
						((ExpressionContext)_localctx).expressionValue =  new Cmp(CmpOperators.GTEQ, ((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(133);
						match(CONCAT);
						setState(134);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(2);
						((ExpressionContext)_localctx).expressionValue =  new Concat(((ExpressionContext)_localctx).e1.expressionValue, ((ExpressionContext)_localctx).e2.expressionValue);
						}
						break;
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public Assign var;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PLParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((AssignmentContext)_localctx).ID = match(ID);
			setState(143);
			match(EQUAL);
			setState(144);
			((AssignmentContext)_localctx).expression = expression(0);
			((AssignmentContext)_localctx).var =  new Assign((((AssignmentContext)_localctx).ID!=null?((AssignmentContext)_localctx).ID.getText():null), ((AssignmentContext)_localctx).expression.expressionValue);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public Loop loopResult;
		public Token ID;
		public Token from;
		public Token to;
		public BlockContext block;
		public TerminalNode FOR_STATEMENT() { return getToken(PLParser.FOR_STATEMENT, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(PLParser.OPEN_BRACE, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public TerminalNode RANGE() { return getToken(PLParser.RANGE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(PLParser.CLOSE_BRACE, 0); }
		public TerminalNode OPEN_BLOCK() { return getToken(PLParser.OPEN_BLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CLOSE_BLOCK() { return getToken(PLParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> NUMERIC() { return getTokens(PLParser.NUMERIC); }
		public TerminalNode NUMERIC(int i) {
			return getToken(PLParser.NUMERIC, i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FOR_STATEMENT);
			setState(148);
			match(OPEN_BRACE);
			setState(149);
			((LoopContext)_localctx).ID = match(ID);
			setState(150);
			match(T__0);
			setState(151);
			((LoopContext)_localctx).from = match(NUMERIC);
			setState(152);
			match(RANGE);
			setState(153);
			((LoopContext)_localctx).to = match(NUMERIC);
			setState(154);
			match(CLOSE_BRACE);
			setState(155);
			match(OPEN_BLOCK);
			setState(156);
			((LoopContext)_localctx).block = block();
			setState(157);
			match(CLOSE_BLOCK);
			 
			            ((LoopContext)_localctx).loopResult =  new Loop(new Assign((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null), new IntLiteral((((LoopContext)_localctx).from!=null?((LoopContext)_localctx).from.getText():null))), new Cmp(CmpOperators.LTEQ, new Deref((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null)), new IntLiteral((((LoopContext)_localctx).to!=null?((LoopContext)_localctx).to.getText():null))), new Assign((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null), new Arithmetic(Operator.ADD, new Deref((((LoopContext)_localctx).ID!=null?((LoopContext)_localctx).ID.getText():null)), new IntLiteral("1"))), ((LoopContext)_localctx).block.blockValue); 
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public Ifelse ifelseResult;
		public ExpressionContext expression;
		public BlockContext ifBlock;
		public BlockContext elseBlock;
		public TerminalNode IF_STATEMENT() { return getToken(PLParser.IF_STATEMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> OPEN_BLOCK() { return getTokens(PLParser.OPEN_BLOCK); }
		public TerminalNode OPEN_BLOCK(int i) {
			return getToken(PLParser.OPEN_BLOCK, i);
		}
		public List<TerminalNode> CLOSE_BLOCK() { return getTokens(PLParser.CLOSE_BLOCK); }
		public TerminalNode CLOSE_BLOCK(int i) {
			return getToken(PLParser.CLOSE_BLOCK, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE_STATEMENT() { return getToken(PLParser.ELSE_STATEMENT, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IF_STATEMENT);
			setState(161);
			((IfStatementContext)_localctx).expression = expression(0);
			setState(162);
			match(OPEN_BLOCK);
			setState(163);
			((IfStatementContext)_localctx).ifBlock = block();
			setState(164);
			match(CLOSE_BLOCK);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_STATEMENT) {
				{
				setState(165);
				match(ELSE_STATEMENT);
				setState(166);
				match(OPEN_BLOCK);
				setState(167);
				((IfStatementContext)_localctx).elseBlock = block();
				setState(168);
				match(CLOSE_BLOCK);
				}
			}


			        Expr elseExpr = ((IfStatementContext)_localctx).ifBlock.blockValue != null ? ((IfStatementContext)_localctx).elseBlock.blockValue : new NoneExpr();
			        ((IfStatementContext)_localctx).ifelseResult =  new Ifelse(((IfStatementContext)_localctx).expression.expressionValue, ((IfStatementContext)_localctx).ifBlock.blockValue, elseExpr);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunDefContext extends ParserRuleContext {
		public FunctionDef funcResult;
		public Token id;
		public ParamsContext p;
		public BlockContext block;
		public TerminalNode FUNC_STATEMENT() { return getToken(PLParser.FUNC_STATEMENT, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(PLParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(PLParser.CLOSE_BRACE, 0); }
		public TerminalNode OPEN_BLOCK() { return getToken(PLParser.OPEN_BLOCK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CLOSE_BLOCK() { return getToken(PLParser.CLOSE_BLOCK, 0); }
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(FUNC_STATEMENT);
			setState(175);
			((FunDefContext)_localctx).id = match(ID);
			setState(176);
			match(OPEN_BRACE);
			setState(177);
			((FunDefContext)_localctx).p = params();
			setState(178);
			match(CLOSE_BRACE);
			setState(179);
			match(OPEN_BLOCK);
			setState(180);
			((FunDefContext)_localctx).block = block();
			setState(181);
			match(CLOSE_BLOCK);
			 ((FunDefContext)_localctx).funcResult =  new FunctionDef((((FunDefContext)_localctx).id!=null?((FunDefContext)_localctx).id.getText():null), ((FunDefContext)_localctx).p.paramList, ((FunDefContext)_localctx).block.blockValue); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public Print printValue;
		public ExpressionsContext expressions;
		public TerminalNode PRINT() { return getToken(PLParser.PRINT, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(PLParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(PLParser.CLOSE_BRACE, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> CONCAT() { return getTokens(PLParser.CONCAT); }
		public TerminalNode CONCAT(int i) {
			return getToken(PLParser.CONCAT, i);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(PRINT);
			setState(185);
			match(OPEN_BRACE);
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(186);
				((PrintStatementContext)_localctx).expressions = expressions();
				}
				break;
			case 2:
				{
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8396288L) != 0)) {
					{
					{
					setState(187);
					expression(0);
					setState(188);
					match(CONCAT);
					setState(189);
					expression(0);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(198);
			match(CLOSE_BRACE);
			 ((PrintStatementContext)_localctx).printValue =  new Print(((PrintStatementContext)_localctx).expressions.expressionListValue); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<String> paramList;
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PLParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParamsContext)_localctx).paramList =  new ArrayList<>(); 
			{
			setState(202);
			((ParamsContext)_localctx).ID = match(ID);
			 _localctx.paramList.add((((ParamsContext)_localctx).ID!=null?((ParamsContext)_localctx).ID.getText():null)); 
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(204);
				match(COMMA);
				setState(205);
				((ParamsContext)_localctx).ID = match(ID);
				 _localctx.paramList.add((((ParamsContext)_localctx).ID!=null?((ParamsContext)_localctx).ID.getText():null)); 
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expr> expressionListValue;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PLParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExpressionsContext)_localctx).expressionListValue =  new ArrayList<Expr>(); 
			{
			setState(213);
			((ExpressionsContext)_localctx).expression = expression(0);
			 _localctx.expressionListValue.add(((ExpressionsContext)_localctx).expression.expressionValue); 
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(215);
				match(COMMA);
				setState(216);
				((ExpressionsContext)_localctx).expression = expression(0);
				 _localctx.expressionListValue.add(((ExpressionsContext)_localctx).expression.expressionValue); 
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00e1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000"+
		"\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002;\b\u0002\n\u0002"+
		"\f\u0002>\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003V\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u008a\b\u0003\n"+
		"\u0003\f\u0003\u008d\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00ab\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u00c0\b\b\n\b\f\b\u00c3\t\b\u0003\b\u00c5\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00d0\b\t\n\t\f\t\u00d3\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0005\n\u00dc\b\n\n\n\f\n\u00df\t\n\u0001\n\u0000"+
		"\u0001\u0006\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0000\u00f0\u0000\u0019\u0001\u0000\u0000\u0000\u00024\u0001\u0000"+
		"\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000"+
		"\b\u008e\u0001\u0000\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u00a0"+
		"\u0001\u0000\u0000\u0000\u000e\u00ae\u0001\u0000\u0000\u0000\u0010\u00b8"+
		"\u0001\u0000\u0000\u0000\u0012\u00c9\u0001\u0000\u0000\u0000\u0014\u00d4"+
		"\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0005\u0000\u0000\u0001\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e"+
		"\u0001\u0001\u0000\u0000\u0000\u001f \u0003\b\u0004\u0000 !\u0005\u001c"+
		"\u0000\u0000!\"\u0006\u0001\uffff\uffff\u0000\"5\u0001\u0000\u0000\u0000"+
		"#$\u0003\u0006\u0003\u0000$%\u0005\u001c\u0000\u0000%&\u0006\u0001\uffff"+
		"\uffff\u0000&5\u0001\u0000\u0000\u0000\'(\u0003\u0010\b\u0000()\u0005"+
		"\u001c\u0000\u0000)*\u0006\u0001\uffff\uffff\u0000*5\u0001\u0000\u0000"+
		"\u0000+,\u0003\n\u0005\u0000,-\u0006\u0001\uffff\uffff\u0000-5\u0001\u0000"+
		"\u0000\u0000./\u0003\u000e\u0007\u0000/0\u0006\u0001\uffff\uffff\u0000"+
		"05\u0001\u0000\u0000\u000012\u0003\f\u0006\u000023\u0006\u0001\uffff\uffff"+
		"\u000035\u0001\u0000\u0000\u00004\u001f\u0001\u0000\u0000\u00004#\u0001"+
		"\u0000\u0000\u00004\'\u0001\u0000\u0000\u00004+\u0001\u0000\u0000\u0000"+
		"4.\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u00005\u0003\u0001\u0000"+
		"\u0000\u00006<\u0006\u0002\uffff\uffff\u000078\u0003\u0002\u0001\u0000"+
		"89\u0006\u0002\uffff\uffff\u00009;\u0001\u0000\u0000\u0000:7\u0001\u0000"+
		"\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000"+
		"?@\u0006\u0002\uffff\uffff\u0000@\u0005\u0001\u0000\u0000\u0000AB\u0006"+
		"\u0003\uffff\uffff\u0000BC\u0005\u0017\u0000\u0000CD\u0003\u0006\u0003"+
		"\u0000DE\u0005\u0018\u0000\u0000EF\u0006\u0003\uffff\uffff\u0000FV\u0001"+
		"\u0000\u0000\u0000GH\u0005\f\u0000\u0000HI\u0005\u0017\u0000\u0000IJ\u0003"+
		"\u0014\n\u0000JK\u0005\u0018\u0000\u0000KL\u0006\u0003\uffff\uffff\u0000"+
		"LV\u0001\u0000\u0000\u0000MN\u0005\f\u0000\u0000NV\u0006\u0003\uffff\uffff"+
		"\u0000OP\u0005\t\u0000\u0000PV\u0006\u0003\uffff\uffff\u0000QR\u0005\n"+
		"\u0000\u0000RV\u0006\u0003\uffff\uffff\u0000ST\u0005\u000b\u0000\u0000"+
		"TV\u0006\u0003\uffff\uffff\u0000UA\u0001\u0000\u0000\u0000UG\u0001\u0000"+
		"\u0000\u0000UM\u0001\u0000\u0000\u0000UO\u0001\u0000\u0000\u0000UQ\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000V\u008b\u0001\u0000\u0000"+
		"\u0000WX\n\u000f\u0000\u0000XY\u0005\r\u0000\u0000YZ\u0003\u0006\u0003"+
		"\u0010Z[\u0006\u0003\uffff\uffff\u0000[\u008a\u0001\u0000\u0000\u0000"+
		"\\]\n\u000e\u0000\u0000]^\u0005\u000e\u0000\u0000^_\u0003\u0006\u0003"+
		"\u000f_`\u0006\u0003\uffff\uffff\u0000`\u008a\u0001\u0000\u0000\u0000"+
		"ab\n\r\u0000\u0000bc\u0005\u000f\u0000\u0000cd\u0003\u0006\u0003\u000e"+
		"de\u0006\u0003\uffff\uffff\u0000e\u008a\u0001\u0000\u0000\u0000fg\n\f"+
		"\u0000\u0000gh\u0005\u0010\u0000\u0000hi\u0003\u0006\u0003\rij\u0006\u0003"+
		"\uffff\uffff\u0000j\u008a\u0001\u0000\u0000\u0000kl\n\u000b\u0000\u0000"+
		"lm\u0005\u0012\u0000\u0000mn\u0003\u0006\u0003\fno\u0006\u0003\uffff\uffff"+
		"\u0000o\u008a\u0001\u0000\u0000\u0000pq\n\n\u0000\u0000qr\u0005\u0013"+
		"\u0000\u0000rs\u0003\u0006\u0003\u000bst\u0006\u0003\uffff\uffff\u0000"+
		"t\u008a\u0001\u0000\u0000\u0000uv\n\t\u0000\u0000vw\u0005\u0014\u0000"+
		"\u0000wx\u0003\u0006\u0003\nxy\u0006\u0003\uffff\uffff\u0000y\u008a\u0001"+
		"\u0000\u0000\u0000z{\n\b\u0000\u0000{|\u0005\u0015\u0000\u0000|}\u0003"+
		"\u0006\u0003\t}~\u0006\u0003\uffff\uffff\u0000~\u008a\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\n\u0007\u0000\u0000\u0080\u0081\u0005\u0016\u0000\u0000"+
		"\u0081\u0082\u0003\u0006\u0003\b\u0082\u0083\u0006\u0003\uffff\uffff\u0000"+
		"\u0083\u008a\u0001\u0000\u0000\u0000\u0084\u0085\n\u0001\u0000\u0000\u0085"+
		"\u0086\u0005\b\u0000\u0000\u0086\u0087\u0003\u0006\u0003\u0002\u0087\u0088"+
		"\u0006\u0003\uffff\uffff\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089"+
		"W\u0001\u0000\u0000\u0000\u0089\\\u0001\u0000\u0000\u0000\u0089a\u0001"+
		"\u0000\u0000\u0000\u0089f\u0001\u0000\u0000\u0000\u0089k\u0001\u0000\u0000"+
		"\u0000\u0089p\u0001\u0000\u0000\u0000\u0089u\u0001\u0000\u0000\u0000\u0089"+
		"z\u0001\u0000\u0000\u0000\u0089\u007f\u0001\u0000\u0000\u0000\u0089\u0084"+
		"\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0007"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005\f\u0000\u0000\u008f\u0090\u0005\u0011\u0000\u0000\u0090\u0091\u0003"+
		"\u0006\u0003\u0000\u0091\u0092\u0006\u0004\uffff\uffff\u0000\u0092\t\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0002\u0000\u0000\u0094\u0095\u0005"+
		"\u0017\u0000\u0000\u0095\u0096\u0005\f\u0000\u0000\u0096\u0097\u0005\u0001"+
		"\u0000\u0000\u0097\u0098\u0005\t\u0000\u0000\u0098\u0099\u0005\u0007\u0000"+
		"\u0000\u0099\u009a\u0005\t\u0000\u0000\u009a\u009b\u0005\u0018\u0000\u0000"+
		"\u009b\u009c\u0005\u0019\u0000\u0000\u009c\u009d\u0003\u0004\u0002\u0000"+
		"\u009d\u009e\u0005\u001a\u0000\u0000\u009e\u009f\u0006\u0005\uffff\uffff"+
		"\u0000\u009f\u000b\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0005\u0000"+
		"\u0000\u00a1\u00a2\u0003\u0006\u0003\u0000\u00a2\u00a3\u0005\u0019\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0004\u0002\u0000\u00a4\u00aa\u0005\u001a\u0000"+
		"\u0000\u00a5\u00a6\u0005\u0006\u0000\u0000\u00a6\u00a7\u0005\u0019\u0000"+
		"\u0000\u00a7\u00a8\u0003\u0004\u0002\u0000\u00a8\u00a9\u0005\u001a\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a5\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0006\u0006\uffff\uffff\u0000\u00ad\r\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0005\u0003\u0000\u0000\u00af\u00b0\u0005\f\u0000\u0000"+
		"\u00b0\u00b1\u0005\u0017\u0000\u0000\u00b1\u00b2\u0003\u0012\t\u0000\u00b2"+
		"\u00b3\u0005\u0018\u0000\u0000\u00b3\u00b4\u0005\u0019\u0000\u0000\u00b4"+
		"\u00b5\u0003\u0004\u0002\u0000\u00b5\u00b6\u0005\u001a\u0000\u0000\u00b6"+
		"\u00b7\u0006\u0007\uffff\uffff\u0000\u00b7\u000f\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0005\u0004\u0000\u0000\u00b9\u00c4\u0005\u0017\u0000\u0000"+
		"\u00ba\u00c5\u0003\u0014\n\u0000\u00bb\u00bc\u0003\u0006\u0003\u0000\u00bc"+
		"\u00bd\u0005\b\u0000\u0000\u00bd\u00be\u0003\u0006\u0003\u0000\u00be\u00c0"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bb\u0001\u0000\u0000\u0000\u00c0\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c4\u00ba\u0001\u0000\u0000\u0000\u00c4\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0005\u0018\u0000\u0000\u00c7\u00c8\u0006\b\uffff\uffff\u0000\u00c8\u0011"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0006\t\uffff\uffff\u0000\u00ca\u00cb"+
		"\u0005\f\u0000\u0000\u00cb\u00d1\u0006\t\uffff\uffff\u0000\u00cc\u00cd"+
		"\u0005\u001b\u0000\u0000\u00cd\u00ce\u0005\f\u0000\u0000\u00ce\u00d0\u0006"+
		"\t\uffff\uffff\u0000\u00cf\u00cc\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u0013\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0006\n\uffff\uffff\u0000\u00d5\u00d6\u0003"+
		"\u0006\u0003\u0000\u00d6\u00dd\u0006\n\uffff\uffff\u0000\u00d7\u00d8\u0005"+
		"\u001b\u0000\u0000\u00d8\u00d9\u0003\u0006\u0003\u0000\u00d9\u00da\u0006"+
		"\n\uffff\uffff\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d7\u0001"+
		"\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u0015\u0001"+
		"\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u000b\u00194<U"+
		"\u0089\u008b\u00aa\u00c1\u00c4\u00d1\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}