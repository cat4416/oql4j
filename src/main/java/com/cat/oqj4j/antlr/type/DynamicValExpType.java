package com.cat.oqj4j.antlr.type;

/**
 * 动态值表达式类型
 * @author gwj
 */
public interface DynamicValExpType extends ValExpType {
    /**
     * 获取值
     * @param srcObj 操作原对象
     * @return 值结果
     */
    public Object getVal(Object srcObj);
}
