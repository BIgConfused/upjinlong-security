package com.upjinlong.demo.common.exception;

/**
 * 不可操作异常
 */
public class NotOperableException extends RuntimeException{
    public NotOperableException(){
        super("不支持的操作。");
    }
}
