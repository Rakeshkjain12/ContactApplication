package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoSave {
public static void main(String[] args) {
	ApplicationContext cx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
	UserDAO udao=cx.getBean(UserDAO.class);
	
	User u=new User();
	
	u.setName("Ram");
	u.setPhone("123456789");
	u.setEmail("ram@mail.com");
	u.setAddress("Delhi");
	u.setLoginName("RR123");
	u.setPassword("rr12345");
	u.setRole(1);
	u.setLoginStatus(1);
	
	udao.save(u);
	System.out.println("---------Data Saved---------");
}
}
