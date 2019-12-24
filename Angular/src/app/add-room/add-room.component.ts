import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {

  message = null;

  constructor(private hotelService: HotelService) { }

  room(addRoom: NgForm) {
    this.hotelService.addRoom(addRoom.value).subscribe(response => {
      addRoom.reset();
      this.message = response.description;
    });
  }

  ngOnInit() {
  }

}
