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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, STRING=9, 
		BOOLEAN=10, NULL=11, NUMBER=12, AND=13, OR=14, IN=15, IS=16, BETWEEN=17, 
		NOT=18, AS=19, EQ=20, GT=21, LT=22, GE=23, LE=24, NEQ=25, COMMA=26, ID=27;
	public static final int
		RULE_parse = 0, RULE_stat = 1, RULE_binaryExp = 2, RULE_operator = 3, 
		RULE_unaryExp = 4, RULE_baseType = 5, RULE_funPlace = 6, RULE_fieldPlace = 7, 
		RULE_idNest = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "stat", "binaryExp", "operator", "unaryExp", "baseType", "funPlace", 
			"fieldPlace", "idNest"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'f{'", "'}'", "'F{'", "'${'", "'.'", null, null, 
			null, null, null, null, null, null, null, null, null, null, "'='", "'>'", 
			"'<'", "'>='", "'<='", null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "WS", "STRING", "BOOLEAN", 
			"NULL", "NUMBER", "AND", "OR", "IN", "IS", "BETWEEN", "NOT", "AS", "EQ", 
			"GT", "LT", "GE", "LE", "NEQ", "COMMA", "ID"
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
			setState(18);
			stat(0);
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
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new BinaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(22);
				binaryExp();
				}
				break;
			case 2:
				{
				_localctx = new UnaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				unaryExp();
				}
				break;
			case 3:
				{
				_localctx = new ParenStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__0);
				setState(25);
				stat(0);
				setState(26);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(36);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AndStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(30);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(31);
						match(AND);
						setState(32);
						stat(4);
						}
						break;
					case 2:
						{
						_localctx = new OrStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(33);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(34);
						match(OR);
						setState(35);
						stat(3);
						}
						break;
					}
					} 
				}
				setState(40);
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
			setState(41);
			baseType();
			setState(42);
			operator();
			setState(43);
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
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
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
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new InCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				baseType();
				setState(48);
				match(IN);
				setState(49);
				match(T__0);
				setState(50);
				baseType();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(51);
					match(COMMA);
					setState(52);
					baseType();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new BetweenCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				baseType();
				setState(61);
				match(BETWEEN);
				setState(62);
				baseType();
				setState(63);
				match(AND);
				setState(64);
				baseType();
				}
				break;
			case 3:
				_localctx = new NullCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				baseType();
				setState(67);
				match(IS);
				setState(68);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new NotNullCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				baseType();
				setState(71);
				match(IS);
				setState(72);
				match(NOT);
				setState(73);
				match(NULL);
				}
				break;
			case 5:
				_localctx = new ValCondContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
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
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(NULL);
				}
				break;
			case T__5:
				_localctx = new FieldPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				fieldPlace();
				}
				break;
			case T__2:
			case T__4:
				_localctx = new FunPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				funPlace();
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
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__2);
				setState(87);
				match(ID);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(88);
					match(T__0);
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7784L) != 0)) {
						{
						setState(89);
						baseType();
						setState(94);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(90);
							match(COMMA);
							setState(91);
							baseType();
							}
							}
							setState(96);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(99);
					match(T__1);
					}
				}

				setState(102);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(T__4);
				setState(104);
				match(ID);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(105);
					match(T__0);
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7784L) != 0)) {
						{
						setState(106);
						baseType();
						setState(111);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(107);
							match(COMMA);
							setState(108);
							baseType();
							}
							}
							setState(113);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(116);
					match(T__1);
					}
				}

				setState(119);
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
		enterRule(_localctx, 14, RULE_fieldPlace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__5);
			setState(123);
			idNest();
			setState(124);
			match(T__3);
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
		enterRule(_localctx, 16, RULE_idNest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ID);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(127);
				match(T__6);
				setState(128);
				match(ID);
				}
				}
				setState(133);
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
		"\u0004\u0001\u001b\u0087\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u001d\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u00046\b\u0004\n\u0004\f\u00049\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004M\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005U\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006]\b\u0006\n\u0006\f\u0006`\t\u0006\u0003"+
		"\u0006b\b\u0006\u0001\u0006\u0003\u0006e\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"n\b\u0006\n\u0006\f\u0006q\t\u0006\u0003\u0006s\b\u0006\u0001\u0006\u0003"+
		"\u0006v\b\u0006\u0001\u0006\u0003\u0006y\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u0082\b\b\n\b"+
		"\f\b\u0085\t\b\u0001\b\u0000\u0001\u0002\t\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0000\u0001\u0001\u0000\u0014\u0019\u0093\u0000\u0012\u0001"+
		"\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004)\u0001\u0000"+
		"\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\bL\u0001\u0000\u0000\u0000"+
		"\nT\u0001\u0000\u0000\u0000\fx\u0001\u0000\u0000\u0000\u000ez\u0001\u0000"+
		"\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001"+
		"\u0000\u0013\u0014\u0005\u0000\u0000\u0001\u0014\u0001\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0006\u0001\uffff\uffff\u0000\u0016\u001d\u0003\u0004"+
		"\u0002\u0000\u0017\u001d\u0003\b\u0004\u0000\u0018\u0019\u0005\u0001\u0000"+
		"\u0000\u0019\u001a\u0003\u0002\u0001\u0000\u001a\u001b\u0005\u0002\u0000"+
		"\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u0015\u0001\u0000\u0000"+
		"\u0000\u001c\u0017\u0001\u0000\u0000\u0000\u001c\u0018\u0001\u0000\u0000"+
		"\u0000\u001d&\u0001\u0000\u0000\u0000\u001e\u001f\n\u0003\u0000\u0000"+
		"\u001f \u0005\r\u0000\u0000 %\u0003\u0002\u0001\u0004!\"\n\u0002\u0000"+
		"\u0000\"#\u0005\u000e\u0000\u0000#%\u0003\u0002\u0001\u0003$\u001e\u0001"+
		"\u0000\u0000\u0000$!\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0003\n\u0005\u0000*+\u0003\u0006"+
		"\u0003\u0000+,\u0003\n\u0005\u0000,\u0005\u0001\u0000\u0000\u0000-.\u0007"+
		"\u0000\u0000\u0000.\u0007\u0001\u0000\u0000\u0000/0\u0003\n\u0005\u0000"+
		"01\u0005\u000f\u0000\u000012\u0005\u0001\u0000\u000027\u0003\n\u0005\u0000"+
		"34\u0005\u001a\u0000\u000046\u0003\n\u0005\u000053\u0001\u0000\u0000\u0000"+
		"69\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008:\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:;\u0005\u0002"+
		"\u0000\u0000;M\u0001\u0000\u0000\u0000<=\u0003\n\u0005\u0000=>\u0005\u0011"+
		"\u0000\u0000>?\u0003\n\u0005\u0000?@\u0005\r\u0000\u0000@A\u0003\n\u0005"+
		"\u0000AM\u0001\u0000\u0000\u0000BC\u0003\n\u0005\u0000CD\u0005\u0010\u0000"+
		"\u0000DE\u0005\u000b\u0000\u0000EM\u0001\u0000\u0000\u0000FG\u0003\n\u0005"+
		"\u0000GH\u0005\u0010\u0000\u0000HI\u0005\u0012\u0000\u0000IJ\u0005\u000b"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KM\u0003\n\u0005\u0000L/\u0001\u0000"+
		"\u0000\u0000L<\u0001\u0000\u0000\u0000LB\u0001\u0000\u0000\u0000LF\u0001"+
		"\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000M\t\u0001\u0000\u0000\u0000"+
		"NU\u0005\t\u0000\u0000OU\u0005\f\u0000\u0000PU\u0005\n\u0000\u0000QU\u0005"+
		"\u000b\u0000\u0000RU\u0003\u000e\u0007\u0000SU\u0003\f\u0006\u0000TN\u0001"+
		"\u0000\u0000\u0000TO\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000"+
		"TQ\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000"+
		"\u0000U\u000b\u0001\u0000\u0000\u0000VW\u0005\u0003\u0000\u0000Wd\u0005"+
		"\u001b\u0000\u0000Xa\u0005\u0001\u0000\u0000Y^\u0003\n\u0005\u0000Z[\u0005"+
		"\u001a\u0000\u0000[]\u0003\n\u0005\u0000\\Z\u0001\u0000\u0000\u0000]`"+
		"\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000aY\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0005"+
		"\u0002\u0000\u0000dX\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fy\u0005\u0004\u0000\u0000gh\u0005\u0005\u0000"+
		"\u0000hu\u0005\u001b\u0000\u0000ir\u0005\u0001\u0000\u0000jo\u0003\n\u0005"+
		"\u0000kl\u0005\u001a\u0000\u0000ln\u0003\n\u0005\u0000mk\u0001\u0000\u0000"+
		"\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rj\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tv\u0005\u0002\u0000\u0000ui\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wy\u0005\u0004\u0000\u0000xV\u0001\u0000"+
		"\u0000\u0000xg\u0001\u0000\u0000\u0000y\r\u0001\u0000\u0000\u0000z{\u0005"+
		"\u0006\u0000\u0000{|\u0003\u0010\b\u0000|}\u0005\u0004\u0000\u0000}\u000f"+
		"\u0001\u0000\u0000\u0000~\u0083\u0005\u001b\u0000\u0000\u007f\u0080\u0005"+
		"\u0007\u0000\u0000\u0080\u0082\u0005\u001b\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0011\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u000e\u001c$&7"+
		"LT^adorux\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}