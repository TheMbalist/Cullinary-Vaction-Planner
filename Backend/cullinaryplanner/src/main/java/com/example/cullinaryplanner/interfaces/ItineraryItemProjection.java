package com.example.cullinaryplanner.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ItineraryItemProjection {
  
    LocalDateTime getDate();            // LocalDate for the date
    String getNotes();             // String for notes
    String getTitle();             // String for title
    LocalDateTime getDate_Time();  // LocalDateTime for date_time
    Integer getItinerary_id(); 
    Integer getResturant_id();
    Integer getExperience_id();
    Integer getItinerary_item_id();
    String getVenueName();
    String getVenueLocation();

    
}
