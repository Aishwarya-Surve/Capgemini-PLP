import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {


  bookedRoomList = [];

  constructor(private hotelService: HotelService, private router: Router) {
    this.getBookingList();
  }

  getBookingList() {
    this.hotelService.userBookedRoom().subscribe(response => {
      console.log(response);
      this.bookedRoomList = response.bookedRoomList;
    }, err => {
      console.log(err);
    });
  }

  cancelBooking(bookingId) {
    console.log(bookingId);
    this.hotelService.cancelBooking(bookingId).subscribe(response => {
      console.log(response);
      this.getBookingList();
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {

  }
}
