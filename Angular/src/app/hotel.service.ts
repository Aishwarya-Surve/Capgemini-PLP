import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hotel } from './hotel';
import { User } from 'user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  api = 'http://localhost:8080/';

  roomArray: [];

  hotelArray: [];

  searchedHotel = [];

  constructor(private http: HttpClient, private router: Router) { }

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

  searchHotel(location) {
    this.http.get<any>(`${this.api}getHotelLocationList?location=${location}`).subscribe(data => {
      console.log(data.hotelList);
      this.searchedHotel = data.hotelList;
      this.router.navigateByUrl('/searchedHotel');
    }, err => {
      console.log(err);
    });
  }

  deleteHotel(hotelId) {
    return this.http.delete<any>(`${this.api}removeHotel?hotelId=${hotelId}`);
  }

  addRoom(data): Observable<any> {
    console.log(data);
    return this.http.post<any>(`${this.api}addRoom`, data);
  }

  getRoomList() {
    this.http.get<any>(`${this.api}getRoomList`).subscribe(data => {
      console.log(data.roomList);
      this.roomArray = data.roomList;
    }, err => {
      console.log(err);
    });
  }

  updateRoom(data) {
    return this.http.post<any>(`${this.api}updateRoom`, data);
  }

  deleteRoom(roomId) {
    return this.http.delete<any>(`${this.api}removeRoom?roomId=${roomId}`);
  }

  getCustomer(): Observable<any> {
    return this.http.get<any>(`${this.api}bookingList`);
  }

}
