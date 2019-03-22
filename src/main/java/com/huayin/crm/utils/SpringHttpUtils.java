/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午2:53:37
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <pre>
 * 工具 - HttpServlet
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:56:33, zby
 */
public class SpringHttpUtils
{
	/**
	 * 
	 * <pre>
	 * 获取HttpServletRequest
	 * </pre>
	 * @return
	 * @since 1.0, 2018年11月20日 上午9:01:16, think
	 */
	public static HttpServletRequest getRequest()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
