import { Component, OnInit } from '@angular/core';
import { ExperienceService } from '../services/experience.service';
import { RestaurantService } from '../services/restaurant.service';
import { Restaurant } from '../models/restaurant';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NgClass } from '@angular/common';
import { MatSelect } from '@angular/material/select';
import { MatInput } from '@angular/material/input';
import { MatOption } from '@angular/material/select';
import { MatLabel } from '@angular/material/select';
import { MatFormField } from '@angular/material/select';
import { MatIcon } from '@angular/material/icon';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { MatRadioModule } from '@angular/material/radio';
import { MatRadioButton } from '@angular/material/radio';
import { AlertserviceService } from '../services/alertservice.service';
import { NgFor } from '@angular/common';
@Component({
  selector: 'app-create-experience',
  standalone: true,
  imports: [NgClass, FormsModule, MatIcon, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField, MatSlideToggle, RouterLink, MatRadioButton, MatRadioModule, NgFor],
  templateUrl: './create-experience.component.html',
  styleUrl: './create-experience.component.scss'
})
export class CreateExperienceComponent implements OnInit{
  newExperience = {
    title: '',
    description: '',
    dateTime: new Date(),
    price: 0,  
    restaurantName: '',
    restaurantLocation: '',
    restaurantRating: 0,  
    cuisineType: '',
    restaurantId: null , 
    userID: 3,  
    venueName: '',
    venueLocation: '',
    notes: '',
    experienceID: 0,
  };
  restaurants: Restaurant[] = [];
  
  selectedRestaurant: any;
  venueChoice: string = '';
  useRestaurant!: string;// Flag to determine if user is selecting a restaurant
  options: string[] = ['Select a Restaurant', 'Enter Venue & Location Manually'];
  minDateTime!: string;
  constructor(private experiencesService: ExperienceService, private restaurantService: RestaurantService, private alertService:AlertserviceService, private router:Router) {}

  ngOnInit() {
    this.loadRestaurants();
    const tomorrow = new Date();
    // Set the time to the start of tomorrow (midnight)
    tomorrow.setDate(tomorrow.getDate() + 1);

    this.minDateTime = tomorrow.toISOString().slice(0, 16); // Slicing to keep it as YYYY-MM-DDTHH:mm
    
  }

  loadRestaurants() {
    // Load the restaurants from the service
    this.restaurantService.getRestaurants().subscribe((data: Restaurant[]) => {
      this.restaurants = data;
      console.log('Restaurants', this.restaurants)
     
    });
  }

  onRestaurantSelect(selectedRestaurant: any) {
    this.selectedRestaurant = selectedRestaurant;
    console.log('Selected Restaurant :', this.selectedRestaurant); 
    this.newExperience.restaurantId = selectedRestaurant.id; // Set the restaurant ID
    console.log('Selected Restaurant ID:', this.newExperience.restaurantId); // Debugging
  }
  
  addExperience() {

    console.log('Experience:', this.newExperience); 
    // Call the service to add the experience
    this.experiencesService.addExperience(this.newExperience).subscribe(
      (response) => {
        this.router.navigate(['/experiences']);
        this.alertService.showSuccessAlert("Experience successfully created!");
        // Reset form after successful submission
      
       
      },(error) => {
        // Handle error response
        console.error('Error adding experience', error);
  
     // Show error alert
     this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
      }
    );
  }
}

