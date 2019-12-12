package com.capp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	 public ModelAndView handleNoHandlerFoundException() {
		 
		 ModelAndView mv =new ModelAndView("errorPage");
		 mv.addObject("errorTitle","This Page is not Construct");
		 mv.addObject("errorDescription","The page you are loooking for is not available now");
		 mv.addObject("title","404 Error page");
		 return mv;
	 }
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleServerSideException(Exception ex) {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle" ,"Contact Administration");
		mv.addObject("errorDescription","If any case web is not running or not working properly Please Contact on 7354717670");
		return mv;
	}
}
