package io.project.services;

import io.project.model.Flight;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface FlightService {

    List<Flight> findAll();

    Flight getById(Long id);

    Flight saveOrUpdate(Flight flight);

    void delete(Long id);

}
