package visitor;// Generated from AldwychLexer.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldwychLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, CURLY_OPEN=3, CURLY_CLOSE=4, PARENT_OPEN=5, PARENT_CLOSE=6, 
		ARROW=7, PRED_SEPARATOR=8, HASH=9, EQUALS=10, GREATER_THAN=11, GREATER_EQ=12, 
		LESS_EQ=13, LESS=14, NOT_EQUAL=15, COMMA=16, PLUS_OPERATOR=17, MINUS_OPERATOR=18, 
		MULT_OPERATOR=19, DIV_OPERATOR=20, TRUE=21, FALSE=22, INTEGER=23, BOOLEAN=24, 
		STRING_CONST=25, WHITESPACE=26, ID=27;
	public static final int STRING_MODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "STRING_MODE"
	};

	public static final String[] ruleNames = {
		"DIGIT", "LOWERCASE", "UPPERCASE", "LETTER", "WORD", "A", "B", "C", "D", 
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
		"S", "T", "U", "V", "W", "X", "Y", "Z", "SEMICOLON", "COLON", "CURLY_OPEN", 
		"CURLY_CLOSE", "PARENT_OPEN", "PARENT_CLOSE", "ARROW", "PRED_SEPARATOR", 
		"HASH", "EQUALS", "GREATER_THAN", "GREATER_EQ", "LESS_EQ", "LESS", "NOT_EQUAL", 
		"COMMA", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", "DIV_OPERATOR", 
		"TRUE", "FALSE", "INTEGER", "BOOLEAN", "STRING_CONST", "WHITESPACE", "ID", 
		"STRING_TEXT", "STRING_END"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'{'", "'}'", "'('", "')'", "'->'", "'||'", "'#'", 
		"'='", "'>'", "'>='", "'<='", "'<'", "'!='", "','", "'+'", "'-'", "'*'", 
		"'/'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", "PARENT_OPEN", 
		"PARENT_CLOSE", "ARROW", "PRED_SEPARATOR", "HASH", "EQUALS", "GREATER_THAN", 
		"GREATER_EQ", "LESS_EQ", "LESS", "NOT_EQUAL", "COMMA", "PLUS_OPERATOR", 
		"MINUS_OPERATOR", "MULT_OPERATOR", "DIV_OPERATOR", "TRUE", "FALSE", "INTEGER", 
		"BOOLEAN", "STRING_CONST", "WHITESPACE", "ID"
	};
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


	    StringBuilder buffer;


	public AldwychLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "visitor/AldwychLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 55:
			STRING_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 58:
			STRING_TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 59:
			STRING_END_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 buffer = new StringBuilder(); 
			break;
		}
	}
	private void STRING_TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 buffer.append(getText()); 
			break;
		}
	}
	private void STRING_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 setText(buffer.toString()); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0125\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"+
		"\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4"+
		" \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4"+
		"+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4"+
		"\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4"+
		"=\t=\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u0085\n\5\3\6\6\6\u0088\n\6\r"+
		"\6\16\6\u0089\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-"+
		"\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\6\67\u00f9"+
		"\n\67\r\67\16\67\u00fa\38\38\58\u00ff\n8\39\39\39\39\39\39\3:\6:\u0108"+
		"\n:\r:\16:\u0109\3:\3:\3;\3;\3;\3;\7;\u0112\n;\f;\16;\u0115\13;\3<\6<"+
		"\u0118\n<\r<\16<\u0119\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\2\2>\4\2\6\2\b\2"+
		"\n\2\f\2\16\2\20\2\22\2\24\2\26\2\30\2\32\2\34\2\36\2 \2\"\2$\2&\2(\2"+
		"*\2,\2.\2\60\2\62\2\64\2\66\28\2:\2<\2>\2@\2B\3D\4F\5H\6J\7L\bN\tP\nR"+
		"\13T\fV\rX\16Z\17\\\20^\21`\22b\23d\24f\25h\26j\27l\30n\31p\32r\33t\34"+
		"v\35x\2z\2\4\2\3\36\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4"+
		"\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQq"+
		"q\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2"+
		"ZZzz\4\2[[{{\4\2\\\\||\4\2\13\17\"\"\7\2\2\2\f\f\17\17$$^^\u010d\2B\3"+
		"\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2"+
		"\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2"+
		"\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3"+
		"\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2"+
		"\2\2v\3\2\2\2\3x\3\2\2\2\3z\3\2\2\2\4|\3\2\2\2\6~\3\2\2\2\b\u0080\3\2"+
		"\2\2\n\u0084\3\2\2\2\f\u0087\3\2\2\2\16\u008b\3\2\2\2\20\u008d\3\2\2\2"+
		"\22\u008f\3\2\2\2\24\u0091\3\2\2\2\26\u0093\3\2\2\2\30\u0095\3\2\2\2\32"+
		"\u0097\3\2\2\2\34\u0099\3\2\2\2\36\u009b\3\2\2\2 \u009d\3\2\2\2\"\u009f"+
		"\3\2\2\2$\u00a1\3\2\2\2&\u00a3\3\2\2\2(\u00a5\3\2\2\2*\u00a7\3\2\2\2,"+
		"\u00a9\3\2\2\2.\u00ab\3\2\2\2\60\u00ad\3\2\2\2\62\u00af\3\2\2\2\64\u00b1"+
		"\3\2\2\2\66\u00b3\3\2\2\28\u00b5\3\2\2\2:\u00b7\3\2\2\2<\u00b9\3\2\2\2"+
		">\u00bb\3\2\2\2@\u00bd\3\2\2\2B\u00bf\3\2\2\2D\u00c1\3\2\2\2F\u00c3\3"+
		"\2\2\2H\u00c5\3\2\2\2J\u00c7\3\2\2\2L\u00c9\3\2\2\2N\u00cb\3\2\2\2P\u00ce"+
		"\3\2\2\2R\u00d1\3\2\2\2T\u00d3\3\2\2\2V\u00d5\3\2\2\2X\u00d7\3\2\2\2Z"+
		"\u00da\3\2\2\2\\\u00dd\3\2\2\2^\u00df\3\2\2\2`\u00e2\3\2\2\2b\u00e4\3"+
		"\2\2\2d\u00e6\3\2\2\2f\u00e8\3\2\2\2h\u00ea\3\2\2\2j\u00ec\3\2\2\2l\u00f1"+
		"\3\2\2\2n\u00f8\3\2\2\2p\u00fe\3\2\2\2r\u0100\3\2\2\2t\u0107\3\2\2\2v"+
		"\u010d\3\2\2\2x\u0117\3\2\2\2z\u011f\3\2\2\2|}\4\62;\2}\5\3\2\2\2~\177"+
		"\4c|\2\177\7\3\2\2\2\u0080\u0081\4C\\\2\u0081\t\3\2\2\2\u0082\u0085\5"+
		"\6\3\2\u0083\u0085\5\b\4\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\13\3\2\2\2\u0086\u0088\5\n\5\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2"+
		"\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b\u008c"+
		"\t\2\2\2\u008c\17\3\2\2\2\u008d\u008e\t\3\2\2\u008e\21\3\2\2\2\u008f\u0090"+
		"\t\4\2\2\u0090\23\3\2\2\2\u0091\u0092\t\5\2\2\u0092\25\3\2\2\2\u0093\u0094"+
		"\t\6\2\2\u0094\27\3\2\2\2\u0095\u0096\t\7\2\2\u0096\31\3\2\2\2\u0097\u0098"+
		"\t\b\2\2\u0098\33\3\2\2\2\u0099\u009a\t\t\2\2\u009a\35\3\2\2\2\u009b\u009c"+
		"\t\n\2\2\u009c\37\3\2\2\2\u009d\u009e\t\13\2\2\u009e!\3\2\2\2\u009f\u00a0"+
		"\t\f\2\2\u00a0#\3\2\2\2\u00a1\u00a2\t\r\2\2\u00a2%\3\2\2\2\u00a3\u00a4"+
		"\t\16\2\2\u00a4\'\3\2\2\2\u00a5\u00a6\t\17\2\2\u00a6)\3\2\2\2\u00a7\u00a8"+
		"\t\20\2\2\u00a8+\3\2\2\2\u00a9\u00aa\t\21\2\2\u00aa-\3\2\2\2\u00ab\u00ac"+
		"\t\22\2\2\u00ac/\3\2\2\2\u00ad\u00ae\t\23\2\2\u00ae\61\3\2\2\2\u00af\u00b0"+
		"\t\24\2\2\u00b0\63\3\2\2\2\u00b1\u00b2\t\25\2\2\u00b2\65\3\2\2\2\u00b3"+
		"\u00b4\t\26\2\2\u00b4\67\3\2\2\2\u00b5\u00b6\t\27\2\2\u00b69\3\2\2\2\u00b7"+
		"\u00b8\t\30\2\2\u00b8;\3\2\2\2\u00b9\u00ba\t\31\2\2\u00ba=\3\2\2\2\u00bb"+
		"\u00bc\t\32\2\2\u00bc?\3\2\2\2\u00bd\u00be\t\33\2\2\u00beA\3\2\2\2\u00bf"+
		"\u00c0\7=\2\2\u00c0C\3\2\2\2\u00c1\u00c2\7<\2\2\u00c2E\3\2\2\2\u00c3\u00c4"+
		"\7}\2\2\u00c4G\3\2\2\2\u00c5\u00c6\7\177\2\2\u00c6I\3\2\2\2\u00c7\u00c8"+
		"\7*\2\2\u00c8K\3\2\2\2\u00c9\u00ca\7+\2\2\u00caM\3\2\2\2\u00cb\u00cc\7"+
		"/\2\2\u00cc\u00cd\7@\2\2\u00cdO\3\2\2\2\u00ce\u00cf\7~\2\2\u00cf\u00d0"+
		"\7~\2\2\u00d0Q\3\2\2\2\u00d1\u00d2\7%\2\2\u00d2S\3\2\2\2\u00d3\u00d4\7"+
		"?\2\2\u00d4U\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6W\3\2\2\2\u00d7\u00d8\7@"+
		"\2\2\u00d8\u00d9\7?\2\2\u00d9Y\3\2\2\2\u00da\u00db\7>\2\2\u00db\u00dc"+
		"\7?\2\2\u00dc[\3\2\2\2\u00dd\u00de\7>\2\2\u00de]\3\2\2\2\u00df\u00e0\7"+
		"#\2\2\u00e0\u00e1\7?\2\2\u00e1_\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3a\3\2"+
		"\2\2\u00e4\u00e5\7-\2\2\u00e5c\3\2\2\2\u00e6\u00e7\7/\2\2\u00e7e\3\2\2"+
		"\2\u00e8\u00e9\7,\2\2\u00e9g\3\2\2\2\u00ea\u00eb\7\61\2\2\u00ebi\3\2\2"+
		"\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0"+
		"\7g\2\2\u00f0k\3\2\2\2\u00f1\u00f2\7h\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7g\2\2\u00f6m\3\2\2\2\u00f7\u00f9"+
		"\5\4\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fbo\3\2\2\2\u00fc\u00ff\5j\65\2\u00fd\u00ff\5l\66\2"+
		"\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ffq\3\2\2\2\u0100\u0101\7"+
		"$\2\2\u0101\u0102\b9\2\2\u0102\u0103\3\2\2\2\u0103\u0104\b9\3\2\u0104"+
		"\u0105\b9\4\2\u0105s\3\2\2\2\u0106\u0108\t\34\2\2\u0107\u0106\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010c\b:\3\2\u010cu\3\2\2\2\u010d\u0113\5\6\3\2\u010e\u0112"+
		"\5\n\5\2\u010f\u0112\5\4\2\2\u0110\u0112\7a\2\2\u0111\u010e\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114w\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0118"+
		"\n\35\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2"+
		"\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\b<\5\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011e\b<\6\2\u011ey\3\2\2\2\u011f\u0120\7$\2\2\u0120\u0121"+
		"\b=\7\2\u0121\u0122\3\2\2\2\u0122\u0123\b=\b\2\u0123\u0124\b=\t\2\u0124"+
		"{\3\2\2\2\f\2\3\u0084\u0089\u00fa\u00fe\u0109\u0111\u0113\u0119\n\39\2"+
		"\b\2\2\7\3\2\3<\3\5\2\2\3=\4\t\33\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}