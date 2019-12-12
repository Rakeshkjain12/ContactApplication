package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoFindAll {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO udao=cx.getBean(UserDAO.class);
    
	System.out.println("---------User Details---------");
	List<User> users=udao.findAll();
	for (User u : users) {
		System.out.println(u.getUserId()+" "+u.getName()+" "+u.getPhone()+" "+u.getAddress());
		
	}

	
}
}
