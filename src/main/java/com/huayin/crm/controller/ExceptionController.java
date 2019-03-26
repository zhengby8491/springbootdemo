/**
 * <pre>
 * Author:		   think
 * Create:	 	   2018年11月8日 上午11:58:15
 * Copyright: 	 Copyright (c) 2018
 * Company:		   ShenZhen HuaYin
 * @since:       1.0
 * <pre>
 */
package com.huayin.crm.controller;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;

import com.huayin.crm.exception.LoginException;
import com.huayin.crm.exception.PermissionException;

/**
 * <pre>
 * 框架 - 异常处理
 * </pre>
 * @author       think
 * @version 	   1.0, 2018年11月8日上午11:58:15, think
 */
@ControllerAdvice
public class ExceptionController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * <pre>
	 * 用户不在线
	 * </pre>
	 * @param req
	 * @param e
	 * @return
	 * @throws AuthException
	 * @since 1.0, 2018年11月16日 下午3:20:23, think
	 */
	@ExceptionHandler(value = LoginException.class)
	public String handleAuthException(HttpServletRequest req, Exception e) throws AuthException
	{
		LOGGER.info("未登录");
		return "redirect:/login";
	}
	
	/**
	 * 
	 * <pre>
	 * 用户无权访问
	 * </pre>
	 * @param req
	 * @param e
	 * @return
	 * @throws AuthException
	 * @since 1.0, 2018年11月19日 下午2:34:40, think
	 */
	@ExceptionHandler(value = PermissionException.class)
	public String handlePermissionException(HttpServletRequest req, PermissionException e) 
	{
		return "/error/401";
	}
	
	@ExceptionHandler(value = NestedServletException.class)
	public String handleNestedServletException(HttpServletRequest req, NestedServletException e)
	{
		return "/error/500";
	}

}
