package io.project.core.application;

import org.springframework.web.bind.annotation.RequestMapping;

public interface HealthChecker {
    
    @RequestMapping("/healthcheck")
    String healthcheck();
}
