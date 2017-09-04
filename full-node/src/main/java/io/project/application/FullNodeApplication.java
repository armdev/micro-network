package io.project.application;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class FullNodeApplication implements GreetingController {
    
    
    public static void main(String[] args) {
        SpringApplication.run(FullNodeApplication.class, args);
    }

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;


    @Override
    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName() + " I am OK!!!!");
    }
}
