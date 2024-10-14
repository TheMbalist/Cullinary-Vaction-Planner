package com.example.cullinaryplanner.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.example.cullinaryplanner.model.Itinerary;

@Repository
public interface IteneraryRepository extends JpaRepository<Itinerary, Integer> {
    

     @Query(value = "SELECT i.title AS itineraryTitle, " +
                   "i.description AS itineraryDescription, " +
                   "e.title AS experienceName, " +
                   "e.description AS experienceDescription, " +
                   "e.date_time AS experienceDateTime, " +
                   "it.notes AS notes " +
                   "FROM Itineraries i " +
                   "INNER JOIN Itinerary_Items it ON i.itinerary_id = it.itinerary_id " +
                   "INNER JOIN Experiences e ON it.experience_id = e.experience_id " +
                   "WHERE i.user_id = :userId AND i.itinerary_id = :itineraryId", 
           nativeQuery = true)
    List<Object[]> findExperiencesByUserId(@Param("userId") Integer userId, @Param("itineraryId") Integer itineraryId);
}
