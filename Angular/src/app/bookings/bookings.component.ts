import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

 

  constructor(private hotelService: HotelService) { }

  search(bookingForm: NgForm) {
    console.log(bookingForm.value);
    this.hotelService.searchHotel(bookingForm.value);
  }

  ngOnInit() {
  }

}
