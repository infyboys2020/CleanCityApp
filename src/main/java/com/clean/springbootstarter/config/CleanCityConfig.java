package com.clean.springbootstarter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.clean.springbootstarter.services.CleanCityUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class CleanCityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CleanCityUserDetailsService  userDetailsService;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	    
	      .authorizeRequests()
	        .antMatchers("/user/**","/css/**","/js/**","/user/reportBoard").permitAll()
	        .antMatchers("/admin/**").hasAuthority("ADMIN")
	        .anyRequest().authenticated().and().formLogin().
	        defaultSuccessUrl("/admin/fetch", true)
	        .permitAll()
	        .and().logout()
	        .permitAll();
	   http.csrf().disable();
	  }
	
	
/*
 
 @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
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

 */
	
	

}
