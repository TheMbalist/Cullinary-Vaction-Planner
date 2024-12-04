import { Component, Input, OnInit } from '@angular/core';
import { MatIcon } from '@angular/material/icon';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-success-alert',
  standalone: true,
  imports: [MatIcon, NgIf],
  templateUrl: './success-alert.component.html',
  styleUrl: './success-alert.component.scss'
})
export class SuccessAlertComponent implements OnInit  {
  @Input() message: string = 'Action successful!'; // Allow custom messages to be passed in
  progressWidth = 0;  // Tracks the progress bar width
  autoDismissTime = 6000;  // How long the alert stays before auto-dismiss (6 seconds)
  showSuccessAlert = false;  // Controls whether the alert is visible

  ngOnInit(): void {
    this.showSuccessAlert = true;
    this.startProgressBar();
    this.autoDismiss();
  }

  // Starts the progress bar animation
  startProgressBar(): void {
    const interval = 50; // Update progress every 50ms
    const progressIncrement = 100 / (this.autoDismissTime / interval); // Calculate the increment value

    const progressInterval = setInterval(() => {
      if (this.progressWidth >= 100) {
        clearInterval(progressInterval); // Stop when the progress reaches 100%
        this.dismissAlert();  // Dismiss the alert automatically when done
      } else {
        this.progressWidth += progressIncrement; // Increment the progress width
      }
    }, interval);
  }

  // Automatically dismiss the alert after the specified time
  autoDismiss(): void {
    setTimeout(() => {
      this.dismissAlert();
    }, this.autoDismissTime);
  }

  // Dismiss the alert (can be triggered manually or automatically)
  dismissAlert(): void {
    this.showSuccessAlert = false;
  }
}
