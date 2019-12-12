
package com.capp.config;//This Class Configure WEBMVC , JAVAMAIL and EXCEPTION HANDLER

import java.util.Properties;

import javax.persistence.criteria.Order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration

@ComponentScan(basePackages = { "com.capp" })

@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	/* ------------------Bean for Exception Or Error Handling ----------------*/
	
	/*
	 * public HandlerExceptionResolver customExceptionResolver() {
	 * SimpleMappingExceptionResolver s=new SimpleMappingExceptionResolver();
	 * Properties p =new Properties();
	 * 
	 * //mapping spring internal error NoHandlerFoundException to a view name.
	 * 
	 * p.setProperty(NoHandlerFoundException.class.getName(), "errorPage");
	 * s.setExceptionMappings(p);
	 * 
	 * //uncomment following line if we want to send code other than default 200
	 * s.addStatusCode("errorPage", HttpStatus.NOT_FOUND.value());
	 * 
	 * //This resolver will be processed before default ones
	 * s.setOrder(Ordered.HIGHEST_PRECEDENCE);
	 * 
	 * return s;
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	/* -------------Bean For JavaMail -------------*/
	
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("rakeshproject123@gmail.com");
		mailSender.setPassword("7354717670");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
}
