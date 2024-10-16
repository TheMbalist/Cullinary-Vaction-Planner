import { Component, OnInit, ViewChild  } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantService } from '../services/restaurant.service';
import { Restaurant } from '../models/restaurant';
import { NgFor } from '@angular/common';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatIcon } from '@angular/material/icon';
import { NgClass } from '@angular/common';
import { MatSelect } from '@angular/material/select';
import { MatInput } from '@angular/material/input';
import { MatOption } from '@angular/material/select';
import { MatLabel } from '@angular/material/select';
import { MatFormField } from '@angular/material/select';

@Component({
  selector: 'app-restaurant-listing-component',
  standalone: true,
  imports: [NgFor, MatPaginator, MatIcon, NgClass, CommonModule, MatSelect, MatInput, MatOption, MatLabel, MatFormField],
  templateUrl: './restaurant-listing-component.component.html',
  styleUrl: './restaurant-listing-component.component.scss'
})
export class RestaurantListingComponentComponent implements OnInit {


  restaurants: Restaurant[] = [];
  filteredRestaurants: any[] = [];

  paginatedRestaurants: Restaurant[] = [];  // Subset of restaurants to display
  itemsPerPage: number = 8;  // Default number of items per page
  totalRestaurants: number = 0;  // Total number of restaurants
  currentPage: number = 0;

  cuisineId: number = 0; // initial value for cuisine selection
  rating: number = 0; // initial value for rating
  location: string = ""; // initial value for location
  cuisines: string[] = [];
  locations: string[] = [];
  selectedCuisines: string[] = []; // For multi-select values
  selectedLocations: string[] = []; // For multi-select values
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private restaurantService: RestaurantService, ) {}

 
  ngOnInit() {
    this.loadRestaurants();
    this.loadFilterData();
  }

  loadRestaurants() {
    // Load the restaurants from the service
    this.restaurantService.getRestaurants().subscribe((data: Restaurant[]) => {
      this.restaurants = data;
      this.filteredRestaurants = this.restaurants;
      this.totalRestaurants = data.length;
      this.paginateData();
    });
  }

  loadFilterData(){
    this.restaurantService.getCuisines().subscribe((data) => {
      this.cuisines = data;
    });

    this.restaurantService.getLocations().subscribe((data) => {
      this.locations = data;
    });
  }

  paginateData() {
    const startIndex = this.currentPage * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.paginatedRestaurants = this.restaurants.slice(startIndex, endIndex);
  }

  // Handle page change event
  onPageChange(event: PageEvent) {
    this.currentPage = event.pageIndex;
    this.itemsPerPage = event.pageSize;
    this.paginateData();
  }

  getRatingClass(rating: number): string {
    if (rating >= 4.5) {
      return 'high-rating';
    } else if (rating >= 3.0) {
      return 'medium-rating';
    } else {
      return 'low-rating';
    }
  }
  
  getStarClass(restaurant: Restaurant, star: number): string {
    const rating = restaurant.rating;
    if (star <= Math.floor(rating)) {
      return 'filled'; // Fully filled star
    } else if (star === Math.ceil(rating) && rating % 1 !== 0) {
      return 'half'; // Half-filled star
    }
    return ''; // Empty star
  }
  

  onFilterChange() {
    this.filteredRestaurants = this.restaurants.filter(restaurant => {
      const matchesCuisine = this.selectedCuisines.length ? this.selectedCuisines.includes(restaurant.cuisineType) : true;
      const matchesLocation = this.selectedLocations.length ? this.selectedLocations.includes(restaurant.location) : true;
      return matchesCuisine && matchesLocation;
    });
  }

}
