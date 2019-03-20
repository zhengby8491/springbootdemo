/**
 * 
 */
package com.huayin.crm.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *
 */
@Controller
public class SysController {

	@RequestMapping("index")
	public String index() {
		return "sys/index.html";
	}
}
