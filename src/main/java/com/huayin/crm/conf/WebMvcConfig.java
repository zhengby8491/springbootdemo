/**
 * <pre>
 * Author:		     zby
 * Create:	 	     2019年3月21日 下午2:08:03
 * Copyright: 	   Copyright (c) 2019
 * Company:		     ShenZhen HuaYin
 * @since:         1.0
 * <pre>
 */
package com.huayin.crm.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 *  框架 - 拦截器
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:08:03, zby
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {
	
	@Bean
	public DateConverterConfig dateConverterConfig()
	{
		return new DateConverterConfig();
	}
}
