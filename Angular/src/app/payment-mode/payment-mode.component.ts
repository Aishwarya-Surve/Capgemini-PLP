import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-payment-mode',
  templateUrl: './payment-mode.component.html',
  styleUrls: ['./payment-mode.component.css']
})
export class PaymentModeComponent implements OnInit {

  totalAmount = null;

  selectedRoomDetails = null;

  constructor(private hotelService: HotelService) {
    console.log(this.hotelService.totalBill);
    this.totalAmount = this.hotelService.totalBill;
    this.selectedRoomDetails = this.hotelService.bookingHotelRoom;
    console.log(this.selectedRoomDetails);
  }

  paymentDone() {
    this.hotelService.paymentCashMode().subscribe(response => {
      console.log(response);
    }, err => {
      console.log(err);
    });
  }
  payment() {
    this.hotelService.paymentCardMode().subscribe(response => {
      console.log(response);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
