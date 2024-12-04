package com.example.cullinaryplanner.controllers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cullinaryplanner.viewmodels.*;
import com.example.cullinaryplanner.model.Itinerary;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.User;
import com.example.cullinaryplanner.services.ItineraryService;
import com.example.cullinaryplanner.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

     @Autowired
     ItineraryService itineraryService;

     @Autowired
     UserService userService;




     @GetMapping("/user/{userId}")
    public List<Itinerary> getItinerariesByUser(@PathVariable Integer userId) {
        User user = new User(); // Replace with your user retrieval logic
        user.setUserId(userId);
        return itineraryService.getItinerariesByUser(user);


    }

    
    @GetMapping("/itinerary/{id}")
    public Itinerary getItinerariesByID(@PathVariable Integer id) {
        return itineraryService.getItineraryById(id);

    }

    
    @GetMapping("/all")
    public List<Itinerary> getAllItineraries() {
        return itineraryService.getItineraries();
    }

    // Update itinerary
    @PutMapping("/editItinerary/{id}")
    public ResponseEntity<Itinerary> updateItinerary(@PathVariable Integer id, @RequestBody Itinerary updatedItinerary) {
        Itinerary itinerary = itineraryService.updateItinerary(id, updatedItinerary);
        return ResponseEntity.ok(itinerary);
    }

    // Delete itinerary
    @DeleteMapping("/deleteItinerary/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Integer id) {
        itineraryService.deleteItinerary(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/createItinerary/{userId}")
    public ResponseEntity<Itinerary> createItinerary(@RequestBody ItineraryViewModel newItinerary, @PathVariable Integer userId) {

       // Integer userID = newItinerary.getUserId();
        User user = userService.findById(userId);

      
        System.out.println("Title " + newItinerary.getTitle());
        System.out.println("Description " + newItinerary.getDescription());
        System.out.println("Is Public " + newItinerary.getIsPublic());
    // Create the new itinerary
    Itinerary itinerary = new Itinerary();
    itinerary.setUser(user); // Set the user based on the received userId
    itinerary.setTitle(newItinerary.getTitle());
    itinerary.setDescription(newItinerary.getDescription());
    
    Boolean isPublic = newItinerary.getIsPublic();
    itinerary.setIsPublic(isPublic);
    itinerary.setCreatedAt(LocalDateTime.now());
    
    
    // Save the itinerary
    Itinerary savedItinerary = itineraryService.createItinerary(itinerary);
    
    return ResponseEntity.ok(savedItinerary);
    }
    
}
