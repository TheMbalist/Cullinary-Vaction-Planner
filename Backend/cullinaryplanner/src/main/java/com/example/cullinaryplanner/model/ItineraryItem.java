package com.example.cullinaryplanner.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Itinerary_Items")
public class ItineraryItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itineraryItemId;

    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private Itinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @Column(name = "date")
    private Date date;
    
    @Column(name = "notes")
    private String notes;
    
}
