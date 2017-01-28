package com.saldivar.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SpringDbConsoleConfig {

	@Profile(value="development") 
	@Bean
	ServletRegistrationBean h2servletRegistration() {
		
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet()); 
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
		
	}

}
