// Generated from UpdateStatement.g4 by ANTLR 4.13.1
package com.cat.oqj4j.antlr.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UpdateStatementLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, WS=12, STRING=13, BOOLEAN=14, NULL=15, NUMBER=16, AND=17, 
		OR=18, IN=19, IS=20, BETWEEN=21, NOT=22, AS=23, EQ=24, GT=25, LT=26, GE=27, 
		LE=28, NEQ=29, COMMA=30, ID=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "WS", "STRING", "BOOLEAN", "NULL", "NUMBER", "INT", 
			"SNEXP", "AND", "OR", "IN", "IS", "BETWEEN", "NOT", "AS", "EQ", "GT", 
			"LT", "GE", "LE", "NEQ", "COMMA", "ID"
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


	public UpdateStatementLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UpdateStatement.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00e0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0004\u000b`\b\u000b\u000b\u000b\f\u000ba\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0005\fh\b\f\n\f\f\fk\t\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\rx\b"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0003\u000f\u0080\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0086\b\u000f\u0001\u000f\u0003\u000f\u0089\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u008f\b\u000f\u0001"+
		"\u000f\u0003\u000f\u0092\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0097\b\u0010\n\u0010\f\u0010\u009a\t\u0010\u0003\u0010\u009c\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00a0\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00a9\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00af\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u00d6\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0005 \u00dc\b \n \f \u00df\t \u0001i\u0000!\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0000#\u0000%\u0011\'\u0012)\u0013+\u0014-\u0015/"+
		"\u00161\u00173\u00185\u00197\u001a9\u001b;\u001c=\u001d?\u001eA\u001f"+
		"\u0001\u0000\u0015\u0003\u0000\t\n\r\r  \u0002\u0000\"\"\'\'\u0002\u0000"+
		"TTtt\u0002\u0000RRrr\u0002\u0000UUuu\u0002\u0000EEee\u0002\u0000FFff\u0002"+
		"\u0000AAaa\u0002\u0000LLll\u0002\u0000SSss\u0002\u0000NNnn\u0001\u0000"+
		"19\u0001\u000009\u0002\u0000++--\u0002\u0000DDdd\u0002\u0000OOoo\u0002"+
		"\u0000IIii\u0002\u0000BBbb\u0002\u0000WWww\u0002\u0000AZaz\u0004\u0000"+
		"09AZ__az\u00ed\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0001C\u0001\u0000\u0000\u0000\u0003"+
		"E\u0001\u0000\u0000\u0000\u0005G\u0001\u0000\u0000\u0000\u0007J\u0001"+
		"\u0000\u0000\u0000\tL\u0001\u0000\u0000\u0000\u000bN\u0001\u0000\u0000"+
		"\u0000\rP\u0001\u0000\u0000\u0000\u000fS\u0001\u0000\u0000\u0000\u0011"+
		"V\u0001\u0000\u0000\u0000\u0013Y\u0001\u0000\u0000\u0000\u0015\\\u0001"+
		"\u0000\u0000\u0000\u0017_\u0001\u0000\u0000\u0000\u0019e\u0001\u0000\u0000"+
		"\u0000\u001bw\u0001\u0000\u0000\u0000\u001dy\u0001\u0000\u0000\u0000\u001f"+
		"\u0091\u0001\u0000\u0000\u0000!\u009b\u0001\u0000\u0000\u0000#\u009d\u0001"+
		"\u0000\u0000\u0000%\u00a8\u0001\u0000\u0000\u0000\'\u00ae\u0001\u0000"+
		"\u0000\u0000)\u00b0\u0001\u0000\u0000\u0000+\u00b3\u0001\u0000\u0000\u0000"+
		"-\u00b6\u0001\u0000\u0000\u0000/\u00be\u0001\u0000\u0000\u00001\u00c2"+
		"\u0001\u0000\u0000\u00003\u00c5\u0001\u0000\u0000\u00005\u00c7\u0001\u0000"+
		"\u0000\u00007\u00c9\u0001\u0000\u0000\u00009\u00cb\u0001\u0000\u0000\u0000"+
		";\u00ce\u0001\u0000\u0000\u0000=\u00d5\u0001\u0000\u0000\u0000?\u00d7"+
		"\u0001\u0000\u0000\u0000A\u00d9\u0001\u0000\u0000\u0000CD\u0005[\u0000"+
		"\u0000D\u0002\u0001\u0000\u0000\u0000EF\u0005]\u0000\u0000F\u0004\u0001"+
		"\u0000\u0000\u0000GH\u0005f\u0000\u0000HI\u0005{\u0000\u0000I\u0006\u0001"+
		"\u0000\u0000\u0000JK\u0005(\u0000\u0000K\b\u0001\u0000\u0000\u0000LM\u0005"+
		")\u0000\u0000M\n\u0001\u0000\u0000\u0000NO\u0005}\u0000\u0000O\f\u0001"+
		"\u0000\u0000\u0000PQ\u0005F\u0000\u0000QR\u0005{\u0000\u0000R\u000e\u0001"+
		"\u0000\u0000\u0000ST\u0005m\u0000\u0000TU\u0005{\u0000\u0000U\u0010\u0001"+
		"\u0000\u0000\u0000VW\u0005M\u0000\u0000WX\u0005{\u0000\u0000X\u0012\u0001"+
		"\u0000\u0000\u0000YZ\u0005$\u0000\u0000Z[\u0005{\u0000\u0000[\u0014\u0001"+
		"\u0000\u0000\u0000\\]\u0005.\u0000\u0000]\u0016\u0001\u0000\u0000\u0000"+
		"^`\u0007\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0006\u000b\u0000\u0000d\u0018\u0001\u0000\u0000\u0000"+
		"ei\u0007\u0001\u0000\u0000fh\t\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000"+
		"hk\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0007\u0001"+
		"\u0000\u0000m\u001a\u0001\u0000\u0000\u0000no\u0007\u0002\u0000\u0000"+
		"op\u0007\u0003\u0000\u0000pq\u0007\u0004\u0000\u0000qx\u0007\u0005\u0000"+
		"\u0000rs\u0007\u0006\u0000\u0000st\u0007\u0007\u0000\u0000tu\u0007\b\u0000"+
		"\u0000uv\u0007\t\u0000\u0000vx\u0007\u0005\u0000\u0000wn\u0001\u0000\u0000"+
		"\u0000wr\u0001\u0000\u0000\u0000x\u001c\u0001\u0000\u0000\u0000yz\u0007"+
		"\n\u0000\u0000z{\u0007\u0004\u0000\u0000{|\u0007\b\u0000\u0000|}\u0007"+
		"\b\u0000\u0000}\u001e\u0001\u0000\u0000\u0000~\u0080\u0005-\u0000\u0000"+
		"\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0003!\u0010\u0000\u0082\u0083"+
		"\u0005.\u0000\u0000\u0083\u0085\u0003!\u0010\u0000\u0084\u0086\u0003#"+
		"\u0011\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0092\u0001\u0000\u0000\u0000\u0087\u0089\u0005-\u0000"+
		"\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0003!\u0010\u0000"+
		"\u008b\u008c\u0003#\u0011\u0000\u008c\u0092\u0001\u0000\u0000\u0000\u008d"+
		"\u008f\u0005-\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092"+
		"\u0003!\u0010\u0000\u0091\u007f\u0001\u0000\u0000\u0000\u0091\u0088\u0001"+
		"\u0000\u0000\u0000\u0091\u008e\u0001\u0000\u0000\u0000\u0092 \u0001\u0000"+
		"\u0000\u0000\u0093\u009c\u00050\u0000\u0000\u0094\u0098\u0007\u000b\u0000"+
		"\u0000\u0095\u0097\u0007\f\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000"+
		"\u009b\u0094\u0001\u0000\u0000\u0000\u009c\"\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0007\u0005\u0000\u0000\u009e\u00a0\u0007\r\u0000\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003!\u0010\u0000\u00a2$\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0007\u0007\u0000\u0000\u00a4\u00a5\u0007\n\u0000"+
		"\u0000\u00a5\u00a9\u0007\u000e\u0000\u0000\u00a6\u00a7\u0005&\u0000\u0000"+
		"\u00a7\u00a9\u0005&\u0000\u0000\u00a8\u00a3\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a9&\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0007\u000f\u0000\u0000\u00ab\u00af\u0007\u0003\u0000\u0000\u00ac\u00ad"+
		"\u0005|\u0000\u0000\u00ad\u00af\u0005|\u0000\u0000\u00ae\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af(\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0007\u0010\u0000\u0000\u00b1\u00b2\u0007\n\u0000\u0000"+
		"\u00b2*\u0001\u0000\u0000\u0000\u00b3\u00b4\u0007\u0010\u0000\u0000\u00b4"+
		"\u00b5\u0007\t\u0000\u0000\u00b5,\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0007\u0011\u0000\u0000\u00b7\u00b8\u0007\u0005\u0000\u0000\u00b8\u00b9"+
		"\u0007\u0002\u0000\u0000\u00b9\u00ba\u0007\u0012\u0000\u0000\u00ba\u00bb"+
		"\u0007\u0005\u0000\u0000\u00bb\u00bc\u0007\u0005\u0000\u0000\u00bc\u00bd"+
		"\u0007\n\u0000\u0000\u00bd.\u0001\u0000\u0000\u0000\u00be\u00bf\u0007"+
		"\n\u0000\u0000\u00bf\u00c0\u0007\u000f\u0000\u0000\u00c0\u00c1\u0007\u0002"+
		"\u0000\u0000\u00c10\u0001\u0000\u0000\u0000\u00c2\u00c3\u0007\u0007\u0000"+
		"\u0000\u00c3\u00c4\u0007\t\u0000\u0000\u00c42\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0005=\u0000\u0000\u00c64\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0005>\u0000\u0000\u00c86\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005<"+
		"\u0000\u0000\u00ca8\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005>\u0000\u0000"+
		"\u00cc\u00cd\u0005=\u0000\u0000\u00cd:\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0005<\u0000\u0000\u00cf\u00d0\u0005=\u0000\u0000\u00d0<\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0005!\u0000\u0000\u00d2\u00d6\u0005=\u0000\u0000"+
		"\u00d3\u00d4\u0005<\u0000\u0000\u00d4\u00d6\u0005>\u0000\u0000\u00d5\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6>\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0005,\u0000\u0000\u00d8@\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dd\u0007\u0013\u0000\u0000\u00da\u00dc\u0007\u0014\u0000"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000"+
		"\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00deB\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000"+
		"\u0010\u0000aiw\u007f\u0085\u0088\u008e\u0091\u0098\u009b\u009f\u00a8"+
		"\u00ae\u00d5\u00dd\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}