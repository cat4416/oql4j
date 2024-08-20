package com.cat.oqj4j.antlr.type;

/**
 * 运算操作符表达式类型
 *
 * @author gwj
 */
public class OperatorExpType implements ExpType {
    private String exp;

    public OperatorExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
