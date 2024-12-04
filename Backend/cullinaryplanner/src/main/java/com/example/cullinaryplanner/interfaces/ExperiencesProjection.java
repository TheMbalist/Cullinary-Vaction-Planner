package com.example.cullinaryplanner.interfaces;

import java.time.LocalDateTime;

public interface ExperiencesProjection {
    
      String getDescription();
     LocalDateTime getDateTime();
     Double getPrice();
     String getCuisineType();
     String getVenueName();
     String getVenueLocation();
     String getNotes();
     Integer getExperienceID();
     Integer getRestaurantID();
     String getTitle();
     

}
