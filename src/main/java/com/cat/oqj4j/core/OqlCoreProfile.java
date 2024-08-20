package com.cat.oqj4j.core;

import com.cat.oqj4j.antlr.handler.CondHandler;
import com.cat.oqj4j.antlr.handler.FunHandler;
import com.cat.oqj4j.antlr.type.CondExpType;
import com.cat.oqj4j.support.BeanHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * oql核心剖面。
 * 此类用于封装自定义函数、配置项等信息。
 *
 * @author gwj
 */
public class OqlCoreProfile {
    /**
     * bean操作器
     */
    private BeanHandler beanHandler;
    /**
     * 条件处理器映射集合
     * key为 支持的条件表达式类
     * val为 处理器处理对象
     */
    private Map<Class<? extends CondExpType>, CondHandler> condHandlers = new HashMap<>();
    /**
     * 函数处理器映射集合
     * key为 函数表达式
     * val为 处理器处理对象
     */
    private Map<String, FunHandler> funHandlers = new HashMap<>();

    /**
     * 获取bean操作器
     * @return
     */
    public BeanHandler getBeanHandler() {
        return beanHandler;
    }

    /**
     * 设置bean操作器
     * @param beanHandler
     */
    void setBeanHandler(BeanHandler beanHandler) {
        this.beanHandler = beanHandler;
    }

    /**
     * 注册条件处理器
     * @param handler 处理器
     */
    void registerCondHandler(CondHandler handler) {
        if (condHandlers.containsKey(handler.getSupportedExpType())) {
            throw new IllegalArgumentException(handler.getSupportedExpType() + "条件处理器已存在");
        }
        condHandlers.put(handler.getSupportedExpType(), handler);
    }

    /**
     * 取出条件处理器对象
     * @param clazz 条件表达式类
     * @return 条件处理器对象。如果没有符合对象，则返回null。
     */
    public CondHandler fetchCondHandler(Class<? extends CondExpType> clazz) {
        return condHandlers.get(clazz);
    }


    /**
     * 注册函数处理器
     * @param handler 处理器
     */
    void registerFunHandler(FunHandler handler) {
        if (funHandlers.containsKey(handler.getSupportedFunName())) {
            throw new IllegalArgumentException(handler.getSupportedFunName() + "函数已存在");
        }
        funHandlers.put(handler.getSupportedFunName(), handler);
    }

    /**
     * 取出函数处理器对象
     * @param funExp 函数表达式
     * @return 条件处理器对象。如果没有符合对象，则返回null。
     */
    public FunHandler fetchFunHandler(String funExp) {
        return funHandlers.get(funExp);
    }



}
