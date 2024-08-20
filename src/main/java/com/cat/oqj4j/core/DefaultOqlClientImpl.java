package com.cat.oqj4j.core;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.gen.WhereStatementLexer;
import com.cat.oqj4j.antlr.gen.WhereStatementParser;
import com.cat.oqj4j.antlr.listener.ThrowErrorListener;
import com.cat.oqj4j.antlr.listener.WhereStatementListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 默认的Oql客户端实现类。
 * ps：此类是线程安全的，可以作为单例使用。
 *
 * @author gwj
 * @date 2024/7/19
 */
@ThreadSafe
public class DefaultOqlClientImpl implements OqlClient {
    /**
     * oql核心剖面
     */
    private OqlCoreProfile coreProfile;
    /**
     * 解析树遍历器
     */
    private ParseTreeWalker walker;

    /**
     * 构建客户端。使用默认级别的访问权限，控制外部构建此对象。
     * @param coreProfile
     */
    DefaultOqlClientImpl(OqlCoreProfile coreProfile) {
        this.coreProfile = coreProfile;
        this.walker = new ParseTreeWalker();
    }

    @Override
    public <T> boolean doWhereExists(String whereOqlExp, T srcObj) {
        return this.doWhereExists(whereOqlExp, Arrays.asList(srcObj));
    }

    @Override
    public <T> boolean doWhereExists(String whereOqlExp, Collection<T> srcCol) {
        return this.doWhere(whereOqlExp, srcCol).getBolResult();
    }

    @Override
    public <T> int doWhereCount(String whereOqlExp, Collection<T> srcCol) {
        return this.doWhere(whereOqlExp, srcCol).getCountResult();
    }

    @Override
    public <T> List<T> doWhereFilter(String whereOqlExp, Collection<T> srcCol) {
        return this.doWhere(whereOqlExp, srcCol).getColResult();
    }

    /**
     * 执行where条件
     * @param whereOqlExp where条件oql表达式
     * @param srcCol 提供操作的来源集合
     * @return where条件监听器
     */
    private <T> WhereStatementListener doWhere(String whereOqlExp, Collection<T> srcCol) {
        WhereStatementLexer lexer = new WhereStatementLexer(CharStreams.fromString(whereOqlExp));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WhereStatementParser parser = new WhereStatementParser(tokens);

        // 删除默认错误监听器并使用指定的监听器
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowErrorListener.getInstance());

        // 执行语法遍历
        WhereStatementListener<T> listener = new WhereStatementListener(this.coreProfile, srcCol);
        walker.walk(listener, parser.parse());
        return listener;
    }


}
