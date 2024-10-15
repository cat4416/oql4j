package com.cat.oqj4j.core;

import com.cat.oqj4j.support.PersonTest;
import com.cat.oqj4j.support.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Oql客户端的函数 测试
 * @author gwj
 */
public class OqlClientFunTest {
    private OqlClient oqlClient;

    @Before
    public void setUp() {
        OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
        oqlClient = oqlClientBuilder.build();
    }

    /**
     * 测试 StrLen 函数
     * @throws Exception
     */
    @Test
    public void testStrLen() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.addAddr("province", "广西壮族自治区");
        p01.addAddr("city", "桂林市");
        personTests.add(p01);

        PersonTest p02 = new PersonTest();
        p02.setName("李四");
        p02.addAddr("province", "广东省");
        p02.addAddr("city", "惠州市");
        personTests.add(p02);

        PersonTest p03 = new PersonTest();
        p03.setName("刘笑笑");
        p03.addAddr("province", "山东省");
        p03.addAddr("city", "济南市");
        personTests.add(p03);

        String whereOqlExp = "F{StrLen(${addr.province})} = 3";
        List<PersonTest> result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(2, result.size());

        whereOqlExp = "f{StrLen(${addr.province})} > 3";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(1, result.size());

        whereOqlExp = "F{StrLen(${addr.province})} > 3 and ${age} > 20";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(0, result.size());
    }

    /**
     * 测试嵌套情况的函数
     * @throws Exception
     */
    @Test
    public void testNestCase() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setAge(94);
        personTests.add(p01);

        PersonTest p02 = new PersonTest();
        p02.setName("李红");
        p01.setAge(101);
        personTests.add(p02);

        String whereOqlExp = "F{CastInt(F{StrLen(${age})})} > 2";
        List<PersonTest> result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * 测试 If 函数
     * @throws Exception
     */
    @Test
    public void testIf() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        personTests.add(p01);

        PersonTest p02 = new PersonTest();
        p02.setName("李红");
        p02.setIsMan(false);
        personTests.add(p02);

        String whereOqlExp = "F{If(${isMan}, 'M','W')} = 'M'";
        List<PersonTest> result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(1, result.size());

        whereOqlExp = "F{If(${isMan}, 'M', 'W')} IN ('W','M')";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertEquals(2, result.size());
    }

    /**
     * 测试 IfNull 函数
     * @throws Exception
     */
    @Test
    public void testIfNull() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        personTests.add(p01);

        PersonTest p02 = new PersonTest();
        p02.setName("李红");
        personTests.add(p02);

        String updateOqlExp = "${isMan} = F{IfNull(${isMan}, false)}";
        int result = oqlClient.doUpdate(updateOqlExp, personTests);
        TestHelper.printResult("{} 输出结果为：{} ", updateOqlExp, result);
        Assert.assertEquals(2, result);
        for (PersonTest personTest : personTests) {
            if (personTest.getName().equals("张三")) {
                Assert.assertEquals(personTest.getIsMan(), true);
            } else  if (personTest.getName().equals("李红")) {
                Assert.assertEquals(personTest.getIsMan(), false);
            }
        }
    }

    /**
     * 测试 CastStr 函数
     * @throws Exception
     */
    @Test
    public void testCastStr() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastStr(${age})})} = 'String'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'String'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }


    /**
     * 测试 CastBigDec 函数
     * @throws Exception
     */
    @Test
    public void testCastBigDec() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastBigDec(${age})})} = 'BigDecimal'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'BigDecimal'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }

    /**
     * 测试 CastInt 函数
     * @throws Exception
     */
    @Test
    public void testCastInt() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastInt(${age})})} = 'Integer'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Integer'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);
    }

    /**
     * 测试 CastLong 函数
     * @throws Exception
     */
    @Test
    public void testCastLong() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastLong(${age})})} = 'Long'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Long'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }


    /**
     * 测试 CastByte 函数
     * @throws Exception
     */
    @Test
    public void testCastByte() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastByte(${age})})} = 'Byte'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, Arrays.asList(p01));
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Byte'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }

    /**
     * 测试 CastFloat 函数
     * @throws Exception
     */
    @Test
    public void testCastFloat() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastFloat(${age})})} = 'Float'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Float'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }

    /**
     * 测试 CastDouble 函数
     * @throws Exception
     */
    @Test
    public void testCastDouble() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(23);

        String whereOqlExp = "F{ClassSimpleName(F{CastDouble(${age})})} = 'Double'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Double'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }


    /**
     * 测试 CastChar 函数
     * @throws Exception
     */
    @Test
    public void testCastChar() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(3);

        String whereOqlExp = "F{ClassSimpleName(F{CastChar(${age})})} = 'Character'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${age})} = 'Character'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }


    /**
     * 测试 CastBool 函数
     * @throws Exception
     */
    @Test
    public void testCastBool() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setIsMan(true);
        p01.setAge(3);

        String whereOqlExp = "F{ClassSimpleName(F{CastBool(${isMan})})} = 'Boolean'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);

        whereOqlExp = "F{ClassSimpleName(${isMan})} = 'boolean'";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);
    }

    /**
     * 测试 NotExistNull 函数
     * @throws Exception
     */
    @Test
    public void testNotExistNull() throws Exception {
        PersonTest p01 = new PersonTest();
        p01.setName("张三");
        p01.setAge(3);

        String whereOqlExp = "F{NotExistNull(${isMan})}";
        boolean result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertFalse(result);

        whereOqlExp = "F{NotExistNull(${name})} && F{NotExistNull(${age})}";
        result = oqlClient.doWhereExists(whereOqlExp, p01);
        TestHelper.printResult("{} 输出结果为：{} ", whereOqlExp, result);
        Assert.assertTrue(result);
    }

    /**
     * 测试 Incr 函数
     * @throws Exception
     */
    @Test
    public void testIncr() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 33);
        map.put("property", 100000L);
        map.put("weight", "57.66");

        String selectOqlExp = " F{Incr(${age})} AS ageIncr, F{Incr(${property})} AS propertyIncr, F{Incr(${weight})} AS weightIncr ";

        Map<String, Object> result = oqlClient.doSelect(selectOqlExp, map);
        TestHelper.printResult("{} 输出结果为：{} ", selectOqlExp, result);
        Assert.assertTrue(result.get("ageIncr") instanceof Integer);
        Assert.assertTrue(result.get("ageIncr").equals(34));
        Assert.assertTrue(result.get("propertyIncr") instanceof Long);
        Assert.assertTrue(result.get("propertyIncr").equals(100001L));
        Assert.assertTrue(result.get("weightIncr") instanceof BigDecimal);
        Assert.assertTrue(((BigDecimal) result.get("weightIncr")).compareTo(new BigDecimal("58.66")) == 0);

        selectOqlExp = "F{Incr(${age}, 10)}  AS ageIncrN, F{Incr(${property}, 10000)}  AS propertyIncrN, F{Incr(${weight}, 20.36)}  AS weightIncrN";
        result = oqlClient.doSelect(selectOqlExp, map);
        TestHelper.printResult("{} 输出结果为：{} ", selectOqlExp, result);
        Assert.assertTrue(result.get("ageIncrN") instanceof Integer);
        Assert.assertTrue(result.get("ageIncrN").equals(43));
        Assert.assertTrue(result.get("propertyIncrN") instanceof Long);
        Assert.assertTrue(result.get("propertyIncrN").equals(110000L));
        Assert.assertTrue(result.get("weightIncrN") instanceof BigDecimal);
        Assert.assertTrue(((BigDecimal) result.get("weightIncrN")).compareTo(new BigDecimal("78.02")) == 0);
    }

    /**
     * 测试 Dncr 函数
     * @throws Exception
     */
    @Test
    public void testDncr() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 33);
        map.put("property", 100000L);
        map.put("weight", "57.66");

        String selectOqlExp = " F{Dncr(${age})} AS ageDncr, F{Dncr(${property})} AS propertyDncr, F{Dncr(${weight})} AS weightDncr ";

        Map<String, Object> result = oqlClient.doSelect(selectOqlExp, map);
        TestHelper.printResult("{} 输出结果为：{} ", selectOqlExp, result);
        Assert.assertTrue(result.get("ageDncr") instanceof Integer);
        Assert.assertTrue(result.get("ageDncr").equals(32));
        Assert.assertTrue(result.get("propertyDncr") instanceof Long);
        Assert.assertTrue(result.get("propertyDncr").equals(99999L));
        Assert.assertTrue(result.get("weightDncr") instanceof BigDecimal);
        Assert.assertTrue(((BigDecimal) result.get("weightDncr")).compareTo(new BigDecimal("56.66")) == 0);

        selectOqlExp = "F{Dncr(${age}, 10)}  AS ageDncrN, F{Dncr(${property}, 10000)}  AS propertyDncrN, F{Dncr(${weight}, 20.36)}  AS weightDncrN";
        result = oqlClient.doSelect(selectOqlExp, map);
        TestHelper.printResult("{} 输出结果为：{} ", selectOqlExp, result);
        Assert.assertTrue(result.get("ageDncrN") instanceof Integer);
        Assert.assertTrue(result.get("ageDncrN").equals(23));
        Assert.assertTrue(result.get("propertyDncrN") instanceof Long);
        Assert.assertTrue(result.get("propertyDncrN").equals(90000L));
        Assert.assertTrue(result.get("weightDncrN") instanceof BigDecimal);
        Assert.assertTrue(((BigDecimal) result.get("weightDncrN")).compareTo(new BigDecimal("37.3")) == 0);
    }

}
