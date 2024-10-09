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
        TestHelper.printResult("{} 语法检查通过", whereOqlExp);
    }


    /**
     * 测试 检查where条件表达式 异常情况
     */
    @Test
    public void testCheckWhereExpException() {
        // 错误语法：变量${age缺少 }括号， ${addr}缺少 in 关键字
        String whereOqlExp = "F{StrLen(${name})} AND ${age AND ${addr}  ('北京市','上海市','广州市')";
        try {
            GrammarCheckHelper.checkWhereExp(whereOqlExp);
            Assert.fail("GrammarCheckHelper.verifyWhereExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", whereOqlExp, e);
        }

        // 错误语法：函数的参数值缺少 ( 括号
        whereOqlExp = "F{StrLen${name})}";
        try {
            GrammarCheckHelper.checkWhereExp(whereOqlExp);
            Assert.fail("GrammarCheckHelper.verifyWhereExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", whereOqlExp, e);
        }
    }


    /**
     * 测试 核实 where条件表达式 是否合法
     */
    @Test
    public void testVerifyWhereExp() {
        String whereOqlExp = "F{StrLen(${name})} AND ${age} > 20 AND ${addr} IN ('北京市','上海市','广州市')";
        boolean result = GrammarCheckHelper.verifyWhereExp(whereOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", whereOqlExp, result);
        Assert.assertEquals(true, result);

        // 错误语法：变量${age缺少 }括号， ${addr}缺少 in 关键字
        whereOqlExp = "F{StrLen(${name})} AND ${age AND ${addr}  ('北京市','上海市','广州市')";
        result = GrammarCheckHelper.verifyWhereExp(whereOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", whereOqlExp, result);
        Assert.assertEquals(false, result);
    }

    /**
     * 测试 检查select映射表达式
     */
    @Test
    public void testCheckSelectExp() {
        String selectOqlExp = "F{StrLen(${name})}, true isMan, 26 as age, ${hobby} myHobby";
        GrammarCheckHelper.checkSelectExp(selectOqlExp);
        TestHelper.printResult("{} 语法检查通过", selectOqlExp);
    }


    /**
     * 测试 检查select映射表达式 异常情况
     */
    @Test
    public void testCheckSelectExpException() {
        // 错误语法：age不是字符串常量也不是动态变量，myHobby别名不能是字符串类型
        String selectOqlExp = "F{StrLen(${name})}, true isMan, age, ${hobby} 'myHobby' ";
        try {
            GrammarCheckHelper.checkSelectExp(selectOqlExp);
            Assert.fail("GrammarCheckHelper.checkSelectExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", selectOqlExp, e);
        }

        // 错误语法：函数的参数值没有()
        selectOqlExp = "F{StrLen${name}} ";
        try {
            GrammarCheckHelper.checkSelectExp(selectOqlExp);
            Assert.fail("GrammarCheckHelper.checkSelectExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", selectOqlExp, e);
        }
    }


    /**
     * 测试 核实 select映射表达式 是否合法
     */
    @Test
    public void testVerifySelectExp() {
        String selectOqlExp = "F{StrLen(${name})}, true isMan, 26 as age, ${hobby} myHobby";
        boolean result = GrammarCheckHelper.verifySelectExp(selectOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", selectOqlExp, result);
        Assert.assertEquals(true, result);

        // 错误语法：age不是字符串常量也不是动态变量，myHobby别名不能是字符串类型
        selectOqlExp = "F{StrLen(${name})}, true isMan, age, ${hobby} 'myHobby' ";
        result = GrammarCheckHelper.verifySelectExp(selectOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", selectOqlExp, result);
        Assert.assertEquals(false, result);
    }


    /**
     * 测试 检查update更新 表达式
     */
    @Test
    public void testCheckUpdateExp() {
        String updateOqlExp = "${age} = F{Incr(${age})}, ${name} = '张三', ${isMan} = ${isMan}";
        GrammarCheckHelper.checkUpdateExp(updateOqlExp);
        TestHelper.printResult("{} 语法检查通过", updateOqlExp);
    }

    /**
     * 测试 检查update更新表达式 异常情况
     */
    @Test
    public void testCheckUpdateExpException() {
        // 错误语法：age不是字段变量， name不是字段变量， ${isMan 缺少 }括号
        String updateOqlExp = "age = 12, 'name' = '李白' , ${isMan = true";
        try {
            GrammarCheckHelper.checkUpdateExp(updateOqlExp);
            Assert.fail("GrammarCheckHelper.checkSelectExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", updateOqlExp, e);
        }
        // 错误语法：${work} 没有=赋值，${age}没有=赋值
        updateOqlExp = " ${work}, ${age} ";
        try {
            GrammarCheckHelper.checkUpdateExp(updateOqlExp);
            Assert.fail("GrammarCheckHelper.checkSelectExp没有抛出期望的异常");
        } catch(OqlExpResolvedException e) {
            TestHelper.printResult( "{} 测试错误语法，抛出期望的异常({})，测试通过", updateOqlExp, e);
        }
    }

    /**
     * 测试 核实 update更新表达式 是否合法
     */
    @Test
    public void testVerifyUpdateExp() {
        String selectOqlExp = "${age} = F{Incr(${age})}, ${name} = '张三', ${isMan} = ${isMan}";
        boolean result = GrammarCheckHelper.verifyUpdateExp(selectOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", selectOqlExp, result);
        Assert.assertEquals(true, result);

        // 错误语法：${work} 没有=赋值，${age}没有=赋值
        selectOqlExp = " ${name} = '李白', ${work}, ${age}";
        result = GrammarCheckHelper.verifyUpdateExp(selectOqlExp);
        TestHelper.printResult("{} 语法检查结果为：{}", selectOqlExp, result);
        Assert.assertEquals(false, result);
    }
}