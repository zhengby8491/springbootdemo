/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午2:53:37
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.plugins.beetl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * Beetl - 自定义函数命名
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:58:04, zby
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BeetlTagName
{
	/**
	 * 标签名称
	 */
	String value() default "";

}
