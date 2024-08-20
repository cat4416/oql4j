package com.cat.oqj4j.antlr.type;
/**
 * 布尔类型
 *
 * @author gwj
 */
public class BooleanValExpType implements ConstValExpType<Boolean> {
    private String exp;

    public BooleanValExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public Boolean getVal() {
        return Boolean.valueOf(this.exp);
    }

}
