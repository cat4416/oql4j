// Generated from WhereStatement.g4 by ANTLR 4.13.1
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
public class WhereStatementParser extends Parser {
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
		RULE_parse = 0, RULE_stat = 1, RULE_binaryExp = 2, RULE_operator = 3, 
		RULE_unaryExp = 4, RULE_baseType = 5, RULE_funPlace = 6, RULE_methodPlace = 7, 
		RULE_fieldPlace = 8, RULE_idNest = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "stat", "binaryExp", "operator", "unaryExp", "baseType", "funPlace", 
			"methodPlace", "fieldPlace", "idNest"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'f{'", "'}'", "'F{'", "'m{'", "'M{'", 
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
	public String getGrammarFileName() { return "WhereStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WhereStatementParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode EOF() { return getToken(WhereStatementParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			stat(0);
			setState(21);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpStatContext extends StatContext {
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public UnaryExpStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterUnaryExpStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitUnaryExpStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitUnaryExpStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenStatContext extends StatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ParenStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterParenStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitParenStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitParenStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndStatContext extends StatContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode AND() { return getToken(WhereStatementParser.AND, 0); }
		public AndStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterAndStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitAndStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitAndStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpStatContext extends StatContext {
		public BinaryExpContext binaryExp() {
			return getRuleContext(BinaryExpContext.class,0);
		}
		public BinaryExpStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterBinaryExpStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitBinaryExpStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitBinaryExpStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrStatContext extends StatContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode OR() { return getToken(WhereStatementParser.OR, 0); }
		public OrStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterOrStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitOrStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitOrStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new BinaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(24);
				binaryExp();
				}
				break;
			case 2:
				{
				_localctx = new UnaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				unaryExp();
				}
				break;
			case 3:
				{
				_localctx = new ParenStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__0);
				setState(27);
				stat(0);
				setState(28);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(38);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AndStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(32);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(33);
						match(AND);
						setState(34);
						stat(4);
						}
						break;
					case 2:
						{
						_localctx = new OrStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(35);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(36);
						match(OR);
						setState(37);
						stat(3);
						}
						break;
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class BinaryExpContext extends ParserRuleContext {
		public BinaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExp; }
	 
		public BinaryExpContext() { }
		public void copyFrom(BinaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryCondContext extends BinaryExpContext {
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public BinaryCondContext(BinaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterBinaryCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitBinaryCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitBinaryCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpContext binaryExp() throws RecognitionException {
		BinaryExpContext _localctx = new BinaryExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_binaryExp);
		try {
			_localctx = new BinaryCondContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			baseType();
			setState(44);
			operator();
			setState(45);
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
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(WhereStatementParser.EQ, 0); }
		public TerminalNode GT() { return getToken(WhereStatementParser.GT, 0); }
		public TerminalNode LT() { return getToken(WhereStatementParser.LT, 0); }
		public TerminalNode GE() { return getToken(WhereStatementParser.GE, 0); }
		public TerminalNode LE() { return getToken(WhereStatementParser.LE, 0); }
		public TerminalNode NEQ() { return getToken(WhereStatementParser.NEQ, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1056964608L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class UnaryExpContext extends ParserRuleContext {
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
	 
		public UnaryExpContext() { }
		public void copyFrom(UnaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BetweenCondContext extends UnaryExpContext {
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public TerminalNode BETWEEN() { return getToken(WhereStatementParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(WhereStatementParser.AND, 0); }
		public BetweenCondContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterBetweenCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitBetweenCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitBetweenCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValCondContext extends UnaryExpContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public ValCondContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterValCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitValCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitValCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InCondContext extends UnaryExpContext {
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public TerminalNode IN() { return getToken(WhereStatementParser.IN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WhereStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WhereStatementParser.COMMA, i);
		}
		public InCondContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterInCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitInCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitInCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotNullCondContext extends UnaryExpContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode IS() { return getToken(WhereStatementParser.IS, 0); }
		public TerminalNode NOT() { return getToken(WhereStatementParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(WhereStatementParser.NULL, 0); }
		public NotNullCondContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterNotNullCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitNotNullCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitNotNullCond(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullCondContext extends UnaryExpContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode IS() { return getToken(WhereStatementParser.IS, 0); }
		public TerminalNode NULL() { return getToken(WhereStatementParser.NULL, 0); }
		public NullCondContext(UnaryExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterNullCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitNullCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitNullCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryExp);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new InCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				baseType();
				setState(50);
				match(IN);
				setState(51);
				match(T__0);
				setState(52);
				baseType();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(53);
					match(COMMA);
					setState(54);
					baseType();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new BetweenCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				baseType();
				setState(63);
				match(BETWEEN);
				setState(64);
				baseType();
				setState(65);
				match(AND);
				setState(66);
				baseType();
				}
				break;
			case 3:
				_localctx = new NullCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				baseType();
				setState(69);
				match(IS);
				setState(70);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new NotNullCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				baseType();
				setState(73);
				match(IS);
				setState(74);
				match(NOT);
				setState(75);
				match(NULL);
				}
				break;
			case 5:
				_localctx = new ValCondContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				baseType();
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
		public TerminalNode NUMBER() { return getToken(WhereStatementParser.NUMBER, 0); }
		public NumberValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterNumberVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitNumberVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitNumberVal(this);
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
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterFunPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitFunPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitFunPlaceVal(this);
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
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterMethodPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitMethodPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitMethodPlaceVal(this);
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
		public List<TerminalNode> COMMA() { return getTokens(WhereStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WhereStatementParser.COMMA, i);
		}
		public ListValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterListVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitListVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitListVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValContext extends BaseTypeContext {
		public TerminalNode STRING() { return getToken(WhereStatementParser.STRING, 0); }
		public StringValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterStringVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitStringVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitStringVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanValContext extends BaseTypeContext {
		public TerminalNode BOOLEAN() { return getToken(WhereStatementParser.BOOLEAN, 0); }
		public BooleanValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterBooleanVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitBooleanVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitBooleanVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullValContext extends BaseTypeContext {
		public TerminalNode NULL() { return getToken(WhereStatementParser.NULL, 0); }
		public NullValContext(BaseTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitNullVal(this);
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
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterFieldPlaceVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitFieldPlaceVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitFieldPlaceVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_baseType);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(NULL);
				}
				break;
			case T__9:
				_localctx = new FieldPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				fieldPlace();
				}
				break;
			case T__4:
			case T__6:
				_localctx = new FunPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				funPlace();
				}
				break;
			case T__7:
			case T__8:
				_localctx = new MethodPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(86);
				methodPlace();
				}
				break;
			case T__2:
				_localctx = new ListValContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(87);
				match(T__2);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124840L) != 0)) {
					{
					setState(88);
					baseType();
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(89);
						match(COMMA);
						setState(90);
						baseType();
						}
						}
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(98);
				match(T__3);
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
		public TerminalNode ID() { return getToken(WhereStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WhereStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WhereStatementParser.COMMA, i);
		}
		public FunPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterFunPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitFunPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitFunPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunPlaceContext funPlace() throws RecognitionException {
		FunPlaceContext _localctx = new FunPlaceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funPlace);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(T__4);
				setState(102);
				match(ID);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(103);
					match(T__0);
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124840L) != 0)) {
						{
						setState(104);
						baseType();
						setState(109);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(105);
							match(COMMA);
							setState(106);
							baseType();
							}
							}
							setState(111);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(114);
					match(T__1);
					}
				}

				setState(117);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(T__6);
				setState(119);
				match(ID);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(120);
					match(T__0);
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124840L) != 0)) {
						{
						setState(121);
						baseType();
						setState(126);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(122);
							match(COMMA);
							setState(123);
							baseType();
							}
							}
							setState(128);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(131);
					match(T__1);
					}
				}

				setState(134);
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
		public TerminalNode ID() { return getToken(WhereStatementParser.ID, 0); }
		public List<BaseTypeContext> baseType() {
			return getRuleContexts(BaseTypeContext.class);
		}
		public BaseTypeContext baseType(int i) {
			return getRuleContext(BaseTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WhereStatementParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WhereStatementParser.COMMA, i);
		}
		public MethodPlaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodPlace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterMethodPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitMethodPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitMethodPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodPlaceContext methodPlace() throws RecognitionException {
		MethodPlaceContext _localctx = new MethodPlaceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodPlace);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(T__7);
				setState(138);
				match(ID);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(139);
					match(T__0);
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124840L) != 0)) {
						{
						setState(140);
						baseType();
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(141);
							match(COMMA);
							setState(142);
							baseType();
							}
							}
							setState(147);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(150);
					match(T__1);
					}
				}

				setState(153);
				match(T__5);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(T__8);
				setState(155);
				match(ID);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(156);
					match(T__0);
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124840L) != 0)) {
						{
						setState(157);
						baseType();
						setState(162);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(158);
							match(COMMA);
							setState(159);
							baseType();
							}
							}
							setState(164);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(167);
					match(T__1);
					}
				}

				setState(170);
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
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterFieldPlace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitFieldPlace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitFieldPlace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldPlaceContext fieldPlace() throws RecognitionException {
		FieldPlaceContext _localctx = new FieldPlaceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldPlace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__9);
			setState(174);
			idNest();
			setState(175);
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
		public List<TerminalNode> ID() { return getTokens(WhereStatementParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(WhereStatementParser.ID, i);
		}
		public IdNestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idNest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).enterIdNest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhereStatementListener ) ((WhereStatementListener)listener).exitIdNest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhereStatementVisitor ) return ((WhereStatementVisitor<? extends T>)visitor).visitIdNest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdNestContext idNest() throws RecognitionException {
		IdNestContext _localctx = new IdNestContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_idNest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ID);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(178);
				match(T__10);
				setState(179);
				match(ID);
				}
				}
				setState(184);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return stat_sempred((StatContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u001f\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\'\b\u0001\n\u0001\f\u0001*"+
		"\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u00048\b\u0004\n\u0004\f\u0004;\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004O\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\\\b\u0005\n\u0005\f\u0005_\t\u0005\u0003\u0005a\b\u0005\u0001\u0005"+
		"\u0003\u0005d\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006l\b\u0006\n\u0006\f\u0006o\t\u0006"+
		"\u0003\u0006q\b\u0006\u0001\u0006\u0003\u0006t\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006}\b\u0006\n\u0006\f\u0006\u0080\t\u0006\u0003\u0006\u0082\b\u0006"+
		"\u0001\u0006\u0003\u0006\u0085\b\u0006\u0001\u0006\u0003\u0006\u0088\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0090\b\u0007\n\u0007\f\u0007\u0093\t\u0007\u0003\u0007"+
		"\u0095\b\u0007\u0001\u0007\u0003\u0007\u0098\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u00a1\b\u0007\n\u0007\f\u0007\u00a4\t\u0007\u0003\u0007\u00a6\b"+
		"\u0007\u0001\u0007\u0003\u0007\u00a9\b\u0007\u0001\u0007\u0003\u0007\u00ac"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00b5\b\t\n\t\f\t\u00b8\t\t\u0001\t\u0000\u0001\u0002\n\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0001\u0000\u0018\u001d"+
		"\u00d0\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000"+
		"\u0000\u0004+\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b"+
		"N\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\f\u0087\u0001\u0000"+
		"\u0000\u0000\u000e\u00ab\u0001\u0000\u0000\u0000\u0010\u00ad\u0001\u0000"+
		"\u0000\u0000\u0012\u00b1\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002"+
		"\u0001\u0000\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0006\u0001\uffff\uffff\u0000\u0018\u001f\u0003"+
		"\u0004\u0002\u0000\u0019\u001f\u0003\b\u0004\u0000\u001a\u001b\u0005\u0001"+
		"\u0000\u0000\u001b\u001c\u0003\u0002\u0001\u0000\u001c\u001d\u0005\u0002"+
		"\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u0017\u0001\u0000"+
		"\u0000\u0000\u001e\u0019\u0001\u0000\u0000\u0000\u001e\u001a\u0001\u0000"+
		"\u0000\u0000\u001f(\u0001\u0000\u0000\u0000 !\n\u0003\u0000\u0000!\"\u0005"+
		"\u0011\u0000\u0000\"\'\u0003\u0002\u0001\u0004#$\n\u0002\u0000\u0000$"+
		"%\u0005\u0012\u0000\u0000%\'\u0003\u0002\u0001\u0003& \u0001\u0000\u0000"+
		"\u0000&#\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000+,\u0003\n\u0005\u0000,-\u0003\u0006\u0003\u0000"+
		"-.\u0003\n\u0005\u0000.\u0005\u0001\u0000\u0000\u0000/0\u0007\u0000\u0000"+
		"\u00000\u0007\u0001\u0000\u0000\u000012\u0003\n\u0005\u000023\u0005\u0013"+
		"\u0000\u000034\u0005\u0001\u0000\u000049\u0003\n\u0005\u000056\u0005\u001e"+
		"\u0000\u000068\u0003\n\u0005\u000075\u0001\u0000\u0000\u00008;\u0001\u0000"+
		"\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\u0002\u0000\u0000"+
		"=O\u0001\u0000\u0000\u0000>?\u0003\n\u0005\u0000?@\u0005\u0015\u0000\u0000"+
		"@A\u0003\n\u0005\u0000AB\u0005\u0011\u0000\u0000BC\u0003\n\u0005\u0000"+
		"CO\u0001\u0000\u0000\u0000DE\u0003\n\u0005\u0000EF\u0005\u0014\u0000\u0000"+
		"FG\u0005\u000f\u0000\u0000GO\u0001\u0000\u0000\u0000HI\u0003\n\u0005\u0000"+
		"IJ\u0005\u0014\u0000\u0000JK\u0005\u0016\u0000\u0000KL\u0005\u000f\u0000"+
		"\u0000LO\u0001\u0000\u0000\u0000MO\u0003\n\u0005\u0000N1\u0001\u0000\u0000"+
		"\u0000N>\u0001\u0000\u0000\u0000ND\u0001\u0000\u0000\u0000NH\u0001\u0000"+
		"\u0000\u0000NM\u0001\u0000\u0000\u0000O\t\u0001\u0000\u0000\u0000Pd\u0005"+
		"\r\u0000\u0000Qd\u0005\u0010\u0000\u0000Rd\u0005\u000e\u0000\u0000Sd\u0005"+
		"\u000f\u0000\u0000Td\u0003\u0010\b\u0000Ud\u0003\f\u0006\u0000Vd\u0003"+
		"\u000e\u0007\u0000W`\u0005\u0003\u0000\u0000X]\u0003\n\u0005\u0000YZ\u0005"+
		"\u001e\u0000\u0000Z\\\u0003\n\u0005\u0000[Y\u0001\u0000\u0000\u0000\\"+
		"_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`X\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0005"+
		"\u0004\u0000\u0000cP\u0001\u0000\u0000\u0000cQ\u0001\u0000\u0000\u0000"+
		"cR\u0001\u0000\u0000\u0000cS\u0001\u0000\u0000\u0000cT\u0001\u0000\u0000"+
		"\u0000cU\u0001\u0000\u0000\u0000cV\u0001\u0000\u0000\u0000cW\u0001\u0000"+
		"\u0000\u0000d\u000b\u0001\u0000\u0000\u0000ef\u0005\u0005\u0000\u0000"+
		"fs\u0005\u001f\u0000\u0000gp\u0005\u0001\u0000\u0000hm\u0003\n\u0005\u0000"+
		"ij\u0005\u001e\u0000\u0000jl\u0003\n\u0005\u0000ki\u0001\u0000\u0000\u0000"+
		"lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000ph\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0005"+
		"\u0002\u0000\u0000sg\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u\u0088\u0005\u0006\u0000\u0000vw\u0005\u0007"+
		"\u0000\u0000w\u0084\u0005\u001f\u0000\u0000x\u0081\u0005\u0001\u0000\u0000"+
		"y~\u0003\n\u0005\u0000z{\u0005\u001e\u0000\u0000{}\u0003\n\u0005\u0000"+
		"|z\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081y\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0085\u0005\u0002\u0000\u0000\u0084x\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0005\u0006\u0000\u0000\u0087e\u0001\u0000\u0000\u0000\u0087v\u0001\u0000"+
		"\u0000\u0000\u0088\r\u0001\u0000\u0000\u0000\u0089\u008a\u0005\b\u0000"+
		"\u0000\u008a\u0097\u0005\u001f\u0000\u0000\u008b\u0094\u0005\u0001\u0000"+
		"\u0000\u008c\u0091\u0003\n\u0005\u0000\u008d\u008e\u0005\u001e\u0000\u0000"+
		"\u008e\u0090\u0003\n\u0005\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u008c\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\u0005\u0002\u0000\u0000\u0097\u008b\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u00ac\u0005\u0006\u0000\u0000\u009a\u009b\u0005\t\u0000\u0000\u009b\u00a8"+
		"\u0005\u001f\u0000\u0000\u009c\u00a5\u0005\u0001\u0000\u0000\u009d\u00a2"+
		"\u0003\n\u0005\u0000\u009e\u009f\u0005\u001e\u0000\u0000\u009f\u00a1\u0003"+
		"\n\u0005\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a5\u009d\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0005\u0002"+
		"\u0000\u0000\u00a8\u009c\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u0006"+
		"\u0000\u0000\u00ab\u0089\u0001\u0000\u0000\u0000\u00ab\u009a\u0001\u0000"+
		"\u0000\u0000\u00ac\u000f\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\n\u0000"+
		"\u0000\u00ae\u00af\u0003\u0012\t\u0000\u00af\u00b0\u0005\u0006\u0000\u0000"+
		"\u00b0\u0011\u0001\u0000\u0000\u0000\u00b1\u00b6\u0005\u001f\u0000\u0000"+
		"\u00b2\u00b3\u0005\u000b\u0000\u0000\u00b3\u00b5\u0005\u001f\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u0013\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u0017\u001e&(9N]`cmps~\u0081\u0084\u0087\u0091\u0094\u0097\u00a2\u00a5"+
		"\u00a8\u00ab\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}