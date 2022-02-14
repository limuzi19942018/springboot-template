package com.shannonai.springboot.base.tips;


/**
 * @Description 所有业务异常的枚举
 * @author ligang
 * @date 2020年09月12日 下午5:04:51
 */
public enum ExceptionEnum {

	/**
	 * 错误的请求
	 */
	EXCEPTION_ERROR_500(500, "服务器异常！"),

	EXCEPTION_ERROR_401(401, "请重新登录！"),

	EXCEPTION_ERROR_404(404, "请求页面不存在！"),

	EXCEPTION_ERROR_400(400,"请求错误！");

	ExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;

	private String message;

	public Integer getCode() {
		return code;
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
}
