/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 上午9:09:59
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.dao.sys;

import java.util.Date;

import com.huayin.crm.dao.AbsDao;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 系统配置  - 用户
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日上午9:09:59, zby
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUser extends AbsDao
{
	
	private static final long serialVersionUID = 2978625682510878721L;

	/**
	 * 系统用户账号
	 */
	private String loginname;

	/**
	 * 系统用户密码
	 */
	private String password;

	/**
	 * 注册手机号
	 */
	private String mobile;

	/**
	 * 注册邮箱
	 */
	private String email;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 最后修改时间
	 */
	private Date updateTime;
}
