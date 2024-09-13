package com.cat.oqj4j.antlr.type;

/**
 * IN条件表达式类型
 *
 * @author gwj
 */
public class InCondExpType implements CondExpType {
    /**
     * 表达式
     */
    private String exp;
    /**
     * in表达式里包含的参数数量
     */
    private int paramQuantity;


    public InCondExpType(String exp) {
        this.exp = exp;
    }

    /**
     * 获取参数数量
     * @return 返回参数数量
     */
    public int getParamQuantity() {
        return paramQuantity;
    }

    /**
     * 设置参数数量
     * @param paramQuantity 返回参数数量
     */
    public void setParamQuantity(int paramQuantity) {
        this.paramQuantity = paramQuantity;
    }

    @Override
    public String getExp() {
        return this.exp;
    }
}
