package com.cat.oqj4j.core;

import com.cat.oqj4j.support.MyPersonTest;
import com.cat.oqj4j.support.PersonTest;
import com.cat.oqj4j.support.TestHelper;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Oql客户端的update更新 测试
 * @author gwj
 */
public class OqlClientlUpdateTest {
    private OqlClient oqlClient;

    @Before
    public void setUp() {
        OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
        oqlClient = oqlClientBuilder.build();
    }

    /**
     * 测试 执行Update更新
     * ps：测试单数据
     * @throws Exception
     */
    @Test
    public void testDoUpdateForSingle() {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);
        String updateOqlExp = " ${age} = '37', ${name} = '刘三', ${isMan} = ${isMan}, ${addr.city} = '惠州市' ";
        int result = oqlClient.doUpdate(updateOqlExp, p01);
        TestHelper.printResult( "{} 输出结果为: {}，更新后的数据为{}", updateOqlExp, result, p01);
        Assert.assertTrue(p01.getAge().equals(37));
        Assert.assertTrue(p01.getName().equals("刘三"));
        Assert.assertTrue(p01.getIsMan().equals(true));
        Assert.assertTrue(p01.getAddr().get("city").equals("惠州市"));

        updateOqlExp = "${addr.city} = '深圳市', ${addr.province} = '广东省' ";
        result = oqlClient.doUpdate(updateOqlExp, p01);
        TestHelper.printResult( "{} 输出结果为: {}，更新后的数据为{}", updateOqlExp, result, p01);
        Assert.assertTrue(p01.getAddr().get("province").equals("广东省"));
        Assert.assertTrue(p01.getAddr().get("city").equals("深圳市"));
    }

    /**
     * 测试 执行Update更新
     * ps：测试多数据
     * @throws Exception
     */
    @Test
    public void testDoUpdateForMulti() {
        List<PersonTest> personTests = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            PersonTest personTest = new PersonTest();
            personTest.setName("李天" + i);
            if (i % 2 == 0) {
                personTest.setIsMan(true);
                personTest.setAge(20 + i);
            } else {
                personTest.setAge(20);
            }
            if (i % 4 == 0) {
                Map<String, String> addr = new HashMap<>();
                addr.put("province", "广东省");
                addr.put("city", "深圳市");
                personTest.setAddr(addr);
            }
            personTests.add(personTest);
        }

        String updateOqlExp = " ${age} = 45, ${name} = '刘三', ${isMan} = ${isMan}, ${addr.city} = '惠州市' ";
        int result = oqlClient.doUpdate(updateOqlExp, personTests);
        TestHelper.printResult( "{} 输出结果为: {}，更新后的数据为{}", updateOqlExp, result, personTests);
        Assert.assertEquals(result, personTests.size());
        int index = 1;
        for (PersonTest personTest : personTests) {
            Assert.assertTrue(personTest.getAge().equals(45));
            Assert.assertTrue(personTest.getName().equals("刘三"));
            if (index % 2 == 0) {
                Assert.assertTrue(personTest.getIsMan());
            } else {
                Assert.assertTrue(personTest.getIsMan() == null);
            }
            Assert.assertTrue(personTest.getAddr().get("city").equals("惠州市"));
            index ++ ;
        }
    }

    /**
     * 测试 执行Update更新
     * ps：测试包含有where条件
     * @throws Exception
     */
    @Test
    public void testDoUpdateForWhere() {
        List<PersonTest> personTests = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            PersonTest personTest = new PersonTest();
            personTest.setName("李天" + i);
            if (i % 2 == 0) {
                personTest.setIsMan(true);
                personTest.setAge(20 + i);
            } else {
                personTest.setAge(20);
            }
            if (i % 4 == 0) {
                Map<String, String> addr = new HashMap<>();
                addr.put("province", "广东省");
                addr.put("city", "深圳市");
                personTest.setAddr(addr);
            }
            personTests.add(personTest);
        }

        // 只对isMan属性为空的数据进行更新
        String updateOqlExp = " ${age} = F{Incr(${age})}, ${name} = '刘三', ${addr.city} = '惠州市' ";
        String wehreOqlExp = "${isMan} IS NULL";
        int result = oqlClient.doUpdate(updateOqlExp, wehreOqlExp, personTests);
        TestHelper.printResult( "{} 输出结果为: {}，更新后的数据为{}", updateOqlExp, result, personTests);
        Assert.assertEquals(result, 10);
        for (PersonTest personTest : personTests) {
            if (personTest.getIsMan() == null) {
                Assert.assertTrue(personTest.getAge().equals(21));
                Assert.assertTrue(personTest.getName().equals("刘三"));
                Assert.assertTrue(personTest.getAddr().get("city").equals("惠州市"));
            } else {
                Assert.assertFalse(personTest.getName().equals("刘三"));
            }
        }
    }



    /**
     * 测试 执行Update更新 异常情况
     * @throws Exception
     */
    @Test
    public void testDoUpdateException() throws Exception {
        // 测试空表达式
        try {
            String updateOqlExp = null;
            PersonTest personTest = new PersonTest();
            personTest.setName("李白百");
            personTest.setAge(55);
            int result = oqlClient.doUpdate(updateOqlExp, personTest);
            Assert.fail("update更新表达式为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("update更新表达式为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象为null
        try {
            String updateOqlExp = " ${name}";
            PersonTest personTest = null;
            int result = oqlClient.doUpdate(updateOqlExp, personTest);
            Assert.fail("update更新操作原对象为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("update更新操作原对象为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象集合为null
        try {
            String updateOqlExp = " ${name}, ${age} ";
            Collection cols = null;
            int result = oqlClient.doUpdate(updateOqlExp, cols);
            Assert.fail("update更新操作原对象集合为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("update更新操作原对象集合为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象集合的元素存在null的情况
        try {
            String updateOqlExp = " ${name}, ${age} ";
            List<PersonTest> personTests = new ArrayList<>();
            personTests.add(new PersonTest());
            personTests.add(null);
            int result = oqlClient.doUpdate(updateOqlExp, personTests);
            Assert.fail("update更新操作原对象集合的元素存在null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("update更新操作原对象集合的元素存在null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试更新的字段不存在
        try {
            String updateOqlExp = " ${myName} = '李白' ";
            List<PersonTest> personTests = new ArrayList<>();
            personTests.add(new PersonTest());
            int result = oqlClient.doUpdate(updateOqlExp, personTests);
            Assert.fail("update更新操作字段不存在，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("update更新操作字段不存在，抛出期望的异常({})，测试通过 ", e);
        }
    }
}
