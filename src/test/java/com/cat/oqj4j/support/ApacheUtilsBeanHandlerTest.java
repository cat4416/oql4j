package com.cat.oqj4j.support;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * apache的beanutils工具包的bean处理器 测试
 */
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

    public static void main(String[] args) {
        String val = "有限公司（深圳）有限";
        System.out.println(val);
        System.out.println(val.replace("有限*", "").replace("（","(")
                .replace("）",")"));
        System.out.println(val.replaceAll("有限*", ""));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(1,"d");

        System.out.println(list);

        BigDecimal b1 = new BigDecimal("36.66");
        BigDecimal b2 = new BigDecimal("36.66");
        System.out.println(b1.compareTo(b2));
        System.out.println(b1.equals(b2));
    }

}