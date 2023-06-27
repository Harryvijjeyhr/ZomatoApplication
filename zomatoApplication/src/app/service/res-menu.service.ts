import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ResMenuService {


  // requestHeader = new HttpHeaders({
  //   "Authorization": `Bearer ${this.authService.getToken()}`
  // })
  
  requestHeader = new HttpHeaders({
    'No-Auth': 'True',
  });
  restaurantId: any;
  constructor(private authService: AuthService, private http: HttpClient, private router: Router) { }

  getRestaurant(){
    return this.http.get("http://localhost:8084/api/z1/allRestaurant", {headers: this.requestHeader});
  }
  getMenu() {
    return this.http.get('http://localhost:8084/api/z1/allMenu', {
      headers: this.requestHeader,
    });
  }

  addRestaurant(restaurant: any){
    return this.http.post("http://localhost:8084/api/z1/restaurants",restaurant, {headers: this.requestHeader})
  }

  // deleteRestaurant(restaurant:any){
  //   return this.http.delete( `http://localhost:8084/api/z1/deleteRestaurant/${this.restaurantId}`,restaurant)
  // }

  // deleteUrl="http://localhost:8084/api/z1/deleteRestaurant";
  // deleteRestaurant (restaurant: any){
  //   this.restaurantId=restaurant[this.restaurantId];
  //   console.log(this.restaurantId);
  //   return this.http.delete(this.deleteUrl+"/"+this.restaurantId,);
  // }
}
