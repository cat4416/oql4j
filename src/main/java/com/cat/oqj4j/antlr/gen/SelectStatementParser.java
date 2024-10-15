// Generated from SelectStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SelectStatementParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, WS=12, STRING=13, BOOLEAN=14, NULL=15, NUMBER=16, AND=17, 
		OR=18, IN=19, IS=20, BETWEEN=21, NOT=22, AS=23, EQ=24, GT=25, LT=26, GE=27, 
		LE=28, NEQ=29, COMMA=30, ID=31;
	public static final int
		RULE_parse = 0, RULE_stat = 1, RULE_select = 2, RULE_baseType = 3, RULE_funPlace = 4, 
		RULE_methodPlace = 5, RULE_fieldPlace = 6, RULE_idNest = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "stat", "select", "baseType", "funPlace", "methodPlace", "fieldPlace", 
			"idNest"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'f{'", "'('", "')'", "'}'", "'F{'", "'m{'", "'M{'", 
			"'${'", "'.'", null, null, null, null, null, null, null, null, null, 
			null, null, null, "'='", "'>'", "'<'", "'>='", "'<='", null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"WS", "STRING", "BOOLEAN", "NULL", "NUMBER", "AND", "OR", "IN", "IS", 
			"BETWEEN", "NOT", "AS", "EQ", "GT", "LT", "GE", "LE", "NEQ", "COMMA", 
			"ID"
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
	public String getGrammarFileName() { return "SelectStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SelectStatementParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SelectStatementParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			stat();
			setState(17);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public List<SelectContext> select() {
			return getRuleContexts(SelectContext.class);
		}
		public SelectContext select(int i) {
			return getRuleContext(SelectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SelectStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SelectStatementParser.COMMA, i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			select();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(20);
				match(COMMA);
				setState(21);
				select();
				}
				}
				setState(26);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectContext extends ParserRuleContext {
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	 
		public SelectContext() { }
		public void copyFrom(SelectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DirectSelectContext extends SelectContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public DirectSelectContext(SelectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterDirectSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitDirectSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitDirectSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsAliasSelectContext extends SelectContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode AS() { return getToken(SelectStatementParser.AS, 0); }
		public IdNestContext idNest() {
			return getRuleContext(IdNestContext.class,0);
		}
		public AsAliasSelectContext(SelectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterAsAliasSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitAsAliasSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitAsAliasSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AliasSelectContext extends SelectContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public IdNestContext idNest() {
			return getRuleContext(IdNestContext.class,0);
		}
		public AliasSelectContext(SelectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterAliasSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitAliasSelect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitAliasSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DirectSelectContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				baseType();
				}
				break;
			case 2:
				_localctx = new AliasSelectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				baseType();
				setState(29);
				idNest();
				}
				break;
			case 3:
				_localctx = new AsAliasSelectContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				baseType();
				setState(32);
				match(AS);
				setState(33);
				idNest();
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
	public static class BaseTypeContext extends ParserRuleContext {
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
	 
		public BaseTypeContext() { }
		public void copyFrom(BaseTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberValContext extends BaseTypeContext {
		public TerminalNode NUMBER() { return getToken(SelectStatementParser.NUMBER, 0); }
		public NumberValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterNumberVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitNumberVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitNumberVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunPlaceValContext extends BaseTypeContext {
		public FunPlaceContext funPlace() {
			return getRuleContext(FunPlaceContext.class,0);
		}
		public FunPlaceValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterFunPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitFunPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitFunPlaceVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodPlaceValContext extends BaseTypeContext {
		public MethodPlaceContext methodPlace() {
			return getRuleContext(MethodPlaceContext.class,0);
		}
		public MethodPlaceValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterMethodPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitMethodPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitMethodPlaceVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListValContext extends BaseTypeContext {
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SelectStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SelectStatementParser.COMMA, i);
		}
		public ListValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterListVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitListVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitListVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValContext extends BaseTypeContext {
		public TerminalNode STRING() { return getToken(SelectStatementParser.STRING, 0); }
		public StringValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanValContext extends BaseTypeContext {
		public TerminalNode BOOLEAN() { return getToken(SelectStatementParser.BOOLEAN, 0); }
		public BooleanValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterBooleanVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitBooleanVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitBooleanVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullValContext extends BaseTypeContext {
		public TerminalNode NULL() { return getToken(SelectStatementParser.NULL, 0); }
		public NullValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FieldPlaceValContext extends BaseTypeContext {
		public FieldPlaceContext fieldPlace() {
			return getRuleContext(FieldPlaceContext.class,0);
		}
		public FieldPlaceValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterFieldPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitFieldPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitFieldPlaceVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_baseType);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				match(NULL);
				}
				break;
			case T__9:
				_localctx = new FieldPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				fieldPlace();
				}
				break;
			case T__2:
			case T__6:
				_localctx = new FunPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				funPlace();
				}
				break;
			case T__7:
			case T__8:
				_localctx = new MethodPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(43);
				methodPlace();
				}
				break;
			case T__0:
				_localctx = new ListValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(44);
				match(T__0);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
					{
					setState(45);
					baseType();
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(46);
						match(COMMA);
						setState(47);
						baseType();
						}
						}
						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(55);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunPlaceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SelectStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SelectStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SelectStatementParser.COMMA, i);
		}
		public FunPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterFunPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitFunPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitFunPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunPlaceContext funPlace() throws RecognitionException {
		FunPlaceContext _localctx = new FunPlaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funPlace);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__2);
				setState(59);
				match(ID);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(60);
					match(T__3);
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(61);
						baseType();
						setState(66);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(62);
							match(COMMA);
							setState(63);
							baseType();
							}
							}
							setState(68);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(71);
					match(T__4);
					}
				}

				setState(74);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__6);
				setState(76);
				match(ID);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(77);
					match(T__3);
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(78);
						baseType();
						setState(83);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(79);
							match(COMMA);
							setState(80);
							baseType();
							}
							}
							setState(85);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(88);
					match(T__4);
					}
				}

				setState(91);
				match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodPlaceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SelectStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SelectStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SelectStatementParser.COMMA, i);
		}
		public MethodPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterMethodPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitMethodPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitMethodPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodPlaceContext methodPlace() throws RecognitionException {
		MethodPlaceContext _localctx = new MethodPlaceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodPlace);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(T__7);
				setState(95);
				match(ID);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(96);
					match(T__3);
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(97);
						baseType();
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(98);
							match(COMMA);
							setState(99);
							baseType();
							}
							}
							setState(104);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(107);
					match(T__4);
					}
				}

				setState(110);
				match(T__5);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__8);
				setState(112);
				match(ID);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(113);
					match(T__3);
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(114);
						baseType();
						setState(119);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(115);
							match(COMMA);
							setState(116);
							baseType();
							}
							}
							setState(121);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(124);
					match(T__4);
					}
				}

				setState(127);
				match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldPlaceContext extends ParserRuleContext {
		public IdNestContext idNest() {
			return getRuleContext(IdNestContext.class,0);
		}
		public FieldPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterFieldPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitFieldPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitFieldPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldPlaceContext fieldPlace() throws RecognitionException {
		FieldPlaceContext _localctx = new FieldPlaceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldPlace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__9);
			setState(131);
			idNest();
			setState(132);
			match(T__5);
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
	public static class IdNestContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SelectStatementParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SelectStatementParser.ID, i);
		}
		public IdNestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idNest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).enterIdNest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SelectStatementListener ) ((SelectStatementListener)listener).exitIdNest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SelectStatementVisitor ) return ((SelectStatementVisitor<? extends T>)visitor).visitIdNest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdNestContext idNest() throws RecognitionException {
		IdNestContext _localctx = new IdNestContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_idNest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ID);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(135);
				match(T__10);
				setState(136);
				match(ID);
				}
				}
				setState(141);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u008f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u0017\b\u0001\n\u0001\f\u0001\u001a\t\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002$\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u00031\b\u0003\n\u0003\f\u00034\t\u0003\u0003"+
		"\u00036\b\u0003\u0001\u0003\u0003\u00039\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004A\b\u0004"+
		"\n\u0004\f\u0004D\t\u0004\u0003\u0004F\b\u0004\u0001\u0004\u0003\u0004"+
		"I\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004R\b\u0004\n\u0004\f\u0004U\t\u0004"+
		"\u0003\u0004W\b\u0004\u0001\u0004\u0003\u0004Z\b\u0004\u0001\u0004\u0003"+
		"\u0004]\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005e\b\u0005\n\u0005\f\u0005h\t\u0005\u0003"+
		"\u0005j\b\u0005\u0001\u0005\u0003\u0005m\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"v\b\u0005\n\u0005\f\u0005y\t\u0005\u0003\u0005{\b\u0005\u0001\u0005\u0003"+
		"\u0005~\b\u0005\u0001\u0005\u0003\u0005\u0081\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u008a\b\u0007\n\u0007\f\u0007\u008d\t\u0007\u0001\u0007\u0000\u0000"+
		"\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000\u00a1\u0000\u0010\u0001"+
		"\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004#\u0001\u0000"+
		"\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000"+
		"\n\u0080\u0001\u0000\u0000\u0000\f\u0082\u0001\u0000\u0000\u0000\u000e"+
		"\u0086\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011"+
		"\u0012\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013"+
		"\u0018\u0003\u0004\u0002\u0000\u0014\u0015\u0005\u001e\u0000\u0000\u0015"+
		"\u0017\u0003\u0004\u0002\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0017"+
		"\u001a\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0001\u0000\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a"+
		"\u0018\u0001\u0000\u0000\u0000\u001b$\u0003\u0006\u0003\u0000\u001c\u001d"+
		"\u0003\u0006\u0003\u0000\u001d\u001e\u0003\u000e\u0007\u0000\u001e$\u0001"+
		"\u0000\u0000\u0000\u001f \u0003\u0006\u0003\u0000 !\u0005\u0017\u0000"+
		"\u0000!\"\u0003\u000e\u0007\u0000\"$\u0001\u0000\u0000\u0000#\u001b\u0001"+
		"\u0000\u0000\u0000#\u001c\u0001\u0000\u0000\u0000#\u001f\u0001\u0000\u0000"+
		"\u0000$\u0005\u0001\u0000\u0000\u0000%9\u0005\r\u0000\u0000&9\u0005\u0010"+
		"\u0000\u0000\'9\u0005\u000e\u0000\u0000(9\u0005\u000f\u0000\u0000)9\u0003"+
		"\f\u0006\u0000*9\u0003\b\u0004\u0000+9\u0003\n\u0005\u0000,5\u0005\u0001"+
		"\u0000\u0000-2\u0003\u0006\u0003\u0000./\u0005\u001e\u0000\u0000/1\u0003"+
		"\u0006\u0003\u00000.\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000036\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u00005-\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000079\u0005\u0002\u0000\u00008%\u0001"+
		"\u0000\u0000\u00008&\u0001\u0000\u0000\u00008\'\u0001\u0000\u0000\u0000"+
		"8(\u0001\u0000\u0000\u00008)\u0001\u0000\u0000\u00008*\u0001\u0000\u0000"+
		"\u00008+\u0001\u0000\u0000\u00008,\u0001\u0000\u0000\u00009\u0007\u0001"+
		"\u0000\u0000\u0000:;\u0005\u0003\u0000\u0000;H\u0005\u001f\u0000\u0000"+
		"<E\u0005\u0004\u0000\u0000=B\u0003\u0006\u0003\u0000>?\u0005\u001e\u0000"+
		"\u0000?A\u0003\u0006\u0003\u0000@>\u0001\u0000\u0000\u0000AD\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CF\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E=\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0005\u0005\u0000"+
		"\u0000H<\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000J]\u0005\u0006\u0000\u0000KL\u0005\u0007\u0000\u0000LY\u0005"+
		"\u001f\u0000\u0000MV\u0005\u0004\u0000\u0000NS\u0003\u0006\u0003\u0000"+
		"OP\u0005\u001e\u0000\u0000PR\u0003\u0006\u0003\u0000QO\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VN\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0005\u0005\u0000\u0000YM\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[]\u0005\u0006\u0000\u0000\\:\u0001\u0000"+
		"\u0000\u0000\\K\u0001\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^_\u0005"+
		"\b\u0000\u0000_l\u0005\u001f\u0000\u0000`i\u0005\u0004\u0000\u0000af\u0003"+
		"\u0006\u0003\u0000bc\u0005\u001e\u0000\u0000ce\u0003\u0006\u0003\u0000"+
		"db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000ia\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000km\u0005\u0005\u0000\u0000l`\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0081\u0005\u0006"+
		"\u0000\u0000op\u0005\t\u0000\u0000p}\u0005\u001f\u0000\u0000qz\u0005\u0004"+
		"\u0000\u0000rw\u0003\u0006\u0003\u0000st\u0005\u001e\u0000\u0000tv\u0003"+
		"\u0006\u0003\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000zr\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0005\u0005\u0000\u0000}q\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0005\u0006\u0000\u0000\u0080^\u0001\u0000\u0000\u0000"+
		"\u0080o\u0001\u0000\u0000\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\n\u0000\u0000\u0083\u0084\u0003\u000e\u0007\u0000\u0084\u0085"+
		"\u0005\u0006\u0000\u0000\u0085\r\u0001\u0000\u0000\u0000\u0086\u008b\u0005"+
		"\u001f\u0000\u0000\u0087\u0088\u0005\u000b\u0000\u0000\u0088\u008a\u0005"+
		"\u001f\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008d\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u000f\u0001\u0000\u0000\u0000\u008d\u008b\u0001"+
		"\u0000\u0000\u0000\u0014\u0018#258BEHSVY\\filwz}\u0080\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}