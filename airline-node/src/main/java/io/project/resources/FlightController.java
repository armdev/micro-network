package io.project.resources;

import io.project.model.Flight;
import io.project.repositories.FlightRepository;
import io.project.services.FlightService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private FlightService flightService;
    
     @Autowired
    private FlightRepository flightRepository;

    @GetMapping(path="/flight/{id}" , produces = "application/json;charset=UTF-8")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        log.debug("REST request to get Blog : {}", id);
        Flight flight = flightService.getById(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(flight));
    }

    @GetMapping("/flights")
    public Page<Flight> findAll() {
        log.debug("REST request to get all Blogs");
        PageRequest pageable =  new PageRequest(0,10);
        //List<Flight> flightList = flightService.findAll();
        
        Page<Flight> page = flightRepository.findAll(new PageRequest(1, 100));
        return page;
    }
//https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
}
