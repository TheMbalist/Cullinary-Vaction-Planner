import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatDialogActions, MatDialogContent } from '@angular/material/dialog';


@Component({
  selector: 'app-delete-itinerary-dialog',
  standalone: true,
  imports: [MatDialogActions, MatDialogContent],
  templateUrl: './delete-itinerary-dialog.component.html',
  styleUrl: './delete-itinerary-dialog.component.scss'
})
export class DeleteItineraryDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<DeleteItineraryDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { id: number, title: string }
  ) {}

  onCancel(): void {
    this.dialogRef.close(); // Close dialog without action
  }

  deleteItinerary(): void {
    this.dialogRef.close(this.data.id); // Pass back the id of the itinerary to be deleted
  }

}
