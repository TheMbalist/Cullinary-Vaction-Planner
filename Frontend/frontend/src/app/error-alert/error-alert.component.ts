import { Component,  Input, OnInit } from '@angular/core';
import { MatIcon } from '@angular/material/icon';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-error-alert',
  standalone: true,
  imports: [MatIcon,NgIf ],
  templateUrl: './error-alert.component.html',
  styleUrl: './error-alert.component.scss'
})
export class ErrorAlertComponent implements OnInit{
  @Input() message: string = 'An error occurred!';  // Default message
  progressValue = 0;
  autoDismissTime = 5000; // 5 seconds
  showErrorAlert: boolean = true;

  ngOnInit(): void {
    this.startProgressBar();
    this.autoDismiss();
  }

  startProgressBar(): void {
    const interval = 50; // Update progress every 50ms
    const progressIncrement = 100 / (this.autoDismissTime / interval); // Calculate the increment value

    const progressInterval = setInterval(() => {
      if (this.progressValue >= 100) {
        clearInterval(progressInterval);
        this.dismissAlert();
      } else {
        this.progressValue += progressIncrement;
      }
    }, interval);
  }

  autoDismiss(): void {
    setTimeout(() => {
      this.dismissAlert();
    }, this.autoDismissTime);
  }

  dismissAlert(): void {
    this.showErrorAlert = false;
  }
}
