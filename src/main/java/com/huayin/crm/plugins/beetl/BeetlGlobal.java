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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * beetl 公共数据
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:58:14, zby
 */
@Component
public class BeetlGlobal implements WebRenderExt
{
	
	private static long version = System.currentTimeMillis();

	@Override
	public void modify(Template template, GroupTemplate gt, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			// 默认系统版本，也可以在系统配置中重写
			template.binding("SITE_VERSION", version);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
