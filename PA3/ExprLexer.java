// Generated from Expr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, NUMBER=16, 
		INT=17, REAL=18, ID=19, NEWLINE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "NUMBER", "INT", 
			"REAL", "ID", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'def'", "'='", "'endef'", "'()'", "'('", "')'", "'*'", 
			"'/'", "'+'", "'-'", "'let'", "'in'", "'~'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "NUMBER", "INT", "REAL", "ID", "NEWLINE", "WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

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
		"\u0004\u0000\u0015\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0003\u000fU\b\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000fY\b\u000f\u0001\u000f\u0003\u000f\\\b\u000f\u0001\u0010\u0004\u0010"+
		"_\b\u0010\u000b\u0010\f\u0010`\u0001\u0011\u0004\u0011d\b\u0011\u000b"+
		"\u0011\f\u0011e\u0001\u0011\u0001\u0011\u0005\u0011j\b\u0011\n\u0011\f"+
		"\u0011m\t\u0011\u0001\u0012\u0004\u0012p\b\u0012\u000b\u0012\f\u0012q"+
		"\u0001\u0013\u0004\u0013u\b\u0013\u000b\u0013\f\u0013v\u0001\u0014\u0004"+
		"\u0014z\b\u0014\u000b\u0014\f\u0014{\u0001\u0014\u0001\u0014\u0000\u0000"+
		"\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000"+
		"\u0004\u0001\u000009\u0005\u0000--09AZ__az\u0002\u0000\n\n\r\r\u0003\u0000"+
		"\t\n\r\r  \u0087\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003-\u0001\u0000\u0000"+
		"\u0000\u00051\u0001\u0000\u0000\u0000\u00073\u0001\u0000\u0000\u0000\t"+
		"9\u0001\u0000\u0000\u0000\u000b<\u0001\u0000\u0000\u0000\r>\u0001\u0000"+
		"\u0000\u0000\u000f@\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000"+
		"\u0013D\u0001\u0000\u0000\u0000\u0015F\u0001\u0000\u0000\u0000\u0017H"+
		"\u0001\u0000\u0000\u0000\u0019L\u0001\u0000\u0000\u0000\u001bO\u0001\u0000"+
		"\u0000\u0000\u001dQ\u0001\u0000\u0000\u0000\u001f[\u0001\u0000\u0000\u0000"+
		"!^\u0001\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000"+
		"\u0000\'t\u0001\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+,\u0005;\u0000"+
		"\u0000,\u0002\u0001\u0000\u0000\u0000-.\u0005d\u0000\u0000./\u0005e\u0000"+
		"\u0000/0\u0005f\u0000\u00000\u0004\u0001\u0000\u0000\u000012\u0005=\u0000"+
		"\u00002\u0006\u0001\u0000\u0000\u000034\u0005e\u0000\u000045\u0005n\u0000"+
		"\u000056\u0005d\u0000\u000067\u0005e\u0000\u000078\u0005f\u0000\u0000"+
		"8\b\u0001\u0000\u0000\u00009:\u0005(\u0000\u0000:;\u0005)\u0000\u0000"+
		";\n\u0001\u0000\u0000\u0000<=\u0005(\u0000\u0000=\f\u0001\u0000\u0000"+
		"\u0000>?\u0005)\u0000\u0000?\u000e\u0001\u0000\u0000\u0000@A\u0005*\u0000"+
		"\u0000A\u0010\u0001\u0000\u0000\u0000BC\u0005/\u0000\u0000C\u0012\u0001"+
		"\u0000\u0000\u0000DE\u0005+\u0000\u0000E\u0014\u0001\u0000\u0000\u0000"+
		"FG\u0005-\u0000\u0000G\u0016\u0001\u0000\u0000\u0000HI\u0005l\u0000\u0000"+
		"IJ\u0005e\u0000\u0000JK\u0005t\u0000\u0000K\u0018\u0001\u0000\u0000\u0000"+
		"LM\u0005i\u0000\u0000MN\u0005n\u0000\u0000N\u001a\u0001\u0000\u0000\u0000"+
		"OP\u0005~\u0000\u0000P\u001c\u0001\u0000\u0000\u0000QR\u0005,\u0000\u0000"+
		"R\u001e\u0001\u0000\u0000\u0000SU\u0005-\u0000\u0000TS\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\\\u0003!\u0010"+
		"\u0000WY\u0005-\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0003#\u0011\u0000[T\u0001\u0000\u0000"+
		"\u0000[X\u0001\u0000\u0000\u0000\\ \u0001\u0000\u0000\u0000]_\u0007\u0000"+
		"\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\"\u0001\u0000\u0000\u0000"+
		"bd\u0007\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gk\u0005.\u0000\u0000hj\u0007\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000l$\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"np\u0007\u0001\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r&\u0001\u0000"+
		"\u0000\u0000su\u0007\u0002\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"w(\u0001\u0000\u0000\u0000xz\u0007\u0003\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006\u0014\u0000\u0000~*\u0001"+
		"\u0000\u0000\u0000\n\u0000TX[`ekqv{\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}