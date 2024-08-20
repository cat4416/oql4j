package com.cat.oqj4j.antlr.type;

import java.math.BigDecimal;

/**
 * 数值类型
 *
 * @author gwj
 */
public class NumberValExpType implements ConstValExpType<BigDecimal> {
    private String exp;

    public NumberValExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public BigDecimal getVal() {
        return new BigDecimal(exp);
    }
}
