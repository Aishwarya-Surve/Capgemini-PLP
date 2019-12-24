import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {



  constructor(private hotelService: HotelService, private router: Router) { }

  search(bookingForm: NgForm) {
    console.log(bookingForm.value.location);
    this.hotelService.searchHotel(bookingForm.value.location);
  }

  ngOnInit() {
  }

}
