import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import jwt_decode from 'jwt-decode';
import { AuthService } from 'src/app/service/auth.service';
import { ResMenuService } from 'src/app/service/res-menu.service';

@Component({
  selector: 'app-restaurantadd',
  templateUrl: './restaurantadd.component.html',
  styleUrls: ['./restaurantadd.component.css']
})
export class RestaurantaddComponent implements OnInit {
 

  foodData: any;
  restaurant: any;
  jwt_data: any;
  jwt_user_data: any;
  jwt_role: any;
  jwt_userid: any;
  showButton: boolean = false;
  token = this.authService.getToken();
  
  constructor(private router:Router, private authService: AuthService,private restaurantService:ResMenuService) { }

  requestHeader = new HttpHeaders({
    "Authorization": `Bearer ${this.authService.getToken()}`
  })
  ngOnInit(): void {
  }

  addFoodForm = new FormGroup({
    restaurantName: new FormControl('',Validators.required)
  })
  

  addRestaurant(){
    this.restaurantService.addRestaurant(this.addFoodForm.value).subscribe((data)=>{  
    },(err)=>console.log(err,"Error"))
    let ref = document.getElementById('cancel');
    ref?.click();
    alert(`${this.addFoodForm.value.restaurantName} added successfully`);
    this.addFoodForm.reset(); 
    this.getRestaurant();
  }
  // deleteRestaurant(){
  //   this.restaurantService.deleteRestaurant(this.restaurant).subscribe((data) => {
  //     console.log('deleted successfully', data);
  //   });
    
  //   this.getRestaurant();
  // }
  getRestaurant(){
    this.restaurantService.getRestaurant()
    .subscribe(async (data: any)=>{
      console.log(data,'restauarantId');
      this.restaurant = await data;
      console.log("Food Data", this.restaurant);
    }, (err)=>{
      if(err instanceof HttpErrorResponse){
        if(err.status === 304){
          this.router.navigate(['/']);
        }
      }
    })
    let role = this.getDecodedAccessToken(this.token);
    this.jwt_role = role.role;
    let userid = this.getDecodedAccessToken(this.token);
    this.jwt_userid = userid.id;
    console.log("User Id", this.jwt_userid);
    
    if(this.jwt_role === "ROLE_ADMIN"){
      this.showButton = true;
    }
  }

  getDecodedAccessToken(token: string): any {
    try {
      console.log(jwt_decode(token), "Decoded token");
      this.jwt_data = jwt_decode(token);
      // console.log(this.jwt_data.userData, "User Data");
      this.jwt_user_data = this.jwt_data.userData;
      return this.jwt_user_data;
    } catch(Error) {
      return null;
    }
  }
 
}
