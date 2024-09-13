package com.cat.oqj4j.antlr.ext;

import com.cat.oqj4j.antlr.gen.UpdateStatementLexer;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;

/**
 * 对 update 表达式词法分析程序进行扩展定制
 * @author gwj
 */
public class MyUpdateStatementLexer extends UpdateStatementLexer {
    public MyUpdateStatementLexer(CharStream input) {
        super(input);
    }

    @Override
    public void recover(RecognitionException re) {
        throw new OqlExpResolvedException("解析异常", re);
    }
}
