import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  jwt_user_data: any;
  jwt_data: any;
 
 

  constructor(private http: HttpClient,private authService:AuthService) { }

  // requestHeader = new HttpHeaders({
  //   'No-Auth': 'True',
  // });

  requestHeader = new HttpHeaders({
    "Authorization": `Bearer ${this.authService.getToken()}`
  })
  getorder() {
    return this.http.get('http://localhost:8085/api/z1/Allorders', {
      headers: this.requestHeader,
    });
  }

  AddCart(order:any){
    return this.http.post('http://localhost:8085/api/z1/orders',order,{
      headers: this.requestHeader,
    });
  }

  getDecodedAccessToken(token: string): any {
    try {
      this.jwt_data = jwt_decode(token);
      // console.log(this.jwt_data.userData, "User Data");
      this.jwt_user_data = this.jwt_data.userData;
      return this.jwt_user_data;
    } catch(Error) {
      return null;
    }
  }
  // loadcart_id(orderId: string){
  //   this.orderId.next(orderId);
  // }

  // getcart_id(): Observable<String>{
  //   return this.orderId.asObservable();
  // } 
  
}
