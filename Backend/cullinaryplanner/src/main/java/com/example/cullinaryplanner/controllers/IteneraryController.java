package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cullinaryplanner.services.IteneraryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
 @RequestMapping("/api/itenerary")
public class IteneraryController {

    @Autowired
    public IteneraryService iteneraryService;


    //http://localhost:8080/api/itenerary/getItenerary?userID=2&itineraryId=1
    @GetMapping("/getItenerary")
    public List<Object[]> getAllIteneraries(@RequestParam Integer userID, @RequestParam Integer itineraryId) {
        return iteneraryService.getAllIteneraryItems(userID, itineraryId);
    }
    
    
}
