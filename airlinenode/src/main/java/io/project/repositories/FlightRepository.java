package io.project.repositories;


import io.project.model.Flight;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Long> {
   
    
    //@Query("select c from Flight c where c.id < 100 ")
    List<Flight> findAll();
}
