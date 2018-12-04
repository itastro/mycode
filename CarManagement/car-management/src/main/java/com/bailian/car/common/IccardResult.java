package com.bailian.car.common;

public class IccardResult {

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String code;

	private String msg;

	public static IccardResult success(String msg, String code) {
		IccardResult result = new IccardResult();
		result.code = "0";
		result.msg = msg;
		return result;

	}

	public static IccardResult fail(String msg, String code) {
		IccardResult result = new IccardResult();
		result.code = "1";
		result.msg = msg;
		return result;

	}

}
