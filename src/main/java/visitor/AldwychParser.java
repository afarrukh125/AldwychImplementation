package visitor;// Generated from AldwychParser.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldwychParser extends Parser {
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
	public static final int
		RULE_aldwychClass = 0, RULE_declaration = 1, RULE_mainprocedure = 2, RULE_heading = 3, 
		RULE_name = 4, RULE_formals = 5, RULE_readers = 6, RULE_writers = 7, RULE_body = 8, 
		RULE_ruleset = 9, RULE_regularrule = 10, RULE_ask = 11, RULE_tell = 12, 
		RULE_finalrule = 13, RULE_expr = 14;
	public static final String[] ruleNames = {
		"aldwychClass", "declaration", "mainprocedure", "heading", "name", "formals", 
		"readers", "writers", "body", "ruleset", "regularrule", "ask", "tell", 
		"finalrule", "expr"
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

	@Override
	public String getGrammarFileName() { return "visitor/AldwychParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AldwychParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AldwychClassContext extends ParserRuleContext {
		public MainprocedureContext mainprocedure() {
			return getRuleContext(MainprocedureContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AldwychParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public AldwychClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aldwychClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterAldwychClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitAldwychClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitAldwychClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AldwychClassContext aldwychClass() throws RecognitionException {
		AldwychClassContext _localctx = new AldwychClassContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aldwychClass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					declaration();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			mainprocedure();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH || _la==ID) {
				{
				{
				setState(37);
				declaration();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(EOF);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationNodeContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(AldwychParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(AldwychParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AldwychParser.SEMICOLON, 0); }
		public DeclarationNodeContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterDeclarationNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitDeclarationNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitDeclarationNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProcedureNodeContext extends DeclarationContext {
		public HeadingContext heading() {
			return getRuleContext(HeadingContext.class,0);
		}
		public TerminalNode CURLY_OPEN() { return getToken(AldwychParser.CURLY_OPEN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode CURLY_CLOSE() { return getToken(AldwychParser.CURLY_CLOSE, 0); }
		public ProcedureNodeContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterProcedureNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitProcedureNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitProcedureNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case HASH:
				_localctx = new ProcedureNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				heading();
				setState(46);
				match(CURLY_OPEN);
				setState(47);
				body();
				setState(48);
				match(CURLY_CLOSE);
				}
				break;
			case ID:
				_localctx = new DeclarationNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(ID);
				setState(51);
				match(EQUALS);
				setState(52);
				expr(0);
				setState(53);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MainprocedureContext extends ParserRuleContext {
		public MainprocedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainprocedure; }
	 
		public MainprocedureContext() { }
		public void copyFrom(MainprocedureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainProcedureNodeContext extends MainprocedureContext {
		public HeadingContext heading() {
			return getRuleContext(HeadingContext.class,0);
		}
		public TerminalNode CURLY_OPEN() { return getToken(AldwychParser.CURLY_OPEN, 0); }
		public FinalruleContext finalrule() {
			return getRuleContext(FinalruleContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AldwychParser.SEMICOLON, 0); }
		public TerminalNode CURLY_CLOSE() { return getToken(AldwychParser.CURLY_CLOSE, 0); }
		public MainProcedureNodeContext(MainprocedureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterMainProcedureNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitMainProcedureNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitMainProcedureNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainprocedureContext mainprocedure() throws RecognitionException {
		MainprocedureContext _localctx = new MainprocedureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainprocedure);
		try {
			_localctx = new MainProcedureNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			heading();
			setState(58);
			match(CURLY_OPEN);
			setState(59);
			finalrule();
			setState(60);
			match(SEMICOLON);
			setState(61);
			match(CURLY_CLOSE);
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

	public static class HeadingContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public FormalsContext formals() {
			return getRuleContext(FormalsContext.class,0);
		}
		public HeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadingContext heading() throws RecognitionException {
		HeadingContext _localctx = new HeadingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_heading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			name();
			setState(64);
			formals();
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(AldwychParser.HASH, 0); }
		public TerminalNode ID() { return getToken(AldwychParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(HASH);
			setState(67);
			match(ID);
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

	public static class FormalsContext extends ParserRuleContext {
		public ReadersContext readers() {
			return getRuleContext(ReadersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(AldwychParser.ARROW, 0); }
		public WritersContext writers() {
			return getRuleContext(WritersContext.class,0);
		}
		public FormalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterFormals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitFormals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitFormals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalsContext formals() throws RecognitionException {
		FormalsContext _localctx = new FormalsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			readers();
			setState(70);
			match(ARROW);
			setState(71);
			writers();
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

	public static class ReadersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AldwychParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldwychParser.ID, i);
		}
		public TerminalNode PARENT_OPEN() { return getToken(AldwychParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldwychParser.PARENT_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public ReadersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterReaders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitReaders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitReaders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadersContext readers() throws RecognitionException {
		ReadersContext _localctx = new ReadersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_readers);
		try {
			int _alt;
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(PARENT_OPEN);
				setState(75);
				match(PARENT_CLOSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(PARENT_OPEN);
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(77);
						match(ID);
						setState(78);
						match(COMMA);
						}
						} 
					}
					setState(83);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(84);
				match(ID);
				setState(85);
				match(PARENT_CLOSE);
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

	public static class WritersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AldwychParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldwychParser.ID, i);
		}
		public TerminalNode PARENT_OPEN() { return getToken(AldwychParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldwychParser.PARENT_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public WritersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterWriters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitWriters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitWriters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritersContext writers() throws RecognitionException {
		WritersContext _localctx = new WritersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_writers);
		try {
			int _alt;
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(PARENT_OPEN);
				setState(90);
				match(PARENT_CLOSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(PARENT_OPEN);
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(92);
						match(ID);
						setState(93);
						match(COMMA);
						}
						} 
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(99);
				match(ID);
				setState(100);
				match(PARENT_CLOSE);
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

	public static class BodyContext extends ParserRuleContext {
		public FinalruleContext finalrule() {
			return getRuleContext(FinalruleContext.class,0);
		}
		public List<RulesetContext> ruleset() {
			return getRuleContexts(RulesetContext.class);
		}
		public RulesetContext ruleset(int i) {
			return getRuleContext(RulesetContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				ruleset();
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SQ_OPEN) | (1L << MINUS_OPERATOR) | (1L << INTEGER) | (1L << ID))) != 0) );
			setState(108);
			finalrule();
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

	public static class RulesetContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(AldwychParser.COLON, 0); }
		public List<RegularruleContext> regularrule() {
			return getRuleContexts(RegularruleContext.class);
		}
		public RegularruleContext regularrule(int i) {
			return getRuleContext(RegularruleContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AldwychParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AldwychParser.SEMICOLON, i);
		}
		public RulesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterRuleset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitRuleset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitRuleset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesetContext ruleset() throws RecognitionException {
		RulesetContext _localctx = new RulesetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ruleset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(110);
				regularrule();
				setState(111);
				match(SEMICOLON);
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SQ_OPEN) | (1L << MINUS_OPERATOR) | (1L << INTEGER) | (1L << ID))) != 0) );
			setState(117);
			match(COLON);
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

	public static class RegularruleContext extends ParserRuleContext {
		public List<AskContext> ask() {
			return getRuleContexts(AskContext.class);
		}
		public AskContext ask(int i) {
			return getRuleContext(AskContext.class,i);
		}
		public TerminalNode PRED_SEPARATOR() { return getToken(AldwychParser.PRED_SEPARATOR, 0); }
		public List<TellContext> tell() {
			return getRuleContexts(TellContext.class);
		}
		public TellContext tell(int i) {
			return getRuleContext(TellContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public RegularruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterRegularrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitRegularrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitRegularrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularruleContext regularrule() throws RecognitionException {
		RegularruleContext _localctx = new RegularruleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_regularrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			ask();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(120);
				match(COMMA);
				setState(121);
				ask();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(PRED_SEPARATOR);
			setState(128);
			tell();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				tell();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AskContext extends ParserRuleContext {
		public AskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ask; }
	 
		public AskContext() { }
		public void copyFrom(AskContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AskNodeContext extends AskContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AskNodeContext(AskContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterAskNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitAskNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitAskNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AskContext ask() throws RecognitionException {
		AskContext _localctx = new AskContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ask);
		try {
			_localctx = new AskNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expr(0);
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

	public static class TellContext extends ParserRuleContext {
		public TellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tell; }
	 
		public TellContext() { }
		public void copyFrom(TellContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TellNodeContext extends TellContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TellNodeContext(TellContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterTellNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitTellNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitTellNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TellContext tell() throws RecognitionException {
		TellContext _localctx = new TellContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tell);
		try {
			_localctx = new TellNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			expr(0);
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

	public static class FinalruleContext extends ParserRuleContext {
		public TerminalNode PRED_SEPARATOR() { return getToken(AldwychParser.PRED_SEPARATOR, 0); }
		public List<TellContext> tell() {
			return getRuleContexts(TellContext.class);
		}
		public TellContext tell(int i) {
			return getRuleContext(TellContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public FinalruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterFinalrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitFinalrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitFinalrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalruleContext finalrule() throws RecognitionException {
		FinalruleContext _localctx = new FinalruleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_finalrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(PRED_SEPARATOR);
			setState(141);
			tell();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(142);
				match(COMMA);
				setState(143);
				tell();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DispatchNodeContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(AldwychParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldwychParser.ID, i);
		}
		public TerminalNode PARENT_OPEN() { return getToken(AldwychParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldwychParser.PARENT_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(AldwychParser.ARROW, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public DispatchNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterDispatchNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitDispatchNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitDispatchNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructureEqNodeContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(AldwychParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldwychParser.ID, i);
		}
		public TerminalNode EQUALS() { return getToken(AldwychParser.EQUALS, 0); }
		public TerminalNode PARENT_OPEN() { return getToken(AldwychParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldwychParser.PARENT_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public StructureEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterStructureEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitStructureEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitStructureEqNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GEqNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER_EQ() { return getToken(AldwychParser.GREATER_EQ, 0); }
		public GEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterGEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitGEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitGEqNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GTNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(AldwychParser.GREATER_THAN, 0); }
		public GTNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterGTNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitGTNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitGTNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerNodeContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(AldwychParser.INTEGER, 0); }
		public TerminalNode MINUS_OPERATOR() { return getToken(AldwychParser.MINUS_OPERATOR, 0); }
		public IntegerNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterIntegerNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitIntegerNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitIntegerNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierNodeContext extends ExprContext {
		public TerminalNode ID() { return getToken(AldwychParser.ID, 0); }
		public IdentifierNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterIdentifierNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitIdentifierNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitIdentifierNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LEqNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS_EQ() { return getToken(AldwychParser.LESS_EQ, 0); }
		public LEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterLEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitLEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitLEqNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(AldwychParser.LESS, 0); }
		public LtNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterLtNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitLtNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitLtNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivMultNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT_OPERATOR() { return getToken(AldwychParser.MULT_OPERATOR, 0); }
		public TerminalNode DIV_OPERATOR() { return getToken(AldwychParser.DIV_OPERATOR, 0); }
		public DivMultNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterDivMultNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitDivMultNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitDivMultNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusPlusNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS_OPERATOR() { return getToken(AldwychParser.MINUS_OPERATOR, 0); }
		public TerminalNode PLUS_OPERATOR() { return getToken(AldwychParser.PLUS_OPERATOR, 0); }
		public MinusPlusNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterMinusPlusNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitMinusPlusNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitMinusPlusNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(AldwychParser.EQUALS, 0); }
		public EqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitEqNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayNodeContext extends ExprContext {
		public TerminalNode SQ_OPEN() { return getToken(AldwychParser.SQ_OPEN, 0); }
		public TerminalNode SQ_CLOSE() { return getToken(AldwychParser.SQ_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldwychParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldwychParser.COMMA, i);
		}
		public ArrayNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterArrayNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitArrayNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitArrayNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NEqNodeContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT_EQUAL() { return getToken(AldwychParser.NOT_EQUAL, 0); }
		public NEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).enterNEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldwychParserListener ) ((AldwychParserListener)listener).exitNEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldwychParserVisitor ) return ((AldwychParserVisitor<? extends T>)visitor).visitNEqNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new StructureEqNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(150);
				match(ID);
				setState(151);
				match(EQUALS);
				setState(152);
				match(ID);
				setState(153);
				match(PARENT_OPEN);
				{
				setState(154);
				expr(0);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(155);
					match(COMMA);
					setState(156);
					expr(0);
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(162);
				match(PARENT_CLOSE);
				}
				break;
			case 2:
				{
				_localctx = new DispatchNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(ID);
				setState(165);
				match(PARENT_OPEN);
				setState(174);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SQ_OPEN) | (1L << MINUS_OPERATOR) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(166);
					expr(0);
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(167);
						match(COMMA);
						setState(168);
						expr(0);
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(176);
				match(PARENT_CLOSE);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(177);
					match(ARROW);
					setState(178);
					match(ID);
					}
					break;
				}
				}
				break;
			case 3:
				{
				_localctx = new ArrayNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(SQ_OPEN);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SQ_OPEN) | (1L << MINUS_OPERATOR) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					{
					setState(182);
					expr(0);
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(183);
						match(COMMA);
						setState(184);
						expr(0);
						}
						}
						setState(189);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(195);
				match(SQ_CLOSE);
				}
				break;
			case 4:
				{
				_localctx = new IdentifierNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new IntegerNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(198);
				_la = _input.LA(1);
				if (_la==MINUS_OPERATOR) {
					{
					setState(197);
					match(MINUS_OPERATOR);
					}
				}

				setState(200);
				match(INTEGER);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new DivMultNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(204);
						_la = _input.LA(1);
						if ( !(_la==MULT_OPERATOR || _la==DIV_OPERATOR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(205);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MinusPlusNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(207);
						_la = _input.LA(1);
						if ( !(_la==PLUS_OPERATOR || _la==MINUS_OPERATOR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(208);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new LEqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(210);
						match(LESS_EQ);
						setState(211);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new LtNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(213);
						match(LESS);
						setState(214);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new EqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(216);
						match(EQUALS);
						setState(217);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new GEqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(219);
						match(GREATER_EQ);
						setState(220);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new GTNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(222);
						match(GREATER_THAN);
						setState(223);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new NEqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(225);
						match(NOT_EQUAL);
						setState(226);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00eb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2"+
		"\16\2%\13\2\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bR\n\b\f\b\16\bU"+
		"\13\b\3\b\3\b\5\bY\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\ta\n\t\f\t\16\td\13\t"+
		"\3\t\3\t\5\th\n\t\3\n\6\nk\n\n\r\n\16\nl\3\n\3\n\3\13\3\13\3\13\6\13t"+
		"\n\13\r\13\16\13u\3\13\3\13\3\f\3\f\3\f\7\f}\n\f\f\f\16\f\u0080\13\f\3"+
		"\f\3\f\3\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\7\17\u0093\n\17\f\17\16\17\u0096\13\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00a0\n\20\f\20\16\20\u00a3\13\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00ac\n\20\f\20\16\20\u00af\13\20"+
		"\5\20\u00b1\n\20\3\20\3\20\3\20\5\20\u00b6\n\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00bc\n\20\f\20\16\20\u00bf\13\20\7\20\u00c1\n\20\f\20\16\20\u00c4"+
		"\13\20\3\20\3\20\3\20\5\20\u00c9\n\20\3\20\5\20\u00cc\n\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e6\n\20\f\20\16\20\u00e9"+
		"\13\20\3\20\2\3\36\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\27"+
		"\30\3\2\25\26\u00fc\2#\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bA\3\2\2\2\nD\3\2"+
		"\2\2\fG\3\2\2\2\16X\3\2\2\2\20g\3\2\2\2\22j\3\2\2\2\24s\3\2\2\2\26y\3"+
		"\2\2\2\30\u008a\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3\2\2\2\36\u00cb\3\2"+
		"\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3"+
		"\2\2\2&*\5\6\4\2\')\5\4\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+"+
		"-\3\2\2\2,*\3\2\2\2-.\7\2\2\3.\3\3\2\2\2/\60\5\b\5\2\60\61\7\5\2\2\61"+
		"\62\5\22\n\2\62\63\7\6\2\2\63:\3\2\2\2\64\65\7\37\2\2\65\66\7\16\2\2\66"+
		"\67\5\36\20\2\678\7\3\2\28:\3\2\2\29/\3\2\2\29\64\3\2\2\2:\5\3\2\2\2;"+
		"<\5\b\5\2<=\7\5\2\2=>\5\34\17\2>?\7\3\2\2?@\7\6\2\2@\7\3\2\2\2AB\5\n\6"+
		"\2BC\5\f\7\2C\t\3\2\2\2DE\7\r\2\2EF\7\37\2\2F\13\3\2\2\2GH\5\16\b\2HI"+
		"\7\13\2\2IJ\5\20\t\2J\r\3\2\2\2KY\7\37\2\2LM\7\7\2\2MY\7\b\2\2NS\7\7\2"+
		"\2OP\7\37\2\2PR\7\24\2\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2"+
		"\2\2US\3\2\2\2VW\7\37\2\2WY\7\b\2\2XK\3\2\2\2XL\3\2\2\2XN\3\2\2\2Y\17"+
		"\3\2\2\2Zh\7\37\2\2[\\\7\7\2\2\\h\7\b\2\2]b\7\7\2\2^_\7\37\2\2_a\7\24"+
		"\2\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\37"+
		"\2\2fh\7\b\2\2gZ\3\2\2\2g[\3\2\2\2g]\3\2\2\2h\21\3\2\2\2ik\5\24\13\2j"+
		"i\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\5\34\17\2o\23\3\2"+
		"\2\2pq\5\26\f\2qr\7\3\2\2rt\3\2\2\2sp\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3"+
		"\2\2\2vw\3\2\2\2wx\7\4\2\2x\25\3\2\2\2y~\5\30\r\2z{\7\24\2\2{}\5\30\r"+
		"\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0082\7\f\2\2\u0082\u0087\5\32\16\2\u0083\u0084\7\24\2"+
		"\2\u0084\u0086\5\32\16\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\27\3\2\2\2\u0089\u0087\3\2\2"+
		"\2\u008a\u008b\5\36\20\2\u008b\31\3\2\2\2\u008c\u008d\5\36\20\2\u008d"+
		"\33\3\2\2\2\u008e\u008f\7\f\2\2\u008f\u0094\5\32\16\2\u0090\u0091\7\24"+
		"\2\2\u0091\u0093\5\32\16\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\35\3\2\2\2\u0096\u0094\3\2\2"+
		"\2\u0097\u0098\b\20\1\2\u0098\u0099\7\37\2\2\u0099\u009a\7\16\2\2\u009a"+
		"\u009b\7\37\2\2\u009b\u009c\7\7\2\2\u009c\u00a1\5\36\20\2\u009d\u009e"+
		"\7\24\2\2\u009e\u00a0\5\36\20\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2"+
		"\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a4\u00a5\7\b\2\2\u00a5\u00cc\3\2\2\2\u00a6\u00a7\7\37\2\2"+
		"\u00a7\u00b0\7\7\2\2\u00a8\u00ad\5\36\20\2\u00a9\u00aa\7\24\2\2\u00aa"+
		"\u00ac\5\36\20\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00a8\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b5\7\b"+
		"\2\2\u00b3\u00b4\7\13\2\2\u00b4\u00b6\7\37\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00cc\3\2\2\2\u00b7\u00c2\7\t\2\2\u00b8\u00bd\5\36"+
		"\20\2\u00b9\u00ba\7\24\2\2\u00ba\u00bc\5\36\20\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00cc\7\n\2\2\u00c6\u00cc\7\37\2\2\u00c7\u00c9\7\26\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\7\33"+
		"\2\2\u00cb\u0097\3\2\2\2\u00cb\u00a6\3\2\2\2\u00cb\u00b7\3\2\2\2\u00cb"+
		"\u00c6\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cc\u00e7\3\2\2\2\u00cd\u00ce\f\r"+
		"\2\2\u00ce\u00cf\t\2\2\2\u00cf\u00e6\5\36\20\r\u00d0\u00d1\f\f\2\2\u00d1"+
		"\u00d2\t\3\2\2\u00d2\u00e6\5\36\20\f\u00d3\u00d4\f\13\2\2\u00d4\u00d5"+
		"\7\21\2\2\u00d5\u00e6\5\36\20\f\u00d6\u00d7\f\n\2\2\u00d7\u00d8\7\22\2"+
		"\2\u00d8\u00e6\5\36\20\13\u00d9\u00da\f\t\2\2\u00da\u00db\7\16\2\2\u00db"+
		"\u00e6\5\36\20\n\u00dc\u00dd\f\b\2\2\u00dd\u00de\7\20\2\2\u00de\u00e6"+
		"\5\36\20\t\u00df\u00e0\f\7\2\2\u00e0\u00e1\7\17\2\2\u00e1\u00e6\5\36\20"+
		"\b\u00e2\u00e3\f\6\2\2\u00e3\u00e4\7\23\2\2\u00e4\u00e6\5\36\20\7\u00e5"+
		"\u00cd\3\2\2\2\u00e5\u00d0\3\2\2\2\u00e5\u00d3\3\2\2\2\u00e5\u00d6\3\2"+
		"\2\2\u00e5\u00d9\3\2\2\2\u00e5\u00dc\3\2\2\2\u00e5\u00df\3\2\2\2\u00e5"+
		"\u00e2\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\37\3\2\2\2\u00e9\u00e7\3\2\2\2\30#*9SXbglu~\u0087\u0094\u00a1"+
		"\u00ad\u00b0\u00b5\u00bd\u00c2\u00c8\u00cb\u00e5\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}