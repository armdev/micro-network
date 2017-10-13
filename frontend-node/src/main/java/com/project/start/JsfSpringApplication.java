package com.project.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
@EnableAutoConfiguration
public class JsfSpringApplication {
        
	public static void main(String[] args) {
		SpringApplication.run(JsfSpringApplication.class, args);
	}
    
}
