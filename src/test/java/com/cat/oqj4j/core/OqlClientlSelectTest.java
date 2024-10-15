package com.cat.oqj4j.core;

import com.cat.oqj4j.support.MyPersonTest;
import com.cat.oqj4j.support.PersonTest;
import com.cat.oqj4j.support.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Oql客户端的select映射 测试
 * @author gwj
 */
public class OqlClientlSelectTest {
    private OqlClient oqlClient;

    @Before
    public void setUp() {
        OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
        oqlClient = oqlClientBuilder.build();
    }

    /**
     * 测试 执行Select映射查询
     * ps：测试单数据并转换为map
     * @throws Exception
     */
    @Test
    public void testDoSelectForSingleMap() {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);
        String selectOqlExp = " ${age} myAge, ${isMan} as manGender, ${name}, ${property} TheProperty, F{StrLen(${name})}, true isOld, M{getBriefIntro} briefIntro";
        Map<String, Object> result = oqlClient.doSelect(selectOqlExp, p01);
        TestHelper.printResult( "{} 输出结果为: {}", selectOqlExp, result);
        Assert.assertTrue(result.get("myAge").equals(36));
        Assert.assertTrue(result.get("manGender").equals(true));
        Assert.assertTrue(result.containsKey("TheProperty"));
        Assert.assertTrue(result.get("name").equals("张三"));
        Assert.assertTrue(result.get("StrLen").equals(2));
    }


    /**
     * 测试 执行Select映射查询
     * ps：测试单数据并转换为目标类
     * @throws Exception
     */
    @Test
    public void testDoSelectForSingleTarget() {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);
        // 测试场景：1、类型不同；2、设置别名；3、嵌套属性设置
        String selectOqlExp = " F{CastStr(${age})} myAge, ${isMan} as knownGender, ${name} as myName, ${addr.province} as  myAddr.province,  ${addr.city} myAddr.city";
        MyPersonTest result = oqlClient.doSelect(selectOqlExp, p01, MyPersonTest.class);
        TestHelper.printResult( "{} 输出结果为: {}", selectOqlExp, result);
        Assert.assertTrue(result.getMyAge().equals(36));
        Assert.assertTrue(result.getKnownGender().equals(true));
        Assert.assertTrue(result.getMyName().equals("张三"));
        Assert.assertNull(result.getMyAddr().getProvince());
    }

    /**
     * 测试 执行Select映射查询
     * ps：测试多数据并转换为目标类
     * @throws Exception
     */
    @Test
    public void testDoSelectForMultiTarget() {
        List<PersonTest> personTests = new ArrayList<>();
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(36);

        PersonTest p02 = new PersonTest();
        p02.setName("李明博");
        p02.setAge(24);
        Map<String, String> addr = new HashMap<>();
        addr.put("province", "山东省");
        addr.put("town", "金山镇");
        p02.setAddr(addr);

        personTests.add(p01);
        personTests.add(p02);

        String selectOqlExp = " ${age} myAge, ${isMan} as knownGender, ${name} as myName, ${addr.province} as  myAddr.province,  ${addr.city} myAddr.city";
        List<MyPersonTest> result = oqlClient.doSelect(selectOqlExp, personTests, MyPersonTest.class);
        TestHelper.printResult( "{} 输出结果为: {}", selectOqlExp, result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.get(0).getMyAge().equals(36));
        Assert.assertTrue(result.get(0).getKnownGender().equals(true));
        Assert.assertTrue(result.get(0).getMyName().equals("张三"));
        Assert.assertNull(result.get(0).getMyAddr().getProvince());

        Assert.assertTrue(result.get(1).getMyAge().equals(24));
        Assert.assertNull(result.get(1).getKnownGender());
        Assert.assertTrue(result.get(1).getMyName().equals("李明博"));
        Assert.assertNotNull(result.get(1).getMyAddr().getProvince());
    }

    /**
     * 测试 执行Select映射查询
     * ps：测试包含有where条件并转换为map
     * @throws Exception
     */
    @Test
    public void testDoSelectForWhereMap() {
        List<PersonTest> personTests = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            PersonTest personTest = new PersonTest();
            personTest.setName("李天" + i);
            if (i % 2 == 0) {
                personTest.setAge(20 + i);
            } else {
                personTest.setAge(20);
            }
            personTests.add(personTest);
        }
        // 测试where条件有满足数据
        String selectOqlExp = " ${age} myAge, ${isMan} as manGender, ${name}, ${property} TheProperty, F{StrLen(${name})}";
        String whereOqlExp = " ${age} = 20 and (${name} = '李天7' or ${name} = '李天13')";
        List<Map<String, Object>> result = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result);
        Assert.assertEquals(2, result.size());

        // 测试空集合数据
        result = oqlClient.doSelect(selectOqlExp, whereOqlExp, Collections.emptyList());
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result);
        Assert.assertEquals(0, result.size());

        // 测试where条件无满足数据
        whereOqlExp = " ${age} = 27 and ${name} = '李天7'";
        result = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result);
        Assert.assertEquals(0, result.size());
    }

    /**
     * 测试 执行Select映射查询
     * ps：测试包含有where条件并转换为目标类
     * @throws Exception
     */
    @Test
    public void testDoSelectForWhereTarget() {
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
        // 测试where条件有满足数据，并转换为Map
        String selectOqlExp = " ${age} myAge, ${isMan} as manGender, ${name}, ${addr}, ${property} TheProperty, F{StrLen(${name})}";
        String whereOqlExp = " ${age} = 24 or ${age} = 32 or ${age} = 38";
        List<Map> result1 = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests, Map.class);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result1);
        Assert.assertEquals(3, result1.size());

        // 测试where条件有满足数据，并转换为PersonTest
        selectOqlExp = " ${age} age, ${isMan} as isMan, ${name}, ${property}, ${addr}";
        whereOqlExp = " ${age} between 21 and 28";
        List<PersonTest> result2 = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests, PersonTest.class);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result2);
        Assert.assertEquals(4, result2.size());


        // 测试where条件有满足数据，并转换为MyPersonTest
        selectOqlExp = " ${age} myAge, ${isMan} as knownGender, ${name} as myName, ${addr.province} as  myAddr.province,  ${addr.city} myAddr.city";
        whereOqlExp = " ${age} in (20, 22, '24')";
        List<MyPersonTest> result3 = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests, MyPersonTest.class);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result3);
        Assert.assertEquals(12, result3.size());

        // 测试where条件有满足数据，并转换为MyPersonTest，并且是有嵌套属性
        whereOqlExp = " ${age} in (20, 22, '24') and F{NotExistNull(${addr})}";
        List<MyPersonTest> result4 = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests, MyPersonTest.class);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result4);
        Assert.assertEquals(1, result4.size());
        Assert.assertNotNull(result4.get(0).getMyAddr());
        Assert.assertNotNull(result4.get(0).getMyAddr().getCity());


        // 测试where条件无满足数据
        whereOqlExp = " ${age} in (20, 22, '24') and F{NotExistNull(${addr})} and ${name} = '李天000'";
        List<MyPersonTest> result5 = oqlClient.doSelect(selectOqlExp, whereOqlExp, personTests, MyPersonTest.class);
        TestHelper.printResult( "selectOqlExp = {}， whereOqlExp = {}， 输出结果为：{}" ,selectOqlExp, whereOqlExp, result5);
        Assert.assertEquals(0, result5.size());
    }

    /**
     * 测试 执行Select映射 异常情况
     * @throws Exception
     */
    @Test
    public void testDoSelectException() throws Exception {
        // 测试空表达式
        try {
            String selectOqlExp = null;
            PersonTest personTest = new PersonTest();
            personTest.setName("李白百");
            personTest.setAge(55);
            Map<String, Object> result = oqlClient.doSelect(selectOqlExp, personTest);
            Assert.fail("select映射表达式为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("select映射表达式为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象为null
        try {
            String selectOqlExp = " ${name}";
            PersonTest personTest = null;
            Map<String, Object> result = oqlClient.doSelect(selectOqlExp, personTest);
            Assert.fail("select映射操作原对象为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("select映射操作原对象为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象集合为null
        try {
            String selectOqlExp = " ${name}, ${age} ";
            Collection cols = null;
            List<PersonTest> result = oqlClient.doSelect(selectOqlExp, cols, PersonTest.class);
            Assert.fail("select映射操作原对象集合为null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("select映射操作原对象集合为null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试操作原对象集合的元素存在null的情况
        try {
            String selectOqlExp = " ${name}, ${age} ";
            List<PersonTest> personTests = new ArrayList<>();
            personTests.add(new PersonTest());
            personTests.add(null);
            List<PersonTest> result = oqlClient.doSelect(selectOqlExp, personTests, PersonTest.class);
            Assert.fail("select映射操作原对象集合的元素存在null，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("select映射操作原对象集合的元素存在null，抛出期望的异常({})，测试通过 ", e);
        }

        // 测试映射的字段不存在
        try {
            String selectOqlExp = " ${name}, ${age} ";
            List<PersonTest> personTests = new ArrayList<>();
            personTests.add(new PersonTest());
            List<MyPersonTest> result = oqlClient.doSelect(selectOqlExp, personTests, MyPersonTest.class);
            Assert.fail("select映射操作字段不存在，没有抛出期望的异常，且执行结果为：" + result);
        } catch(Exception e) {
            TestHelper.printResult("select映射操作字段不存在，抛出期望的异常({})，测试通过 ", e);
        }
    }
}
