package com.example.cullinaryplanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.cullinaryplanner.model.Itinerary;
import com.example.cullinaryplanner.model.User;
import com.example.cullinaryplanner.repositories.ItineraryRepository;
import com.example.cullinaryplanner.services.ItineraryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class ItineraryServiceTests {

    @Mock
    private ItineraryRepository itineraryRepository;

    @InjectMocks
    private ItineraryService itineraryService;

    private Itinerary itinerary;
    private User user;

    //using Mock ensure we do not interact with teh actual db and only test that the data is in the correct format
    @BeforeEach
    public void setup() {
         // Setup a mock user
         user = new User();
         user.setUserId(1);
         
         //user.s("John Doe");
 
         // Setup a mock itinerary
         itinerary = new Itinerary();
        // itinerary.setItineraryId(1);
         itinerary.setUser(user);
         itinerary.setDescription("Trip to Paris");
    }


    @Test
    public void testCreateItinerary() {

        // Arrange
        Itinerary itinerary = new Itinerary();
        
        itinerary.setItineraryId(1);
        itinerary.setTitle("My Culinary Adventure");
        itinerary.setDescription("Exploring culinary experiences across cities!");
        itinerary.setIsPublic(false);
        itinerary.setUser(user);

        // Mock repository behavior
        when(itineraryRepository.save(any(Itinerary.class))).thenReturn(itinerary);

        // Act
        Itinerary savedItinerary = itineraryService.createItinerary(itinerary);

        // Assert
        //asserts conditions in testing; can help compare actual and expected results
        assertNotNull(savedItinerary.getItineraryId(), "Itinerary should have a generated ID");
        assertEquals("My Culinary Adventure", savedItinerary.getTitle(), "The title should match the input");
        assertEquals("Exploring culinary experiences across cities!", savedItinerary.getDescription(), "The description should match the input");
        assertFalse(savedItinerary.getIsPublic(), "The itinerary should not be public");
        assertEquals(user, savedItinerary.getUser(), "The itinerary should be associated with the correct user");

        // Verify that the save method was called once on the repository
        verify(itineraryRepository, times(1)).save(itinerary);

    }

    @Test
    public void testUpdateItinerary() {
        // Arrange (Mock the data)
        Itinerary existingItinerary = new Itinerary();
        existingItinerary.setItineraryId(1);
        existingItinerary.setTitle("Old Title");
        existingItinerary.setDescription("Old Description");
        existingItinerary.setIsPublic(false);

        Itinerary updatedItinerary = new Itinerary();
        updatedItinerary.setItineraryId(1); // Ensure matching ID
        updatedItinerary.setTitle("New Title");
        updatedItinerary.setDescription("Updated Trip to Rome");
        updatedItinerary.setIsPublic(false);

        // Mock the repository behavior
        when(itineraryRepository.findById(1)).thenReturn(Optional.of(existingItinerary));
        when(itineraryRepository.save(any(Itinerary.class))).thenReturn(updatedItinerary);

        // Act
        Itinerary result = itineraryService.updateItinerary(1, updatedItinerary);

        // Assert
        assertNotNull(result, "The updated itinerary should not be null");
        assertEquals("Updated Trip to Rome", result.getDescription(), "The description should be updated");
        assertEquals("New Title", result.getTitle(), "The title should be updated");
        verify(itineraryRepository, times(1)).save(argThat(itinerary ->
            itinerary.getDescription().equals("Updated Trip to Rome") &&
            itinerary.getTitle().equals("New Title") &&
            itinerary.getIsPublic() == false
        ));
    }



        // @Test
        // public void deleteItinerary() {
        //     // Arrange
        //     doNothing().when(itineraryRepository).deleteById(1);  // Adjust to use Integer if needed

        //     // Act
        //     itineraryService.deleteItinerary(1);  // Call the method to delete an itinerary

        //     // Assert
        //     verify(itineraryRepository, times(1)).deleteById(1);  // Verify the delete method was called once
        // }

        @Test
        public void getItinerariesByUser() {
            // Arrange
            when(itineraryRepository.findByUser(user)).thenReturn(List.of(itinerary));
    
            // Act
            List<Itinerary> itineraries = itineraryService.getItinerariesByUser(user);
    
            // Assert
            assertNotNull(itineraries);
            assertEquals(1, itineraries.size());
            assertEquals("Trip to Paris", itineraries.get(0).getDescription());
            verify(itineraryRepository, times(1)).findByUser(user);
        }

}
