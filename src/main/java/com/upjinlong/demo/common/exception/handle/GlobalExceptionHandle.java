package com.upjinlong.demo.common.exception.handle;

import com.upjinlong.demo.common.exception.NotOperableException;
import com.upjinlong.demo.common.http.JsonObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public JsonObject handle(Exception e){
        return new JsonObject(null, -1, e.getMessage());
    }
}
