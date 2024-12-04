package com.example.cullinaryplanner.services;
import com.example.cullinaryplanner.interfaces.ItineraryItemProjection;
import com.example.cullinaryplanner.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import com.example.cullinaryplanner.repositories.ItineraryItemRepository;
import com.example.cullinaryplanner.viewmodels.ItineraryItemViewModel;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryItemService {

    private final ItineraryItemRepository itineraryItemRepository;
    private final ItineraryService itineraryService;
    private final ExperiencesService experiencesService;
    private final RestaurantService restaurantService;

    @Autowired
    public ItineraryItemService(ItineraryItemRepository itineraryItemRepository, 
                               @Lazy  ItineraryService itineraryService,
                               @Lazy  ExperiencesService experiencesService,
                               @Lazy   RestaurantService restaurantService) {
        this.itineraryItemRepository = itineraryItemRepository;
        this.itineraryService = itineraryService;
        this.experiencesService = experiencesService;
        this.restaurantService = restaurantService;
    }

    public List<ItineraryItem> getItemByItineraryID(Integer itinerary_id){

        return itineraryItemRepository.findByItineraryID(itinerary_id);
    }

    public List<ItineraryItemProjection> getItemDetails(Integer itinerary_id){

        return itineraryItemRepository.getItineraryItemDetails(itinerary_id);
    }

    
    public Optional<ItineraryItemProjection> getItemWithExperince(Integer exprienceId){

        return itineraryItemRepository.getItineraryItemWithExperince(exprienceId);
    }

    public List<ItineraryItemProjection> getItemWithExperinceID(Integer exprienceId){

        return itineraryItemRepository.getItineraryItemWithExperinceID(exprienceId);
    }


public void addExperienceToItinerary(ItineraryItemViewModel itineraryItem) {
    Itinerary itinerary = itineraryService.getItineraryById(itineraryItem.getItinerary_id());
    Experience experience = experiencesService.getExperienceById(itineraryItem.getExperience_id());
   // Restaurant restaurant = restaurantService.findByID(itineraryItem.getResturant_id());

    ItineraryItem item = new ItineraryItem();
    item.setDate(itineraryItem.getDate_Time());
    item.setExperience(experience);
    item.setItinerary(itinerary);
   // item.setRestaurant(restaurant);
    
    itineraryItemRepository.save(item);
}



    @Transactional
    public void DeleteItineraryItem(Integer id){
        Optional<ItineraryItem> itineraryItemOpt = itineraryItemRepository.findById(id);

        
        if (itineraryItemOpt.isPresent()) {
            ItineraryItem itineraryItem = itineraryItemOpt.get();

            itineraryItemRepository.delete(itineraryItem);
        }

    }






    
   

}
