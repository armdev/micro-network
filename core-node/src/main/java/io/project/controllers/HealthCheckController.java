package io.project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public interface HealthCheckController {
    
    @RequestMapping("/healthcheck")
    String healthcheck();
}
