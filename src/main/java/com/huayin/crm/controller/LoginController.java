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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huayin.crm.constant.CrmConstant;
import com.huayin.crm.pojo.CrmResult;
import com.huayin.crm.service.LoginService;
import com.huayin.crm.utils.CookieUtils;

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
	@Autowired
	private LoginService loginService;
	
	/**
	 * <pre>
	 * 登录
	 * </pre>
	 * @param model
	 * @return
	 * @since 1.0, 2019年3月21日 下午5:32:47, zby
	 */
	@RequestMapping("/")
	public String forword(Model model)
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
	 * 主页
	 * </pre>
	 * @param model
	 * @return
	 * @since 1.0, 2019年3月26日 下午3:27:34, zby
	 */
	@RequestMapping("/home")
	public String home (Model model)
	{
		return "home.html";
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
	
	/**
	 * <pre>
	 * 提交登录账号密码
	 * </pre>
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 * @since 1.0, 2019年3月22日 下午5:48:07, zby
	 */
	@RequestMapping("/login/submit")
	@ResponseBody
	public CrmResult loginSubmit(HttpServletRequest request,HttpServletResponse response, String username, String password)
	{
		CrmResult result =	loginService.loginSubmit(username, password);
		if (result.isOK())
		{
			CookieUtils.setCookie(request, response, CrmConstant.TOKEN, result.getData().toString());
		}
		return result;
	}
	
}
