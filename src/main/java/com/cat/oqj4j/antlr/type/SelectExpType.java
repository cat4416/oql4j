package com.cat.oqj4j.antlr.type;

/**
 * select映射表达式类型
 * @author gwj
 */
public interface SelectExpType extends ExpType {
    /**
     * 获取映射的名称
     * @return 名称
     */
    public String getSelectName();
}
