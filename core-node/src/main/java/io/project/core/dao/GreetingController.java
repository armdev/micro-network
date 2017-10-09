package io.project.core.dao;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {

   // @RequestMapping("/api/logs/healthcheck")
    String greeting();
}
