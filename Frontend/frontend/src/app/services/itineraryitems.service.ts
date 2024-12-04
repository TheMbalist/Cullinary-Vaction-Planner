import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItineraryItems } from '../models/itineraryitems';

@Injectable({
  providedIn: 'root'
})
export class ItineraryitemsService {

  private apiUrl = 'http://localhost:8080/api/itineraryItems';
  constructor(private http: HttpClient) { }



  getItems(id:number): Observable<ItineraryItems[]> {
    return this.http.get<ItineraryItems[]>(`${this.apiUrl}/items/${id}`);
    
  }

  addItemToItinerary(item: ItineraryItems){
    return this.http.post<ItineraryItems[]>(`${this.apiUrl}/addToItinerary`,item);
    
  }

  deleteItineraryItem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/deleteItineraryItem/${id}`, );
  }



 
}
