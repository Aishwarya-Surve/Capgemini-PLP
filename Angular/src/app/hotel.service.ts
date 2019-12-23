import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hotel } from './hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  api = 'http://localhost:8080/';

  hotelArray: [];

  searchedHotel = [];

  constructor(private http: HttpClient) { }

  addHotel(data): Observable<any> {
    return this.http.post<any>(`${this.api}addHotel`, data);
  }

  getHotelList() {
    this.http.get<any>(`${this.api}getHotelList`).subscribe(data => {
      console.log(data.hotelList);
      this.hotelArray = data.hotelList;
    }, err => {
      console.log(err);
    });
  }

  updateHotel(data) {
    return this.http.post<any>(`${this.api}updateHotel`, data);
  }

  deleteHotel(hotelId) {
    return this.http.delete<any>(`${this.api}removeHotel?hotelId=${hotelId}`);
  }

  searchHotel(data) {
    console.log(data.location);
    this.http.get<any>(`${this.api}getHotelLocationList?location=${data.location}`).subscribe(response => {
      console.log(response.hotelList);
      this.searchedHotel = response.hotelList;
    }, err => {
      console.log(err);
    });
  }

}
