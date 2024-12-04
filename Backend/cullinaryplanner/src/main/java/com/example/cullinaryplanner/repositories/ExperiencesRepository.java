package com.example.cullinaryplanner.repositories;

import org.springframework.stereotype.Repository;

import com.example.cullinaryplanner.interfaces.ExperiencesProjection;
import com.example.cullinaryplanner.model.Experience;
import com.example.cullinaryplanner.viewmodels.ExperinceViewModel;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ExperiencesRepository extends JpaRepository<Experience, Integer> {

        @Query(value = "SELECT " +
        "e.title as title, e.description as description, e.date_time as dateTime, e.price, e.notes, " +
        "ct.cusine_type as cuisineType, e.experience_id as experienceID, r.restaurant_id as restaurantID, " +
        "COALESCE(e.venue_name, r.name) as venueName, " +
        "COALESCE(e.venue_address, r.location) as venueLocation " +
        "FROM Experiences e " +
        "LEFT JOIN Restaurants r ON e.restaurant_id = r.restaurant_id " +
        "LEFT JOIN Cusine_Types ct ON ct.cusine_type_id = r.cuisine_type_id" +
        " WHERE e.date_time >= CURRENT_TIMESTAMP",
        nativeQuery = true)
 List<ExperiencesProjection> findExperienceWithVenueOrRestaurant();
 

                @Query(value = "SELECT " +
                "e.title as title, e.description as description, e.date_time as dateTime, e.price, e.notes, " +
                "ct.cusine_type as cuisineType, e.experience_id as experienceID," +
                "COALESCE(e.venue_name, r.name) as venueName, " +
                "COALESCE(e.venue_address, r.location) as venueLocation " +
                "FROM Experiences e " +
                "LEFT JOIN Restaurants r ON e.restaurant_id = r.restaurant_id " +
                "LEFT JOIN Cusine_Types ct ON ct.cusine_type_id = r.cuisine_type_id" +
                "WHERE it.experince_id = :experience_id",
                nativeQuery = true)
List<ExperiencesProjection[]> findExperienceWithVenueOrRestaurantByID(@Param("experience_id") Integer experience_id);

    
}
