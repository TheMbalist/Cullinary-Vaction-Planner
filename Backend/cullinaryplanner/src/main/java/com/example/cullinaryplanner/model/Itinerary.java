package com.example.cullinaryplanner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

import java.util.Date;

@Entity
@Table(name = "Itineraries")
@NoArgsConstructor
@AllArgsConstructor
public class Itinerary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itineraryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_public", columnDefinition = "BIT")
    private Boolean isPublic;

   
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // @ManyToOne
    // @JoinColumn(name = "created_by", nullable = false)
    // private User created_by;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // @ManyToOne
    // @JoinColumn(name = "updated_by", nullable = true)
    // private User updated_by;

    public Integer getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Integer itineraryId) {
        this.itineraryId = itineraryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public LocalDateTime  getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime  createdAt) {
        this.createdAt = createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }



  
}
