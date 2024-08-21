package com.upjinlong.demo.common.http;

import com.upjinlong.demo.common.exception.NotOperableException;

/**
 * 通用响应对象
 */
public class JsonObject {

    /**
     * 响应内容
     */
    private Object data;
    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应说明
     */
    private String message;

    public JsonObject(Object data, int code, String message){
        this.data = data;
        this.code = code;
        this.message = message;
    }
    public JsonObject(){}

    public JsonObject(Object data){
        this.data = data;
        this.code = HttpStatus.SUCCESS.getValue();
    }

    public static final JsonObject SUCCESS = new JsonObject(){
        @Override
        public void setData(Object data) {
            throw new NotOperableException();
        }

        @Override
        public void setCode(int code) {
            throw new NotOperableException();
        }

        @Override
        public void setMessage(String message) {
            throw new NotOperableException();
        }
    };

    public static final JsonObject FAIL = new JsonObject(){
        @Override
        public void setData(Object data) {
            throw new NotOperableException();
        }

        @Override
        public void setCode(int code) {
            throw new NotOperableException();
        }

        @Override
        public void setMessage(String message) {
            throw new NotOperableException();
        }
    };

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
