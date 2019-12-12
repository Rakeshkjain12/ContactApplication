package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoUpdate {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO udao=cx.getBean(UserDAO.class);
	
	User u=new User();
	
	u.setName("rakesh");
	u.setPhone("7354717670");
	u.setEmail("jainrakeshindia@mail.com");
	u.setAddress("bhopal");
	u.setRole(1);
	u.setLoginStatus(1);
	u.setUserId(38);
	udao.update(u);
	System.out.println("---------Data Updated---------");
	
	
}
}
