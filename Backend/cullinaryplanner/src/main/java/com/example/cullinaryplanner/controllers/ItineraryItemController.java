package com.example.cullinaryplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cullinaryplanner.viewmodels.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import com.example.cullinaryplanner.interfaces.ItineraryItemProjection;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.ItineraryItem;
import com.example.cullinaryplanner.services.ItineraryItemService;
@RestController
@RequestMapping("/api/itineraryItems")
public class ItineraryItemController {
    
    @Autowired
    ItineraryItemService itineraryItemService;



    //  @GetMapping("/all/{id}")
    // public List<ItineraryItem> getAllItineraries(@PathVariable Integer id) {
    //     return itineraryItemService.getItemByItineraryID(id);
    // }


    @GetMapping("/items/{id}")
    public List<ItineraryItemProjection> getItemDetails(@PathVariable Integer id) {
        return itineraryItemService.getItemDetails(id);
    }

        @DeleteMapping("/deleteItineraryItem/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Integer id) {
        itineraryItemService.DeleteItineraryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addToItinerary")
    public ResponseEntity<Void> addItemToItinerary(@RequestBody ItineraryItemViewModel itineraryItem) {
        itineraryItemService.addExperienceToItinerary(itineraryItem);
        return ResponseEntity.ok().build();
    }


}
