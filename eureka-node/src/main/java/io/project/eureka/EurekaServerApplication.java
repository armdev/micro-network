package io.project.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
//http://192.168.99.100:8761/

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
