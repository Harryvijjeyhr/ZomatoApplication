import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ResMenuService } from 'src/app/service/res-menu.service';

declare var Razorpay: any;
@Component({
  selector: 'app-menu-item',
  templateUrl: './menu-item.component.html',
  styleUrls: ['./menu-item.component.css'],
})
export class MenuItemComponent implements OnInit {
  restaurant: any;
  Order: any;

  // @Output() restaurantaddtoCart: EventEmitter<restaurant> = new EventEmitter<restaurant>();
  constructor(private menuService:ResMenuService,private router:Router) {}

  ngOnInit(): void {
    this.listMenu();
  }

  listMenu() {
    this.menuService.getMenu().subscribe((data) => {
      this.restaurant = data;
    });
  }
  getMenu() {
    this.menuService.getMenu().subscribe((data) => {
      this.restaurant = data;
    });
  }

  AddCart(restaurant: any) {
    this.router.navigate(['/restaurant/cart']);
  }
}
