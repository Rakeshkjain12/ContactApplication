package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.service.UserService;

public class TestUserSerivceSave {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserService uservice=cx.getBean(UserService.class);
	
	User u=new User();
	
	u.setName("Nitin");
	u.setPhone("9888888");
	u.setEmail("nitin@mail.com");
	u.setAddress("Delhi");
	u.setLoginName("Nitin123");
	u.setPassword("n12345");
	u.setRole(uservice.ROLE_ADMIN);
	u.setLoginStatus(uservice.LOGIN_STATUS_ACTIVE);
	
	uservice.register(u);
	System.out.println("--------User Registred---------");
}
}
