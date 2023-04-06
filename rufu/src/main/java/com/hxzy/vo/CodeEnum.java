package com.hxzy.vo;

public enum CodeEnum {
	SUCCESS(20000,null),
	FAILURE(50001, "操作失败"),
	ILLEGAL_TOKEN(50008, "非法的令牌"),
	TOKEN_EXPIRED(50014, "令牌已失效"),
	UID_PWD_WRONG(20001,"用户名或密码错误"),
	USER_BROKING(20002,"用户状态异常，请联系管理员")
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
