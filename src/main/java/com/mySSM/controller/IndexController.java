package com.mySSM.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private Logger logger=LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("index.do")
	public String redirectIndex(ModelMap model){
		logger.debug("跳转到主页按钮");
		return "/user/userLogin";
	}
}
