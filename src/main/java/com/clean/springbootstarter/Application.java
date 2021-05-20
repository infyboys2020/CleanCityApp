package com.clean.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.clean.springbootstarter","com.disaster.springbootstarter"})
public class Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
