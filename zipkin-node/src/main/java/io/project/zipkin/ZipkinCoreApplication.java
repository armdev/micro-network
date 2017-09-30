package io.project.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinStreamServer
@EnableZipkinServer
@EnableEurekaClient
public class ZipkinCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinCoreApplication.class, args);
	}
}
