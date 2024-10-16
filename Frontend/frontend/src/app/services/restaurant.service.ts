import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Restaurant } from '../models/restaurant';
@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

   apiUrl = 'http://localhost:8080/api/restaurants'; // Replace with your backend URL

  constructor(private http: HttpClient) {}

  getRestaurants(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(`${this.apiUrl}/all`);
  }

  getLocations(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/locations`);
  }

  getCuisines(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/cuisines`);
  }
}
