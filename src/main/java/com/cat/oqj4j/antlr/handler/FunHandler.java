package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.annotation.ThreadSafe;

import java.util.Collection;

/**
 * 函数处理器接口。
 * ps：实现此接口的类需要支持线程安全
 * @author gwj
 */
@ThreadSafe
public interface FunHandler {
    /**
     * 处理函数
     * @param srcCol 原对象集合
     * @param curObj 当前处理对象
     * @param args 参数
     * @return 处理结果
     */
    public Object handleFun(Collection<?> srcCol, Object curObj, Object... args);

    /**
     * 获取支持的函数名称
     * @return 函数名称
     */
    public String getSupportedFunName();
}
