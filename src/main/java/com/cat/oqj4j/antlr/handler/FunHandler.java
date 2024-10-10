package com.cat.oqj4j.antlr.handler;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.support.FunHandlerContext;

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
     * @param context 上下文
     * @return 处理结果
     */
    public Object handleFun(FunHandlerContext context);

    /**
     * 获取支持的函数名称
     * @return 函数名称
     */
    public String getSupportedFunName();
}
