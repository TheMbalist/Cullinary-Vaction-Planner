package com.example.cullinaryplanner.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Restaurants")
public class Restaurant {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    private String name;
    private String location;
    private String cuisineType;

    @Column(name = "rating")
    private Float rating;

    private String description;

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
