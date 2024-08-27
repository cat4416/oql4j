package com.cat.oqj4j.support;

/**
 * 测试助手类
 * @author gwj
 */
public abstract class TestHelper {
    /**
     * 打印结果
     * @param str 输出字符串
     * @param args 输出参数
     */
    public static void printResult(String str, Object... args) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String testCase = stackTrace.length >= 3 ? stackTrace[2].toString(): "" ;
        System.out.println("---【" + testCase + "】---");
        System.out.println(StrHelper.fillPlaceholder(str, args));
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
}
