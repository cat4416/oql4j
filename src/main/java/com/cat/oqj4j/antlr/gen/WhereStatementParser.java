// Generated from F:/developer/oql4j/srccode/src/main/resources/altnr/WhereStatement.g4 by ANTLR 4.13.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, AND=6, OR=7, IN=8, IS=9, BETWEEN=10, 
		NOT=11, STRING=12, FIELDPLACE=13, BOOLEAN=14, NULL=15, NUMBER=16, EQ=17, 
		GT=18, LT=19, GE=20, LE=21, NEQ=22, COMMA=23, ID=24, WS=25;
	public static final int
		RULE_parse = 0, RULE_stat = 1, RULE_binaryExp = 2, RULE_operator = 3, 
		RULE_unaryExp = 4, RULE_baseType = 5, RULE_funPlace = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "stat", "binaryExp", "operator", "unaryExp", "baseType", "funPlace"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'f{'", "'}'", "'F{'", null, null, null, null, null, 
			null, null, null, null, null, null, "'='", "'>'", "'<'", "'>='", "'<='", 
			null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "AND", "OR", "IN", "IS", "BETWEEN", 
			"NOT", "STRING", "FIELDPLACE", "BOOLEAN", "NULL", "NUMBER", "EQ", "GT", 
			"LT", "GE", "LE", "NEQ", "COMMA", "ID", "WS"
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
			setState(14);
			stat(0);
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
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new BinaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(17);
				binaryExp();
				}
				break;
			case 2:
				{
				_localctx = new UnaryExpStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				unaryExp();
				}
				break;
			case 3:
				{
				_localctx = new ParenStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(T__0);
				setState(20);
				stat(0);
				setState(21);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AndStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(25);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(26);
						match(AND);
						setState(27);
						stat(4);
						}
						break;
					case 2:
						{
						_localctx = new OrStatContext(new StatContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stat);
						setState(28);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(29);
						match(OR);
						setState(30);
						stat(3);
						}
						break;
					}
					} 
				}
				setState(35);
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
			setState(36);
			baseType();
			setState(37);
			operator();
			setState(38);
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
			setState(40);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new InCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				baseType();
				setState(43);
				match(IN);
				setState(44);
				match(T__0);
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
				setState(53);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new BetweenCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				baseType();
				setState(56);
				match(BETWEEN);
				setState(57);
				baseType();
				setState(58);
				match(AND);
				setState(59);
				baseType();
				}
				break;
			case 3:
				_localctx = new NullCondContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				baseType();
				setState(62);
				match(IS);
				setState(63);
				match(NULL);
				}
				break;
			case 4:
				_localctx = new NotNullCondContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				baseType();
				setState(66);
				match(IS);
				setState(67);
				match(NOT);
				setState(68);
				match(NULL);
				}
				break;
			case 5:
				_localctx = new ValCondContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
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
		public TerminalNode FIELDPLACE() { return getToken(WhereStatementParser.FIELDPLACE, 0); }
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
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullValContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(NULL);
				}
				break;
			case FIELDPLACE:
				_localctx = new FieldPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				match(FIELDPLACE);
				}
				break;
			case T__2:
			case T__4:
				_localctx = new FunPlaceValContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
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
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__2);
				setState(82);
				match(ID);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(83);
					match(T__0);
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 127016L) != 0)) {
						{
						setState(84);
						baseType();
						setState(89);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(85);
							match(COMMA);
							setState(86);
							baseType();
							}
							}
							setState(91);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(94);
					match(T__1);
					}
				}

				setState(97);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__4);
				setState(99);
				match(ID);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(100);
					match(T__0);
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 127016L) != 0)) {
						{
						setState(101);
						baseType();
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(102);
							match(COMMA);
							setState(103);
							baseType();
							}
							}
							setState(108);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(111);
					match(T__1);
					}
				}

				setState(114);
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
		"\u0004\u0001\u0019v\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u00041\b\u0004\n\u0004\f\u00044\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004H\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005P\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006X\b\u0006\n\u0006\f\u0006[\t"+
		"\u0006\u0003\u0006]\b\u0006\u0001\u0006\u0003\u0006`\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006i\b\u0006\n\u0006\f\u0006l\t\u0006\u0003\u0006n\b\u0006\u0001"+
		"\u0006\u0003\u0006q\b\u0006\u0001\u0006\u0003\u0006t\b\u0006\u0001\u0006"+
		"\u0000\u0001\u0002\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0001\u0001"+
		"\u0000\u0011\u0016\u0083\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0017"+
		"\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000\u0006(\u0001\u0000"+
		"\u0000\u0000\bG\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fs"+
		"\u0001\u0000\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0001"+
		"\u0001\u0000\u0000\u0000\u0010\u0011\u0006\u0001\uffff\uffff\u0000\u0011"+
		"\u0018\u0003\u0004\u0002\u0000\u0012\u0018\u0003\b\u0004\u0000\u0013\u0014"+
		"\u0005\u0001\u0000\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016"+
		"\u0005\u0002\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017\u0010"+
		"\u0001\u0000\u0000\u0000\u0017\u0012\u0001\u0000\u0000\u0000\u0017\u0013"+
		"\u0001\u0000\u0000\u0000\u0018!\u0001\u0000\u0000\u0000\u0019\u001a\n"+
		"\u0003\u0000\u0000\u001a\u001b\u0005\u0006\u0000\u0000\u001b \u0003\u0002"+
		"\u0001\u0004\u001c\u001d\n\u0002\u0000\u0000\u001d\u001e\u0005\u0007\u0000"+
		"\u0000\u001e \u0003\u0002\u0001\u0003\u001f\u0019\u0001\u0000\u0000\u0000"+
		"\u001f\u001c\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0003\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0003\n\u0005\u0000%&\u0003\u0006"+
		"\u0003\u0000&\'\u0003\n\u0005\u0000\'\u0005\u0001\u0000\u0000\u0000()"+
		"\u0007\u0000\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0003\n\u0005"+
		"\u0000+,\u0005\b\u0000\u0000,-\u0005\u0001\u0000\u0000-2\u0003\n\u0005"+
		"\u0000./\u0005\u0017\u0000\u0000/1\u0003\n\u0005\u00000.\u0001\u0000\u0000"+
		"\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0005"+
		"\u0002\u0000\u00006H\u0001\u0000\u0000\u000078\u0003\n\u0005\u000089\u0005"+
		"\n\u0000\u00009:\u0003\n\u0005\u0000:;\u0005\u0006\u0000\u0000;<\u0003"+
		"\n\u0005\u0000<H\u0001\u0000\u0000\u0000=>\u0003\n\u0005\u0000>?\u0005"+
		"\t\u0000\u0000?@\u0005\u000f\u0000\u0000@H\u0001\u0000\u0000\u0000AB\u0003"+
		"\n\u0005\u0000BC\u0005\t\u0000\u0000CD\u0005\u000b\u0000\u0000DE\u0005"+
		"\u000f\u0000\u0000EH\u0001\u0000\u0000\u0000FH\u0003\n\u0005\u0000G*\u0001"+
		"\u0000\u0000\u0000G7\u0001\u0000\u0000\u0000G=\u0001\u0000\u0000\u0000"+
		"GA\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\t\u0001\u0000\u0000"+
		"\u0000IP\u0005\f\u0000\u0000JP\u0005\u0010\u0000\u0000KP\u0005\u000e\u0000"+
		"\u0000LP\u0005\u000f\u0000\u0000MP\u0005\r\u0000\u0000NP\u0003\f\u0006"+
		"\u0000OI\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000\u0000OK\u0001\u0000"+
		"\u0000\u0000OL\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000ON\u0001"+
		"\u0000\u0000\u0000P\u000b\u0001\u0000\u0000\u0000QR\u0005\u0003\u0000"+
		"\u0000R_\u0005\u0018\u0000\u0000S\\\u0005\u0001\u0000\u0000TY\u0003\n"+
		"\u0005\u0000UV\u0005\u0017\u0000\u0000VX\u0003\n\u0005\u0000WU\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\T\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^`\u0005\u0002\u0000\u0000_S\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000at\u0005\u0004\u0000\u0000bc\u0005"+
		"\u0005\u0000\u0000cp\u0005\u0018\u0000\u0000dm\u0005\u0001\u0000\u0000"+
		"ej\u0003\n\u0005\u0000fg\u0005\u0017\u0000\u0000gi\u0003\n\u0005\u0000"+
		"hf\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000me\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000oq\u0005\u0002\u0000\u0000pd\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0005\u0004\u0000"+
		"\u0000sQ\u0001\u0000\u0000\u0000sb\u0001\u0000\u0000\u0000t\r\u0001\u0000"+
		"\u0000\u0000\r\u0017\u001f!2GOY\\_jmps";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}