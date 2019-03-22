/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午5:29:24
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Crm登录
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午5:29:24, zby
 */
@Controller
public class LoginController
{
	/**
	 * <pre>
	 * 登录
	 * </pre>
	 * @param model
	 * @return
	 * @since 1.0, 2019年3月21日 下午5:32:47, zby
	 */
	@RequestMapping("/")
	public String home(Model model)
	{
		return "forward:/index";
	}
	
	/**
	 * <pre>
	 * 访问主页
	 * </pre>
	 * @param model
	 * @return
	 * @since 1.0, 2019年3月21日 下午5:32:50, zby
	 */
	@RequestMapping("/index")
	public String index (Model model)
	{
		return "index.html";
	}

	/**
	 * <pre>
	 * 登录页
	 * </pre>
	 * @param model
	 * @param request
	 * @return
	 * @since 1.0, 2019年3月21日 下午5:40:31, zby
	 */
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request)
	{
		return "login.html";
	}
}