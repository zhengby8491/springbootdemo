/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月22日 上午9:26:26
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * 基础字段
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月22日上午9:26:26, zby
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbsVo implements Serializable
{
	private static final long serialVersionUID = 6138226051014011177L;

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 版本
	 */
	private Long version;
	
	/**
	 * 备注
	 */
	private String memo;
}
