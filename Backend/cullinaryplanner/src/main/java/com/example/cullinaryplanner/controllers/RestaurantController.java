package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.services.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    //Get Requests for clients i.e non-restaurnats owners/itenenerary makers lol
    @GetMapping("/all")
    public List<Object[]> getAllRestaurants() {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getAll();
    }


    //http://localhost:8080/api/restaurants/byName?restaurantName=The Culinary Spot

    @GetMapping("/byName")
    public List<Restaurant> getRestaurantByName(@RequestParam String restaurantName) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByName(restaurantName);
    }


    //http://localhost:8080/api/restaurants/byCuisine?cuisineTypeID=1

    @GetMapping("/byCuisine")
    public List<Object[]> getRestaurantByCuisine(@RequestParam Integer cuisineTypeID) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByCuisineType(cuisineTypeID);
    }


     //http://localhost:8080/api/restaurants/byLocation?locationName=New York

     @GetMapping("/byLocation")
     public List<Object[]> getRestaurantByLocation(@RequestParam String locationName) {
        // System.out.println("Fetching all restaurants");
         return this.restaurantService.getByLocation(locationName);
     }

        //http://localhost:8080/api/restaurants/byRating?searchRating=4.7

     @GetMapping("/byRating")
     public List<Object[]> getRestaurantsByRating(@RequestParam float searchRating) {
         return restaurantService.getByRating(searchRating);
        }



   

 
}
