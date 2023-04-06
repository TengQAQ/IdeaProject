package com.hxzy.vo;

public enum CodeEnum {
    SUCCESS(20000,null),
    FAILURE(50001, "操作失败"),
    ILLEGAL_TOKEN(50008, "非法的令牌"),
    TOKEN_EXPIRED(50014, "令牌已失效"),
    INCORRECT_LOGIN_INFO(50015,"用户名或密码错误"),
    USER_BLOCKED_STATE(50016,"当前用户状态异常，请与管理员联系")
    ;


    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
