package com.example.cullinaryplanner.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.cullinaryplanner.model.User;
import com.example.cullinaryplanner.repositories.ItineraryRepository;
import com.example.cullinaryplanner.repositories.UserRepository;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("User not found with id: " + id);
    }
}


    

    
}
