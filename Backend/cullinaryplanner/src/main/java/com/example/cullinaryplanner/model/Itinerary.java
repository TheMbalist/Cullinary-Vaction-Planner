package com.example.cullinaryplanner.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Itineraries")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itineraryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;
    private String description;

    @Column(name = "is_public")
    private Boolean isPublic;

   
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User created_by;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", nullable = true)
    private User updated_by;

    
}
