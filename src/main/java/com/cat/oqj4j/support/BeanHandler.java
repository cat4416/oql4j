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
     *    并且sample对象不允许为null，否则可能抛出异常。
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @return 字段值
     * @throws BeanHandlingException
     */
    <T> T getFieldVal(Object bean, String fieldName) throws BeanHandlingException;

    /**
     * 设置字段值。
     * ps：支持嵌套操作，例如sample.display表示操作 sample对象中的display的属性值，
     *    如果sample对象为null，则尝试进行实例化sample对象，实力化失败则抛出异常。
     * @param bean 操作对象
     * @param fieldName 字段名称
     * @param val 字段值
     * @throws BeanHandlingException
     */
    void setFieldVal(Object bean, String fieldName, Object val) throws BeanHandlingException;

    /**
     * bean拷贝
     * @param dest 目的对象。即设置拷贝值的对象。
     * @param orig 来源对象。即取值来源。
     * @throws BeanHandlingException
     */
    void copyBean(Object dest, Object orig) throws BeanHandlingException;
}
