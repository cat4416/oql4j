package com.cat.oqj4j.antlr.type;

/**
 * 值表达式类型
 * ps：直接用当前值来判断布尔条件的真假
 *
 * @author gwj
 */
public class ValCondExpType implements CondExpType {
    private String exp;

    public ValCondExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
