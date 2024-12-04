import { Component, OnInit, ViewChild } from '@angular/core';
import { ExperienceService } from '../services/experience.service';
import { ItineraryitemsService } from '../services/itineraryitems.service';
import { Itinerary } from '../models/itinerary';
import { DatePipe } from '@angular/common';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgStyle } from '@angular/common';
import { ItineraryService } from '../services/itinerary.service';
import { Experience } from '../models/experinces';
import { MatDialog } from '@angular/material/dialog';
import { ItineraryModalComponent } from '../itinerary-modal/itinerary-modal.component';
import { EditExperienceDialogComponent } from '../edit-experience-dialog/edit-experience-dialog.component';
import { AlertserviceService } from '../services/alertservice.service';
import { MatIcon } from '@angular/material/icon';
import { DeleteExperienceDialogComponent } from '../delete-experience-dialog/delete-experience-dialog.component';
import { RouterLink } from '@angular/router';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
@Component({
  selector: 'app-experiences',
  standalone: true,
  imports: [DatePipe, NgFor, NgStyle, MatIcon, RouterLink, NgIf, MatPaginator],
  templateUrl: './experiences.component.html',
  styleUrl: './experiences.component.scss'
})
export class ExperiencesComponent {
  experiences: Experience[] = [];
  paginatedExperiences: Experience[] = [];
  itineraries: Itinerary[] = [];
  itemsPerPage: number = 12;  // Default number of items per page
  totalExperiences: number = 0;  // Total number of restaurants
  currentPage: number = 0;
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private experiencesService: ExperienceService,
    private itineraryItemService: ItineraryitemsService,
    private itineraryService:ItineraryService,
    private dialog: MatDialog,
    private alertService:AlertserviceService
  ) {}

  ngOnInit(): void {
    this.getExperiences();
    this.loadItineraries();
  }

  getExperiences() {
    this.experiencesService.getAllExperiences().subscribe((data: any) => {
      this.experiences = data;
      this.totalExperiences = data.length;
      console.log('Data', data)
      this.paginateData();
    });
  }

  paginateData() {
    const startIndex = this.currentPage * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.paginatedExperiences = this.experiences.slice(startIndex, endIndex);
  }

  // Handle page change event
  onPageChange(event: PageEvent) {
    this.currentPage = event.pageIndex;
    this.itemsPerPage = event.pageSize;
    this.paginateData();
  }


  // Load itineraries from API
  loadItineraries() {
    this.itineraryService.getItineraries().subscribe((data) => {
      this.itineraries = data;
    });
  }


  openItineraryModal(experience: Experience) {
    const dialogRef = this.dialog.open(ItineraryModalComponent, {
      width: '400px',
      data: { itineraries: this.itineraries }
    });

    dialogRef.afterClosed().subscribe(selectedItineraryId => {
      if (selectedItineraryId) {
        const itineraryItem = this.mapExperienceToItineraryItem(experience, selectedItineraryId);
        this.itineraryItemService.addItemToItinerary(itineraryItem)
          .subscribe(() => {
             // Show success alert
           this.alertService.showSuccessAlert('Experince successfully added to itinerary!');
          },(error) => {
            // Handle error response
            console.error('Error adding experience', error);
      
         // Show error alert
         this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
          }
        );
      }
    });
  }

  
  openEditDialog(experience: any): void {
    const dialogRef = this.dialog.open(EditExperienceDialogComponent, {
      width: '600px',
      data: { ...experience } // Pass experience and additional data
    });
  
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        // Update the experience list or UI
       // this.refreshExperiences();
       this.updateExperience(experience.experienceID, result);
      }
    });
  }

  updateExperience(id:number, updatedExperience: Experience) {
    // Call your service to update the itinerary here
    //console.log(updatedItinerary)
    this.experiencesService.updateExperience(id, updatedExperience).subscribe(
      () => {
   
        
      // Show success alert
      this.alertService.showSuccessAlert('Your changes have been successfully made!');
  
       
      },
      (error) => {
        // Handle error response
        console.error('Error updating itinerary', error);
  
     // Show error alert
     this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
      }
    );
  }






  mapExperienceToItineraryItem(experience: Experience, itineraryId: number) {
    return {
      date: new Date(),
      notes: experience.notes,
      title: experience.title,
      description: experience.description,
      itinerary_id: itineraryId,
      restaurant_id: experience.restaurantId,
      experience_id: experience.experienceID,
      date_Time: experience.dateTime,
      itinerary_item_id:0,
      venueName:'',
      venueLocation: ''
    };
  }

  
  openDeleteDialog(experience: Experience): void {
    const dialogRef = this.dialog.open(DeleteExperienceDialogComponent, {
      width: '400px',
      data: { id: experience.experienceID, title: experience.title }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Handle deletion of itinerary
        this.deleteExperince(result);
      }
    });
  }

  deleteExperince(id:number) {
    // Call your service to delete the itinerary here
    this.experiencesService.deleteExperince(id).subscribe(
      () => {

        // Show success alert
        this.alertService.showSuccessAlert('Experience has been sucessfully deleted!');
  
       
      
      },
      (error) => {
        // Handle error response
        console.error('Error deleting Experience', error);
  
        // Show error alert
        this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
      }
    );
   
  }
  

}
