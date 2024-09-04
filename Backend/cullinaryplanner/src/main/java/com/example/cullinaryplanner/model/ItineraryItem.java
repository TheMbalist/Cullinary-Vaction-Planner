package com.example.cullinaryplanner.model;

import javax.persistence.*;
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

    private Date date;
    private String notes;
    
}
