import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Itinerary } from '../models/itinerary';
import { ItineraryService } from '../services/itinerary.service';
import { RouterLink } from '@angular/router';
import * as Masonry from 'masonry-layout';
import { NgFor } from '@angular/common';
import { MatIcon } from '@angular/material/icon';
import { MatPaginator, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-itenerary',
  standalone: true,
  imports: [RouterLink, NgFor, MatIcon, MatPaginator],
  templateUrl: './itenerary.component.html',
  styleUrl: './itenerary.component.scss'
})
export class IteneraryComponent implements OnInit{

  itineraries: Itinerary[] = [];
  private imageArray: string[] = [
    'assets/restaurantimage.jpg',
    'assets/restaurantimage2.jpg',
    'assets/restaurantimage3.jpeg',
    'assets/restaurantimage4.jpg',
    'assets/restaurantimage5.jpg'
  ];

  paginatedItineraries: Itinerary[] = [];  // Subset of restaurants to display
  itemsPerPage: number = 12;  // Default number of items per page
  totalItineraries: number = 0;  // Total number of restaurants
  currentPage: number = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private itineraryService: ItineraryService) {}

  ngOnInit(): void {
    this.loadItineraries();
  }


  // Load itineraries from API
  loadItineraries() {
    this.itineraryService.getItineraries().subscribe((data) => {
      this.itineraries = data;
      this.totalItineraries = data.length;
   //   imageUrl: this.getRandomImage(); 
      this.paginateData();
    });
  }

    // Function to randomly select an image from the image array
    getRandomImage(): string {
      const randomIndex = Math.floor(Math.random() * this.imageArray.length);
      return this.imageArray[randomIndex];
    }

    paginateData() {
      const startIndex = this.currentPage * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      this.paginatedItineraries = this.itineraries.slice(startIndex, endIndex);
    }
  
    // Handle page change event
    onPageChange(event: PageEvent) {
      this.currentPage = event.pageIndex;
      this.itemsPerPage = event.pageSize;
      this.paginateData();
    }
  

}
