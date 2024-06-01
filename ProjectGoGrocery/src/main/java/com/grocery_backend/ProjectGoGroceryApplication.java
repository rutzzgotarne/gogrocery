package com.grocery_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.grocery_backend","com.controller","com.dao","com.exception","com.model","com.service"})
@EntityScan("com.model")
@EnableJpaRepositories(basePackages="com.dao")
public class ProjectGoGroceryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGoGroceryApplication.class, args);
		
		System.out.println("Hello Customer your app Started...");
	}

}
