package io.project.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TurbineNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineNodeApplication.class, args);
	}
}
