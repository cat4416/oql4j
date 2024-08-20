package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.antlr.type.CondExpType;
import com.cat.oqj4j.antlr.type.ExpType;
import com.cat.oqj4j.support.LegalObjPack;

import java.util.Collection;
import java.util.Deque;

/**
 * 条件处理器接口。
 * ps：实现此接口的类需要支持线程安全
 * @author gwj
 */
@ThreadSafe
public interface CondHandler<T extends CondExpType> {
    /**
     * 处理条件
     * @param condExpType 条件表达式
     * @param nodeStack 节点栈
     * @param srcCol 操作原对象集合
     * @return 合法对象封装
     */
    public LegalObjPack handleCond(T condExpType,  Deque<ExpType> nodeStack, Collection<Object> srcCol);

    /**
     * 获取能支持的表达式类型
     * @return
     */
    public Class<T> getSupportedExpType();
}
