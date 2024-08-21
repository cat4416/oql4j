package com.cat.oqj4j.support;


import com.cat.oqj4j.exception.OqlExpResolvedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试 语法检查助手
 *
 * @author gwj
 */
public class GrammarCheckHelperTest {

    /**
     * 测试 检查where条件表达式
     */
    @Test
    public void testCheckWhereExp() {
        String whereOqlExp = "F{StrLen(${name})} AND ${age} > 20 AND ${addr} IN ('北京市','上海市','广州市')";
        GrammarCheckHelper.checkWhereExp(whereOqlExp);
        System.out.println(whereOqlExp + " 语法检查通过");
    }


    /**
     * 测试 检查where条件表达式 异常情况
     */
    @Test
    public void testCheckWhereExpException() {
        String whereOqlExp = "F{StrLen(${name})} AND ${age AND ${addr}  ('北京市','上海市','广州市')";
        try {
            GrammarCheckHelper.checkWhereExp(whereOqlExp);
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(OqlExpResolvedException e) {
            System.out.println(whereOqlExp + " 测试错误语法，测试通过");
        }

        whereOqlExp = "F{StrLen${name})}";
        try {
            GrammarCheckHelper.checkWhereExp(whereOqlExp);
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(OqlExpResolvedException e) {
            System.out.println(whereOqlExp + " 测试错误语法，测试通过");
        }
    }


    /**
     * 测试 核实 where条件表达式 是否合法
     */
    @Test
    public void testVerifyWhereExp() {
        String whereOqlExp = "F{StrLen(${name})} AND ${age} > 20 AND ${addr} IN ('北京市','上海市','广州市')";
        boolean result = GrammarCheckHelper.verifyWhereExp(whereOqlExp);
        System.out.println(whereOqlExp + " 语法检查结果为：" + result);
        Assert.assertEquals(true, result);


        whereOqlExp = "F{StrLen(${name})} AND ${age AND ${addr}  ('北京市','上海市','广州市')";
        result = GrammarCheckHelper.verifyWhereExp(whereOqlExp);
        System.out.println(whereOqlExp + " 语法检查结果为：" + result);
        Assert.assertEquals(false, result);
    }
}