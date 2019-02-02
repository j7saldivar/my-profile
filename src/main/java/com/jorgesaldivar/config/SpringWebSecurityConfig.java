package com.jorgesaldivar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Security configuration class
 *
 * @author Jorge.Saldivar
 *
 */
@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Security permitted urls if user is not logged.
	 * Login page configuration.
	 * CSRF disabled
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/webjars/**", "/css/**", "/fonts/**", "/js/**", "/images/**", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

	/**
	 *
	 * @param auth
	 * @throws Exception
	 */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("me@jorgesaldivar.com").password("password").roles("USER");
    }
}