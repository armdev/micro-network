package io.project.application;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {    
    
    @RequestMapping("/healthcheck")
    String greeting();
}
