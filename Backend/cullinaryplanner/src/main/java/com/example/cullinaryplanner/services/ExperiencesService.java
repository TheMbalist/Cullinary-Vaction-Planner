package com.example.cullinaryplanner.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cullinaryplanner.interfaces.ExperiencesProjection;
import com.example.cullinaryplanner.interfaces.ItineraryItemProjection;
import com.example.cullinaryplanner.model.Experience;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.ItineraryItem;
import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.model.User;
import com.example.cullinaryplanner.repositories.ExperiencesRepository;
import com.example.cullinaryplanner.viewmodels.ExperinceViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ExperiencesService {
    
    private final ExperiencesRepository experiencesRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final ItineraryItemService itineraryItemService;

    @Autowired
    public ExperiencesService(ExperiencesRepository experiencesRepository, 
                               @Lazy  UserService userService,
                               @Lazy   RestaurantService restaurantService,
                               @Lazy ItineraryItemService itineraryItemService) {
        this.experiencesRepository = experiencesRepository;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.itineraryItemService = itineraryItemService;
    }



    public List<ExperiencesProjection> getExperineces(){

        return experiencesRepository.findExperienceWithVenueOrRestaurant();
    }

    public List<ExperiencesProjection[]> getExperinece(Integer experinceid){

        return experiencesRepository.findExperienceWithVenueOrRestaurantByID(experinceid);
    }

    public Experience getExperienceById(Integer id) {
        return experiencesRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));
    }



    @Transactional
     public Experience createExperience(ExperinceViewModel experienceDto) {
         User user = userService.findById(experienceDto.getUserID());

        
        Experience experience = new Experience();
        // Set properties from DTO
        experience.setTitle(experienceDto.getTitle());
        experience.setDescription(experienceDto.getDescription());
        experience.setDateTime(experienceDto.getDateTime());
        experience.setPrice(experienceDto.getPrice());
        if(experienceDto.getNotes() != null){
            experience.setNotes(experienceDto.getNotes());
         }
        if(experienceDto.getRestaurantId() != null){
            Restaurant restaurant = restaurantService.findByID(experienceDto.getRestaurantId());
            experience.setRestaurant(restaurant);
            experience.setVenue_name(restaurant.getName());
            experience.setVenue_address(restaurant.getLocation());
         }else{
            experience.setVenue_name(experienceDto.getVenueName());
            experience.setVenue_address(experienceDto.getVenueLocation());
         }

        //  if(experienceDto.getVenueLocation() != null && experienceDto.getVenueName() != null){
           
        //  }
        experience.setCreatedAt(LocalDateTime.now());
        experience.setCreated_by(user);
       
        // Save to DB
        return experiencesRepository.save(experience);
    }



    @Transactional
    public Experience updateExperience(Integer id, ExperinceViewModel experienceDto) {
        Experience existingExperience = experiencesRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));
        User user = userService.findById(3);

        existingExperience.setTitle(experienceDto.getTitle());
        existingExperience.setDescription(experienceDto.getDescription());
        existingExperience.setDateTime(experienceDto.getDateTime());
        existingExperience.setPrice(experienceDto.getPrice());
        if(experienceDto.getRestaurantId() != null && experienceDto.getRestaurantId() != existingExperience.getRestaurant().getRestaurantId()){
            Restaurant restaurant = restaurantService.findByID(experienceDto.getRestaurantId());
            existingExperience.setRestaurant(restaurant);
            existingExperience.setVenue_name(restaurant.getName());
            existingExperience.setVenue_address(restaurant.getLocation());
            
         }

         if(experienceDto.getNotes() != null){
            existingExperience.setNotes(experienceDto.getNotes());
         }

         if(experienceDto.getVenueLocation() != null && experienceDto.getVenueName() != null){
            existingExperience.setVenue_name(experienceDto.getVenueName());
            existingExperience.setVenue_address(experienceDto.getVenueLocation());
         }
         existingExperience.setUpdatedAt(LocalDateTime.now());
         existingExperience.setUpdated_by(user);
        // Save to DB
        return experiencesRepository.save(existingExperience);
    }

    @Transactional
    public void deleteExperience(Integer id) {
        Experience experience = experiencesRepository.findById(id).orElseThrow(() -> new RuntimeException("Experience not found"));

         // Retrieve all itinerary items associated with the experience
    List<ItineraryItemProjection> itineraryItems = itineraryItemService.getItemWithExperinceID(experience.getExperienceId());

    // Loop through itinerary items and delete them
    for (ItineraryItemProjection item : itineraryItems) {
        // Directly delete the itinerary item
        itineraryItemService.DeleteItineraryItem(item.getItinerary_item_id());
    }
        experiencesRepository.delete(experience);
    }


}
