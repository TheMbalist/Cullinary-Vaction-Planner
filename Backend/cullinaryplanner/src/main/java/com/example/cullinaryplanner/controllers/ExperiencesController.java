package com.example.cullinaryplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cullinaryplanner.interfaces.ExperiencesProjection;
import com.example.cullinaryplanner.model.Experience;
import com.example.cullinaryplanner.services.ExperiencesService;
import com.example.cullinaryplanner.viewmodels.ExperinceViewModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
    
    @Autowired
    ExperiencesService experiencesService;

    @GetMapping("/getAll")
    public List<ExperiencesProjection> getExperinces() {
        return experiencesService.getExperineces();
    }

    @GetMapping("getExperience/{id}")
    public ResponseEntity<Experience> viewExperience(@PathVariable Integer id) {
        Experience experience = experiencesService.getExperienceById(id);
        return ResponseEntity.ok(experience);
    }

    

      @PostMapping("/createExperience")
    public ResponseEntity<Experience> createExperience(@RequestBody ExperinceViewModel experienceDto) {
        Experience newExperience = experiencesService.createExperience(experienceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExperience);
    }

    @PutMapping("/updateExperince/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Integer id, @RequestBody ExperinceViewModel experienceDto) {
        Experience updatedExperience = experiencesService.updateExperience(id, experienceDto);
        return ResponseEntity.ok(updatedExperience);
    }


    @DeleteMapping("/deleteExperince/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Integer id) {
        experiencesService.deleteExperience(id);
        return ResponseEntity.noContent().build();
    }

}
