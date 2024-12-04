import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Itinerary } from '../models/itinerary';
@Injectable({
  providedIn: 'root'
})
export class ItineraryService {
  private apiUrl = 'http://localhost:8080/api/itineraries';
  constructor(private http: HttpClient) { }



  getUserItineraries(userId: number): Observable<Itinerary[]> {
    return this.http.get<Itinerary[]>(`${this.apiUrl}/user/${userId}`);
  }


  getItienraryByID(id: number): Observable<Itinerary[]> {
    return this.http.get<Itinerary[]>(`${this.apiUrl}/itinerary/${id}`);
  }
  getItineraries(): Observable<Itinerary[]> {
    return this.http.get<Itinerary[]>(`${this.apiUrl}/all`);
  }


  // Create a new itinerary
  createItinerary(itinerary: Itinerary, userID: number): Observable<Itinerary> {
    return this.http.post<Itinerary>(`${this.apiUrl}/createItinerary/${userID}`, itinerary);
  }

  // Update an existing itinerary
  updateItinerary(id: number, itinerary: Itinerary): Observable<Itinerary> {
    return this.http.put<Itinerary>(`${this.apiUrl}/editItinerary/${id}`, itinerary);
  }

  // Delete an itinerary
  deleteItinerary(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/deleteItinerary/${id}`, );
  }
}
