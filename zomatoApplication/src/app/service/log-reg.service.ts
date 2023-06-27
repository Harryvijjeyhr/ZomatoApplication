import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { login } from '../modal/login';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class LogRegService {
  jwt: any;
  private _isLoggedIn= new BehaviorSubject<boolean>(false);
  isLoggedIn = this._isLoggedIn.asObservable();
  requestHeader = new HttpHeaders({
    "Authorization": `Bearer ${this.authService.getToken()}`
  })
  email= "premvijjey@gmail.com";
  password = "password";
  constructor(private http: HttpClient, private router: Router,private authService:AuthService) {
    const token = localStorage.getItem('token');
    this._isLoggedIn.next(!!token);
   }

  login(loginModel:login){
    this.http.post('http://localhost:8083/api/z1/token', loginModel, {headers: this.requestHeader}).subscribe((data)=>{
      this.jwt = data;
      this._isLoggedIn.next(true);
      localStorage.setItem('token', JSON.stringify(this.jwt.token));
      console.log(this.jwt);
      alert("Logged in successfully");
      console.log(this.jwt,"token")
      this.router.navigate(['/restaurant']);
}, (err)=>{
  alert("Wrong credentials!")
  console.log(err.message);
  this.router.navigate(['/login']);
})
  }


  token(){
    localStorage.getItem('token')
  }
}
