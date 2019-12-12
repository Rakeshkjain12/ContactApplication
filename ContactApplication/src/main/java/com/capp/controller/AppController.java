package com.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
   
	@RequestMapping(value={"/","/home"})
	public String homepage(){
		return "home";
	}
	
	@RequestMapping(value="/help")
	public String helppage(){
		return "help";
	}
	
	@RequestMapping(value="/forgotPass")
	public String emailForResetPassword(){
		return "findpass";//JSP
	}
}
