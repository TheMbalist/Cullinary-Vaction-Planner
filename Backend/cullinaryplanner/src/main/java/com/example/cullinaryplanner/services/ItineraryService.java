package com.example.cullinaryplanner.services;
import com.example.cullinaryplanner.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import com.example.cullinaryplanner.repositories.ItineraryRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final ItineraryItemService itineraryItemService;

     @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository, 
                            @Lazy  ItineraryItemService itineraryItemService) {
        this.itineraryRepository = itineraryRepository;
        this.itineraryItemService = itineraryItemService;
    }


    public Itinerary getItineraryById(Integer id) {
        return itineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
    }

    @Transactional
    public Itinerary updateItinerary(Integer id, Itinerary updatedItinerary) {
        Optional<Itinerary> itineraryOpt = itineraryRepository.findById(id);

        if (itineraryOpt.isPresent()) {
            Itinerary itinerary = itineraryOpt.get();

        
        itinerary.setTitle(updatedItinerary.getTitle());
        itinerary.setDescription(updatedItinerary.getDescription());
        itinerary.setIsPublic(updatedItinerary.getIsPublic());
        itinerary.setUpdatedAt(LocalDateTime.now());
        return itineraryRepository.save(itinerary);
        }

        return null;
    }

    @Transactional
    public void deleteItinerary(Integer id) {
        Optional<Itinerary> itineraryOpt = itineraryRepository.findById(id);
        List<ItineraryItem> itineraryItems = itineraryItemService.getItemByItineraryID(id);
    
        if (itineraryOpt.isPresent()) {
            Itinerary itinerary = itineraryOpt.get();
    
            // Delete all itinerary items associated with this itinerary
            if (!itineraryItems.isEmpty()) {
                for (ItineraryItem item : itineraryItems) {
                    itineraryItemService.DeleteItineraryItem(item.getItineraryItemId());
                }
            }
    
            // After deleting all items, delete the itinerary
            itineraryRepository.delete(itinerary);
        }
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
