package com.cat.oqj4j.support;

import com.cat.oqj4j.exception.BeanHandlingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * apache的beanutils工具包的bean处理器 测试
 *
 * @author gwj
 */
@SuppressWarnings("unchecked")
public class ApacheUtilsBeanHandlerTest {
    private ApacheUtilsBeanHandler apacheUtilsBeanHandler;

    @Before
    public void setUp() {
        apacheUtilsBeanHandler = new ApacheUtilsBeanHandler();
    }

    /**
     * 测试获取字段值
     * @throws Exception
     */
    @Test
    public void testGetFieldVal() throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("name", "gwj");
        Map<String, Object> addr = new HashMap();
        addr.put("city", "广州市");
        map.put("addr", addr);

        Object result1 = apacheUtilsBeanHandler.getFieldVal(map, "name");
        TestHelper.printResult("result1={}", result1);
        Assert.assertEquals("gwj", result1);

        Object result2 = apacheUtilsBeanHandler.getFieldVal(map, "addr.city");
        TestHelper.printResult("result2=", result2);
        Assert.assertEquals("广州市", result2);

        Object result3 = apacheUtilsBeanHandler.getFieldVal(map, "addr.town");
        TestHelper.printResult("result3=", result3);
        Assert.assertEquals(null, result3);
    }

    /**
     * 测试设置字段值
     * @throws Exception
     */
    @Test
    public void testSetFieldVal() throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("name", "gwj");
        Map<String, Object> addr = new HashMap();
        addr.put("city", "广州市");
        map.put("addr", addr);

        TestHelper.printResult("before: {}", map);
        apacheUtilsBeanHandler.setFieldVal(map, "name", "张三");
        apacheUtilsBeanHandler.setFieldVal(map, "addr.city", "惠州市");
        TestHelper.printResult("after: {}", map);
        Assert.assertTrue(map.get("name").equals("张三"));
        Assert.assertTrue(((Map)map.get("addr")).get("city").equals("惠州市"));

        PersonTest personTest = new PersonTest();
        // 复杂属性也支持自动实例化
        apacheUtilsBeanHandler.setFieldVal(personTest, "name", "李四");
        apacheUtilsBeanHandler.setFieldVal(personTest, "age", 32);
        // 测试复杂属性的嵌套赋值
        apacheUtilsBeanHandler.setFieldVal(personTest, "addr.city", "惠州市");
        TestHelper.printResult("设置复杂属性后的结果：{}", personTest);
        Assert.assertTrue(personTest.getName().equals("李四"));
        Assert.assertTrue(personTest.getAge().equals(32));
        Assert.assertTrue(personTest.getAddr().get("city").equals("惠州市"));

        // 测试类型不同时的赋值
        apacheUtilsBeanHandler.setFieldVal(personTest, "name",  123);
        apacheUtilsBeanHandler.setFieldVal(personTest, "age", 33L);
        TestHelper.printResult("使用非严格模式的赋值结果：{}", personTest);
        Assert.assertTrue(personTest.getName().equals("123"));
        Assert.assertTrue(personTest.getAge().equals(33));

        // 测试布尔类型的赋值
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", 1);
        Assert.assertTrue(personTest.getIsMan().equals(true));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "true");
        Assert.assertTrue(personTest.getIsMan().equals(true));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "True");
        Assert.assertTrue(personTest.getIsMan().equals(true));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "TRUE");
        Assert.assertTrue(personTest.getIsMan().equals(true));

        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", 0);
        Assert.assertTrue(personTest.getIsMan().equals(false));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "false");
        Assert.assertTrue(personTest.getIsMan().equals(false));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "False");
        Assert.assertTrue(personTest.getIsMan().equals(false));
        apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "FALSE");
        Assert.assertTrue(personTest.getIsMan().equals(false));
    }

    /**
     * 测试设置字段值出现异常
     * @throws Exception
     */
    @Test
    public void testSetFieldValException() throws Exception {
        TestHelper.printResult("测试异常情况testSetFieldValException");
        PersonTest personTest = new PersonTest();

        // 使用无法转换的类型
        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "age", "abc");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "99");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "yes");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "no");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "on");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "isMan", "off");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            TestHelper.printResult("设置非严格模式切类型无法转换抛出期望异常({})，测试通过。", e);
        }
    }

    /**
     * 测试拷贝bean
     * @throws Exception
     */
    @Test
    public void testCopyBean() throws Exception {

        Map<String, String> addr = new HashMap();
        addr.put("city", "广州市");

        PersonTest dest = new PersonTest();
        dest.setIsMan(true);
        TestHelper.printResult("before: {}", dest);


        Map<String, Object> mapOrig = new HashMap();
        mapOrig.put("name", "gwj");
        mapOrig.put("addr", addr);
        mapOrig.put("other", "知识份子");

        apacheUtilsBeanHandler.copyBean(dest, mapOrig, true);
        TestHelper.printResult("map拷贝结果: {}", dest);


        PersonTest origPerson = new PersonTest();
        origPerson.setName(null);
        origPerson.setAddr(addr);

        apacheUtilsBeanHandler.copyBean(dest, origPerson, true);
        TestHelper.printResult("bean拷贝结果:{} ", dest);

        Map<String, Object> mapOrig2 = new HashMap();
        mapOrig2.put("name", 123);
        mapOrig2.put("addr", addr);
        mapOrig2.put("age", '9');
        mapOrig2.put("isMan", "1");
        apacheUtilsBeanHandler.copyBean(dest, mapOrig2, false);
        TestHelper.printResult("非严格模式的bean拷贝结果:{} ", dest);
    }

}