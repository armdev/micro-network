package io.project.services;

import io.project.model.Flight;
import io.project.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Service
@Component
public class FlightServiceImpl implements FlightService {
 
    
    @Autowired
    private  FlightRepository flightRepository;


   
//    public FlightServiceImpl(FlightRepository flightRepository) {
//        this.flightRepository = flightRepository;
//    }

    @Override
    public List<Flight> findAll() {
        List<Flight> products = new ArrayList<>();
        // flightRepository.findAll().forEach(products::add); //fun with Java 8
        products = flightRepository.findAll();
        return products;
    }

    @Override
    public Flight getById(Long id) {
        return flightRepository.findOne(id);
    }

    @Override
    public Flight saveOrUpdate(Flight product) {
        flightRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        flightRepository.delete(id);

    }

}
