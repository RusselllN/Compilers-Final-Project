// Generated from /home/levi/csci4020/Compilers-Final-Project/src/PL.g4 by ANTLR 4.13.1

import backend.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PLLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "FOR_STATEMENT", "FUNC_STATEMENT", "PRINT", "IF_STATEMENT", "ELSE_STATEMENT", 
			"RANGE", "CONCAT", "NUMERIC", "STRING", "BOOLEAN", "ID", "ADD", "SUB", 
			"MUL", "DIV", "EQUAL", "LT", "GT", "EQ", "LTEQ", "GTEQ", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BLOCK", "CLOSE_BLOCK", "COMMA", "SEMICOLON", "COMMENT", 
			"WHITESPACE"
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




	public PLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001e\u00bb\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0004\bc\b\b\u000b\b\f\bd\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\tk\b\t\n\t\f\tn\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n{\b\n\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u007f\b\u000b\n\u000b\f\u000b\u0082\t\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u00ab\b\u001c\n\u001c\f\u001c\u00ae\t\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0004\u001d"+
		"\u00b6\b\u001d\u000b\u001d\f\u001d\u00b7\u0001\u001d\u0001\u001d\u0001"+
		"\u00ac\u0000\u001e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001"+
		"\u0000\u0004\u0001\u0000\"\"\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\r\r  \u00c1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0001=\u0001\u0000\u0000\u0000\u0003@\u0001\u0000\u0000"+
		"\u0000\u0005D\u0001\u0000\u0000\u0000\u0007M\u0001\u0000\u0000\u0000\t"+
		"S\u0001\u0000\u0000\u0000\u000bV\u0001\u0000\u0000\u0000\r[\u0001\u0000"+
		"\u0000\u0000\u000f^\u0001\u0000\u0000\u0000\u0011b\u0001\u0000\u0000\u0000"+
		"\u0013f\u0001\u0000\u0000\u0000\u0015z\u0001\u0000\u0000\u0000\u0017|"+
		"\u0001\u0000\u0000\u0000\u0019\u0083\u0001\u0000\u0000\u0000\u001b\u0085"+
		"\u0001\u0000\u0000\u0000\u001d\u0087\u0001\u0000\u0000\u0000\u001f\u0089"+
		"\u0001\u0000\u0000\u0000!\u008b\u0001\u0000\u0000\u0000#\u008d\u0001\u0000"+
		"\u0000\u0000%\u008f\u0001\u0000\u0000\u0000\'\u0091\u0001\u0000\u0000"+
		"\u0000)\u0094\u0001\u0000\u0000\u0000+\u0097\u0001\u0000\u0000\u0000-"+
		"\u009a\u0001\u0000\u0000\u0000/\u009c\u0001\u0000\u0000\u00001\u009e\u0001"+
		"\u0000\u0000\u00003\u00a0\u0001\u0000\u0000\u00005\u00a2\u0001\u0000\u0000"+
		"\u00007\u00a4\u0001\u0000\u0000\u00009\u00a6\u0001\u0000\u0000\u0000;"+
		"\u00b5\u0001\u0000\u0000\u0000=>\u0005i\u0000\u0000>?\u0005n\u0000\u0000"+
		"?\u0002\u0001\u0000\u0000\u0000@A\u0005f\u0000\u0000AB\u0005o\u0000\u0000"+
		"BC\u0005r\u0000\u0000C\u0004\u0001\u0000\u0000\u0000DE\u0005f\u0000\u0000"+
		"EF\u0005u\u0000\u0000FG\u0005n\u0000\u0000GH\u0005c\u0000\u0000HI\u0005"+
		"t\u0000\u0000IJ\u0005i\u0000\u0000JK\u0005o\u0000\u0000KL\u0005n\u0000"+
		"\u0000L\u0006\u0001\u0000\u0000\u0000MN\u0005p\u0000\u0000NO\u0005r\u0000"+
		"\u0000OP\u0005i\u0000\u0000PQ\u0005n\u0000\u0000QR\u0005t\u0000\u0000"+
		"R\b\u0001\u0000\u0000\u0000ST\u0005i\u0000\u0000TU\u0005f\u0000\u0000"+
		"U\n\u0001\u0000\u0000\u0000VW\u0005e\u0000\u0000WX\u0005l\u0000\u0000"+
		"XY\u0005s\u0000\u0000YZ\u0005e\u0000\u0000Z\f\u0001\u0000\u0000\u0000"+
		"[\\\u0005.\u0000\u0000\\]\u0005.\u0000\u0000]\u000e\u0001\u0000\u0000"+
		"\u0000^_\u0005+\u0000\u0000_`\u0005+\u0000\u0000`\u0010\u0001\u0000\u0000"+
		"\u0000ac\u000209\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0012\u0001\u0000"+
		"\u0000\u0000fl\u0005\"\u0000\u0000gh\u0005\\\u0000\u0000hk\u0005\"\u0000"+
		"\u0000ik\b\u0000\u0000\u0000jg\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005"+
		"\"\u0000\u0000p\u0014\u0001\u0000\u0000\u0000qr\u0005t\u0000\u0000rs\u0005"+
		"r\u0000\u0000st\u0005u\u0000\u0000t{\u0005e\u0000\u0000uv\u0005f\u0000"+
		"\u0000vw\u0005a\u0000\u0000wx\u0005l\u0000\u0000xy\u0005s\u0000\u0000"+
		"y{\u0005e\u0000\u0000zq\u0001\u0000\u0000\u0000zu\u0001\u0000\u0000\u0000"+
		"{\u0016\u0001\u0000\u0000\u0000|\u0080\u0007\u0001\u0000\u0000}\u007f"+
		"\u0007\u0002\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000"+
		"\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000"+
		"\u0000\u0081\u0018\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005+\u0000\u0000\u0084\u001a\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005-\u0000\u0000\u0086\u001c\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005*\u0000\u0000\u0088\u001e\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005/\u0000\u0000\u008a \u0001\u0000\u0000\u0000\u008b\u008c\u0005="+
		"\u0000\u0000\u008c\"\u0001\u0000\u0000\u0000\u008d\u008e\u0005<\u0000"+
		"\u0000\u008e$\u0001\u0000\u0000\u0000\u008f\u0090\u0005>\u0000\u0000\u0090"+
		"&\u0001\u0000\u0000\u0000\u0091\u0092\u0005=\u0000\u0000\u0092\u0093\u0005"+
		"=\u0000\u0000\u0093(\u0001\u0000\u0000\u0000\u0094\u0095\u0005<\u0000"+
		"\u0000\u0095\u0096\u0005=\u0000\u0000\u0096*\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005>\u0000\u0000\u0098\u0099\u0005=\u0000\u0000\u0099,\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005(\u0000\u0000\u009b.\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005)\u0000\u0000\u009d0\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0005{\u0000\u0000\u009f2\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"}\u0000\u0000\u00a14\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005,\u0000"+
		"\u0000\u00a36\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005;\u0000\u0000\u00a5"+
		"8\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005/\u0000\u0000\u00a7\u00a8\u0005"+
		"*\u0000\u0000\u00a8\u00ac\u0001\u0000\u0000\u0000\u00a9\u00ab\t\u0000"+
		"\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0005*\u0000\u0000\u00b0\u00b1\u0005/\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u001c\u0000\u0000"+
		"\u00b3:\u0001\u0000\u0000\u0000\u00b4\u00b6\u0007\u0003\u0000\u0000\u00b5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u001d\u0000\u0000\u00ba"+
		"<\u0001\u0000\u0000\u0000\b\u0000djlz\u0080\u00ac\u00b7\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}