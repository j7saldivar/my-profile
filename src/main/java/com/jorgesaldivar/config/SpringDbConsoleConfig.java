package com.jorgesaldivar.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 
 * Configuration class to create the console web point
 * for accessing H2 console web browser
 * 
 * @author Jorge.Saldivar
 *
 */
@Configuration
public class SpringDbConsoleConfig {

	/**
	 * 
	 * @return registration bean
	 */
	@Profile(value="development") 
	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet()); 
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

}
