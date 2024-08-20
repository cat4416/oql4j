package com.cat.oqj4j.antlr.type;

/**
 * IS NULL条件表达式类型
 *
 * @author gwj
 */
public class NullCondExpType implements CondExpType {
    private String exp;

    public NullCondExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
