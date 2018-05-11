package com.sura.cgapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sura.cgapp.auth.handler.LoginSuccesHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**").permitAll()
		.antMatchers("/categorias/**").hasAnyRole("ADMIN")
		.antMatchers("/subcategories/**").hasAnyRole("ADMIN")
		.antMatchers("/egreso/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.formLogin().successHandler(successHandler)
		.loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN","USER");
		build.inMemoryAuthentication().withUser("andres").password("123").roles("USER");
	}
}