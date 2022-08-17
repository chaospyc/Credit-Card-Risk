package com.chaossnow.ms.result;

public enum ResultCode {

    SUCCESS(200),
    FAIL(400),
    //缺少目标资源的有效认证凭证
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
