package com.cat.oqj4j.antlr.ext;

import com.cat.oqj4j.annotation.ThreadSafe;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import org.antlr.v4.runtime.*;

/**
 * 消极方式异常策略
 * ps：不用错误语法中进行恢复，语法错误直接抛出异常。
 *
 * @author gwj
 */
@ThreadSafe
public class NegativeErrorStrategy extends DefaultErrorStrategy {
    private static final NegativeErrorStrategy instance = new NegativeErrorStrategy();

    /**
     * 限制对象的创建
     */
    private NegativeErrorStrategy() {
    }

    /**
     * 获取实例对象
     * @return
     */
    public static NegativeErrorStrategy getInstance() {
        return instance;
    }

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        // 不从异常中恢复，直接包装异常就不会被捕捉到
        throw new OqlExpResolvedException("解析异常", e);
    }


    @Override
    public void sync(Parser recognizer) throws RecognitionException {
        // 确保不会试图从子规则的问题中恢复，不做任何的实现。父方法是会试图从恢复的，故覆盖父方法。
    }
}
