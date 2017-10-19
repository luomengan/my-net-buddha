package com.luomengan.pojo;

import com.luomengan.exception.ExceptionEnum;

/**
 * 响应结果对象
 * 
 * @author luomengan
 *
 * @param <T>
 *            结果数据类型
 */
public class Response<T> {

	/**
	 * 状态码
	 */
	private String code = "200";
	/**
	 * 响应实体对象
	 */
	private T result;
	/**
	 * 响应消息提示
	 */
	private String message = "OK";

	public Response() {
	}

	public Response(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public Response(ExceptionEnum exEnum) {
		this.code = exEnum.getCode();
		this.message = exEnum.getMessage();
	}

	public Response(T result) {
		this.result = result;
	}

	public Response(String code, T result, String message) {
		this.code = code;
		this.result = result;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
