package com.xuefeng.vo;

/**
 * 通过枚举罗列出所有的状态码
 */
public enum CodeEnum {
    SUCCESS(20000,null),
    FAILURE(50001, "操作失败"),
    ILLEGAL_TOKEN(50008, "非法的令牌"),
    TOKEN_EXPIRED(50014, "令牌已失效")
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
