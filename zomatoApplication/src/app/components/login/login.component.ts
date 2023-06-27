
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LogRegService } from 'src/app/service/log-reg.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide: boolean = false;
  jwt: any;
  constructor(private logreg:LogRegService,private router:Router) { }

 
  ngOnInit(): void {
  }

  loginForm=new FormGroup ({
    email: new FormControl('',Validators.email),
    password: new FormControl('',Validators.minLength(8))
  })

   onLogin() {
    
    this.jwt = this.logreg.login(this.loginForm.value);
    console.log(this.loginForm.value);
    this.router.navigate(['/restaurant'])
     }
  get email(){
    return this.loginForm.get('email');
  }

  get password(){
    return this.loginForm.get('password');
  }
  }
