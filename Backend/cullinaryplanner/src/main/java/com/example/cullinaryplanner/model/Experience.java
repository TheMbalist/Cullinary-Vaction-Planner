package com.example.cullinaryplanner.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer experienceId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = true)
    private Restaurant restaurant;

    private String title;
    private String description;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User created_by;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", nullable = true)
    private User updated_by;

    @Column(name = "venue_name")
    private String venue_name;
    
    @Column(name = "venue_address")
    private String venue_address;

    @Column(name = "notes")
    private String notes;





    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getVenue_address() {
        return venue_address;
    }

    public void setVenue_address(String venue_address) {
        this.venue_address = venue_address;
    }


    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Experience orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

}
