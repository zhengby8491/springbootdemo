/**
 * <pre>
 * Author:		   think
 * Create:	 	   2018年11月19日 下午12:01:46
 * Copyright: 	 Copyright (c) 2018
 * Company:		   ShenZhen HuaYin
 * @since:       1.0
 * <pre>
 */
package com.huayin.crm.utils;

import java.io.UnsupportedEncodingException;

/**
 * <pre>
 * String工具类
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午5:38:41, zby
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils
{
	public static final String CHARSET_NAME = "UTF-8";
	
	/**
	 * <pre>
	 * 转换为字符串
	 * </pre>
	 * @param bytes
	 * @return
	 * @since 1.0, 2019年1月23日 下午2:17:16, think
	 */
	public static String toString(byte[] bytes)
	{
		try
		{
			return new String(bytes, CHARSET_NAME);
		}
		catch (UnsupportedEncodingException e)
		{
			return null;
		}
	}

	/**
	 * <pre>
	 * 转换为字节数组
	 * </pre>
	 * @param str
	 * @return
	 * @since 1.0, 2019年1月23日 下午1:56:46, think
	 */
	public static byte[] getBytes(String str)
	{
		if (str != null)
		{
			try
			{
				return str.getBytes(CHARSET_NAME);
			}
			catch (UnsupportedEncodingException e)
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
}
