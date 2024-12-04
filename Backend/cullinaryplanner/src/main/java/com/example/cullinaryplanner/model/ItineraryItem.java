package com.example.cullinaryplanner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Itinerary_Items")
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itineraryItemId;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "experience_id", nullable = true)
    private Experience experience;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = true)
    private Restaurant restaurant;

  
    @Column(name = "date")
    private LocalDateTime date;


    public Integer getItineraryItemId() {
        return itineraryItemId;
    }

    public void setItineraryItemId(Integer itineraryItemId) {
        this.itineraryItemId = itineraryItemId;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    


    
}
