package io.project.resources;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import io.project.model.Flight;
import io.project.repositories.FlightRepository;
import io.project.services.FlightService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightController {

    private static final Logger log = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping(path = "/flight/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        log.debug("REST request to get Blog : {}", id);
        Flight flight = flightService.getById(id);

        printAvailableServices();
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(flight));
    }

    @GetMapping(path = "/flights", produces = "application/json;charset=UTF-8")
    public List<Flight> findAll() {
        log.debug("REST request to get all Blogs");

        PageRequest pageable = new PageRequest(0, 10);
        List<Flight> flightList = new ArrayList<>();

        Page<Flight> page = flightRepository.findAll(new PageRequest(1, 100));
        flightList.addAll(page.getContent());
        printAvailableServices();
        return flightList;
    }
//https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc

    public void printAvailableServices() {
        try {
            //PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = eurekaClient.getApplications();

            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {

                    log.info("*******************start************************");
                    log.info("App Name " + instance.getAppName());
                    log.info("Instance Id " + instance.getInstanceId());
                    log.info("HealthCheckUrl  " + instance.getHealthCheckUrl());
                    log.info("getHomePageUrl  " + instance.getHomePageUrl());
                    log.info("getSecureVipAddress  " + instance.getSecureVipAddress());
                    log.info("getASGName  " + instance.getASGName());
                    log.info("getStatusPageUrl  " + instance.getStatusPageUrl());
                    log.info("getActionType  " + instance.getActionType().toString());
                    log.info("getLastDirtyTimestamp  " + instance.getLastDirtyTimestamp());
                    log.info("getVIPAddress  " + instance.getVIPAddress());
                    log.info("getPort  " + instance.getPort());
                    log.info("getLeaseInfo  " + instance.getLeaseInfo().toString());
                    log.info("*******************stop************************");

                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
