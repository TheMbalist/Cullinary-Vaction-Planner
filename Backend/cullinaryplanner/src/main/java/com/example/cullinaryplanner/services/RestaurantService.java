package com.example.cullinaryplanner.services;

import com.example.cullinaryplanner.interfaces.RestaurantProjection;
import com.example.cullinaryplanner.model.*;
import com.example.cullinaryplanner.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    //Get
    public List<RestaurantProjection> getAll() {
        return restaurantRepository.findAllRestaurants();
    }

    public Restaurant findByID(Integer id) {
        return restaurantRepository.findByRestaurantId(id);
    }

    public List<Restaurant> getByName(String ResturantName){
        return restaurantRepository.findByName(ResturantName);
    }

    public List<Object[]> getByCuisineType(Integer cuisineTypeID){
        return restaurantRepository.findCuisineTypeId(cuisineTypeID);
    }

    public List<Restaurant> findRestaurants(String name, String location, String cuisineType, Double rating) {
        return restaurantRepository.findRestaurants(name, location, cuisineType, rating);
    }

    public List<String> findDistinctLocations(){
        return restaurantRepository.findDistinctLocations();
    }

    public List<String> findDistinctCuisines(){
        return restaurantRepository.findDistinctCuisines();
    }
    
}
