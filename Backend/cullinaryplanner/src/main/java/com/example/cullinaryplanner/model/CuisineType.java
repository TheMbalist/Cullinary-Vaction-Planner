package com.example.cullinaryplanner.model;
import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@Table(name = "Cusine_Types")
public class CuisineType {

    public CuisineType(){

    }

    public CuisineType(Integer cusineTypeId, String type) {
        this.cusineTypeId = cusineTypeId;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer cusineTypeId;

    @Column(name = "cusine_type")
    private String type;

   
    

  

  
   
    
}
