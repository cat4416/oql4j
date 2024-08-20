package com.cat.oqj4j.core;

import com.cat.oqj4j.support.PersonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(whereOqlExp +" 输出结果为：" + result);
        Assert.assertEquals(2, result.size());

        whereOqlExp = "f{StrLen(${addr.province})} > 3";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +" 输出结果为：" + result);
        Assert.assertEquals(1, result.size());

        whereOqlExp = "F{StrLen(${addr.province})} > 3 and ${age} > 20";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +" 输出结果为：" + result);
        Assert.assertEquals(0, result.size());
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

        String whereOqlExp = "F{If(${isMan}, 'M',' W')} = 'M'";
        List<PersonTest> result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +" 输出结果为：" + result);
        Assert.assertEquals(1, result.size());

        whereOqlExp = "F{If(${isMan}, 'M', 'W')} IN ('W','M')";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +" 输出结果为：" + result);
        Assert.assertEquals(2, result.size());
    }

}
