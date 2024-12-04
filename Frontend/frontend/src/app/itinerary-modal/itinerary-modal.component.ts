import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Itinerary } from '../models/itinerary';
import { NgModel } from '@angular/forms';
import { NgFor } from '@angular/common';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-itinerary-modal',
  standalone: true,
  imports: [NgFor, CommonModule, FormsModule],
  templateUrl: './itinerary-modal.component.html',
  styleUrl: './itinerary-modal.component.scss'
})
export class ItineraryModalComponent implements OnInit{

  itineraries: Itinerary[] = [];
  selectedItinerary: number | null = null;

  constructor(
    public dialogRef: MatDialogRef<ItineraryModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    // Load itineraries from the data passed to the modal
    this.itineraries = this.data.itineraries;
  }

  selectItinerary(itineraryId: number): void {
    this.selectedItinerary = itineraryId;
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSave(): void {
    if (this.selectedItinerary) {
      this.dialogRef.close(this.selectedItinerary);
    }
  }

}
