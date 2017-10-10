package io.project.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class TurbineNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineNodeApplication.class, args);
	}
}
