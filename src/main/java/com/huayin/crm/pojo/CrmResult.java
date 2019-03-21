/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 上午14:52:01
 * Copyright: 	   Copyright (c) 2018
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.pojo;

import java.io.Serializable;

/**
 * <pre>
 * Crm 统一响应结构
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:52:13, zby
 */
public class CrmResult implements Serializable
{
	private static final long serialVersionUID = 9118576162013886372L;

	/**
	 * 验证失败
	 */
	public static final Integer VALID_FAIL = 9988;

	// 定义jackson对象
	// private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 响应业务状态
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 扩展消息（可用于国际化）
	 */
	private String ext;

	/**
	 * 响应中的数据
	 */
	private Object data;

	public static CrmResult build(Integer status, String msg, Object data)
	{
		return new CrmResult(status, msg, null, data);
	}

	public static CrmResult build(Integer status, String msg)
	{
		return new CrmResult(status, msg, null, null);
	}

	public static CrmResult buildValidator(String msg, String ext)
	{
		return new CrmResult(VALID_FAIL, msg, ext, null);
	}

	public static CrmResult ok(Object data)
	{
		return new CrmResult(data);
	}

	public static CrmResult ok()
	{
		return new CrmResult(null);
	}

	public CrmResult()
	{

	}

	public CrmResult(Integer status, String msg, String ext, Object data)
	{
		this.status = status;
		this.msg = msg;
		this.ext = ext;
		this.data = data;
	}

	public CrmResult(Object data)
	{
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Boolean isOK()
	{
		return this.status == 200;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public String getExt()
	{
		return ext;
	}

	public void setExt(String ext)
	{
		this.ext = ext;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}
}
