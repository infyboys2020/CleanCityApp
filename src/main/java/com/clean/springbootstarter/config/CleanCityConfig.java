package com.clean.springbootstarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class CleanCityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	    
	      .authorizeRequests()
	        .antMatchers("/user/**").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated().and().formLogin().
	        defaultSuccessUrl("/admin/fetch", true)
	        .permitAll()
	        .and().logout()
	        .permitAll();
	   
	  }
	
	@Autowired
	  public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    .passwordEncoder(NoOpPasswordEncoder.getInstance())
	      .withUser("user").password("password").roles("USER")
	    .and()
	      .withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
	    .and()
	      .withUser("audit").password("audit").roles("USER", "ADMIN", "READER");
	  }


}
