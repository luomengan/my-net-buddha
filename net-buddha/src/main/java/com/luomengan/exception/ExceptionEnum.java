package com.luomengan.exception;

public enum ExceptionEnum {

	// 系统
	Unknow_Exception("1001", "服务器未知异常：%s"),

	// 公共
	AlreadyLike_Exception("2001", "已点赞，不能重复点赞"),

	AlreadyFavourite_Exception("2002", "已收藏，不能重复收藏"),

	AlreadyRating_Exception("2003", "已评分，不能重复评分"),

	UnsupportedPictureFormat_Exception("2004", "不支持的图片格式"),

	// 用户
	UsernameOrPasswordError_Exception("3001", "用户名或者密码错误"),
	
	PhoneAlreadyRegister_Exception("3002", "手机号已被注册");

	private ExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
