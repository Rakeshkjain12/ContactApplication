package com.capp.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class mailServiceImpl implements mailService{

	
	@Autowired
	JavaMailSender mailSender;
   
	public void sendMail(final String senderEmailId, final String receiverEmailId,  final String subject,final String msg) {

		MimeMessagePreparator preparator=new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(senderEmailId);			
				mimeMessage.setRecipient(Message.RecipientType.TO	, new InternetAddress(receiverEmailId));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(msg);
				
			}
		};
		
		try {
			
			mailSender.send(preparator);
            System.out.println("-------mail sent------");
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

            

}
