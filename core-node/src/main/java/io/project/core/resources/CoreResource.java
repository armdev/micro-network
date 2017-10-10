package io.project.core.resources;

import io.project.core.application.LogService;
import java.net.URISyntaxException;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class CoreResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CoreResource.class);
    
    @Autowired
    private Tracer tracer;
    
    @Autowired
    private LogService logService;

    @RequestMapping("/")
    public String home() {
        LOGGER.info("Request to / endpoint");
        return "Hello World";
    }
    
    @RequestMapping("/time")
    public String getLocalTime() throws URISyntaxException {
        LOGGER.info("Request to /time endpoint");
        logService.log("Will call local service");                        
        return "The localtime is: " + System.currentTimeMillis();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public String healthcheck() {
        LOGGER.info("Request to /healthcheck endpoint");
        return "I am ok";
    }

}
