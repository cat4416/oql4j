package com.cat.oqj4j.antlr.type;

/**
 * IS NOT NULL条件表达式类型
 *
 * @author gwj
 */
public class NotNullCondExpType implements CondExpType {
    private String exp;

    public NotNullCondExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
