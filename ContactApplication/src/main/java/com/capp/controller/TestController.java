package com.capp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
	@RequestMapping(value="/test")
	public String testAjax(){
		return "test";
	}
	
	@RequestMapping(value="/get_time")
	@ResponseBody
	public String getTime(){
		Date d=new Date();
		return d.toString();
	}
}
