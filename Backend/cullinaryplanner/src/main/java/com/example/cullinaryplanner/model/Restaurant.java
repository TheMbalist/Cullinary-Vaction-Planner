package com.example.cullinaryplanner.model;

import jakarta.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import java.util.Date;


@Entity
@Data
@Table(name = "Restaurants")
@DynamicUpdate
public class Restaurant {
    
    public Restaurant(){

    }
    
    public Restaurant(Integer restaurantId, String name, String location, CuisineType cuisineType, Float rating,
            String description, Date createdAt, User created_by, Date updatedAt, User updated_by) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.cusineType = cuisineType;
        this.rating = rating;
        this.description = description;
        this.createdAt = createdAt;
        this.created_by = created_by;
        this.updatedAt = updatedAt;
        this.updated_by = updated_by;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer restaurantId;


    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "cuisine_type_id", nullable = false)
    private CuisineType cusineType;

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

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CuisineType getCuisineType() {
        return cusineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cusineType = cuisineType;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

   
}
