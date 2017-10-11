package io.project.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
//@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class HystrixNodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixNodeApplication.class, args);
	}
}
