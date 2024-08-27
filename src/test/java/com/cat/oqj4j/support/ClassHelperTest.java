package com.cat.oqj4j.support;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.Closeable;
import java.math.BigDecimal;
import java.util.*;

/**
 * 测试 Class字节码操作助手类
 */
public class ClassHelperTest {

    /**
     * 测试实例化
     * @throws Exception
     */
    @Test
    public void testNewInstance() throws Exception {
        Map mapIns = ClassHelper.newInstance(Map.class);
        TestHelper.printResult( "{}实例化后为 {}", Map.class, mapIns.getClass());

        Collection colIns = ClassHelper.newInstance(Collection.class);
        TestHelper.printResult( "{}实例化后为 {}", Collection.class, colIns.getClass());

        List listIns = ClassHelper.newInstance(List.class);
        TestHelper.printResult( "{}实例化后为 {}", List.class, listIns.getClass());

        Set setIns = ClassHelper.newInstance(Set.class);
        TestHelper.printResult( "{}实例化后为 {}", Set.class, setIns.getClass());

        PersonTest personTest = ClassHelper.newInstance(PersonTest.class);
        TestHelper.printResult( "{}实例化后为 {}", PersonTest.class, personTest.getClass());
    }

    /**
     * 测试实例化 异常
     * @throws Exception
     */
    @Test
    public void testNewInstanceException() throws Exception {
        try {
            Class<Closeable> s = Closeable.class;
            Closeable closeableIns = ClassHelper.newInstance(s);
            Assert.fail("ClassHelper.newInstance进行接口实例化，没有抛出期望的异常" + closeableIns);
        } catch(InstantiationException e) {
            TestHelper.printResult( "进行非集合接口实例化抛出预期异常({}})，测试通过", e);
        }

        try {
            Class<BigDecimal> s = BigDecimal.class;
            BigDecimal bigDecimalIns = ClassHelper.newInstance(s);
            Assert.fail("ClassHelper.newInstance进行非空参数构造器实例化，没有抛出期望的异常" + bigDecimalIns);
        } catch(InstantiationException e) {
            TestHelper.printResult( "进行非空参数构造器实例化抛出预期异常({})，测试通过", e);
        }
    }
}