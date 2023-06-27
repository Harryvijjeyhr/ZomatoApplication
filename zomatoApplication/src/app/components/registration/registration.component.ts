import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

 
  msg: any;
  errorMsg: any;
  constructor(private router: Router, private http: HttpClient) { }

 
  ngOnInit(): void {
  }

  registerForm = new FormGroup({
    name:new FormControl('',Validators.required),
    email: new FormControl('',Validators.required),
    mobileNo: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

  register(){
    this.http.post('http://localhost:8083/api/z1/registration', this.registerForm.value).subscribe((data)=>{
      this.msg = data;
      console.log(data, "data");
      alert("Registration Sucessful!");
      this.registerForm.reset();
      this.router.navigate(['/']);
    },(error)=>{
      if(error instanceof HttpErrorResponse){
        this.errorMsg = error;
        console.log(this.errorMsg.error);
        alert(this.errorMsg.error);
      }
    });
  }


}
