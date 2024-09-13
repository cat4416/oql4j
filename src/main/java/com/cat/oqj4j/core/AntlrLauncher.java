package com.cat.oqj4j.core;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.ext.MySelectStatementLexer;
import com.cat.oqj4j.antlr.ext.MyWhereStatementLexer;
import com.cat.oqj4j.antlr.ext.NegativeErrorStrategy;
import com.cat.oqj4j.antlr.ext.ThrowErrorListener;
import com.cat.oqj4j.antlr.gen.SelectStatementBaseListener;
import com.cat.oqj4j.antlr.gen.SelectStatementParser;
import com.cat.oqj4j.antlr.gen.WhereStatementBaseListener;
import com.cat.oqj4j.antlr.gen.WhereStatementParser;
import com.cat.oqj4j.support.StrHelper;
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
     * where表达式 默认监听器
     */
    private static final WhereStatementBaseListener defaultWhereListener = new WhereStatementBaseListener();
    /**
     * select表达式 默认监听器
     */
    private static final SelectStatementBaseListener defaultSelectListener = new SelectStatementBaseListener();

    /**
     * 限制对象的创建
     */
    private AntlrLauncher() {
    }

    /**
     * 获取实例对象
     * @return 获取实例
     */
    public static AntlrLauncher getInstance() {
        return instance;
    }

    /**
     * 执行where表达式
     * @param whereOqlExp where表达式
     * @param listener 监听器
     */
    public void emitWhereWalk(String whereOqlExp, ParseTreeListener listener) {
        if (StrHelper.isBlank(whereOqlExp)) {
            throw new IllegalArgumentException("oql表达式不能为空");
        }
        TokenSource lexer = new MyWhereStatementLexer(CharStreams.fromString(whereOqlExp));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WhereStatementParser parser = new WhereStatementParser(tokens);
        // 删除默认错误监听器并使用指定的监听器
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowErrorListener.getInstance());
        // 指定异常处理策略
        parser.setErrorHandler(NegativeErrorStrategy.getInstance());
        ParseTreeWalker.DEFAULT.walk(listener, parser.parse());
    }

    /**
     * 执行where表达式。
     * ps：使用默认的监听器，不会对监听内容做任何处理。
     * @param whereOqlExp where表达式
     */
    public void emitWhereWalk(String whereOqlExp) {
        this.emitWhereWalk(whereOqlExp, defaultWhereListener);
    }



    /**
     * 执行select表达式
     * @param selectOqlExp where表达式
     * @param listener 监听器
     */
    public void emitSelectWalk(String selectOqlExp, ParseTreeListener listener) {
        if (StrHelper.isBlank(selectOqlExp)) {
            throw new IllegalArgumentException("oql表达式不能为空");
        }
        TokenSource lexer = new MySelectStatementLexer(CharStreams.fromString(selectOqlExp));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SelectStatementParser parser = new SelectStatementParser(tokens);
        // 删除默认错误监听器并使用指定的监听器
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowErrorListener.getInstance());
        // 指定异常处理策略
        parser.setErrorHandler(NegativeErrorStrategy.getInstance());
        ParseTreeWalker.DEFAULT.walk(listener, parser.parse());
    }

    /**
     * 执行select表达式。
     * ps：使用默认的监听器，不会对监听内容做任何处理。
     * @param selectOqlExp select表达式
     */
    public void emitSelectWalk(String selectOqlExp) {
        this.emitSelectWalk(selectOqlExp, defaultSelectListener);
    }


}
