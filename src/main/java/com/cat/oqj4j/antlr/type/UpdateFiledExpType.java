package com.cat.oqj4j.antlr.type;

/**
 * 更新字段 表达式
 *
 * @author gwj
 */
public class UpdateFiledExpType implements ExpType{
    /**
     * 表达式
     */
    private String exp;


    public UpdateFiledExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
