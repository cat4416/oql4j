package com.cat.oqj4j.support;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.exception.BeanHandlingException;

/**
 * bean操作器接口
 * ps：实现此接口的类需要支持线程安全
 * @author gwj
 */
@ThreadSafe
public interface BeanHandler {
    /**
     * 获取字段值。
     * ps：支持嵌套操作，例如sample.display表示操作 sample对象中的display的属性值，
     *    如果sample对象为null，则直接返回null。
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @param <T> 目标类型
     * @return 字段值
     * @throws BeanHandlingException bean处理异常
     */
    <T> T getFieldVal(Object bean, String fieldName) throws BeanHandlingException;

    /**
     * 设置字段值。
     * ps：
     *  1、支持嵌套操作，例如sample.display表示操作 sample对象中的display的属性值，如果sample对象为null，则尝试进行实例化sample对象，实力化失败则抛出异常。
     *  2、如果类型不同，将尝试转换，如果转换失败则抛出异常。
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @param val 字段值
     * @throws BeanHandlingException bean处理异常
     */
    void setFieldVal(Object bean, String fieldName, Object val) throws BeanHandlingException;

    /**
     * bean拷贝
     * @param dest 目的对象。即设置拷贝值的对象。
     * @param orig 来源对象。即取值来源。
     * @param isStrictType 是否严格类型。如果为true，则不会做类型转换，类型不同的赋值会抛出异常。
     * @throws BeanHandlingException bean处理异常
     */
    void copyBean(Object dest, Object orig, boolean isStrictType) throws BeanHandlingException;

    /**
     * 类型转换
     * @param type 类型字节对象
     * @param value 原值对象
     * @param <T> 目标类型
     * @return 转换后的目标值
     * @throws BeanHandlingException 转换异常
     */
    <T> T convertType(Class<T> type, Object value) throws BeanHandlingException;
}
