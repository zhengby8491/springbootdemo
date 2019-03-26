/**
 * 
 */
package com.huayin.crm.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * TODO 输入类型说明
 * </pre>
 * @author         zby
 * @version 	     1.0, 2019年3月21日下午3:57:29, zby
 */
@Controller
public class SysController
{

	/**
	 * <pre>
	 * TODO
	 * </pre>
	 * @param model
	 * @return
	 * @since 1.0, 2019年3月21日 下午5:52:52, zby
	 */
	@RequestMapping("sys/index")
	public String index(Model model)
	{
		return "sys/index.html";
	}
	
	@RequestMapping("sys/list")
	public String list(Model model)
	{
		return "sys/list.html";
	}
}
