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
        // 复杂属性也支持自动实例化
        //personTest.setAddr(new HashMap<>());
        apacheUtilsBeanHandler.setFieldVal(personTest, "name", "李四");
        apacheUtilsBeanHandler.setFieldVal(personTest, "age", 32);
        // 测试复杂属性的嵌套赋值
        apacheUtilsBeanHandler.setFieldVal(personTest, "addr.city", "惠州市");
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
            System.out.println("设置类型不同抛出期望异常("  + e.getMessage() + ")，测试通过。");
        }

        try {
            apacheUtilsBeanHandler.setFieldVal(personTest, "age", "32");
            Assert.fail("apacheUtilsBeanHandler.setFieldVal没有抛出期望的BeanHandlingException异常");
        } catch(BeanHandlingException e) {
            System.out.println("设置类型不同抛出期望异常("  + e.getMessage() + ")，测试通过。");
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
        System.out.println("before: " + dest);


        Map<String, Object> mapOrig = new HashMap();
        mapOrig.put("name", "gwj");
        mapOrig.put("addr", addr);
        mapOrig.put("other", "知识份子");

        apacheUtilsBeanHandler.copyBean(dest, mapOrig);
        System.out.println("after: " + dest);


        PersonTest origPerson = new PersonTest();
        origPerson.setName(null);
        origPerson.setAddr(addr);

        apacheUtilsBeanHandler.copyBean(dest, origPerson);
        System.out.println("after2: " + dest);
    }

}