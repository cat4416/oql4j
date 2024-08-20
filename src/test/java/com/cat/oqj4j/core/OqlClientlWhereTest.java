package com.cat.oqj4j.core;

import com.cat.oqj4j.support.PersonTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Oql客户端的where条件 测试
 *
 * @author gwj
 */
public class OqlClientlWhereTest {
    private OqlClient oqlClient;

    @Before
    public void setUp() {
        OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
        oqlClient = oqlClientBuilder.build();
    }

    /**
     * 测试 执行Where条件是否存在符合的记录
     * ps：测试in
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForIn() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName("张三");
        String whereOqlExp = " ${name} in ('李白', '张三')";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);


        whereOqlExp = " ${name} in ('李白', '张', '飞', 'gwj')";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(false, result);
    }

    /**
     * 测试 执行Where条件是否存在符合的记录
     * ps：测试单值表达式
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForVal() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName("0");
        String whereOqlExp = " ${name}";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(false, result);


        personTest.setName("true");
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);
    }

    /**
     * 测试 执行Where条件是否存在符合的记录3
     * ps：测试null
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForNull() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName(null);
        String whereOqlExp = " ${name} = null";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);


        whereOqlExp = " ${name} != null";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(false, result);

        whereOqlExp = " ${name} is null";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);

        whereOqlExp = " ${name} IS not null";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(false, result);
        
        Map<String, String> srcMap = new HashMap<>();
        srcMap.put("name", "李明");
        whereOqlExp = " ${name} IS not null";
        result = oqlClient.doWhereExists(whereOqlExp, srcMap);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);
    }

    /**
     * 测试 执行Where条件是否存在符合的记录4
     * ps：测试between表达式
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForBetween() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName("李白百");
        personTest.setAge(55);
        String whereOqlExp = " ${age} between 54 and 66";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(true, result);


        whereOqlExp = " ${age} between 65 and 66";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(false, result);
    }

    /**
     * 测试 执行Where条件是否存在符合的记录5
     * ps：测试and、or表达式
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForAndOr() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName("李白百");
        personTest.setAge(55);
        String whereOqlExp = " ${age} = 20 And ${name} = '李白百'";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(false, result);

        whereOqlExp = " ${age} = 20 Or ${name} = '李白百'";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(true, result);

        whereOqlExp = "${age} = 20 or ${age} = 55 or  ${name} = '李白百' and ${name} = '李飞'";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(true, result);

        whereOqlExp = "${age} = 20 or (${age} = 55 or  ${name} = '李白百') and ${name} = '李飞'";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp + "输出结果为：" + result);
        Assert.assertEquals(false, result);
    }


    /**
     * 测试 执行Where条件是否存在符合的记录6
     * ps：测试函数
     * @throws Exception
     */
    @Test
    public void testDoWhereExistsForFun() throws Exception {
        PersonTest personTest = new PersonTest();
        personTest.setName("李白百");
        personTest.setAge(55);
        String whereOqlExp = "F{StrLen(${name})} > 2";
        boolean result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(true, result);

        whereOqlExp = "F{StrLen(${name})} = 3";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(true, result);

        whereOqlExp = "F{StrLen(${name})} > 3";
        result = oqlClient.doWhereExists(whereOqlExp, personTest);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(false, result);
    }

    /**
     * 测试 执行Where条件统计符合的记录数
     * @throws Exception
     */
    @Test
    public void testDoWhereCount() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        int count20Age = 0;
        for (int i = 1; i <= 20; i++) {
            PersonTest personTest = new PersonTest();
            personTest.setName("李天" + i);
            if (i % 2 == 0) {
                personTest.setAge(20 + i);
            } else {
                count20Age++;
                personTest.setAge(20);
            }
            personTests.add(personTest);
        }
        String whereOqlExp = " ${age} = 20 or ${name} = '李白百'";
        int result = oqlClient.doWhereCount(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(count20Age, result);

        whereOqlExp = " ${age} = 20 and ${name} = '李天3'";
        result = oqlClient.doWhereCount(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(1, result);

        whereOqlExp = " ${age} = 20 and ${name} = '李白百'";
        result = oqlClient.doWhereCount(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(0, result);

        whereOqlExp = " ${age} = 30";
        result = oqlClient.doWhereCount(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(1, result);
    }

    /**
     * 测试 执行Where条件 过滤出符合条件的记录
     * @throws Exception
     */
    @Test
    public void testDoWhereFilter() throws Exception {
        List<PersonTest> personTests = new ArrayList<>();
        int count20Age = 0;
        for (int i = 1; i <= 20; i++) {
            PersonTest personTest = new PersonTest();
            personTest.setName("李天" + i);
            if (i % 2 == 0) {
                personTest.setAge(20 + i);
            } else {
                count20Age++;
                personTest.setAge(20);
            }
            personTests.add(personTest);
        }
        String whereOqlExp = " ${age} = 20 or ${name} = '李白百'";
        List<PersonTest> result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(count20Age, result.size());

        whereOqlExp = " ${age} = 20 and ${name} = '李天3'";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(1, result.size());

        whereOqlExp = " ${age} = 20 and ${name} = '李白百'";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(0, result.size());


        whereOqlExp = " ${age} = 30";
        result = oqlClient.doWhereFilter(whereOqlExp, personTests);
        System.out.println(whereOqlExp +"输出结果为：" + result);
        Assert.assertEquals(1, result.size());
    }

}
