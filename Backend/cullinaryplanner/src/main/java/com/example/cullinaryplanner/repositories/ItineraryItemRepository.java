package com.example.cullinaryplanner.repositories;
import com.example.cullinaryplanner.interfaces.ItineraryItemProjection;
import com.example.cullinaryplanner.interfaces.RestaurantProjection;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.ItineraryItem;
import com.example.cullinaryplanner.viewmodels.ItineraryItemViewModel;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface ItineraryItemRepository extends JpaRepository<ItineraryItem, Integer> {
    
    @Query(value = "SELECT it.*, i.itinerary_id AS i_itinerary_id FROM Itinerary_Items it INNER JOIN Itineraries i ON it.itinerary_id = i.itinerary_id WHERE it.itinerary_id = :itinerary_id", nativeQuery = true)
List<ItineraryItem> findByItineraryID(@Param("itinerary_id") Integer itinerary_id);


@Query(value = "SELECT it.date, e.notes, e.title, e.description, e.date_time, i.itinerary_id AS i_itinerary_id, it.itinerary_item_id, COALESCE(e.venue_name, r.name) as venueName, COALESCE(e.venue_address, r.location) as venueLocation FROM Itinerary_Items it INNER JOIN Itineraries i ON it.itinerary_id = i.itinerary_id INNER JOIN Experiences e on it.experience_id = e.experience_id LEFT JOIN Restaurants r on r.restaurant_id = e.restaurant_id WHERE it.itinerary_id = :itinerary_id ", nativeQuery = true)
List<ItineraryItemProjection> getItineraryItemDetails(@Param("itinerary_id") Integer itinerary_id);


@Query(value = "SELECT it.date, e.notes, e.title, e.description, e.date_time, i.itinerary_id AS i_itinerary_id, it.itinerary_item_id FROM Itinerary_Items it INNER JOIN Itineraries i ON it.itinerary_id = i.itinerary_id INNER JOIN Experiences e on it.experience_id = e.experience_id WHERE it.experience_id = :experience_id ", nativeQuery = true)
Optional<ItineraryItemProjection> getItineraryItemWithExperince(@Param("experience_id") Integer experience_id);


@Query(value = "SELECT i.itinerary_id AS i_itinerary_id, it.itinerary_item_id FROM Itinerary_Items it INNER JOIN Itineraries i ON it.itinerary_id = i.itinerary_id INNER JOIN Experiences e on it.experience_id = e.experience_id WHERE it.experience_id = :experience_id ", nativeQuery = true)
List<ItineraryItemProjection> getItineraryItemWithExperinceID(@Param("experience_id") Integer experience_id);







}
