package io.project.core.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.project.core.application.LogService;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CoreResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreResource.class);

    @Autowired
    private LogService logService;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String home() {
        LOGGER.info("Request to / endpoint");
        return "Hello World time is:  " + logService.getTimeAsString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/time")
    public String getLocalTime() throws URISyntaxException {
        LOGGER.info("Request to /time endpoint");
        logService.log("Will call local service");
        return "The localtime is: " + logService.getTimeAsString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public String healthcheck() {
        LOGGER.info("Request to /healthcheck endpoint");
        return "I am ok and time is  " + logService.getTimeAsString();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @RequestMapping(method = RequestMethod.GET, value = "/heavyrequest")
    public String justDoIt() {
        LOGGER.info("IllegalArgumentException  ");
        throw new IllegalArgumentException();
    }

    public String reliable() {
        LOGGER.info("Request again failed ");
        return "Fail time is: " + logService.getTimeAsString();
    }

}
