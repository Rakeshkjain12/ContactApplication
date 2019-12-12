
package com.capp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;










public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	
	  protected FrameworkServlet createDispatcherServlet(WebApplicationContext wac)
	  {
		  DispatcherServlet ds=new DispatcherServlet(wac);
	  ds.setThrowExceptionIfNoHandlerFound(true); return ds; 
	  
	  }
	 

	public void onStartup(ServletContext servletContext) throws ServletException {

		super.onStartup(servletContext);
	}
	
	
}
