package io.project.resources;

import io.project.model.Flight;
import io.project.services.FlightService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
    private FlightService flightService;

    @GetMapping(path="/flight/{id}" , produces = "application/json;charset=UTF-8")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        log.debug("REST request to get Blog : {}", id);
        Flight flight = flightService.getById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(flight));
    }

    @GetMapping("/flights")
    public List<Flight> findAll() {
        log.debug("REST request to get all Blogs");
        List<Flight> flightList = flightService.listAll();
        return flightList;
    }
//https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
}
