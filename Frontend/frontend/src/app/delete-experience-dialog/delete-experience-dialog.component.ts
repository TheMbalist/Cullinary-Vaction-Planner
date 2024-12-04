import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatDialogActions, MatDialogContent } from '@angular/material/dialog';
@Component({
  selector: 'app-delete-experience-dialog',
  standalone: true,
  imports: [MatDialogActions, MatDialogContent],
  templateUrl: './delete-experience-dialog.component.html',
  styleUrl: './delete-experience-dialog.component.scss'
})
export class DeleteExperienceDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<DeleteExperienceDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { id: number, title: string }
  ) {}

  onCancel(): void {
    this.dialogRef.close(); // Close dialog without action
  }

  deleteExperience(): void {
    this.dialogRef.close(this.data.id); // Pass back the id of the itinerary to be deleted
  }

}
