import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  constructor(private router: Router) {}

  navigateTo(path: string): void {
    this.router.navigate([`/${path}`]); // Navigates to '/restaurants' or '/experiences'
  }

}
