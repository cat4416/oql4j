package com.cat.oqj4j.exception;

/**
 *  bean处理异常
 *
 * @author gwj
 */
public class BeanHandlingException extends Exception{
    public BeanHandlingException() {
        super();
    }

    public BeanHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanHandlingException(Throwable cause) {
        super(cause);
    }

    public BeanHandlingException(String message) {
        super(message);
    }
}
