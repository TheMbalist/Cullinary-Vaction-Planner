package com.example.cullinaryplanner.viewmodels;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ExperinceViewModel {
    
    

    private String title;
    public ExperinceViewModel(String title, String description, LocalDateTime dateTime, Double price,
            String restaurantName, String restaurantLocation, Double restaurantRating, String cuisineType,
            Integer restaurantId, Integer userID, String venueName, String venueLocation,
            String notes) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.price = price;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantRating = restaurantRating;
        this.cuisineType = cuisineType;
        this.restaurantId = restaurantId;
        this.userID = userID;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
        this.notes = notes;
    }


    private String description;
    private LocalDateTime dateTime;
    private Double price;
    private String restaurantName;
    private String restaurantLocation;
    private Double restaurantRating;
    private String cuisineType;
    private Integer restaurantId; 
    private Integer userID;
    private String venueName;
    private String venueLocation;
    private String notes;
     

   
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public String getRestaurantLocation() {
        return restaurantLocation;
    }
    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
    public Double getRestaurantRating() {
        return restaurantRating;
    }
    public void setRestaurantRating(Double restaurantRating) {
        this.restaurantRating = restaurantRating;
    }
    public String getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
    public String getVenueName() {
        return venueName;
    }
    public void setVenueOrRestaurantName(String venueName) {
        this.venueName = venueName;
    }
    public String getVenueLocation() {
        return venueLocation;
    }
    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }
    public Integer getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
  
}
