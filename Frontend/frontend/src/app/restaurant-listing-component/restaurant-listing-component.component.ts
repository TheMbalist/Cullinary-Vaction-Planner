import { Component, OnInit } from '@angular/core';
import { RestaurantService } from '../services/restaurant.service';
import { Restaurant } from '../models/restaurant';
import { NgFor } from '@angular/common';
@Component({
  selector: 'app-restaurant-listing-component',
  standalone: true,
  imports: [NgFor],
  templateUrl: './restaurant-listing-component.component.html',
  styleUrl: './restaurant-listing-component.component.scss'
})
export class RestaurantListingComponentComponent implements OnInit {


  restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService) {}

  ngOnInit(): void {
    this.restaurantService.getRestaurants().subscribe(
      (data) => {
        this.restaurants = data;
        console.log('Restaurants', this.restaurants)
      },
      (error) => {
        console.error('Error fetching restaurants', error);
      }
    );
  }

}
