package io.project.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
//@EnableEurekaClient
//@EnableAutoConfiguration
public class ZipkinCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinCoreApplication.class, args);
	}
}
