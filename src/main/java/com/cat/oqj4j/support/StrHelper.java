package com.cat.oqj4j.support;

import org.antlr.v4.runtime.RuleContext;

/**
 * 字符串助手类
 *
 * @author gwj
 */
public abstract class StrHelper {
    /**
     * 填充{}占位符的内容
     * @param str 原字符串
     * @param args 参数
     * @return 填充后的字符串
     */
    public static String fillPlaceholder(String str, Object... args) {
        String result = str;
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                String argStr = arg == null ? "null" : arg.toString();
                // 如果存在$符号需要进行转义
                if (argStr.contains("$")) {
                    argStr = argStr.replaceAll("\\$", "\\\\\\$");
                }
                result = result.replaceFirst("\\{\\}", argStr);
            }
        }
        return result;
    }

    /**
     * 头部和尾部个修剪掉1个字符串.
     * ps：如果str参数为null或者长度小于2，则直接返回原字符串。
     * @param str
     * @return 去除后的字符串
     */
    public static String trimOneCharHeadAndTail(String str) {
        String result = str;
        if (result != null && result.length() >= 2) {
            result = result.substring(1, result.length() - 1);
        }
        return result;
    }

    /***
     *  拼接子文本并使用空格隔开
     * @param ruleContext antlr的规则上下文
     * @return 拼接字符串
     */
    public static String joinChildTextUseBlankPart(RuleContext ruleContext) {
        int childCount = ruleContext.getChildCount();
        if (childCount == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            builder.append(ruleContext.getChild(i).getText()).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}
