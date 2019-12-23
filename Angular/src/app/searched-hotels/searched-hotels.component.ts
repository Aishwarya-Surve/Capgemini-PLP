import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-searched-hotels',
  templateUrl: './searched-hotels.component.html',
  styleUrls: ['./searched-hotels.component.css']
})
export class SearchedHotelsComponent implements OnInit {

  constructor(private hotelService: HotelService) {
   }

  ngOnInit() {
  }

}
