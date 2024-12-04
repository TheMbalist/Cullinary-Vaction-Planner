package com.example.cullinaryplanner.viewmodels;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ItineraryItemViewModel {


    public LocalDateTime Date;
    public String Notes;
    public String Title;
    public LocalDateTime Date_Time;
    public Integer Itinerary_id;
    public Integer restuarant_id;
    public Integer experience_id;

    public ItineraryItemViewModel(LocalDateTime date, String notes, String title, LocalDateTime date_Time,
            Integer itinerary_id, Integer restuarant_id, Integer experience_id) {
        Date = date;
        Notes = notes;
        Title = title;
        Date_Time = date_Time;
        Itinerary_id = itinerary_id;
        this.restuarant_id = restuarant_id;
        this.experience_id = experience_id;
    }

    public LocalDateTime getDate() {
        return Date;
    }
    public void setDate(LocalDateTime date) {
        Date = date;
    }
    public String getNotes() {
        return Notes;
    }
    public void setNotes(String notes) {
        Notes = notes;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public LocalDateTime getDate_Time() {
        return Date_Time;
    }
    public void setDate_Time(LocalDateTime date_Time) {
        Date_Time = date_Time;
    }
    public Integer getItinerary_id() {
        return Itinerary_id;
    }
    public void setItinerary_id(Integer itinerary_id) {
        Itinerary_id = itinerary_id;
    }

    public Integer getRestuarnat_id() {
        return restuarant_id;
    }
    public void setRestuarnat_id(Integer restuarant_id) {
        this.restuarant_id = restuarant_id;
    }

    public Integer getExperience_id() {
        return experience_id;
    }
    public void setExperience_id(Integer experience_id) {
        this.experience_id = experience_id;
    }
}
