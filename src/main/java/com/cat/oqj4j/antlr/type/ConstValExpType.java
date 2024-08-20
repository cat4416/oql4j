package com.cat.oqj4j.antlr.type;

/**
 * 常量值表达式类型
 *
 * @author gwj
 */
public interface ConstValExpType<T> extends ValExpType {
    /**
     * 获取值
     * @return 值结果
     */
    public T getVal();
}
