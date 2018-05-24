package com.sura.cgapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sura.cgapp.auth.handler.LoginSuccesHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/api/rest/**").permitAll()
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
		PasswordEncoder encoder =
			     PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN","USER").build();
		
		build.inMemoryAuthentication().withUser(user);
		
		user = User.withUsername("jero")
                .password(encoder.encode("123"))
                .roles("USER").build();
		
		build.inMemoryAuthentication().withUser(user);
	}
}