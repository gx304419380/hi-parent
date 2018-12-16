package com.fly.hi.common.exception;

public class BaseRuntimeException extends RuntimeException {

    private Integer code;

    public BaseRuntimeException() {
    }

    public BaseRuntimeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public BaseRuntimeException setCode(Integer code) {
        this.code = code;
        return this;
    }
}
