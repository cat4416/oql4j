package com.cat.oqj4j.antlr.type;

import java.math.BigDecimal;

/**
 * 数值类型
 *
 * @author gwj
 */
public class NumberValExpType implements ConstValExpType<Number> {
    private String exp;

    public NumberValExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public Number getVal() {
        /**
         * 优先级如下：
         * 1、如果只有整数，优先考虑使用Integer，当长度超过10位数时，则用Long
         * 2、如果存在小数或者科学计数法，则统一使用BigDecimal类型。
         */
        Number val = null;
        if (exp.contains(".") || exp.contains("e") || exp.contains("E")) {
            val = new BigDecimal(exp);
        } else if (exp.length() > 10) {
            val = new Long(exp);
        } else {
            val = new Integer(exp);
        }
        return val;
    }
}
