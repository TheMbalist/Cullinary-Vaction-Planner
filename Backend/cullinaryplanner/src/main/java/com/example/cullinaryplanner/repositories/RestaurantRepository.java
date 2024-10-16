package com.example.cullinaryplanner.repositories;

import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.interfaces.RestaurantProjection;
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

      @Query(value = "SELECT r.Name as name, r.Location as location, r.Description as description, r.Rating as rating, c.cusine_type as cuisineType FROM Restaurants r INNER JOIN Cusine_Types c ON r.cuisine_type_id = c.cusine_type_id", nativeQuery = true)
      List<RestaurantProjection> findAllRestaurants();

      @Query(value = "SELECT r.* FROM Restaurants r "
        + "JOIN Cusine_Types c ON r.cuisine_type_id = c.cusine_type_id "
        + "WHERE (COALESCE(:name, NULL) IS NULL OR r.name LIKE %:name%) "
        + "AND (COALESCE(:location, NULL) IS NULL OR r.location LIKE %:location%) "
        + "AND (COALESCE(:rating, NULL) IS NULL OR r.rating >= :rating) "
        + "AND (COALESCE(:cuisineType, NULL) IS NULL OR c.cuisine_type LIKE %:cuisineType%)", 
        nativeQuery = true)
        List<Restaurant> findRestaurants(
            @Param("name") String name,
            @Param("location") String location,
            @Param("cuisineType") String cuisineType,
            @Param("rating") Double rating
        );

      

        @Query(value = "SELECT DISTINCT r.location FROM Restaurants r", nativeQuery = true)
        List<String> findDistinctLocations();

        @Query( value = "SELECT DISTINCT c.cusine_type as cuisineType FROM Restaurants r INNER JOIN Cusine_Types c ON r.cuisine_type_id = c.cusine_type_id", nativeQuery = true)
         List<String> findDistinctCuisines();



}
