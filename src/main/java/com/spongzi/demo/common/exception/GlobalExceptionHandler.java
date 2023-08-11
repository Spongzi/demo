package com.spongzi.demo.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<?> handlerDemoException(DemoException e) {
        log.error("项目出现异常，当前异常状态码为：{}，当前异常返回信息为：{}", e.getCode(), e.getMsg());
        return ResponseEntity.badRequest().body(e.getMsg());
    }
}
