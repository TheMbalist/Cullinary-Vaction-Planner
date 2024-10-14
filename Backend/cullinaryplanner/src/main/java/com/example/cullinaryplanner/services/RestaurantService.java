package com.example.cullinaryplanner.services;

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
    public List<Object[]> getAll() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getByName(String ResturantName){
        return restaurantRepository.findByName(ResturantName);
    }

    public List<Object[]> getByCuisineType(Integer cuisineTypeID){
        return restaurantRepository.findCuisineTypeId(cuisineTypeID);
    }

    public List<Object[]> getByLocation(String locationName){
        return restaurantRepository.findByLocation(locationName);
    }


    public List<Object[]> getByRating(float searchRating) {
        return restaurantRepository.findByRating(searchRating);
    }
    


    
}
