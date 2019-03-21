/**
 * 
 */
package com.huayin.crm.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *
 */
@Controller
public class SysController {

	@RequestMapping("index")
	public String index(Model mod) {
		mod.addAttribute("att", "hello");
		return "sys/index.html";
	}
}
