import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GlobalNavBarComponent } from './global-nav-bar/global-nav-bar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, GlobalNavBarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';
}
