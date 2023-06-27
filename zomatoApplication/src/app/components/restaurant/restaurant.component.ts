import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResMenuService } from 'src/app/service/res-menu.service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css'],
})
export class RestaurantComponent implements OnInit {
  restaurant: any;

  constructor(private resService: ResMenuService, private router: Router) {}

  ngOnInit() {
    this.listRestaurant();
  }

  getRestaurant() {
    this.resService.getRestaurant().subscribe((data) => {
      this.restaurant = data;
    });
  }
  listRestaurant() {
    this.resService.getRestaurant().subscribe((data) => {
      this.restaurant = data;
    });
  }
}
