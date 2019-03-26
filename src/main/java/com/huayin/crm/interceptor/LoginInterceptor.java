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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.huayin.crm.constant.CrmConstant;
import com.huayin.crm.exception.LoginException;
import com.huayin.crm.service.LoginService;
import com.huayin.crm.utils.CookieUtils;
import com.huayin.crm.utils.StringUtils;

/**
 * <pre>
 * 登录拦截器
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午3:45:29, zby
 */
public class LoginInterceptor implements HandlerInterceptor
{
	@Autowired
	private LoginService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		String token = CookieUtils.getCookieValue(request, CrmConstant.TOKEN);
		if (StringUtils.isNotBlank(token) && loginService.isOnline(token))
		{
			// 重置过期时间
			loginService.resetExpire(token); 
			return true;
		}
		else
		{
			throw new LoginException();
		}
	}

}
