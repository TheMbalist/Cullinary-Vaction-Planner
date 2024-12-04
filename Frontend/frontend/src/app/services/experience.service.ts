import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Experience } from '../models/experinces';
import { ExperienceViewModel } from '../models/experincesviewmodel';
@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

 
  private apiUrl = 'http://localhost:8080/api/experiences';
  constructor(private http: HttpClient) { }

  addExperience(experience: Experience): Observable<any> {
    return this.http.post(`${this.apiUrl}/createExperience`, experience);
  }

  getAllExperiences(): Observable<ExperienceViewModel[]> {
    return this.http.get<ExperienceViewModel[]>(`${this.apiUrl}/getAll`);
  }

  getExperience(id:number): Observable<Experience> {
    return this.http.get<Experience>(`${this.apiUrl}/getExperience/${id}`);
  }

  
  updateExperience(id:number, updateExperience: Experience): Observable<Experience> {
    return this.http.put<Experience>(`${this.apiUrl}/updateExperince/${id}`, updateExperience);
  }

  deleteExperince(id:number){
    return this.http.delete<Experience>(`${this.apiUrl}/deleteExperince/${id}`);
  }
}
