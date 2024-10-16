package com.example.cullinaryplanner.viewmodels;

import lombok.Getter;
import java.time.LocalDateTime;

public class ItineraryViewModel {
    private String title;
    private String description;
    private Integer userId;
    private Boolean is_Public;
    private LocalDateTime  Created_at;


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
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Boolean getIs_Public() {
        return is_Public;
    }
    public void setIs_Public(Boolean is_Public) {
        this.is_Public = is_Public;
    }
    public LocalDateTime  getCreated_at() {
        return Created_at;
    }
    public void setCreated_at(LocalDateTime  created_at) {
        Created_at = created_at;
    }
   

}
