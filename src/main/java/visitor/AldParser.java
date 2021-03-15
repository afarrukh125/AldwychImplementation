package visitor;// Generated from AldParser.g4 by ANTLR 4.5.3

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AldParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            SEMICOLON = 1, COLON = 2, CURLY_OPEN = 3, CURLY_CLOSE = 4, PARENT_OPEN = 5, PARENT_CLOSE = 6,
            ARROW = 7, PRED_SEPARATOR = 8, HASH = 9, EQUALS = 10, GREATER_THAN = 11, GREATER_EQ = 12,
            LESS_EQ = 13, LESS = 14, COMMA = 15, PLUS_OPERATOR = 16, MINUS_OPERATOR = 17, MULT_OPERATOR = 18,
            DIV_OPERATOR = 19, TRUE = 20, FALSE = 21, INTEGER = 22, BOOLEAN = 23, STRING_CONST = 24,
            WHITESPACE = 25, ID = 26;
    public static final int
            RULE_aldwychClass = 0, RULE_declaration = 1, RULE_seqprocedure = 2, RULE_seqbody = 3,
            RULE_heading = 4, RULE_name = 5, RULE_formals = 6, RULE_readers = 7, RULE_writers = 8,
            RULE_body = 9, RULE_ruleset = 10, RULE_regularrule = 11, RULE_ask = 12,
            RULE_tell = 13, RULE_finalrule = 14, RULE_expr = 15;
    public static final String[] ruleNames = {
            "aldwychClass", "declaration", "seqprocedure", "seqbody", "heading", "name",
            "formals", "readers", "writers", "body", "ruleset", "regularrule", "ask",
            "tell", "finalrule", "expr"
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
    public String getGrammarFileName() {
        return "visitor/AldParser.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public AldParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class AldwychClassContext extends ParserRuleContext {
        public SeqprocedureContext seqprocedure() {
            return getRuleContext(SeqprocedureContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(AldParser.EOF, 0);
        }

        public List<DeclarationContext> declaration() {
            return getRuleContexts(DeclarationContext.class);
        }

        public DeclarationContext declaration(int i) {
            return getRuleContext(DeclarationContext.class, i);
        }

        public AldwychClassContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aldwychClass;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterAldwychClass(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitAldwychClass(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitAldwychClass(this);
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
                setState(32);
                seqprocedure();
                setState(36);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == HASH || _la == ID) {
                    {
                        {
                            setState(33);
                            declaration();
                        }
                    }
                    setState(38);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(39);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeclarationContext extends ParserRuleContext {
        public DeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declaration;
        }

        public DeclarationContext() {
        }

        public void copyFrom(DeclarationContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class DeclarationNodeContext extends DeclarationContext {
        public TerminalNode ID() {
            return getToken(AldParser.ID, 0);
        }

        public TerminalNode EQUALS() {
            return getToken(AldParser.EQUALS, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(AldParser.SEMICOLON, 0);
        }

        public DeclarationNodeContext(DeclarationContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterDeclarationNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitDeclarationNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitDeclarationNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ProcedureNodeContext extends DeclarationContext {
        public HeadingContext heading() {
            return getRuleContext(HeadingContext.class, 0);
        }

        public TerminalNode CURLY_OPEN() {
            return getToken(AldParser.CURLY_OPEN, 0);
        }

        public BodyContext body() {
            return getRuleContext(BodyContext.class, 0);
        }

        public TerminalNode CURLY_CLOSE() {
            return getToken(AldParser.CURLY_CLOSE, 0);
        }

        public ProcedureNodeContext(DeclarationContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterProcedureNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitProcedureNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitProcedureNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DeclarationContext declaration() throws RecognitionException {
        DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_declaration);
        try {
            setState(51);
            switch (_input.LA(1)) {
                case HASH:
                    _localctx = new ProcedureNodeContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(41);
                    heading();
                    setState(42);
                    match(CURLY_OPEN);
                    setState(43);
                    body();
                    setState(44);
                    match(CURLY_CLOSE);
                }
                break;
                case ID:
                    _localctx = new DeclarationNodeContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(46);
                    match(ID);
                    setState(47);
                    match(EQUALS);
                    setState(48);
                    expr(0);
                    setState(49);
                    match(SEMICOLON);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SeqprocedureContext extends ParserRuleContext {
        public SeqprocedureContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_seqprocedure;
        }

        public SeqprocedureContext() {
        }

        public void copyFrom(SeqprocedureContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SequentialProcedureNodeContext extends SeqprocedureContext {
        public HeadingContext heading() {
            return getRuleContext(HeadingContext.class, 0);
        }

        public TerminalNode CURLY_OPEN() {
            return getToken(AldParser.CURLY_OPEN, 0);
        }

        public SeqbodyContext seqbody() {
            return getRuleContext(SeqbodyContext.class, 0);
        }

        public TerminalNode CURLY_CLOSE() {
            return getToken(AldParser.CURLY_CLOSE, 0);
        }

        public SequentialProcedureNodeContext(SeqprocedureContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener)
                ((AldParserListener) listener).enterSequentialProcedureNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitSequentialProcedureNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitSequentialProcedureNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SeqprocedureContext seqprocedure() throws RecognitionException {
        SeqprocedureContext _localctx = new SeqprocedureContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_seqprocedure);
        try {
            _localctx = new SequentialProcedureNodeContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(53);
                heading();
                setState(54);
                match(CURLY_OPEN);
                setState(55);
                seqbody();
                setState(56);
                match(CURLY_CLOSE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SeqbodyContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(AldParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(AldParser.SEMICOLON, i);
        }

        public SeqbodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_seqbody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterSeqbody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitSeqbody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitSeqbody(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SeqbodyContext seqbody() throws RecognitionException {
        SeqbodyContext _localctx = new SeqbodyContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_seqbody);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(58);
                            expr(0);
                            setState(59);
                            match(SEMICOLON);
                        }
                    }
                    setState(63);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class HeadingContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public FormalsContext formals() {
            return getRuleContext(FormalsContext.class, 0);
        }

        public HeadingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_heading;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterHeading(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitHeading(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitHeading(this);
            else return visitor.visitChildren(this);
        }
    }

    public final HeadingContext heading() throws RecognitionException {
        HeadingContext _localctx = new HeadingContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_heading);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(65);
                name();
                setState(66);
                formals();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NameContext extends ParserRuleContext {
        public TerminalNode HASH() {
            return getToken(AldParser.HASH, 0);
        }

        public TerminalNode ID() {
            return getToken(AldParser.ID, 0);
        }

        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(68);
                match(HASH);
                setState(69);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FormalsContext extends ParserRuleContext {
        public ReadersContext readers() {
            return getRuleContext(ReadersContext.class, 0);
        }

        public TerminalNode ARROW() {
            return getToken(AldParser.ARROW, 0);
        }

        public WritersContext writers() {
            return getRuleContext(WritersContext.class, 0);
        }

        public FormalsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formals;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterFormals(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitFormals(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitFormals(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FormalsContext formals() throws RecognitionException {
        FormalsContext _localctx = new FormalsContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_formals);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(71);
                readers();
                setState(72);
                match(ARROW);
                setState(73);
                writers();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReadersContext extends ParserRuleContext {
        public List<TerminalNode> ID() {
            return getTokens(AldParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(AldParser.ID, i);
        }

        public TerminalNode PARENT_OPEN() {
            return getToken(AldParser.PARENT_OPEN, 0);
        }

        public TerminalNode PARENT_CLOSE() {
            return getToken(AldParser.PARENT_CLOSE, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(AldParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(AldParser.COMMA, i);
        }

        public ReadersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_readers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterReaders(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitReaders(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitReaders(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ReadersContext readers() throws RecognitionException {
        ReadersContext _localctx = new ReadersContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_readers);
        try {
            int _alt;
            setState(88);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(75);
                    match(ID);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(76);
                    match(PARENT_OPEN);
                    setState(77);
                    match(PARENT_CLOSE);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(78);
                    match(PARENT_OPEN);
                    setState(83);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(79);
                                    match(ID);
                                    setState(80);
                                    match(COMMA);
                                }
                            }
                        }
                        setState(85);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                    }
                    setState(86);
                    match(ID);
                    setState(87);
                    match(PARENT_CLOSE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WritersContext extends ParserRuleContext {
        public List<TerminalNode> ID() {
            return getTokens(AldParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(AldParser.ID, i);
        }

        public TerminalNode PARENT_OPEN() {
            return getToken(AldParser.PARENT_OPEN, 0);
        }

        public TerminalNode PARENT_CLOSE() {
            return getToken(AldParser.PARENT_CLOSE, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(AldParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(AldParser.COMMA, i);
        }

        public WritersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_writers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterWriters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitWriters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitWriters(this);
            else return visitor.visitChildren(this);
        }
    }

    public final WritersContext writers() throws RecognitionException {
        WritersContext _localctx = new WritersContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_writers);
        try {
            int _alt;
            setState(103);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(90);
                    match(ID);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(91);
                    match(PARENT_OPEN);
                    setState(92);
                    match(PARENT_CLOSE);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(93);
                    match(PARENT_OPEN);
                    setState(98);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(94);
                                    match(ID);
                                    setState(95);
                                    match(COMMA);
                                }
                            }
                        }
                        setState(100);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                    }
                    setState(101);
                    match(ID);
                    setState(102);
                    match(PARENT_CLOSE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BodyContext extends ParserRuleContext {
        public FinalruleContext finalrule() {
            return getRuleContext(FinalruleContext.class, 0);
        }

        public List<RulesetContext> ruleset() {
            return getRuleContexts(RulesetContext.class);
        }

        public RulesetContext ruleset(int i) {
            return getRuleContext(RulesetContext.class, i);
        }

        public BodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_body;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterBody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitBody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitBody(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BodyContext body() throws RecognitionException {
        BodyContext _localctx = new BodyContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_body);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(105);
                            ruleset();
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0));
                setState(110);
                finalrule();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RulesetContext extends ParserRuleContext {
        public TerminalNode COLON() {
            return getToken(AldParser.COLON, 0);
        }

        public List<RegularruleContext> regularrule() {
            return getRuleContexts(RegularruleContext.class);
        }

        public RegularruleContext regularrule(int i) {
            return getRuleContext(RegularruleContext.class, i);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(AldParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(AldParser.SEMICOLON, i);
        }

        public RulesetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ruleset;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterRuleset(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitRuleset(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitRuleset(this);
            else return visitor.visitChildren(this);
        }
    }

    public final RulesetContext ruleset() throws RecognitionException {
        RulesetContext _localctx = new RulesetContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_ruleset);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(115);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(112);
                            regularrule();
                            setState(113);
                            match(SEMICOLON);
                        }
                    }
                    setState(117);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0));
                setState(119);
                match(COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RegularruleContext extends ParserRuleContext {
        public List<AskContext> ask() {
            return getRuleContexts(AskContext.class);
        }

        public AskContext ask(int i) {
            return getRuleContext(AskContext.class, i);
        }

        public TerminalNode PRED_SEPARATOR() {
            return getToken(AldParser.PRED_SEPARATOR, 0);
        }

        public List<TellContext> tell() {
            return getRuleContexts(TellContext.class);
        }

        public TellContext tell(int i) {
            return getRuleContext(TellContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(AldParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(AldParser.COMMA, i);
        }

        public RegularruleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_regularrule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterRegularrule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitRegularrule(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitRegularrule(this);
            else return visitor.visitChildren(this);
        }
    }

    public final RegularruleContext regularrule() throws RecognitionException {
        RegularruleContext _localctx = new RegularruleContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_regularrule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(121);
                ask();
                setState(126);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(122);
                            match(COMMA);
                            setState(123);
                            ask();
                        }
                    }
                    setState(128);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(129);
                match(PRED_SEPARATOR);
                setState(130);
                tell();
                setState(135);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(131);
                            match(COMMA);
                            setState(132);
                            tell();
                        }
                    }
                    setState(137);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AskContext extends ParserRuleContext {
        public AskContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ask;
        }

        public AskContext() {
        }

        public void copyFrom(AskContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class AskNodeContext extends AskContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public AskNodeContext(AskContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterAskNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitAskNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitAskNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AskContext ask() throws RecognitionException {
        AskContext _localctx = new AskContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_ask);
        try {
            _localctx = new AskNodeContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(138);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TellContext extends ParserRuleContext {
        public TellContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tell;
        }

        public TellContext() {
        }

        public void copyFrom(TellContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class TellNodeContext extends TellContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TellNodeContext(TellContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterTellNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitTellNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitTellNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public final TellContext tell() throws RecognitionException {
        TellContext _localctx = new TellContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_tell);
        try {
            _localctx = new TellNodeContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(140);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FinalruleContext extends ParserRuleContext {
        public TerminalNode PRED_SEPARATOR() {
            return getToken(AldParser.PRED_SEPARATOR, 0);
        }

        public List<TellContext> tell() {
            return getRuleContexts(TellContext.class);
        }

        public TellContext tell(int i) {
            return getRuleContext(TellContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(AldParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(AldParser.COMMA, i);
        }

        public FinalruleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_finalrule;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterFinalrule(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitFinalrule(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitFinalrule(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FinalruleContext finalrule() throws RecognitionException {
        FinalruleContext _localctx = new FinalruleContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_finalrule);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                match(PRED_SEPARATOR);
                setState(143);
                tell();
                setState(148);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(144);
                            match(COMMA);
                            setState(145);
                            tell();
                        }
                    }
                    setState(150);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class DispatchNodeContext extends ExprContext {
        public List<TerminalNode> ID() {
            return getTokens(AldParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(AldParser.ID, i);
        }

        public TerminalNode PARENT_OPEN() {
            return getToken(AldParser.PARENT_OPEN, 0);
        }

        public TerminalNode PARENT_CLOSE() {
            return getToken(AldParser.PARENT_CLOSE, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode ARROW() {
            return getToken(AldParser.ARROW, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(AldParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(AldParser.COMMA, i);
        }

        public DispatchNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterDispatchNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitDispatchNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitDispatchNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class GEqNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode GREATER_EQ() {
            return getToken(AldParser.GREATER_EQ, 0);
        }

        public GEqNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterGEqNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitGEqNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitGEqNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class GTNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode GREATER_THAN() {
            return getToken(AldParser.GREATER_THAN, 0);
        }

        public GTNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterGTNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitGTNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitGTNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntegerNodeContext extends ExprContext {
        public TerminalNode INTEGER() {
            return getToken(AldParser.INTEGER, 0);
        }

        public IntegerNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterIntegerNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitIntegerNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitIntegerNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IdentifierNodeContext extends ExprContext {
        public TerminalNode ID() {
            return getToken(AldParser.ID, 0);
        }

        public IdentifierNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterIdentifierNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitIdentifierNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitIdentifierNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TrueContext extends ExprContext {
        public TerminalNode TRUE() {
            return getToken(AldParser.TRUE, 0);
        }

        public TrueContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterTrue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitTrue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitTrue(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FalseContext extends ExprContext {
        public TerminalNode FALSE() {
            return getToken(AldParser.FALSE, 0);
        }

        public FalseContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterFalse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitFalse(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitFalse(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LEqNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LESS_EQ() {
            return getToken(AldParser.LESS_EQ, 0);
        }

        public LEqNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterLEqNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitLEqNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitLEqNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LtNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LESS() {
            return getToken(AldParser.LESS, 0);
        }

        public LtNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterLtNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitLtNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitLtNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StringConstNodeContext extends ExprContext {
        public TerminalNode STRING_CONST() {
            return getToken(AldParser.STRING_CONST, 0);
        }

        public StringConstNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterStringConstNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitStringConstNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitStringConstNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DivMultNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MULT_OPERATOR() {
            return getToken(AldParser.MULT_OPERATOR, 0);
        }

        public TerminalNode DIV_OPERATOR() {
            return getToken(AldParser.DIV_OPERATOR, 0);
        }

        public DivMultNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterDivMultNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitDivMultNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitDivMultNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MinusPlusNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MINUS_OPERATOR() {
            return getToken(AldParser.MINUS_OPERATOR, 0);
        }

        public TerminalNode PLUS_OPERATOR() {
            return getToken(AldParser.PLUS_OPERATOR, 0);
        }

        public MinusPlusNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterMinusPlusNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitMinusPlusNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor)
                return ((AldParserVisitor<? extends T>) visitor).visitMinusPlusNode(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EqNodeContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode EQUALS() {
            return getToken(AldParser.EQUALS, 0);
        }

        public EqNodeContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).enterEqNode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AldParserListener) ((AldParserListener) listener).exitEqNode(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof AldParserVisitor) return ((AldParserVisitor<? extends T>) visitor).visitEqNode(this);
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
        int _startState = 30;
        enterRecursionRule(_localctx, 30, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(174);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                    case 1: {
                        _localctx = new DispatchNodeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(152);
                        match(ID);
                        setState(153);
                        match(PARENT_OPEN);
                        setState(162);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRING_CONST) | (1L << ID))) != 0)) {
                            {
                                setState(154);
                                expr(0);
                                setState(159);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == COMMA) {
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
                        }

                        setState(164);
                        match(PARENT_CLOSE);
                        setState(167);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                            case 1: {
                                setState(165);
                                match(ARROW);
                                setState(166);
                                match(ID);
                            }
                            break;
                        }
                    }
                    break;
                    case 2: {
                        _localctx = new IdentifierNodeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(169);
                        match(ID);
                    }
                    break;
                    case 3: {
                        _localctx = new IntegerNodeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(170);
                        match(INTEGER);
                    }
                    break;
                    case 4: {
                        _localctx = new StringConstNodeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(171);
                        match(STRING_CONST);
                    }
                    break;
                    case 5: {
                        _localctx = new TrueContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(172);
                        match(TRUE);
                    }
                    break;
                    case 6: {
                        _localctx = new FalseContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(173);
                        match(FALSE);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(199);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(197);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                                case 1: {
                                    _localctx = new DivMultNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(176);
                                    if (!(precpred(_ctx, 12)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(177);
                                    _la = _input.LA(1);
                                    if (!(_la == MULT_OPERATOR || _la == DIV_OPERATOR)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(178);
                                    expr(12);
                                }
                                break;
                                case 2: {
                                    _localctx = new MinusPlusNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(179);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(180);
                                    _la = _input.LA(1);
                                    if (!(_la == PLUS_OPERATOR || _la == MINUS_OPERATOR)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(181);
                                    expr(11);
                                }
                                break;
                                case 3: {
                                    _localctx = new LEqNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(182);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(183);
                                    match(LESS_EQ);
                                    setState(184);
                                    expr(11);
                                }
                                break;
                                case 4: {
                                    _localctx = new LtNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(185);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(186);
                                    match(LESS);
                                    setState(187);
                                    expr(10);
                                }
                                break;
                                case 5: {
                                    _localctx = new EqNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(188);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(189);
                                    match(EQUALS);
                                    setState(190);
                                    expr(9);
                                }
                                break;
                                case 6: {
                                    _localctx = new GEqNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(191);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(192);
                                    match(GREATER_EQ);
                                    setState(193);
                                    expr(8);
                                }
                                break;
                                case 7: {
                                    _localctx = new GTNodeContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(194);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(195);
                                    match(GREATER_THAN);
                                    setState(196);
                                    expr(7);
                                }
                                break;
                            }
                        }
                    }
                    setState(201);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 15:
                return expr_sempred((ExprContext) _localctx, predIndex);
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
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00cd\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2" +
                    "\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5@\n\5\r\5\16\5A\3\6\3" +
                    "\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tT\n\t\f" +
                    "\t\16\tW\13\t\3\t\3\t\5\t[\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nc\n\n\f\n\16" +
                    "\nf\13\n\3\n\3\n\5\nj\n\n\3\13\6\13m\n\13\r\13\16\13n\3\13\3\13\3\f\3" +
                    "\f\3\f\6\fv\n\f\r\f\16\fw\3\f\3\f\3\r\3\r\3\r\7\r\177\n\r\f\r\16\r\u0082" +
                    "\13\r\3\r\3\r\3\r\3\r\7\r\u0088\n\r\f\r\16\r\u008b\13\r\3\16\3\16\3\17" +
                    "\3\17\3\20\3\20\3\20\3\20\7\20\u0095\n\20\f\20\16\20\u0098\13\20\3\21" +
                    "\3\21\3\21\3\21\3\21\3\21\7\21\u00a0\n\21\f\21\16\21\u00a3\13\21\5\21" +
                    "\u00a5\n\21\3\21\3\21\3\21\5\21\u00aa\n\21\3\21\3\21\3\21\3\21\3\21\5" +
                    "\21\u00b1\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00c8\n\21\f\21" +
                    "\16\21\u00cb\13\21\3\21\2\3 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36" +
                    " \2\4\3\2\24\25\3\2\22\23\u00d9\2\"\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2" +
                    "\b?\3\2\2\2\nC\3\2\2\2\fF\3\2\2\2\16I\3\2\2\2\20Z\3\2\2\2\22i\3\2\2\2" +
                    "\24l\3\2\2\2\26u\3\2\2\2\30{\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3\2\2\2" +
                    "\36\u0090\3\2\2\2 \u00b0\3\2\2\2\"&\5\6\4\2#%\5\4\3\2$#\3\2\2\2%(\3\2" +
                    "\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\2\2\3*\3\3\2\2\2+," +
                    "\5\n\6\2,-\7\5\2\2-.\5\24\13\2./\7\6\2\2/\66\3\2\2\2\60\61\7\34\2\2\61" +
                    "\62\7\f\2\2\62\63\5 \21\2\63\64\7\3\2\2\64\66\3\2\2\2\65+\3\2\2\2\65\60" +
                    "\3\2\2\2\66\5\3\2\2\2\678\5\n\6\289\7\5\2\29:\5\b\5\2:;\7\6\2\2;\7\3\2" +
                    "\2\2<=\5 \21\2=>\7\3\2\2>@\3\2\2\2?<\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2" +
                    "\2\2B\t\3\2\2\2CD\5\f\7\2DE\5\16\b\2E\13\3\2\2\2FG\7\13\2\2GH\7\34\2\2" +
                    "H\r\3\2\2\2IJ\5\20\t\2JK\7\t\2\2KL\5\22\n\2L\17\3\2\2\2M[\7\34\2\2NO\7" +
                    "\7\2\2O[\7\b\2\2PU\7\7\2\2QR\7\34\2\2RT\7\21\2\2SQ\3\2\2\2TW\3\2\2\2U" +
                    "S\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\34\2\2Y[\7\b\2\2ZM\3\2\2\2" +
                    "ZN\3\2\2\2ZP\3\2\2\2[\21\3\2\2\2\\j\7\34\2\2]^\7\7\2\2^j\7\b\2\2_d\7\7" +
                    "\2\2`a\7\34\2\2ac\7\21\2\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3" +
                    "\2\2\2fd\3\2\2\2gh\7\34\2\2hj\7\b\2\2i\\\3\2\2\2i]\3\2\2\2i_\3\2\2\2j" +
                    "\23\3\2\2\2km\5\26\f\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2" +
                    "\2pq\5\36\20\2q\25\3\2\2\2rs\5\30\r\2st\7\3\2\2tv\3\2\2\2ur\3\2\2\2vw" +
                    "\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\4\2\2z\27\3\2\2\2{\u0080\5" +
                    "\32\16\2|}\7\21\2\2}\177\5\32\16\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~" +
                    "\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083" +
                    "\u0084\7\n\2\2\u0084\u0089\5\34\17\2\u0085\u0086\7\21\2\2\u0086\u0088" +
                    "\5\34\17\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2" +
                    "\u0089\u008a\3\2\2\2\u008a\31\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d" +
                    "\5 \21\2\u008d\33\3\2\2\2\u008e\u008f\5 \21\2\u008f\35\3\2\2\2\u0090\u0091" +
                    "\7\n\2\2\u0091\u0096\5\34\17\2\u0092\u0093\7\21\2\2\u0093\u0095\5\34\17" +
                    "\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097" +
                    "\3\2\2\2\u0097\37\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\b\21\1\2\u009a" +
                    "\u009b\7\34\2\2\u009b\u00a4\7\7\2\2\u009c\u00a1\5 \21\2\u009d\u009e\7" +
                    "\21\2\2\u009e\u00a0\5 \21\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1" +
                    "\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2" +
                    "\2\2\u00a4\u009c\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6" +
                    "\u00a9\7\b\2\2\u00a7\u00a8\7\t\2\2\u00a8\u00aa\7\34\2\2\u00a9\u00a7\3" +
                    "\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b1\3\2\2\2\u00ab\u00b1\7\34\2\2\u00ac" +
                    "\u00b1\7\30\2\2\u00ad\u00b1\7\32\2\2\u00ae\u00b1\7\26\2\2\u00af\u00b1" +
                    "\7\27\2\2\u00b0\u0099\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2" +
                    "\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00c9" +
                    "\3\2\2\2\u00b2\u00b3\f\16\2\2\u00b3\u00b4\t\2\2\2\u00b4\u00c8\5 \21\16" +
                    "\u00b5\u00b6\f\r\2\2\u00b6\u00b7\t\3\2\2\u00b7\u00c8\5 \21\r\u00b8\u00b9" +
                    "\f\f\2\2\u00b9\u00ba\7\17\2\2\u00ba\u00c8\5 \21\r\u00bb\u00bc\f\13\2\2" +
                    "\u00bc\u00bd\7\20\2\2\u00bd\u00c8\5 \21\f\u00be\u00bf\f\n\2\2\u00bf\u00c0" +
                    "\7\f\2\2\u00c0\u00c8\5 \21\13\u00c1\u00c2\f\t\2\2\u00c2\u00c3\7\16\2\2" +
                    "\u00c3\u00c8\5 \21\n\u00c4\u00c5\f\b\2\2\u00c5\u00c6\7\r\2\2\u00c6\u00c8" +
                    "\5 \21\t\u00c7\u00b2\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7" +
                    "\u00bb\3\2\2\2\u00c7\u00be\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3\2" +
                    "\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca" +
                    "!\3\2\2\2\u00cb\u00c9\3\2\2\2\24&\65AUZdinw\u0080\u0089\u0096\u00a1\u00a4" +
                    "\u00a9\u00b0\u00c7\u00c9";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}