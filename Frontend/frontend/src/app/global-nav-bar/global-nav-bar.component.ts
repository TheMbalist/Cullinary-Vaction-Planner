import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-global-nav-bar',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './global-nav-bar.component.html',
  styleUrl: './global-nav-bar.component.scss'
})
export class GlobalNavBarComponent {

}
