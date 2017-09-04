package io.project.core.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "io.project")
@EnableEurekaClient
@EnableFeignClients
@RestController
public class CoreNodeApplication {    

    public static void main(String[] args) {
        SpringApplication.run(CoreNodeApplication.class, args);
    }
    
    @Autowired
    private HealthChecker clientController;

    @RequestMapping("/get-healthcheck")
    public String getHealthcheck(Model model) {
        model.addAttribute("healthcheck", clientController.healthcheck());
        return "greeting-view";
    }
}
