/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午2:00:44
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayin.crm.mapper.sys.SysUserMapper;
import com.huayin.crm.service.sys.SysUserService;
import com.huayin.crm.vo.sys.SysUser;

/**
 * <pre>
 * 系统用户
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午2:00:44, zby
 */
@Service
public class SysUserServiceImpl implements SysUserService
{
	@Autowired
	private SysUserMapper sysUserMapper;
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.sys.SysUserService#get(java.lang.Long)
	 */
	@Override
	public SysUser get(Long id)
	{
		return sysUserMapper.get(id);
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.sys.SysUserService#getByLoginname(java.lang.String)
	 */
	@Override
	public SysUser getByLoginname(String loginname)
	{
		return sysUserMapper.getByLoginname(loginname);
	}
	
	/* （非 Javadoc）
	 * @see com.huayin.crm.service.sys.SysUserService#update(com.huayin.crm.vo.sys.SysUser)
	 */
	@Override
	public void update(SysUser sysUser)
	{
		sysUserMapper.updateByIdSelective(sysUser);
	}
}
