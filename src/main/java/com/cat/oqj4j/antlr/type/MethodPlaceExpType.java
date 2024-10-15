package com.cat.oqj4j.antlr.type;

/**
 * 对象方法取值占位符表达式
 *
 * @author gwj
 */
public class MethodPlaceExpType implements ExpType{
    /**
     * 表达式
     */
    private String exp;
    /**
     *  方法表达式里包含的参数数量
     * ps：funName(10,20,${city}) 则说明有3个参数
     */
    private int argQuantity;


    public MethodPlaceExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    /**
     * 获取参数数量
     * @return 返回参数数量
     */
    public int getArgQuantity() {
        return argQuantity;
    }

    /**
     * 设置参数数量
     * @param argQuantity 返回参数数量
     */
    public void setArgQuantity(int argQuantity) {
        this.argQuantity = argQuantity;
    }
}
