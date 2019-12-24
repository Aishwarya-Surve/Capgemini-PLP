import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from '../hotel';

@Component({
  selector: 'app-searched-hotels-details',
  templateUrl: './searched-hotels-details.component.html',
  styleUrls: ['./searched-hotels-details.component.css']
})
export class SearchedHotelsDetailsComponent implements OnInit {

  constructor() { }

  @Input() hotelDetails: Hotel;

  ngOnInit() {
  }

}
