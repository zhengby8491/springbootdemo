/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 下午1:59:51
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.service.sys;

import com.huayin.crm.vo.sys.SysUser;

/**
 * <pre>
 * 系统用户
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日下午1:59:51, zby
 */
public interface SysUserService
{
	
	/**
	 * <pre>
	 * 获取一条用户的记录
	 * </pre>
	 * @param id
	 * @return
	 * @since 1.0, 2019年3月22日 下午2:35:25, zby
	 */
	public SysUser get(Long id);
	
	/**
	 * <pre>
	 * 更新客户记录
	 * </pre>
	 * @param sysUser
	 * @return 
	 * @since 1.0, 2019年3月22日 下午2:10:37, zby
	 */
	public void update(SysUser sysUser);
}
