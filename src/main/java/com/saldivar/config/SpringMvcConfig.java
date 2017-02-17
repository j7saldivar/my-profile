package com.saldivar.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Language Configuration Class
 * 
 * @author Jorge.Saldivar
 *
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Configures the default language to English
	 * 
	 * @return {@link SessionLocaleResolver}
	 */
	@Bean
	LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	/**
	 * Configures the default string that will be used as the GET parameter name
	 * 
	 * @return {@link LocaleChangeInterceptor}
	 */
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor () {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

}
