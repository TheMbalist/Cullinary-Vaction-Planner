import { Component, OnInit } from '@angular/core';
import { Itinerary } from '../models/itinerary';
import { CommonModule } from '@angular/common';
import { ItineraryService } from '../services/itinerary.service';
import { Route, Router, ActivatedRoute } from '@angular/router';
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


@Component({
  selector: 'app-itinerary-form',
  standalone: true,
  imports: [NgClass, FormsModule, MatIcon, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField, MatSlideToggle],
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
    private router: Router
  ) {}

  ngOnInit(): void {
    
  }

  // Create or update an itinerary
  saveItinerary() {
    console.log('New Itinerary', this.itinerary);
    
    
      this.itineraryService.createItinerary(this.itinerary, 2).subscribe(() => {
        this.router.navigate(['/itenerary']); // Redirect to list page after creation
      });
    
  }

}
