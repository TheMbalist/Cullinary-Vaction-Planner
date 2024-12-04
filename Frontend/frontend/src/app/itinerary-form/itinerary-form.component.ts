import { Component, OnInit } from '@angular/core';
import { Itinerary } from '../models/itinerary';
import { CommonModule } from '@angular/common';
import { ItineraryService } from '../services/itinerary.service';
import { Route, Router, ActivatedRoute, RouterLink } from '@angular/router';
import { NgClass } from '@angular/common';
import { NgModel } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { MatSelect } from '@angular/material/select';
import { MatInput } from '@angular/material/input';
import { MatOption } from '@angular/material/select';
import { MatLabel } from '@angular/material/select';
import { MatFormField } from '@angular/material/select';
import { MatIcon } from '@angular/material/icon';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog } from '@angular/material/dialog';
import { AlertserviceService } from '../services/alertservice.service';

@Component({
  selector: 'app-itinerary-form',
  standalone: true,
  imports: [NgClass, FormsModule, MatIcon, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField, MatSlideToggle, RouterLink],
  templateUrl: './itinerary-form.component.html',
  styleUrl: './itinerary-form.component.scss'
})
export class ItineraryFormComponent {

  itinerary: Itinerary = {
    itineraryId: 0,
    title: '',
    description: '',
    isPublic: false,
    userID: 2 ,  // Adjust if you have a user object
  };

  constructor(
    private itineraryService: ItineraryService,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertserviceService
  ) {}

  ngOnInit(): void {
    
  }

  // Create or update an itinerary
  saveItinerary() {
    console.log('New Itinerary', this.itinerary);
    
    
      this.itineraryService.createItinerary(this.itinerary, 2).subscribe(() => {
        
        this.router.navigate(['/itinerary']); // Redirect to list page after creation
        this.alertService.showSuccessAlert("Itinerary successfully created!");
      },(error) => {
        // Handle error response
        console.error('Error creating itinerary', error);
  
     // Show error alert
     this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
      }
    );
    
  }

}
