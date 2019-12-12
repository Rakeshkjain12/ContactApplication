package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoDeleteById {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO udao=cx.getBean(UserDAO.class);

	udao.deleteById(3);
	System.out.println("---------Data Deleted---------");
	
	
}
}
