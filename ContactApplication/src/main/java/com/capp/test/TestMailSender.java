package com.capp.test;


import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import com.capp.service.mailService;
import com.capp.service.mailServiceImpl;

/*
public class TestMailSender {
	public static void main(String[] args) {
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	   mailService mailService=ctx.getBean(mailServiceImpl.class);
	   mailService.sendMail("rakeshproject123@gmail.com",
	    		   "jainrakesh279@gmail.com",
	    		   "Testing Contact App", 
	    		   "JAi Shree Ram");
	    ctx.close();
	     System.out.println("---------mail sent-------");
		
	}*/

public class TestMailSender{

	/*
	 * public static void main(String[] args) { String
	 * aToZ="ABCDEFGHIJKLNMOPQRSTWXYZ"; // 36 letter. String dig="1234567890";
	 * String schar="abcdefghijklmnopqrst"; String
	 * randomStr=generateRandom(aToZ,dig,schar); System.out.println(randomStr); }
	 * 
	 * private static String generateRandom(String aToZ,String dig,String schar) {
	 * Random rand=new Random(); StringBuilder res=new StringBuilder(); for (int i =
	 * 0; i < 6; i++) { int randIndex=rand.nextInt(aToZ.length());
	 * res.append(aToZ.charAt(randIndex)); } return res.toString(); }
	 */
	
	
	public static void main(String[] args) {
		System.out.println("\n[a-zA-Z0-9]");

        for (int i = 0; i < 5; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(6));
        }
	}
	}
