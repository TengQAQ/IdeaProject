package com.hxzy.vo;

public class Result {
	// 状态码
	private Integer code;
	// 消息
	private String message;
	// 响应的数据
	private Object data;

	public Integer getCode() {
		return code;
	}

	public Result() {
	}

	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public static Result of(CodeEnum codeEnum) {
		return new Result(codeEnum.getCode(), codeEnum.getMessage());
	}

	public static Result of(int update, String failureMessage) {
		Result result;
		if (update > 0) { // 数据库受影响的行数大于0，则说明删除成功
			result = Result.of(CodeEnum.SUCCESS);
		} else {
			result = Result.of(CodeEnum.FAILURE);
			if (failureMessage != null) {
				result.setMessage(failureMessage);
			}
		}
		return result;
	}

	public void setCode(Integer code) {
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

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
