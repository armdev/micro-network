package io.project.core.application;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {

    @RequestMapping("/api/logs/healthcheck")
    String greeting();
}
