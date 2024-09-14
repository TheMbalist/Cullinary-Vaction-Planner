package com.example.cullinaryplanner.repositories;


import com.example.cullinaryplanner.model.CuisineType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineTypeRepository extends JpaRepository<CuisineType, Integer> {
    
}
