package com.spongzi.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum DemoExceptionEnum {

    USER_NOT_EXIST(10001, "用户不存在"),
    INSUFFICIENT_BALANCE(10002, "余额不足");

    private final Integer code;

    private final String msg;

    DemoExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
