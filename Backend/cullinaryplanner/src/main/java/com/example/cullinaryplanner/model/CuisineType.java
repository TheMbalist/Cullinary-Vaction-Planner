package com.example.cullinaryplanner.model;
import javax.persistence.*;

@Entity
@Table(name = "Cuisine_Type")
public class CuisineType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cusineTypeId;

    private String type;
    
}
