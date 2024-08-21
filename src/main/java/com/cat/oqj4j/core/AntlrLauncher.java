package com.cat.oqj4j.core;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.ext.MyWhereStatementLexer;
import com.cat.oqj4j.antlr.ext.NegativeErrorStrategy;
import com.cat.oqj4j.antlr.ext.ThrowErrorListener;
import com.cat.oqj4j.antlr.gen.WhereStatementBaseListener;
import com.cat.oqj4j.antlr.gen.WhereStatementParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * antlr 执行器
 *
 * @author gwj
 */
@ThreadSafe
public class AntlrLauncher {
    /**
     * 执行器实例
     */
    private static final AntlrLauncher instance = new AntlrLauncher();

    /**
     * where表达式 解析树遍历器
     */
    private static final ParseTreeWalker whereWalker = new ParseTreeWalker();
    /**
     * where表达式 默认监听器
     */
    private static final WhereStatementBaseListener defaultWhereListener = new WhereStatementBaseListener();


    /**
     * 限制对象的创建
     */
    private AntlrLauncher() {
    }

    /**
     * 获取实例对象
     * @return
     */
    public static AntlrLauncher getInstance() {
        return instance;
    }

    /**
     * 执行where表达式
     * @param whereOqlExp where表达式
     * @param listener 监听器
     * @return 语法解析树
     */
    public void emitWhereWalk(String whereOqlExp, ParseTreeListener listener) {
        TokenSource lexer = new MyWhereStatementLexer(CharStreams.fromString(whereOqlExp));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WhereStatementParser parser = new WhereStatementParser(tokens);
        // 删除默认错误监听器并使用指定的监听器
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowErrorListener.getInstance());
        // 指定异常处理策略
        parser.setErrorHandler(NegativeErrorStrategy.getInstance());
        whereWalker.walk(listener, parser.parse());
    }

    /**
     * 执行where表达式。
     * ps：使用默认的监听器，不会对监听内容做任何处理。
     * @param whereOqlExp where表达式
     * @return 语法解析树
     */
    public void emitWhereWalk(String whereOqlExp) {
        this.emitWhereWalk(whereOqlExp, defaultWhereListener);
    }


}
