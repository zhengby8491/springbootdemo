/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午6:22:01
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service;

import com.huayin.crm.pojo.CrmResult;
import com.huayin.crm.vo.sys.SysUser;

/**
 * <pre>
 * 登录
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午6:22:01, zby
 */
public interface LoginService
{

	/**
	 * <pre>
	 * 系统用户登录
	 * </pre>
	 * @param username
	 * @param password
	 * @return
	 * @since 1.0, 2019年3月25日 上午10:09:22, zby
	 */
	CrmResult loginSubmit(String username, String password);
	
	/**
	 * <pre>
	 * 获取在线用户
	 * </pre>
	 * @param token
	 * @return
	 * @since 1.0, 2019年3月25日 上午10:09:35, zby
	 */
	SysUser online(String token);

	/**
	 * <pre>
	 * 用户是否在线
	 * </pre>
	 * @param token
	 * @return
	 * @since 1.0, 2019年3月25日 上午10:09:43, zby
	 */
	boolean isOnline(String token);
	
	/**
	 * <pre>
	 * 重置cookies过期时间
	 * </pre>
	 * @param token
	 * @since 1.0, 2019年3月25日 上午10:09:51, zby
	 */
	void resetExpire(String token);
}
