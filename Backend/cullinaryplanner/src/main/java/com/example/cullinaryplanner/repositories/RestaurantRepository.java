package com.example.cullinaryplanner.repositories;

import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.model.CuisineType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    // You can add custom query methods here if needed

    //List<Restaurant> findByCuisineType(CuisineType cuisineType);
    List<Restaurant> findByName(String name);
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByDescription(String description);

    @Query(value = "SELECT r.Name, r.Location, r.description, r.rating, c.cusine_type FROM Restaurants r INNER JOIN Cusine_Types c ON r.cuisine_type_id = c.cusine_type_id WHERE c.cusine_type_id = :cuisineTypeId", nativeQuery = true)
      List<Object[]> findCuisineTypeId(Integer cuisineTypeId);

}
