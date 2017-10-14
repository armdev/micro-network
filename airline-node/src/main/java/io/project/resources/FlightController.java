package io.project.resources;


import io.project.model.Flight;
import io.project.services.FlightService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/v1")
public class FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    @RequestMapping(method = GET)
    public List<Flight> list() {
        LOGGER.info("Fetching all list");
        return flightService.listAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Flight get(@PathVariable Long id) {
        LOGGER.info("Find by id ");
        return flightService.getById(id);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Flight> put(@PathVariable Long id, @RequestBody Flight flight) {
        LOGGER.info("Update by id ");
        flight.setId(id);
       
        return ResponseEntity.accepted().body(flightService.saveOrUpdate(flight));
    }

    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<Flight> post(@RequestBody Flight flight) {
        LOGGER.info("Save new object");      
        return ResponseEntity.accepted().body(flightService.saveOrUpdate(flight));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        LOGGER.info("Delete object");
        return null;
    }

}
