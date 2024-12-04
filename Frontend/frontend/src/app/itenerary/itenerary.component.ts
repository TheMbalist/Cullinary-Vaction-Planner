import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Itinerary } from '../models/itinerary';
import { ItineraryService } from '../services/itinerary.service';
import { RouterLink, Router, Route } from '@angular/router';
import * as Masonry from 'masonry-layout';
import { NgFor, NgIf } from '@angular/common';
import { MatIcon } from '@angular/material/icon';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { EditItineraryDialogComponent } from '../edit-itinerary-dialog/edit-itinerary-dialog.component';
import { DeleteItineraryDialogComponent } from '../delete-itinerary-dialog/delete-itinerary-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { AlertserviceService } from '../services/alertservice.service';
@Component({
  selector: 'app-itenerary',
  standalone: true,
  imports: [RouterLink, NgFor, MatIcon, MatPaginator, NgIf],
  templateUrl: './itenerary.component.html',
  styleUrl: './itenerary.component.scss'
})
export class IteneraryComponent implements OnInit{

  itineraries: Itinerary[] = [];
  private imageArray: string[] = [
    'assets/restaurantimage.jpg',
    'assets/restaurantimage2.jpg',
    'assets/restaurantimage3.jpeg',
    'assets/restaurantimage4.jpg',
    'assets/restaurantimage5.jpg'
  ];

  paginatedItineraries: Itinerary[] = [];  // Subset of restaurants to display
  itemsPerPage: number = 12;  // Default number of items per page
  totalItineraries: number = 0;  // Total number of restaurants
  currentPage: number = 0;
  

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private itineraryService: ItineraryService, private dialog: MatDialog, private router: Router, private alertService: AlertserviceService) {}

  ngOnInit(): void {
    this.loadItineraries();
  }


  // Load itineraries from API
  loadItineraries() {
    this.itineraryService.getItineraries().subscribe((data) => {
      this.itineraries = data;
      this.totalItineraries = data.length;
   //   imageUrl: this.getRandomImage(); 
      this.paginateData();
    });
  }

    // Function to randomly select an image from the image array
    getRandomImage(): string {
      const randomIndex = Math.floor(Math.random() * this.imageArray.length);
      return this.imageArray[randomIndex];
    }

    paginateData() {
      const startIndex = this.currentPage * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      this.paginatedItineraries = this.itineraries.slice(startIndex, endIndex);
    }
  
    // Handle page change event
    onPageChange(event: PageEvent) {
      this.currentPage = event.pageIndex;
      this.itemsPerPage = event.pageSize;
      this.paginateData();
    }
  

    openEditDialog(itinerary: Itinerary): void {
      const dialogRef = this.dialog.open(EditItineraryDialogComponent, {
        width: '400px',
        data: { title: itinerary.title, description: itinerary.description, isPublic: itinerary.isPublic }
      });
  
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          // Handle the updated data and update itinerary
          this.updateItinerary(itinerary.itineraryId, result);
          
          
        }
        
      });
    }
  
    updateItinerary(id:number, updatedItinerary: Itinerary) {
      // Call your service to update the itinerary here
      //console.log(updatedItinerary)
      this.itineraryService.updateItinerary(id, updatedItinerary).subscribe(
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


   
  openDeleteDialog(itinerary:Itinerary): void {
    const dialogRef = this.dialog.open(DeleteItineraryDialogComponent, {
      width: '400px',
      data: { id: itinerary.itineraryId, title: itinerary.title }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Handle deletion of itinerary
        this.deleteItinerary(result);
      }
    });
  }

  deleteItinerary(id:number) {
    // Call your service to delete the itinerary here
    this.itineraryService.deleteItinerary(id).subscribe(
      () => {

        // Show success alert
        this.alertService.showSuccessAlert('Your itinerary has been sucessfully deleted!');
  
       
      
      },
      (error) => {
        // Handle error response
        console.error('Error deleting itinerary', error);
  
        // Show error alert
        this.alertService.showErrorAlert('Error. Please try again or contact us if the issue persists.');
      }
    );
   
  }

}
