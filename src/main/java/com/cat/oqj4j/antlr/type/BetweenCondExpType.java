package com.cat.oqj4j.antlr.type;

/**
 * BETWEEN条件表达式类型
 *
 * @author gwj
 */
public class BetweenCondExpType implements CondExpType {
    private String exp;

    public BetweenCondExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
