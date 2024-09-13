package com.cat.oqj4j.antlr.ext;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.StrHelper;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * 抛出错误监听器
 * ps：监听alntr的语法解析，如果出现错误则直接抛出
 *
 * @author gwj
 */
@ThreadSafe
public class ThrowErrorListener extends BaseErrorListener {
    private static final ThrowErrorListener instance = new ThrowErrorListener();

    /**
     * 限制对象的创建
     */
    private ThrowErrorListener() {
    }

    /**
     * 获取实例对象
     * @return 返回实例对象
     */
    public static ThrowErrorListener getInstance() {
        return instance;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        throw new OqlExpResolvedException(StrHelper.fillPlaceholder("表达式解析异常-在第 {} 行 {} 位置字符有误. {}", line, charPositionInLine, msg));
    }
}
