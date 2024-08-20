package com.cat.oqj4j.core;

import com.cat.oqj4j.antlr.handler.*;
import com.cat.oqj4j.support.ApacheUtilsBeanHandler;
import com.cat.oqj4j.support.BeanHandler;

/**
 * Oql客户端建造者
 *
 * @author gwj
 */
public class OqlClientBuilder {
    private final OqlCoreProfile oqlCore = new OqlCoreProfile();

    /**
     * 构造对象
     */
    public OqlClientBuilder() {
        // 初始化默认配置
        preInitDefault();
    }

    /**
     * 前置初始化默认值
     */
    private void preInitDefault() {
        // 注册默认支持的条件处理器
        // IN条件处理器
        oqlCore.registerCondHandler(new InCondHandler());
        // BETWEEN条件处理器
        oqlCore.registerCondHandler( new BetweenCondHandler());
        // IS NULL条件表达式处理器
        oqlCore.registerCondHandler(new NullCondHandler());
        // IS NOT NULL条件表达式处理器
        oqlCore.registerCondHandler(new NotNullCondHandler());
        // 值条件表达式处理器
        oqlCore.registerCondHandler(new ValCondHandler());
        // 二元表达式处理器
        oqlCore.registerCondHandler(new BinaryCondHandler());

        // 注册默认定义的函数处理器
        // StrLen函数处理器
        oqlCore.registerFunHandler(new StrLenFunHandler());
        // If函数处理器
        oqlCore.registerFunHandler(new IfFunHandler());
        // IfNull函数处理器
        oqlCore.registerFunHandler(new IfNullFunHandler());
    }

    /**
     * 设置bean操作器
     * @param beanHandler
     */
    public OqlClientBuilder setBeanHandler(BeanHandler beanHandler) {
        oqlCore.setBeanHandler(beanHandler);
        return this;
    }

    /**
     * 注册条件处理器
     * @param handler 处理器
     */
    public OqlClientBuilder registerCondHandler(CondHandler handler) {
        oqlCore.registerCondHandler(handler);
        return this;
    }

    /**
     * 注册函数处理器
     * @param handler 处理器
     */
    public OqlClientBuilder registerFunHandler(FunHandler handler) {
        oqlCore.registerFunHandler(handler);
        return this;
    }


    /**
     * 构建客户端
     * @return 客户端对象
     */
    public OqlClient build() {
        // 设置默认值
        postInitDefault();

        return new DefaultOqlClientImpl(oqlCore);
    }

    /**
     * 后置初始化默认值
     */
    private void postInitDefault() {
        if (oqlCore.getBeanHandler() == null) {
            oqlCore.setBeanHandler(new ApacheUtilsBeanHandler());
        }
    }
}
