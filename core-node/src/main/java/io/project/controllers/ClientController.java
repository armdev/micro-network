package io.project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public interface ClientController {

    @RequestMapping("/healthcheck")
    String healthcheck();
}
