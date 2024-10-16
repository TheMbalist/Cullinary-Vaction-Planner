package com.example.cullinaryplanner.services;
import com.example.cullinaryplanner.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.cullinaryplanner.repositories.ItineraryRepository;
import java.util.List;


@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private UserService userService;


    public Itinerary getItineraryById(Integer id) {
        return itineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
    }

    @Transactional
    public Itinerary updateItinerary(Integer id, Itinerary updatedItinerary) {
        Itinerary itinerary = getItineraryById(id);
        
        itinerary.setTitle(updatedItinerary.getTitle());
        itinerary.setDescription(updatedItinerary.getDescription());
        itinerary.setIsPublic(updatedItinerary.getIsPublic());
        // itinerary.setUpdatedAt();
        // itinerary.setUpdated_by(updatedItinerary.getUpdated_by());
        return itineraryRepository.save(itinerary);
    }

    @Transactional
    public void deleteItinerary(Integer id) {
        Itinerary itinerary = getItineraryById(id);
        itineraryRepository.delete(itinerary);
    }

    public List<Itinerary> getItinerariesByUser(User user) {
        return itineraryRepository.findByUser(user);
    }

    public List<Itinerary> getItineraries() {
        return itineraryRepository.findAll();
    }


    @Transactional
    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }
}
