import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ItineraryService } from '../services/itinerary.service';
import { ItineraryitemsService } from '../services/itineraryitems.service';
import { NgIf, NgFor } from '@angular/common';
import { DeleteItineraryDialogComponent } from '../delete-itinerary-dialog/delete-itinerary-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { AlertserviceService } from '../services/alertservice.service';
import { ItineraryItems } from '../models/itineraryitems';
import { DatePipe } from '@angular/common';
import { NgStyle } from '@angular/common';
import { Itinerary } from '../models/itinerary';


@Component({
  selector: 'app-view-itinerary',
  standalone: true,
  imports: [NgIf, NgFor, RouterLink, DatePipe, NgStyle],
  templateUrl: './view-itinerary.component.html',
  styleUrl: './view-itinerary.component.scss'
})
export class ViewItineraryComponent implements OnInit{

  itinerary: any ={}
  itineraryItems: ItineraryItems[] = []; // Store itinerary items
  currentItineraryItems: any[] = [];
  pastItineraryItems: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private itineraryService: ItineraryService,
    private itineraryItemService: ItineraryitemsService,
    private dialog: MatDialog,
    private alertService: AlertserviceService
  ) {}

    ngOnInit(): void {
      const id = this.route.snapshot.paramMap.get('id');

    if (id !== null) {
      const itineraryId = parseInt(id, 10); // Convert string to number
      this.itineraryService.getItienraryByID(itineraryId).subscribe(data => {
        this.itinerary = data;
        console.log('Itinerary', this.itinerary)
      });

      this.getItems(itineraryId);
    } else {
      // Handle case where 'id' is null (optional)
      console.error('Itinerary ID is missing');
    }

    
   
  }

  getItems(id:number){
    this.itineraryItemService.getItems(id).subscribe((items :ItineraryItems[]) => {
      this.itineraryItems = items;
      this.sortItineraryItems();
      console.log('Items', items)
    });
  }

 // Method to separate and sort itinerary items
 sortItineraryItems(): void {
  const now = new Date();
  this.currentItineraryItems = this.itineraryItems.filter(item => !this.isPastDate(item.date_Time));
  this.pastItineraryItems = this.itineraryItems.filter(item => this.isPastDate(item.date_Time));

  // Sort current items by date (soonest first)
  this.currentItineraryItems.sort((a, b) => new Date(a.date_Time).getTime() - new Date(b.date_Time).getTime());

  // Sort past items by date (most recent first)
  this.pastItineraryItems.sort((a, b) => new Date(b.date_Time).getTime() - new Date(a.date_Time).getTime());
}

// Helper method to check if the date is in the past
isPastDate(date: Date): boolean {
  const currentDate = new Date();
  return new Date(date) < currentDate;
}


  
  openDeleteDialog(itinerary:ItineraryItems): void {
    const dialogRef = this.dialog.open(DeleteItineraryDialogComponent, {
      width: '400px',
      data: { id: itinerary.itinerary_id, title: itinerary.title }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Handle deletion of itinerary
        this.removeItineraryItem(result);
      }
    });
  }

  removeItineraryItem(itemId:number) {
    // Call your service to delete the itinerary here
    this.itineraryItemService.deleteItineraryItem(itemId).subscribe(
      () => {
        this.itineraryItems = this.itineraryItems.filter(item => item.itinerary_id !== itemId);
        // Show success alert
        this.alertService.showSuccessAlert('Your itinerary item has been sucessfully deleted!');
        this.sortItineraryItems();
  
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