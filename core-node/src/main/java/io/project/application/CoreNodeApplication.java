package io.project.application;

import io.project.controllers.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Controller
public class CoreNodeApplication {
    
    @Autowired
    private ClientController greetingClient;

    public static void main(String[] args) {
        SpringApplication.run(CoreNodeApplication.class, args);
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        model.addAttribute("healthcheck", greetingClient.healthcheck());
        return "greeting-view";
    }
}
