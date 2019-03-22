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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * 生成随机验证码
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:53:37, zby
 */
@SuppressWarnings("serial")
@WebServlet("/servlet/captcha")
public class CaptchaServlet extends HttpServlet {
	/**
	 * 图片验证码
	 */
	public static final String SESSION_CAPTCHA = "_session_captcha_";
	
	public CaptchaServlet()
	{
		super();
	}

	public void destroy()
	{
		super.destroy();
	}

	/**
	 * <pre>
	 * 检查验证码
	 * </pre>
	 * @param request
	 * @param captcha
	 * @return
	 * @since 1.0, 2017年10月26日 上午9:21:41, think
	 */
	public static boolean validate(HttpServletRequest request, String captcha)
	{
		String _captcha = (String) request.getSession().getAttribute(SESSION_CAPTCHA);
		if (StringUtils.isBlank(_captcha))
		{
			return false;
		}
		// 验证图片验证码
		if (!captcha.equalsIgnoreCase(_captcha))
		{
			return false;
		}
		return true;
	}

	/*
	 * （非 Javadoc）
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String _captcha = request.getParameter(SESSION_CAPTCHA); // AJAX验证，成功返回true
		if (StringUtils.isNotBlank(_captcha))
		{
			response.getOutputStream().print(validate(request, _captcha) ? "true" : "false");
		}
		else
		{
			this.doPost(request, response);
		}
	}

	/*
	 * （非 Javadoc）
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		createImage(request, response);
	}
	
	/**
	 * <pre>
	 * 创建图片
	 * </pre>
	 * @param request
	 * @param response
	 * @throws IOException
	 * @since 1.0, 2018年12月28日 上午11:03:39, think
	 */
	private void createImage(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = CaptchaUtils.generateVerifyCode(4);
		request.getSession().setAttribute(SESSION_CAPTCHA, verifyCode);

		// 生成图片
		int w = 100, h = 30;
		CaptchaUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}
