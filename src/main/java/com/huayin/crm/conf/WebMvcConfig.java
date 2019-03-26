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

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.huayin.crm.interceptor.LoginInterceptor;
import com.huayin.crm.interceptor.PermissionInterceptor;

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
	
	@Bean
	public LoginInterceptor loginInterceptor()
	{
		return new LoginInterceptor();
	}

	@Bean
	public PermissionInterceptor permissionInterceptor()
	{
		return new PermissionInterceptor();
	}

	/* （非 Javadoc）
	* @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	*/
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		List<String> excludePathPatterns = Arrays.asList("/login**","/login/**","/error/**","/assets/**","/site/**");
		// 登录拦截
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
			.excludePathPatterns(excludePathPatterns)
			.excludePathPatterns("/login/**");
		
		
//		// 权限拦截
//		registry.addInterceptor(permissionInterceptor()).addPathPatterns("/**")
//			.excludePathPatterns(excludePathPatterns);
	}
}
