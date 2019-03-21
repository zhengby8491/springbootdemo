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

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Tag;
import org.beetl.ext.spring.SpringBeanTagFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibeetl.starter.BeetlTemplateCustomize;

/**
 * <pre>
 * Beetl - 工厂
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午2:57:26, zby
 */
@Configuration
public class BeetlExtConfig implements ApplicationContextAware
{
	@Value("${fastdfs.base.url}")
	private String FASTDFS_BASE_URL;
	
	@Value("${page.portal.url}")
	private String portalUrl;

	@Value("${page.portal.erp}")
	private String portalErp;

	@Value("${page.portal.finance}")
	private String portalFinanc;

	@Value("${page.portal.partner}")
	private String portalPartner;

	/**
	 * 购物指南:购物流程
	 */
	@Value("${page.portal.helper.process}")
	private String portalHelperProcess;

	/**
	 * 购物指南:常见问题
	 */
	@Value("${page.portal.helper.problem}")
	private String portalHelperProblem;

	/**
	 * 购物指南:交易条款
	 */
	@Value("${page.portal.helper.trade}")
	private String portalHelperTrade;

	/**
	 * 购物指南:账户信息
	 */
	@Value("${page.portal.helper.members}")
	private String portalHelperMembers;

	/**
	 * 购物指南:支付及发票
	 */
	@Value("${page.portal.helper.invoice}")
	private String portalHelperInvoice;

	/**
	 * 售后服务：售后条款
	 */
	@Value("${page.portal.helper.clause}")
	private String portalHelperClause;

	/**
	 * 售后服务：售后申请
	 */
	@Value("${page.portal.helper.apply}")
	private String portalHelperApply;

	/**
	 * 售后服务：售后退款说明
	 */
	@Value("${page.portal.helper.refund}")
	private String portalHelperRefund;

	/**
	 * 售后服务：售后查询/修改
	 */
	@Value("${page.portal.helper.queryupdate}")
	private String portalHelperQueryupdate;

	/**
	 * 关于我们：公司简介
	 */
	@Value("${page.portal.helper.intro}")
	private String portalHelperIntro;

	/**
	 * 关于我们：广告服务
	 */
	@Value("${page.portal.helper.adv}")
	private String portalHelperAdv;

	/**
	 * 关于我们：平台定位
	 */
	@Value("${page.portal.helper.location}")
	private String portalHelperLocation;

	/**
	 * 关于我们：大事记
	 */
	@Value("${page.portal.helper.history}")
	private String portalHelperHistory;

	/**
	 * 服务规则：商家服务规则
	 */
	@Value("${page.portal.helper.shop}")
	private String portalHelperShop;

	/**
	 * 服务规则：聚印网优惠券规则
	 */
	@Value("${page.portal.helper.coupon}")
	private String portalHelperCoupon;

	/**
	 * 服务规则：积分规则一点通
	 */
	@Value("${page.portal.helper.pointeasy}")
	private String portalHelperPointeasy;

	/**
	 * 商家服务:卖家入驻
	 */
	@Value("${page.portal.helper.in}")
	private String portalHelperIn;

	/**
	 * 商家服务:卖家服务支持
	 */
	@Value("${page.portal.helper.support}")
	private String portalHelperSupport;

	/**
	 * 配送与支付：配送服务与说明
	 */
	@Value("${page.portal.helper.desc}")
	private String portalHelperDesc;

	/**
	 * 配送与支付：配送服务查询
	 */
	@Value("${page.portal.helper.query}")
	private String portalHelperQuery;

	/**
	 * 配送与支付：配送情况异常
	 */
	@Value("${page.portal.helper.exception}")
	private String portalHelperException;

	/**
	 * 配送与支付：地址填写/变更
	 */
	@Value("${page.portal.helper.change}")
	private String portalHelperChange;

	/**
	 * 服务规则：积分管理规则
	 */
	@Value("${page.portal.helper.point}")
	private String portalHelperPoint;

	@Value("${page.sso.url}")
	private String ssoUrl;

	@Value("${page.sso.register}")
	private String ssoRegister;
	
	/**
	 * Spring 应用程序上下文
	 */
	private ApplicationContext applicationContext = null;

	/**
	 * Spring 应用程序上下文
	 *
	 * @param applicationContext
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}
	
	@Bean
	public BeetlTemplateCustomize beetlTemplateCustomize()
	{
		return new BeetlTemplateCustomize()
		{
			public void customize(GroupTemplate groupTemplate)
			{

				/**
				 * 公共参数
				 */
				Map<String, Object> vars = new HashMap<>();
				vars.put("fastdfsUrl", FASTDFS_BASE_URL);
				
				// 基本信息
				vars.put("portalUrl", portalUrl);
				vars.put("portalErp", portalUrl + portalErp);
				vars.put("portalFinanc", portalUrl + portalFinanc);
				vars.put("portalPartner", portalUrl + portalPartner);
				vars.put("ssoUrl", ssoUrl);
				vars.put("ssoRegister", ssoUrl + ssoRegister);

				// 购物指南
				vars.put("portalHelperProcess", portalUrl + portalHelperProcess);
				vars.put("portalHelperProblem", portalUrl + portalHelperProblem);
				vars.put("portalHelperTrade", portalUrl + portalHelperTrade);
				vars.put("portalHelperMembers", portalUrl + portalHelperMembers);
				vars.put("portalHelperInvoice", portalUrl + portalHelperInvoice);

				// 售后服务
				vars.put("portalHelperClause", portalUrl + portalHelperClause);
				vars.put("portalHelperApply", portalUrl + portalHelperApply);
				vars.put("portalHelperRefund", portalUrl + portalHelperRefund);
				vars.put("portalHelperQueryupdate", portalUrl + portalHelperQueryupdate);

				// 关于我们
				vars.put("portalHelperIntro", portalUrl + portalHelperIntro);
				vars.put("portalHelperAdv", portalUrl + portalHelperAdv);
				vars.put("portalHelperLocation", portalUrl + portalHelperLocation);
				vars.put("portalHelperHistory", portalUrl + portalHelperHistory);

				// 服务规则
				vars.put("portalHelperPoint", portalUrl + portalHelperPoint);
				vars.put("portalHelperShop", portalUrl + portalHelperShop);
				vars.put("portalHelperCoupon", portalUrl + portalHelperCoupon);
				vars.put("portalHelperPointeasy", portalUrl + portalHelperPointeasy);

				// 商家服务
				vars.put("portalHelperIn", portalUrl + portalHelperIn);
				vars.put("portalHelperSupport", portalUrl + portalHelperSupport);

				// 配送与支付
				vars.put("portalHelperDesc", portalUrl + portalHelperDesc);
				vars.put("portalHelperQuery", portalUrl + portalHelperQuery);
				vars.put("portalHelperException", portalUrl + portalHelperException);
				vars.put("portalHelperChange", portalUrl + portalHelperChange);

				groupTemplate.setSharedVars(vars);
				
				/**
				 * 自定义标签
				 */
				//			groupTemplate.registerTag("permission", com.huayin.admin.tags.PermissionTag.class);
				Map<String, Tag> beans = applicationContext.getBeansOfType(Tag.class);
				for (String beanName : beans.keySet())
				{
					// 读取自定义标签名
					BeetlTagName tagAnno = beans.get(beanName).getClass().getAnnotation(BeetlTagName.class);
					String tagName = tagAnno != null ? tagAnno.value() : beanName;
					groupTemplate.registerTagFactory(tagName, toSpringBeanTagFactory(beanName));
				}
			}
		};
	}
	
	/**
	 * <pre>
	 * 构造bean对象（可以使用@Autowried）
	 * </pre>
	 * @param beanName
	 * @return
	 * @since 1.0, 2018年12月5日 上午10:41:35, think
	 */
	private SpringBeanTagFactory toSpringBeanTagFactory(String beanName)
	{
		SpringBeanTagFactory springBeanTagFactory = new SpringBeanTagFactory();
		springBeanTagFactory.setName(beanName);
		springBeanTagFactory.setApplicationContext(this.applicationContext);
		return springBeanTagFactory;
	}

}
