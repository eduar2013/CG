package com.sura.cgapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER");
		build.inMemoryAuthentication().withUser("andres").password("123").roles("USER");
	}

}
