package com.spongzi.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DemoException extends RuntimeException {

    private Integer code;

    private String msg;

    public DemoException() {

    }

    public DemoException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DemoException(DemoExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }
}
