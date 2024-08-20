package com.cat.oqj4j.exception;

/**
 * oql表达式解析异常
 *
 * @author gwj
 */
public class OqlExpResolvedException extends RuntimeException{
    public OqlExpResolvedException() {
        super();
    }

    public OqlExpResolvedException(String message) {
        super(message);
    }

    public OqlExpResolvedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OqlExpResolvedException(Throwable cause) {
        super(cause);
    }
}
