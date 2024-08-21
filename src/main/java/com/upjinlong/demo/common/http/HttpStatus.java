package com.upjinlong.demo.common.http;

/**
 * 通用响应状态编码
 */
public enum HttpStatus {

    SUCCESS(1),

    FALL(0);

    private final int value;

    HttpStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
