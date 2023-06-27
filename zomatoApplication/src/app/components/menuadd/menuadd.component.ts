import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menuadd',
  templateUrl: './menuadd.component.html',
  styleUrls: ['./menuadd.component.css']
})
export class MenuaddComponent implements OnInit {
  restaurant: any;
  constructor() { }

  ngOnInit(): void {
  }
  addFoodForm = new FormGroup({
    menuName: new FormControl('',Validators.required),
    price: new FormControl('',Validators.required)
  })
  AddMenu(){
   
  }
  getMenu(){
   
  }

}
