import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { MatSelect } from '@angular/material/select';
import { MatInput } from '@angular/material/input';
import { MatOption } from '@angular/material/select';
import { MatLabel } from '@angular/material/select';
import { MatFormField } from '@angular/material/select';
import { MatIcon } from '@angular/material/icon';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { CommonModule } from '@angular/common';
import { NgClass } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatDialogActions, MatDialogContent } from '@angular/material/dialog';
import { ExperienceService } from '../services/experience.service';
import { AlertserviceService } from '../services/alertservice.service';
import { RestaurantService } from '../services/restaurant.service';
import { Restaurant } from '../models/restaurant';
import { MatRadioModule } from '@angular/material/radio';
import { MatRadioButton } from '@angular/material/radio';

@Component({
  selector: 'app-edit-experience-dialog',
  standalone: true,
  imports: [NgClass, FormsModule, MatIcon, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField, MatSlideToggle, RouterLink, MatDialogActions, MatDialogContent, MatRadioButton, FormsModule, MatRadioModule],
  templateUrl: './edit-experience-dialog.component.html',
  styleUrl: './edit-experience-dialog.component.scss'
})
export class EditExperienceDialogComponent {

  useRestaurant: string;
  minDateTime!: string;
  restaurants: Restaurant[] = [];
  options: string[] = ['Select a Restaurant', 'Enter Venue & Location Manually'];
  constructor(
    public dialogRef: MatDialogRef<EditExperienceDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, // Expect data to have the existing experience details
    private experienceService: ExperienceService,
    private alertService: AlertserviceService,
    private restaurantService: RestaurantService
  ) {
    // Determine which input type to show (restaurant or manual entry)
    if (data.selectedRestaurant) {
      this.useRestaurant = 'Select a Restaurant';
  } else {
      this.useRestaurant = 'Enter Venue & Location Manually';
  }
  

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

  onCancel(): void {
    this.dialogRef.close();
  }

  saveChanges(): void {
    this.dialogRef.close(this.data);  // Pass back edited data
  }

}
