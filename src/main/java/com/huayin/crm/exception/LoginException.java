/**
 * <pre>
 * Author:		   think
 * Create:	 	   2018年11月16日 下午3:17:16
 * Copyright: 	 Copyright (c) 2018
 * Company:		   ShenZhen HuaYin
 * @since:       1.0
 * <pre>
 */
package com.huayin.crm.exception;

/**
 * <pre>
 * 框架 - 用户不在线
 * </pre>
 * @author       think
 * @version 	   1.0, 2018年11月16日下午3:17:16, think
 */
public class LoginException extends Exception
{
	private static final long serialVersionUID = 1L;

	public LoginException()
	{
		super();
	}

	public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LoginException(String message)
	{
		super(message);
	}

	public LoginException(Throwable cause)
	{
		super(cause);
	}
}
