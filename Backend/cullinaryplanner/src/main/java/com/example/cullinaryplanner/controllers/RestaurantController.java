package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cullinaryplanner.interfaces.RestaurantProjection;
import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.services.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    //Get Requests for clients i.e non-restaurnats owners/itenenerary makers lol
    //http://localhost:8080/api/restaurants/all
    @GetMapping("/all")
    public List<RestaurantProjection> getAllRestaurants() {
       // System.out.println("Fetching all restaurants");
       List<RestaurantProjection> restaurants = restaurantService.getAll();
        return restaurants;
    }


    //http://localhost:8080/api/restaurants/getByName?restaurantName=The Culinary Spot

    @GetMapping("/getByName")
    public List<Restaurant> getRestaurantByName(@RequestParam String restaurantName) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByName(restaurantName);
    }


    //http://localhost:8080/api/restaurants/getByCuisine?cuisineTypeID=1

    @GetMapping("/getByCuisine")
    public List<Object[]> getRestaurantByName(@RequestParam Integer cuisineTypeID) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByCuisineType(cuisineTypeID);
    }

    @GetMapping("/filteredRestaurants")
    public List<Restaurant> getFilteredRestaurants(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String location,
    @RequestParam(required = false) String cuisineType,
    @RequestParam(required = false) Double rating) {

    return restaurantService.findRestaurants(name, location, cuisineType, rating);
    }


    @GetMapping("/locations")
    public List<String> getAllLocations() {
        return restaurantService.findDistinctLocations();
    }


    @GetMapping("/cuisines")
    public List<String> getAllCuisines() {
        return restaurantService.findDistinctCuisines();
    }



   

 
}
