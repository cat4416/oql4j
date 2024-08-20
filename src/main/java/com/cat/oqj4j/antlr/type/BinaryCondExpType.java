package com.cat.oqj4j.antlr.type;

/**
 * 二元条件表达式类型
 * 格式: left binaryCond right
 *
 * @author gwj
 */
public class BinaryCondExpType implements CondExpType {
    private String exp;

    public BinaryCondExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
