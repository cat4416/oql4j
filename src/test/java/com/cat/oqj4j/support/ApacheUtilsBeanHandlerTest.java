package com.cat.oqj4j.support;

import com.cat.oqj4j.exception.BeanHandlingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        System.out.println("result1=" + result1);
        Assert.assertEquals("gwj", result1);

        Object result2 = apacheUtilsBeanHandler.getFieldVal(map, "addr.city");
        System.out.println("result2=" + result2);
        Assert.assertEquals("广州市", result2);

        Object result3 = apacheUtilsBeanHandler.getFieldVal(map, "addr.town");
        System.out.println("result3=" + result3);
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

        System.out.println("before: " + map);
        apacheUtilsBeanHandler.setFieldVal(map, "name", "张三");
        apacheUtilsBeanHandler.setFieldVal(map, "addr.city", "惠州市");
        System.out.println("after: " + map);

        PersonTest personTest = new PersonTest();
        apacheUtilsBeanHandler.setFieldVal(personTest, "name", "李四");
        apacheUtilsBeanHandler.setFieldVal(personTest, "age", 32);
        System.out.println(personTest);

    }

    /**
     * 测试设置字段值出现异常
     * @throws Exception
     */
    @Test
    public void testSetFieldValException() throws Exception {
        System.out.println("测试异常情况testSetFieldValException");
        PersonTest personTest = new PersonTest();
        // 类型不同进行设置，期望抛出异常
        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "name", 998);
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            System.out.println("设置类型不同出现异常，测试通过。" + e.getMessage());
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "age", "32");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            System.out.println("设置类型不同出现异常，测试通过。" + e.getMessage());
        }
    }

    /**
     * 测试拷贝bean
     * @throws Exception
     */
    @Test
    public void testCopyBean() throws Exception {
        PersonTest origPerson = new PersonTest();
        origPerson.setName(null);
        Map<String, String> addr = new HashMap();
        addr.put("city", "广州市");
        origPerson.setAddr(addr);

        Map<String, Object> mapOrig = new HashMap();
        mapOrig.put("name", "gwj");
        mapOrig.put("addr", addr);

        PersonTest dest = new PersonTest();
        System.out.println("before: " + dest);
        apacheUtilsBeanHandler.copyBean(dest, mapOrig);
        System.out.println("after: " + dest);
        apacheUtilsBeanHandler.copyBean(dest, origPerson);
        System.out.println("after2: " + dest);
    }

}