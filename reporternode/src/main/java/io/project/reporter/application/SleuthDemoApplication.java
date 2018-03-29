package io.project.reporter.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SleuthDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SleuthDemoApplication.class);

    @Autowired
    private Tracer tracer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DateService dateService;

    @Autowired
    private LogService logService;

    @Value("${server.port}")
    private int appPort;

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Request to / endpoint");
        return "Hello World";
    }
  
    @RequestMapping("/getLocalTime")
    public String getLocalTime() throws URISyntaxException {
        LOGGER.info("Request to /getLocalTime endpoint");
        logService.log("Will call local service");
        ResponseEntity<String> forEntity = restTemplate.getForEntity(new URI("http://localhost:" + appPort + "/getTime"), String.class);
        LOGGER.info("Got response code: {}", forEntity.getStatusCode().toString());
        return "The localtime is: " + forEntity.getBody();
    }

    @RequestMapping("/getTime")
    public String getTime() {
        LOGGER.info("Request to /getTime endpoint");
        return dateService.getTimeAsString();
    }

}
