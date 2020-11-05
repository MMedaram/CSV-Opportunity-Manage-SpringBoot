package com.dbadapters.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.dbadapters.core"})
public class ExampleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		
	}

}
