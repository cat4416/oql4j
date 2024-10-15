package com.cat.oqj4j.core;

import com.cat.oqj4j.support.PersonTest;
import com.cat.oqj4j.support.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Oql客户端的对象方法 测试
 * @author gwj
 */
public class OqlClientMethodTest {
    private OqlClient oqlClient;

    @Before
    public void setUp() {
        OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
        oqlClient = oqlClientBuilder.build();
    }

    /**
     * 测试 执行Select映射
     * @throws Exception
     */
    @Test
    public void testDoSelect() {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);
        String selectOqlExp = " M{toString} ,M{getBriefIntro} briefIntro, m{packageBriefIntro(['我的基本信息为', ${name}, ${age}])}";
        Map<String, Object> result = oqlClient.doSelect(selectOqlExp, p01);
        TestHelper.printResult( "{} 输出结果为: {}", selectOqlExp, result);
        Assert.assertTrue(result.get("briefIntro").equals("张三-36"));
        Assert.assertTrue(result.get("packageBriefIntro").equals("我的基本信息为-张三-36"));
    }

    /**
     * 测试 执行Where条件是否存在符合的记录
     * @throws Exception
     */
    @Test
    public void testDoWhereExists() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);
        String whereOqlExp = " M{getBriefIntro} = '张三-36'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);
    }

    /**
     * 测试 执行Update更新
     * ps：测试单数据
     * @throws Exception
     */
    @Test
    public void testDoUpdate() {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setAge(36);
        String updateOqlExp = " ${name} = m{packageBriefIntro(['我的基本信息为', ${name}, ${age}])} ";
        int result = oqlClient.doUpdate(updateOqlExp, p01);
        TestHelper.printResult( "{} 输出结果为: {}，更新后的数据为{}", updateOqlExp, result, p01);
        Assert.assertEquals(result, 1);
        Assert.assertTrue(p01.getName().equals("我的基本信息为-张三-36"));
    }

}
