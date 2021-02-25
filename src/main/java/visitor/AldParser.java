package visitor;// Generated from AldParser.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMICOLON=1, COLON=2, CURLY_OPEN=3, CURLY_CLOSE=4, PARENT_OPEN=5, PARENT_CLOSE=6, 
		ARROW=7, PRED_SEPARATOR=8, HASH=9, EQUALS=10, GREATER_THAN=11, GREATER_EQ=12, 
		LESS_EQ=13, LESS=14, COMMA=15, PLUS_OPERATOR=16, MINUS_OPERATOR=17, MULT_OPERATOR=18, 
		DIV_OPERATOR=19, TRUE=20, FALSE=21, INTEGER=22, BOOLEAN=23, STRING_CONST=24, 
		WHITESPACE=25, ID=26;
	public static final int
		RULE_aldwychClass = 0, RULE_declaration = 1, RULE_heading = 2, RULE_name = 3, 
		RULE_formals = 4, RULE_readers = 5, RULE_writers = 6, RULE_body = 7, RULE_regularrule = 8, 
		RULE_ask = 9, RULE_tell = 10, RULE_finalrule = 11, RULE_expr = 12;
	public static final String[] ruleNames = {
		"aldwychClass", "declaration", "heading", "name", "formals", "readers", 
		"writers", "body", "regularrule", "ask", "tell", "finalrule", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'{'", "'}'", "'('", "')'", "'->'", "'||'", "'#'", 
		"'='", "'>'", "'>='", "'<='", "'<'", "','", "'+'", "'-'", "'*'", "'/'", 
		"'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SEMICOLON", "COLON", "CURLY_OPEN", "CURLY_CLOSE", "PARENT_OPEN", 
		"PARENT_CLOSE", "ARROW", "PRED_SEPARATOR", "HASH", "EQUALS", "GREATER_THAN", 
		"GREATER_EQ", "LESS_EQ", "LESS", "COMMA", "PLUS_OPERATOR", "MINUS_OPERATOR", 
		"MULT_OPERATOR", "DIV_OPERATOR", "TRUE", "FALSE", "INTEGER", "BOOLEAN", 
		"STRING_CONST", "WHITESPACE", "ID"
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
	public String getGrammarFileName() { return "visitor/AldParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AldParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AldwychClassContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AldParser.EOF, 0); }
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
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterAldwychClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitAldwychClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitAldwychClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AldwychClassContext aldwychClass() throws RecognitionException {
		AldwychClassContext _localctx = new AldwychClassContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aldwychClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				declaration();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HASH || _la==ID );
			setState(31);
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
		public TerminalNode ID() { return getToken(AldParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(AldParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AldParser.SEMICOLON, 0); }
		public DeclarationNodeContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterDeclarationNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitDeclarationNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitDeclarationNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProcedureNodeContext extends DeclarationContext {
		public HeadingContext heading() {
			return getRuleContext(HeadingContext.class,0);
		}
		public TerminalNode CURLY_OPEN() { return getToken(AldParser.CURLY_OPEN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode CURLY_CLOSE() { return getToken(AldParser.CURLY_CLOSE, 0); }
		public ProcedureNodeContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterProcedureNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitProcedureNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitProcedureNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(43);
			switch (_input.LA(1)) {
			case HASH:
				_localctx = new ProcedureNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				heading();
				setState(34);
				match(CURLY_OPEN);
				setState(35);
				body();
				setState(36);
				match(CURLY_CLOSE);
				}
				break;
			case ID:
				_localctx = new DeclarationNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(ID);
				setState(39);
				match(EQUALS);
				setState(40);
				expr(0);
				setState(41);
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
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadingContext heading() throws RecognitionException {
		HeadingContext _localctx = new HeadingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_heading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			name();
			setState(46);
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
		public TerminalNode HASH() { return getToken(AldParser.HASH, 0); }
		public TerminalNode ID() { return getToken(AldParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(HASH);
			setState(49);
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
		public TerminalNode ARROW() { return getToken(AldParser.ARROW, 0); }
		public WritersContext writers() {
			return getRuleContext(WritersContext.class,0);
		}
		public FormalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterFormals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitFormals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitFormals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalsContext formals() throws RecognitionException {
		FormalsContext _localctx = new FormalsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			readers();
			setState(52);
			match(ARROW);
			setState(53);
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
		public List<TerminalNode> ID() { return getTokens(AldParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldParser.ID, i);
		}
		public TerminalNode PARENT_OPEN() { return getToken(AldParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldParser.PARENT_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldParser.COMMA, i);
		}
		public ReadersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterReaders(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitReaders(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitReaders(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadersContext readers() throws RecognitionException {
		ReadersContext _localctx = new ReadersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_readers);
		try {
			int _alt;
			setState(66);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(ID);
				}
				break;
			case PARENT_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(PARENT_OPEN);
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(57);
						match(ID);
						setState(58);
						match(COMMA);
						}
						} 
					}
					setState(63);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(64);
				match(ID);
				setState(65);
				match(PARENT_CLOSE);
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

	public static class WritersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AldParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AldParser.ID, i);
		}
		public TerminalNode PARENT_OPEN() { return getToken(AldParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldParser.PARENT_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(AldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldParser.COMMA, i);
		}
		public WritersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterWriters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitWriters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitWriters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritersContext writers() throws RecognitionException {
		WritersContext _localctx = new WritersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_writers);
		try {
			int _alt;
			setState(79);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(ID);
				}
				break;
			case PARENT_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(PARENT_OPEN);
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(70);
						match(ID);
						setState(71);
						match(COMMA);
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(77);
				match(ID);
				setState(78);
				match(PARENT_CLOSE);
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

	public static class BodyContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(AldParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(AldParser.COLON, i);
		}
		public FinalruleContext finalrule() {
			return getRuleContext(FinalruleContext.class,0);
		}
		public List<RegularruleContext> regularrule() {
			return getRuleContexts(RegularruleContext.class);
		}
		public RegularruleContext regularrule(int i) {
			return getRuleContext(RegularruleContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AldParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AldParser.SEMICOLON, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0)) {
				{
				{
				setState(81);
				regularrule();
				setState(82);
				match(SEMICOLON);
				setState(84);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(83);
					match(COLON);
					}
					break;
				}
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(COLON);
			setState(92);
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

	public static class RegularruleContext extends ParserRuleContext {
		public List<AskContext> ask() {
			return getRuleContexts(AskContext.class);
		}
		public AskContext ask(int i) {
			return getRuleContext(AskContext.class,i);
		}
		public TerminalNode PRED_SEPARATOR() { return getToken(AldParser.PRED_SEPARATOR, 0); }
		public List<TellContext> tell() {
			return getRuleContexts(TellContext.class);
		}
		public TellContext tell(int i) {
			return getRuleContext(TellContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldParser.COMMA, i);
		}
		public RegularruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterRegularrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitRegularrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitRegularrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularruleContext regularrule() throws RecognitionException {
		RegularruleContext _localctx = new RegularruleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_regularrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			ask();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				ask();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(PRED_SEPARATOR);
			setState(103);
			tell();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(104);
				match(COMMA);
				setState(105);
				tell();
				}
				}
				setState(110);
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
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterAskNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitAskNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitAskNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AskContext ask() throws RecognitionException {
		AskContext _localctx = new AskContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ask);
		try {
			_localctx = new AskNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
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
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterTellNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitTellNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitTellNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TellContext tell() throws RecognitionException {
		TellContext _localctx = new TellContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tell);
		try {
			_localctx = new TellNodeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		public TerminalNode PRED_SEPARATOR() { return getToken(AldParser.PRED_SEPARATOR, 0); }
		public List<TellContext> tell() {
			return getRuleContexts(TellContext.class);
		}
		public TellContext tell(int i) {
			return getRuleContext(TellContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldParser.COMMA, i);
		}
		public FinalruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterFinalrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitFinalrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitFinalrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalruleContext finalrule() throws RecognitionException {
		FinalruleContext _localctx = new FinalruleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_finalrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(PRED_SEPARATOR);
			setState(116);
			tell();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(117);
				match(COMMA);
				setState(118);
				tell();
				}
				}
				setState(123);
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
		public TerminalNode ID() { return getToken(AldParser.ID, 0); }
		public TerminalNode PARENT_OPEN() { return getToken(AldParser.PARENT_OPEN, 0); }
		public TerminalNode PARENT_CLOSE() { return getToken(AldParser.PARENT_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AldParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AldParser.COMMA, i);
		}
		public DispatchNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterDispatchNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitDispatchNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitDispatchNode(this);
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
		public TerminalNode GREATER_EQ() { return getToken(AldParser.GREATER_EQ, 0); }
		public GEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterGEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitGEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitGEqNode(this);
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
		public TerminalNode GREATER_THAN() { return getToken(AldParser.GREATER_THAN, 0); }
		public GTNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterGTNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitGTNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitGTNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerNodeContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(AldParser.INTEGER, 0); }
		public IntegerNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterIntegerNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitIntegerNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitIntegerNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierNodeContext extends ExprContext {
		public TerminalNode ID() { return getToken(AldParser.ID, 0); }
		public IdentifierNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterIdentifierNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitIdentifierNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitIdentifierNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(AldParser.TRUE, 0); }
		public TrueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(AldParser.FALSE, 0); }
		public FalseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitFalse(this);
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
		public TerminalNode LESS_EQ() { return getToken(AldParser.LESS_EQ, 0); }
		public LEqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterLEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitLEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitLEqNode(this);
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
		public TerminalNode LESS() { return getToken(AldParser.LESS, 0); }
		public LtNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterLtNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitLtNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitLtNode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConstNodeContext extends ExprContext {
		public TerminalNode STRING_CONST() { return getToken(AldParser.STRING_CONST, 0); }
		public StringConstNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterStringConstNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitStringConstNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitStringConstNode(this);
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
		public TerminalNode MULT_OPERATOR() { return getToken(AldParser.MULT_OPERATOR, 0); }
		public TerminalNode DIV_OPERATOR() { return getToken(AldParser.DIV_OPERATOR, 0); }
		public DivMultNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterDivMultNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitDivMultNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitDivMultNode(this);
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
		public TerminalNode MINUS_OPERATOR() { return getToken(AldParser.MINUS_OPERATOR, 0); }
		public TerminalNode PLUS_OPERATOR() { return getToken(AldParser.PLUS_OPERATOR, 0); }
		public MinusPlusNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterMinusPlusNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitMinusPlusNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitMinusPlusNode(this);
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
		public TerminalNode EQUALS() { return getToken(AldParser.EQUALS, 0); }
		public EqNodeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).enterEqNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AldParserListener ) ((AldParserListener)listener).exitEqNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AldParserVisitor ) return ((AldParserVisitor<? extends T>)visitor).visitEqNode(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new DispatchNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(125);
				match(ID);
				setState(126);
				match(PARENT_OPEN);
				setState(135);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0)) {
					{
					setState(127);
					expr(0);
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(128);
						match(COMMA);
						setState(129);
						expr(0);
						}
						}
						setState(134);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(137);
				match(PARENT_CLOSE);
				}
				break;
			case 2:
				{
				_localctx = new IdentifierNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new IntegerNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(INTEGER);
				}
				break;
			case 4:
				{
				_localctx = new StringConstNodeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(STRING_CONST);
				}
				break;
			case 5:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(TRUE);
				}
				break;
			case 6:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new DivMultNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(146);
						_la = _input.LA(1);
						if ( !(_la==MULT_OPERATOR || _la==DIV_OPERATOR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(147);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new MinusPlusNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(149);
						_la = _input.LA(1);
						if ( !(_la==PLUS_OPERATOR || _la==MINUS_OPERATOR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(150);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new LEqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(152);
						match(LESS_EQ);
						setState(153);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new LtNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(155);
						match(LESS);
						setState(156);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new EqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(158);
						match(EQUALS);
						setState(159);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new GEqNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(161);
						match(GREATER_EQ);
						setState(162);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new GTNodeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(164);
						match(GREATER_THAN);
						setState(165);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00ae\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\36\n\2\r\2\16\2\37\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7>\n\7\f\7\16\7A\13\7\3\7\3\7\5\7E"+
		"\n\7\3\b\3\b\3\b\3\b\7\bK\n\b\f\b\16\bN\13\b\3\b\3\b\5\bR\n\b\3\t\3\t"+
		"\3\t\5\tW\n\t\7\tY\n\t\f\t\16\t\\\13\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nd\n"+
		"\n\f\n\16\ng\13\n\3\n\3\n\3\n\3\n\7\nm\n\n\f\n\16\np\13\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\7\rz\n\r\f\r\16\r}\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u0085\n\16\f\16\16\16\u0088\13\16\5\16\u008a\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0092\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u00a9\n\16\f\16\16\16\u00ac\13\16\3\16\2\3\32\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\4\3\2\24\25\3\2\22\23\u00b9\2\35\3\2\2\2\4-\3\2\2"+
		"\2\6/\3\2\2\2\b\62\3\2\2\2\n\65\3\2\2\2\fD\3\2\2\2\16Q\3\2\2\2\20Z\3\2"+
		"\2\2\22`\3\2\2\2\24q\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32\u0091\3\2\2\2"+
		"\34\36\5\4\3\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 "+
		"!\3\2\2\2!\"\7\2\2\3\"\3\3\2\2\2#$\5\6\4\2$%\7\5\2\2%&\5\20\t\2&\'\7\6"+
		"\2\2\'.\3\2\2\2()\7\34\2\2)*\7\f\2\2*+\5\32\16\2+,\7\3\2\2,.\3\2\2\2-"+
		"#\3\2\2\2-(\3\2\2\2.\5\3\2\2\2/\60\5\b\5\2\60\61\5\n\6\2\61\7\3\2\2\2"+
		"\62\63\7\13\2\2\63\64\7\34\2\2\64\t\3\2\2\2\65\66\5\f\7\2\66\67\7\t\2"+
		"\2\678\5\16\b\28\13\3\2\2\29E\7\34\2\2:?\7\7\2\2;<\7\34\2\2<>\7\21\2\2"+
		"=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\34\2"+
		"\2CE\7\b\2\2D9\3\2\2\2D:\3\2\2\2E\r\3\2\2\2FR\7\34\2\2GL\7\7\2\2HI\7\34"+
		"\2\2IK\7\21\2\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3"+
		"\2\2\2OP\7\34\2\2PR\7\b\2\2QF\3\2\2\2QG\3\2\2\2R\17\3\2\2\2ST\5\22\n\2"+
		"TV\7\3\2\2UW\7\4\2\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2XS\3\2\2\2Y\\\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\4\2\2^_\5\30\r\2_\21\3"+
		"\2\2\2`e\5\24\13\2ab\7\21\2\2bd\5\24\13\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2"+
		"\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\n\2\2in\5\26\f\2jk\7\21\2\2km\5\26"+
		"\f\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\23\3\2\2\2pn\3\2\2\2qr\5"+
		"\32\16\2r\25\3\2\2\2st\5\32\16\2t\27\3\2\2\2uv\7\n\2\2v{\5\26\f\2wx\7"+
		"\21\2\2xz\5\26\f\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\31\3\2\2\2"+
		"}{\3\2\2\2~\177\b\16\1\2\177\u0080\7\34\2\2\u0080\u0089\7\7\2\2\u0081"+
		"\u0086\5\32\16\2\u0082\u0083\7\21\2\2\u0083\u0085\5\32\16\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u0092\7\b\2\2\u008c\u0092\7\34\2\2\u008d"+
		"\u0092\7\30\2\2\u008e\u0092\7\32\2\2\u008f\u0092\7\26\2\2\u0090\u0092"+
		"\7\27\2\2\u0091~\3\2\2\2\u0091\u008c\3\2\2\2\u0091\u008d\3\2\2\2\u0091"+
		"\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\u00aa\3\2"+
		"\2\2\u0093\u0094\f\16\2\2\u0094\u0095\t\2\2\2\u0095\u00a9\5\32\16\16\u0096"+
		"\u0097\f\r\2\2\u0097\u0098\t\3\2\2\u0098\u00a9\5\32\16\r\u0099\u009a\f"+
		"\f\2\2\u009a\u009b\7\17\2\2\u009b\u00a9\5\32\16\r\u009c\u009d\f\13\2\2"+
		"\u009d\u009e\7\20\2\2\u009e\u00a9\5\32\16\f\u009f\u00a0\f\n\2\2\u00a0"+
		"\u00a1\7\f\2\2\u00a1\u00a9\5\32\16\13\u00a2\u00a3\f\t\2\2\u00a3\u00a4"+
		"\7\16\2\2\u00a4\u00a9\5\32\16\n\u00a5\u00a6\f\b\2\2\u00a6\u00a7\7\r\2"+
		"\2\u00a7\u00a9\5\32\16\t\u00a8\u0093\3\2\2\2\u00a8\u0096\3\2\2\2\u00a8"+
		"\u0099\3\2\2\2\u00a8\u009c\3\2\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a2\3\2"+
		"\2\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\33\3\2\2\2\u00ac\u00aa\3\2\2\2\22\37-?DLQVZen{\u0086"+
		"\u0089\u0091\u00a8\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}