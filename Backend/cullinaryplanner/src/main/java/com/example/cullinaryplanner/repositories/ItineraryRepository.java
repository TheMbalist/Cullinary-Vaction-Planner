package com.example.cullinaryplanner.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.ItineraryItem;
import com.example.cullinaryplanner.model.User;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

    List<Itinerary> findByUser(User user);
    List<Itinerary> findAll();
   
    
}
