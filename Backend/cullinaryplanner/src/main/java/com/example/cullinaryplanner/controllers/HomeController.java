package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cullinaryplanner.model.Restaurant;
import com.example.cullinaryplanner.services.RestaurantService;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Culinary Planner!";
    }
}
