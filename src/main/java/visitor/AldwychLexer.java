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
		SQ_OPEN=7, SQ_CLOSE=8, ARROW=9, PRED_SEPARATOR=10, HASH=11, EQUALS=12, 
		GREATER_THAN=13, GREATER_EQ=14, LESS_EQ=15, LESS=16, NOT_EQUAL=17, COMMA=18, 
		PLUS_OPERATOR=19, MINUS_OPERATOR=20, MULT_OPERATOR=21, DIV_OPERATOR=22, 
		TRUE=23, FALSE=24, INTEGER=25, BOOLEAN=26, STRING_CONST=27, WHITESPACE=28, 
		ID=29;
	public static final int STRING_MODE = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "STRING_MODE"
	};

	public static final String[] ruleNames = {
		"DIGIT", "LOWERCASE", "UPPERCASE", "LETTER", "WORD", "A", "B", "C", "D", 
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
		"S", "T", "U", "V", "W", "X", "Y", "Z", "SEMICOLON", "COLON", "CURLY_OPEN", 
		"CURLY_CLOSE", "PARENT_OPEN", "PARENT_CLOSE", "SQ_OPEN", "SQ_CLOSE", "ARROW", 
		"PRED_SEPARATOR", "HASH", "EQUALS", "GREATER_THAN", "GREATER_EQ", "LESS_EQ", 
		"LESS", "NOT_EQUAL", "COMMA", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", 
		"DIV_OPERATOR", "TRUE", "FALSE", "INTEGER", "BOOLEAN", "STRING_CONST", 
		"WHITESPACE", "ID", "STRING_TEXT", "STRING_END"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'->'", 
		"'||'", "'#'", "'='", "'>'", "'>='", "'<='", "'<'", "'!='", "','", "'+'", 
		"'-'", "'*'", "'/'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", "PARENT_OPEN", 
		"PARENT_CLOSE", "SQ_OPEN", "SQ_CLOSE", "ARROW", "PRED_SEPARATOR", "HASH", 
		"EQUALS", "GREATER_THAN", "GREATER_EQ", "LESS_EQ", "LESS", "NOT_EQUAL", 
		"COMMA", "PLUS_OPERATOR", "MINUS_OPERATOR", "MULT_OPERATOR", "DIV_OPERATOR", 
		"TRUE", "FALSE", "INTEGER", "BOOLEAN", "STRING_CONST", "WHITESPACE", "ID"
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
		case 57:
			STRING_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 60:
			STRING_TEXT_action((RuleContext)_localctx, actionIndex);
			break;
		case 61:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u012d\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
		"\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"+
		"\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4"+
		" \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4"+
		"+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4"+
		"\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4"+
		"=\t=\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u0089\n\5\3\6\6\6"+
		"\u008c\n\6\r\6\16\6\u008d\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\3"+
		"8\38\38\39\69\u0101\n9\r9\169\u0102\3:\3:\5:\u0107\n:\3;\3;\3;\3;\3;\3"+
		";\3<\6<\u0110\n<\r<\16<\u0111\3<\3<\3=\3=\3=\3=\7=\u011a\n=\f=\16=\u011d"+
		"\13=\3>\6>\u0120\n>\r>\16>\u0121\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\2\2@\4"+
		"\2\6\2\b\2\n\2\f\2\16\2\20\2\22\2\24\2\26\2\30\2\32\2\34\2\36\2 \2\"\2"+
		"$\2&\2(\2*\2,\2.\2\60\2\62\2\64\2\66\28\2:\2<\2>\2@\2B\3D\4F\5H\6J\7L"+
		"\bN\tP\nR\13T\fV\rX\16Z\17\\\20^\21`\22b\23d\24f\25h\26j\27l\30n\31p\32"+
		"r\33t\34v\35x\36z\37|\2~\2\4\2\3\36\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4"+
		"\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOo"+
		"o\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2"+
		"XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2\13\17\"\"\7\2\2\2\f\f\17\17"+
		"$$^^\u0115\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3"+
		"\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2"+
		"\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\2d\3\2\2\2"+
		"\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2\2p\3\2\2\2\2r"+
		"\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\3|\3\2\2\2\3~\3\2"+
		"\2\2\4\u0080\3\2\2\2\6\u0082\3\2\2\2\b\u0084\3\2\2\2\n\u0088\3\2\2\2\f"+
		"\u008b\3\2\2\2\16\u008f\3\2\2\2\20\u0091\3\2\2\2\22\u0093\3\2\2\2\24\u0095"+
		"\3\2\2\2\26\u0097\3\2\2\2\30\u0099\3\2\2\2\32\u009b\3\2\2\2\34\u009d\3"+
		"\2\2\2\36\u009f\3\2\2\2 \u00a1\3\2\2\2\"\u00a3\3\2\2\2$\u00a5\3\2\2\2"+
		"&\u00a7\3\2\2\2(\u00a9\3\2\2\2*\u00ab\3\2\2\2,\u00ad\3\2\2\2.\u00af\3"+
		"\2\2\2\60\u00b1\3\2\2\2\62\u00b3\3\2\2\2\64\u00b5\3\2\2\2\66\u00b7\3\2"+
		"\2\28\u00b9\3\2\2\2:\u00bb\3\2\2\2<\u00bd\3\2\2\2>\u00bf\3\2\2\2@\u00c1"+
		"\3\2\2\2B\u00c3\3\2\2\2D\u00c5\3\2\2\2F\u00c7\3\2\2\2H\u00c9\3\2\2\2J"+
		"\u00cb\3\2\2\2L\u00cd\3\2\2\2N\u00cf\3\2\2\2P\u00d1\3\2\2\2R\u00d3\3\2"+
		"\2\2T\u00d6\3\2\2\2V\u00d9\3\2\2\2X\u00db\3\2\2\2Z\u00dd\3\2\2\2\\\u00df"+
		"\3\2\2\2^\u00e2\3\2\2\2`\u00e5\3\2\2\2b\u00e7\3\2\2\2d\u00ea\3\2\2\2f"+
		"\u00ec\3\2\2\2h\u00ee\3\2\2\2j\u00f0\3\2\2\2l\u00f2\3\2\2\2n\u00f4\3\2"+
		"\2\2p\u00f9\3\2\2\2r\u0100\3\2\2\2t\u0106\3\2\2\2v\u0108\3\2\2\2x\u010f"+
		"\3\2\2\2z\u0115\3\2\2\2|\u011f\3\2\2\2~\u0127\3\2\2\2\u0080\u0081\4\62"+
		";\2\u0081\5\3\2\2\2\u0082\u0083\4c|\2\u0083\7\3\2\2\2\u0084\u0085\4C\\"+
		"\2\u0085\t\3\2\2\2\u0086\u0089\5\6\3\2\u0087\u0089\5\b\4\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0087\3\2\2\2\u0089\13\3\2\2\2\u008a\u008c\5\n\5\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\r\3\2\2\2\u008f\u0090\t\2\2\2\u0090\17\3\2\2\2\u0091\u0092"+
		"\t\3\2\2\u0092\21\3\2\2\2\u0093\u0094\t\4\2\2\u0094\23\3\2\2\2\u0095\u0096"+
		"\t\5\2\2\u0096\25\3\2\2\2\u0097\u0098\t\6\2\2\u0098\27\3\2\2\2\u0099\u009a"+
		"\t\7\2\2\u009a\31\3\2\2\2\u009b\u009c\t\b\2\2\u009c\33\3\2\2\2\u009d\u009e"+
		"\t\t\2\2\u009e\35\3\2\2\2\u009f\u00a0\t\n\2\2\u00a0\37\3\2\2\2\u00a1\u00a2"+
		"\t\13\2\2\u00a2!\3\2\2\2\u00a3\u00a4\t\f\2\2\u00a4#\3\2\2\2\u00a5\u00a6"+
		"\t\r\2\2\u00a6%\3\2\2\2\u00a7\u00a8\t\16\2\2\u00a8\'\3\2\2\2\u00a9\u00aa"+
		"\t\17\2\2\u00aa)\3\2\2\2\u00ab\u00ac\t\20\2\2\u00ac+\3\2\2\2\u00ad\u00ae"+
		"\t\21\2\2\u00ae-\3\2\2\2\u00af\u00b0\t\22\2\2\u00b0/\3\2\2\2\u00b1\u00b2"+
		"\t\23\2\2\u00b2\61\3\2\2\2\u00b3\u00b4\t\24\2\2\u00b4\63\3\2\2\2\u00b5"+
		"\u00b6\t\25\2\2\u00b6\65\3\2\2\2\u00b7\u00b8\t\26\2\2\u00b8\67\3\2\2\2"+
		"\u00b9\u00ba\t\27\2\2\u00ba9\3\2\2\2\u00bb\u00bc\t\30\2\2\u00bc;\3\2\2"+
		"\2\u00bd\u00be\t\31\2\2\u00be=\3\2\2\2\u00bf\u00c0\t\32\2\2\u00c0?\3\2"+
		"\2\2\u00c1\u00c2\t\33\2\2\u00c2A\3\2\2\2\u00c3\u00c4\7=\2\2\u00c4C\3\2"+
		"\2\2\u00c5\u00c6\7<\2\2\u00c6E\3\2\2\2\u00c7\u00c8\7}\2\2\u00c8G\3\2\2"+
		"\2\u00c9\u00ca\7\177\2\2\u00caI\3\2\2\2\u00cb\u00cc\7*\2\2\u00ccK\3\2"+
		"\2\2\u00cd\u00ce\7+\2\2\u00ceM\3\2\2\2\u00cf\u00d0\7]\2\2\u00d0O\3\2\2"+
		"\2\u00d1\u00d2\7_\2\2\u00d2Q\3\2\2\2\u00d3\u00d4\7/\2\2\u00d4\u00d5\7"+
		"@\2\2\u00d5S\3\2\2\2\u00d6\u00d7\7~\2\2\u00d7\u00d8\7~\2\2\u00d8U\3\2"+
		"\2\2\u00d9\u00da\7%\2\2\u00daW\3\2\2\2\u00db\u00dc\7?\2\2\u00dcY\3\2\2"+
		"\2\u00dd\u00de\7@\2\2\u00de[\3\2\2\2\u00df\u00e0\7@\2\2\u00e0\u00e1\7"+
		"?\2\2\u00e1]\3\2\2\2\u00e2\u00e3\7>\2\2\u00e3\u00e4\7?\2\2\u00e4_\3\2"+
		"\2\2\u00e5\u00e6\7>\2\2\u00e6a\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9"+
		"\7?\2\2\u00e9c\3\2\2\2\u00ea\u00eb\7.\2\2\u00ebe\3\2\2\2\u00ec\u00ed\7"+
		"-\2\2\u00edg\3\2\2\2\u00ee\u00ef\7/\2\2\u00efi\3\2\2\2\u00f0\u00f1\7,"+
		"\2\2\u00f1k\3\2\2\2\u00f2\u00f3\7\61\2\2\u00f3m\3\2\2\2\u00f4\u00f5\7"+
		"v\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7g\2\2\u00f8o"+
		"\3\2\2\2\u00f9\u00fa\7h\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7n\2\2\u00fc"+
		"\u00fd\7u\2\2\u00fd\u00fe\7g\2\2\u00feq\3\2\2\2\u00ff\u0101\5\4\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103s\3\2\2\2\u0104\u0107\5n\67\2\u0105\u0107\5p8\2\u0106\u0104"+
		"\3\2\2\2\u0106\u0105\3\2\2\2\u0107u\3\2\2\2\u0108\u0109\7$\2\2\u0109\u010a"+
		"\b;\2\2\u010a\u010b\3\2\2\2\u010b\u010c\b;\3\2\u010c\u010d\b;\4\2\u010d"+
		"w\3\2\2\2\u010e\u0110\t\34\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2"+
		"\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114"+
		"\b<\3\2\u0114y\3\2\2\2\u0115\u011b\5\6\3\2\u0116\u011a\5\n\5\2\u0117\u011a"+
		"\5\4\2\2\u0118\u011a\7a\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c{\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0120\n\35\2\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\b>\5\2\u0124\u0125\3\2\2\2\u0125\u0126\b>\6"+
		"\2\u0126}\3\2\2\2\u0127\u0128\7$\2\2\u0128\u0129\b?\7\2\u0129\u012a\3"+
		"\2\2\2\u012a\u012b\b?\b\2\u012b\u012c\b?\t\2\u012c\177\3\2\2\2\f\2\3\u0088"+
		"\u008d\u0102\u0106\u0111\u0119\u011b\u0121\n\3;\2\b\2\2\7\3\2\3>\3\5\2"+
		"\2\3?\4\t\35\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}