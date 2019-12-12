package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoFindSingleRecord {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO udao=cx.getBean(UserDAO.class);
    
	System.out.println("---------User Details---------");
	User u=udao.findById(1);
	
	System.out.println(u.getUserId());
	System.out.println(u.getName());
	System.out.println(u.getPhone());
	System.out.println(u.getAddress());
	System.out.println(u.getLoginName());
	System.out.println(u.getRole());
	System.out.println(u.getLoginStatus());
	
}
}
