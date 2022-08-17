package com.chaossnow.ms.result;

import java.lang.ref.SoftReference;

/**
 * @author chaos
 * @ClassName Result
 * @date 2022年07月30日 23:40
 * @Version 1.0
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    Result(int code, String message,Object data){
        this.code = code;
        this.message = message;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
