package com.mySSM.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mySSM.common.util.JsonUtil;

@Controller
@RequestMapping("/test")
public class TestJSON {
	private static Logger logger=LoggerFactory.getLogger(TestJSON.class);
	@RequestMapping("/testAjax")
	public String testAjax(@RequestParam(value="id") String id,HttpServletResponse res){
		try {
			logger.error("this is debug log");
			logger.error("this is a error log....");
			JsonUtil.success(res, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
