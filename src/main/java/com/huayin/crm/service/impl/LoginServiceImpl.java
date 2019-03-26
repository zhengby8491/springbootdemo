/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午6:23:24
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.huayin.crm.pojo.CrmResult;
import com.huayin.crm.service.JedisClient;
import com.huayin.crm.service.LoginService;
import com.huayin.crm.service.sys.SysUserService;
import com.huayin.crm.utils.FastJsonConvert;
import com.huayin.crm.utils.IDUtils;
import com.huayin.crm.vo.sys.SysUser;

/**
 * <pre>
 * 登录
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午6:23:24, zby
 */
@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private JedisClient jedisClient;
	
	/**
	 * 用户登录SESSION
	 */
	@Value("${redisKey.session.user}")
	private String SESSION_USER;

	/**
	 * 用户登录SESSSION失效时间
	 */
	@Value("${redisKey.session.expire}")
	private Integer SESSION_EXPIRE;

	/**
	 * 用户登录拥有的菜单权限
	 */
	@Value("${redisKey.session.user_permissions}")
	private String SESSION_USER_PERMISSIONS;
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.LoginService#loginSubmit(java.lang.String, java.lang.String)
	 */
	@Override
	public CrmResult loginSubmit(String username, String password)
	{
		if (StringUtils.isEmpty(username))
		{
			return CrmResult.buildValidator("用户名不能为空", "loginfail|");
		}
		
		if (StringUtils.isEmpty(password))
		{
			return CrmResult.buildValidator("密码不能为空", "loginfail|");
		}
		CrmResult result = new CrmResult();
		SysUser user = sysUserService.getByLoginname(username);
		if (user == null)
		{
			return CrmResult.buildValidator("用户名或密码错误", "loginfail|");
		} else {
			if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword()))
			{
				return CrmResult.buildValidator("用户名或密码错误", "loginfail|");
			} else
			{	
				String token =  IDUtils.genToken();
				String key = SESSION_USER + token;
				jedisClient.set(key, FastJsonConvert.convertObjectToJSON(user));
				jedisClient.expire(key, SESSION_EXPIRE);
				result.setData(token);
				result.setStatus(200);
			}
		}
		return result;
		
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.LoginService#online(java.lang.String)
	 */
	@Override
	public SysUser online(String token)
	{
		String key = SESSION_USER + token;
		String online = jedisClient.get(key);
		if (StringUtils.isNotBlank(online))
		{
			return FastJsonConvert.convertJSONToObject(online, SysUser.class);
		}
		return null;
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.LoginService#isOnline(java.lang.String)
	 */
	@Override
	public boolean isOnline(String token)
	{
		return null != online(token);
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.LoginService#resetExpire(java.lang.String)
	 */
	@Override
	public void resetExpire(String token)
	{
		resetExpireUser(token);
		resetExpireUserPermissions(token);
	}
	
	/**
	 * <pre>
	 * 用户登录权限
	 * </pre>
	 * @param token
	 * @since 1.0, 2019年3月25日 上午10:22:44, zby
	 */
	public void resetExpireUser(String token)
	{
		String key = SESSION_USER + token;
		String online = jedisClient.get(key);
		if (StringUtils.isNotBlank(online))
		{
			jedisClient.expire(key, SESSION_EXPIRE);
		}
	}
	
	/**
	 * <pre>
	 * 用户菜单权限
	 * </pre>
	 * @param token
	 * @since 1.0, 2019年3月25日 上午10:22:37, zby
	 */
	public void resetExpireUserPermissions(String token)
	{
		String key = SESSION_USER_PERMISSIONS + token;
		String online = jedisClient.get(key);
		if (StringUtils.isNotBlank(online))
		{
			jedisClient.expire(key, SESSION_EXPIRE);
		}
	}
}
