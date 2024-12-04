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

@Component({
  selector: 'app-edit-itinerary-dialog',
  standalone: true,
  imports: [NgClass, FormsModule, MatIcon, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField, MatSlideToggle, RouterLink, MatDialogActions, MatDialogContent],
  templateUrl: './edit-itinerary-dialog.component.html',
  styleUrl: './edit-itinerary-dialog.component.scss'
})
export class EditItineraryDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<EditItineraryDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { title: string; description: string; isPublic:boolean }
  ) {}

  onCancel(): void {
    this.dialogRef.close();
  }

  saveChanges(): void {
    this.dialogRef.close(this.data);  // Pass back edited data
  }

}
