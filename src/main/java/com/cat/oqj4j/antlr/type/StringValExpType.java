package com.cat.oqj4j.antlr.type;

import com.cat.oqj4j.support.StrHelper;

/**
 * 字符串值类型
 *
 * @author gwj
 */
public class StringValExpType implements ConstValExpType<String> {
    /**
     * 单引号
     */
    private final static String SINGLE_QUOTES = "'";
    /**
     * 双引号
     */
    private final static String DOUBLE_QUOTES = "\"";

    /**
     * 表达式
     */
    private String exp;


    public StringValExpType(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return this.exp;
    }

    @Override
    public String getVal() {
        /**
         * 字符串格式表达式有两种：
         * "字符串内容"
         * '字符串内容'
         *
         * 需要将头尾两边的单双引号去掉
         */
        String val = exp;
        if (val.startsWith(DOUBLE_QUOTES) && val.endsWith(DOUBLE_QUOTES)) {
            val = StrHelper.trimOneCharHeadAndTail(val);
        } else if (val.startsWith(SINGLE_QUOTES) && val.endsWith(SINGLE_QUOTES)) {
            val = StrHelper.trimOneCharHeadAndTail(val);
        }
        return val;
    }
}
