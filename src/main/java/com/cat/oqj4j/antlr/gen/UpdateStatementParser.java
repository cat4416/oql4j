// Generated from UpdateStatement.g4 by ANTLR 4.13.1
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
public class UpdateStatementParser extends Parser {
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
		RULE_parse = 0, RULE_stat = 1, RULE_update = 2, RULE_updateField = 3, 
		RULE_baseType = 4, RULE_funPlace = 5, RULE_methodPlace = 6, RULE_fieldPlace = 7, 
		RULE_idNest = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "stat", "update", "updateField", "baseType", "funPlace", "methodPlace", 
			"fieldPlace", "idNest"
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
	public String getGrammarFileName() { return "UpdateStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UpdateStatementParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode EOF() { return getToken(UpdateStatementParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			stat();
			setState(19);
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
		public List<UpdateContext> update() {
			return getRuleContexts(UpdateContext.class);
		}
		public UpdateContext update(int i) {
			return getRuleContext(UpdateContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UpdateStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UpdateStatementParser.COMMA, i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitStat(this);
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
			setState(21);
			update();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(22);
				match(COMMA);
				setState(23);
				update();
				}
				}
				setState(28);
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
	public static class UpdateContext extends ParserRuleContext {
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
	 
		public UpdateContext() { }
		public void copyFrom(UpdateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseAssignContext extends UpdateContext {
		public UpdateFieldContext updateField() {
			return getRuleContext(UpdateFieldContext.class,0);
		}
		public TerminalNode EQ() { return getToken(UpdateStatementParser.EQ, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public BaseAssignContext(UpdateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterBaseAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitBaseAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitBaseAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_update);
		try {
			_localctx = new BaseAssignContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			updateField();
			setState(30);
			match(EQ);
			setState(31);
			baseType();
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
	public static class UpdateFieldContext extends ParserRuleContext {
		public FieldPlaceContext fieldPlace() {
			return getRuleContext(FieldPlaceContext.class,0);
		}
		public UpdateFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterUpdateField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitUpdateField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitUpdateField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateFieldContext updateField() throws RecognitionException {
		UpdateFieldContext _localctx = new UpdateFieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_updateField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			fieldPlace();
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
		public TerminalNode NUMBER() { return getToken(UpdateStatementParser.NUMBER, 0); }
		public NumberValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterNumberVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitNumberVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitNumberVal(this);
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
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterFunPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitFunPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitFunPlaceVal(this);
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
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterMethodPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitMethodPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitMethodPlaceVal(this);
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
		public List<TerminalNode> COMMA() { return getTokens(UpdateStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UpdateStatementParser.COMMA, i);
		}
		public ListValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterListVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitListVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitListVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValContext extends BaseTypeContext {
		public TerminalNode STRING() { return getToken(UpdateStatementParser.STRING, 0); }
		public StringValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanValContext extends BaseTypeContext {
		public TerminalNode BOOLEAN() { return getToken(UpdateStatementParser.BOOLEAN, 0); }
		public BooleanValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterBooleanVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitBooleanVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitBooleanVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullValContext extends BaseTypeContext {
		public TerminalNode NULL() { return getToken(UpdateStatementParser.NULL, 0); }
		public NullValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitNullVal(this);
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
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterFieldPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitFieldPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitFieldPlaceVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_baseType);
		int _la;
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				match(NULL);
				}
				break;
			case T__9:
				_localctx = new FieldPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				fieldPlace();
				}
				break;
			case T__2:
			case T__6:
				_localctx = new FunPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				funPlace();
				}
				break;
			case T__7:
			case T__8:
				_localctx = new MethodPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				methodPlace();
				}
				break;
			case T__0:
				_localctx = new ListValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(42);
				match(T__0);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
					{
					setState(43);
					baseType();
					setState(48);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(44);
						match(COMMA);
						setState(45);
						baseType();
						}
						}
						setState(50);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(53);
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
		public TerminalNode ID() { return getToken(UpdateStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UpdateStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UpdateStatementParser.COMMA, i);
		}
		public FunPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterFunPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitFunPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitFunPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunPlaceContext funPlace() throws RecognitionException {
		FunPlaceContext _localctx = new FunPlaceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funPlace);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__2);
				setState(57);
				match(ID);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(58);
					match(T__3);
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(59);
						baseType();
						setState(64);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(60);
							match(COMMA);
							setState(61);
							baseType();
							}
							}
							setState(66);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(69);
					match(T__4);
					}
				}

				setState(72);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__6);
				setState(74);
				match(ID);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(75);
					match(T__3);
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(76);
						baseType();
						setState(81);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(77);
							match(COMMA);
							setState(78);
							baseType();
							}
							}
							setState(83);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(86);
					match(T__4);
					}
				}

				setState(89);
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
		public TerminalNode ID() { return getToken(UpdateStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UpdateStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UpdateStatementParser.COMMA, i);
		}
		public MethodPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterMethodPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitMethodPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitMethodPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodPlaceContext methodPlace() throws RecognitionException {
		MethodPlaceContext _localctx = new MethodPlaceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodPlace);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(T__7);
				setState(93);
				match(ID);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(94);
					match(T__3);
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(95);
						baseType();
						setState(100);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(96);
							match(COMMA);
							setState(97);
							baseType();
							}
							}
							setState(102);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(105);
					match(T__4);
					}
				}

				setState(108);
				match(T__5);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__8);
				setState(110);
				match(ID);
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(111);
					match(T__3);
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124810L) != 0)) {
						{
						setState(112);
						baseType();
						setState(117);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(113);
							match(COMMA);
							setState(114);
							baseType();
							}
							}
							setState(119);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(122);
					match(T__4);
					}
				}

				setState(125);
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
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterFieldPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitFieldPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitFieldPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldPlaceContext fieldPlace() throws RecognitionException {
		FieldPlaceContext _localctx = new FieldPlaceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldPlace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__9);
			setState(129);
			idNest();
			setState(130);
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
		public List<TerminalNode> ID() { return getTokens(UpdateStatementParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UpdateStatementParser.ID, i);
		}
		public IdNestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idNest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).enterIdNest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateStatementListener ) ((UpdateStatementListener)listener).exitIdNest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateStatementVisitor ) return ((UpdateStatementVisitor<? extends T>)visitor).visitIdNest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdNestContext idNest() throws RecognitionException {
		IdNestContext _localctx = new IdNestContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_idNest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ID);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(133);
				match(T__10);
				setState(134);
				match(ID);
				}
				}
				setState(139);
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
		"\u0004\u0001\u001f\u008d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u0019\b\u0001\n\u0001\f\u0001\u001c\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"/\b\u0004\n\u0004\f\u00042\t\u0004\u0003\u00044\b\u0004\u0001\u0004\u0003"+
		"\u00047\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005?\b\u0005\n\u0005\f\u0005B\t\u0005\u0003"+
		"\u0005D\b\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"P\b\u0005\n\u0005\f\u0005S\t\u0005\u0003\u0005U\b\u0005\u0001\u0005\u0003"+
		"\u0005X\b\u0005\u0001\u0005\u0003\u0005[\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006c\b\u0006"+
		"\n\u0006\f\u0006f\t\u0006\u0003\u0006h\b\u0006\u0001\u0006\u0003\u0006"+
		"k\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006t\b\u0006\n\u0006\f\u0006w\t\u0006"+
		"\u0003\u0006y\b\u0006\u0001\u0006\u0003\u0006|\b\u0006\u0001\u0006\u0003"+
		"\u0006\u007f\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0088\b\b\n\b\f\b\u008b\t\b\u0001\b\u0000\u0000"+
		"\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0000\u009c\u0000\u0012"+
		"\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004\u001d"+
		"\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000\b6\u0001\u0000"+
		"\u0000\u0000\nZ\u0001\u0000\u0000\u0000\f~\u0001\u0000\u0000\u0000\u000e"+
		"\u0080\u0001\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0003\u0002\u0001\u0000\u0013\u0014\u0005\u0000\u0000\u0001\u0014"+
		"\u0001\u0001\u0000\u0000\u0000\u0015\u001a\u0003\u0004\u0002\u0000\u0016"+
		"\u0017\u0005\u001e\u0000\u0000\u0017\u0019\u0003\u0004\u0002\u0000\u0018"+
		"\u0016\u0001\u0000\u0000\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a"+
		"\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u0003\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0003\u0006\u0003\u0000\u001e\u001f\u0005\u0018\u0000\u0000\u001f"+
		" \u0003\b\u0004\u0000 \u0005\u0001\u0000\u0000\u0000!\"\u0003\u000e\u0007"+
		"\u0000\"\u0007\u0001\u0000\u0000\u0000#7\u0005\r\u0000\u0000$7\u0005\u0010"+
		"\u0000\u0000%7\u0005\u000e\u0000\u0000&7\u0005\u000f\u0000\u0000\'7\u0003"+
		"\u000e\u0007\u0000(7\u0003\n\u0005\u0000)7\u0003\f\u0006\u0000*3\u0005"+
		"\u0001\u0000\u0000+0\u0003\b\u0004\u0000,-\u0005\u001e\u0000\u0000-/\u0003"+
		"\b\u0004\u0000.,\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u00003+\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u000057\u0005\u0002\u0000\u00006#\u0001\u0000"+
		"\u0000\u00006$\u0001\u0000\u0000\u00006%\u0001\u0000\u0000\u00006&\u0001"+
		"\u0000\u0000\u00006\'\u0001\u0000\u0000\u00006(\u0001\u0000\u0000\u0000"+
		"6)\u0001\u0000\u0000\u00006*\u0001\u0000\u0000\u00007\t\u0001\u0000\u0000"+
		"\u000089\u0005\u0003\u0000\u00009F\u0005\u001f\u0000\u0000:C\u0005\u0004"+
		"\u0000\u0000;@\u0003\b\u0004\u0000<=\u0005\u001e\u0000\u0000=?\u0003\b"+
		"\u0004\u0000><\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000C;\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EG\u0005\u0005\u0000\u0000F:\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H[\u0005"+
		"\u0006\u0000\u0000IJ\u0005\u0007\u0000\u0000JW\u0005\u001f\u0000\u0000"+
		"KT\u0005\u0004\u0000\u0000LQ\u0003\b\u0004\u0000MN\u0005\u001e\u0000\u0000"+
		"NP\u0003\b\u0004\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0005\u0005\u0000\u0000WK\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y[\u0005\u0006\u0000\u0000Z8\u0001\u0000\u0000\u0000ZI\u0001\u0000\u0000"+
		"\u0000[\u000b\u0001\u0000\u0000\u0000\\]\u0005\b\u0000\u0000]j\u0005\u001f"+
		"\u0000\u0000^g\u0005\u0004\u0000\u0000_d\u0003\b\u0004\u0000`a\u0005\u001e"+
		"\u0000\u0000ac\u0003\b\u0004\u0000b`\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eh\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000g_\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0005\u0005\u0000"+
		"\u0000j^\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000l\u007f\u0005\u0006\u0000\u0000mn\u0005\t\u0000\u0000n{\u0005"+
		"\u001f\u0000\u0000ox\u0005\u0004\u0000\u0000pu\u0003\b\u0004\u0000qr\u0005"+
		"\u001e\u0000\u0000rt\u0003\b\u0004\u0000sq\u0001\u0000\u0000\u0000tw\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xp\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0005\u0005"+
		"\u0000\u0000{o\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}\u007f\u0005\u0006\u0000\u0000~\\\u0001\u0000\u0000"+
		"\u0000~m\u0001\u0000\u0000\u0000\u007f\r\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\n\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082\u0083"+
		"\u0005\u0006\u0000\u0000\u0083\u000f\u0001\u0000\u0000\u0000\u0084\u0089"+
		"\u0005\u001f\u0000\u0000\u0085\u0086\u0005\u000b\u0000\u0000\u0086\u0088"+
		"\u0005\u001f\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u0011\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u0013\u001a036@CFQTWZdgjux{~\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}