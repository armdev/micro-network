package io.project.services;

import io.project.model.Flight;
import java.util.List;

public interface FlightService {

    List<Flight> findAll();

    Flight getById(Long id);

    Flight saveOrUpdate(Flight flight);

    void delete(Long id);

}
