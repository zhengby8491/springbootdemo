/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午3:45:29
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <pre>
 * 登录拦截器
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午3:45:29, zby
 */
public class LoginInterceptor implements HandlerInterceptor
{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
//		throw new Exception();
		return true;
	}

}
