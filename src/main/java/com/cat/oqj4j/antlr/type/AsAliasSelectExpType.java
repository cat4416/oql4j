package com.cat.oqj4j.antlr.type;

/**
 *  别名映射选择 表达式类型
 * ps：即进行select字段映射时，增加 as 关键字来指定任何的别名。格式为 name as alias。
 * @author gwj
 */
public class AsAliasSelectExpType implements SelectExpType{
    /**
     * 表达式
     */
    private String exp;
    /**
     * 别名
     */
    private String alias;

    /**
     * 构建对象
     * @param exp 表达式
     * @param alias 别名
     */
    public AsAliasSelectExpType(String exp, String alias) {
        this.exp = exp;
        this.alias = alias;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public String getSelectName() {
        return alias;
    }
}
