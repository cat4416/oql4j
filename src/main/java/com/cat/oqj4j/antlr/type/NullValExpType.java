package com.cat.oqj4j.antlr.type;

/**
 * NULL类型
 *
 * @author gwj
 */
public class NullValExpType implements ConstValExpType<Void> {
    private String exp;

    public NullValExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public Void getVal() {
        return null;
    }
}
