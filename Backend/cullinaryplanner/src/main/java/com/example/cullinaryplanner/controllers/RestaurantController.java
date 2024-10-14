package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.services.RestaurantService;

@RestController
 @RequestMapping("/api/restaurants")
 @CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    //Get Requests for clients i.e non-restaurnats owners/itenenerary makers lol
    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getAll();
    }


    //http://localhost:8080/getByName?restaurantName=The Culinary Spot

    @GetMapping("/getByName")
    public List<Restaurant> getRestaurantByName(@RequestParam String restaurantName) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByName(restaurantName);
    }


    //http://localhost:8080/getByCuisine?cuisineTypeID=1

    @GetMapping("/getByCuisine")
    public List<Object[]> getRestaurantByName(@RequestParam Integer cuisineTypeID) {
       // System.out.println("Fetching all restaurants");
        return this.restaurantService.getByCuisineType(cuisineTypeID);
    }




   

 
}
