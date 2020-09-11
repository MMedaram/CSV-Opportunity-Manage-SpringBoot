package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
public class ExampleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		
	}

}
