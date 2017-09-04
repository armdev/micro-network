package io.project.application;

import org.springframework.web.bind.annotation.RequestMapping;

public interface HealthCheckController {    
    
    @RequestMapping("/healthcheck")
    String healthcheck();
}
