package com.luomengan.awre.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luomengan.exception.ExceptionEnum;
import com.luomengan.exception.ServiceException;
import com.luomengan.pojo.DataResponse;

@ControllerAdvice(basePackages = { "com.luomengan.controller" })
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public DataResponse<? extends Object> exceptionHandler(ServiceException ex, HttpServletRequest request,
			HttpServletResponse response) {
		DataResponse<? extends Object> result = new DataResponse<>(null);
		result.setCode(ex.getCode());
		result.setMessage(ex.getMessage());
		return result;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public DataResponse<? extends Object> exceptionHandler(Exception ex, HttpServletRequest request,
			HttpServletResponse response) {
		String message = String.format(ExceptionEnum.Unknow_Exception.getMessage(), new Object[] { ex.getMessage() });
		logger.error(message, ex);
		DataResponse<? extends Object> result = new DataResponse<>(null);
		String servletPath = request.getServletPath();
		result.setCode(ExceptionEnum.Unknow_Exception.getMessage());
		result.setMessage(String.format("%s:%s:%s", message, servletPath, ex.getMessage()));
		return result;
	}

}
