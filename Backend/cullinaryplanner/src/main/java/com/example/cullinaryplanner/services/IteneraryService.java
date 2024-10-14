package com.example.cullinaryplanner.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cullinaryplanner.model.*;
import com.example.cullinaryplanner.repositories.IteneraryRepository;
import com.example.cullinaryplanner.repositories.RestaurantRepository;

@Service
public class IteneraryService {

    @Autowired
    private IteneraryRepository iteneraryRepository;

    public List<Object[]> getAllIteneraryItems(Integer userID, Integer iteneraryID){
        return iteneraryRepository.findExperiencesByUserId(userID, iteneraryID);
    }

    
    
}
