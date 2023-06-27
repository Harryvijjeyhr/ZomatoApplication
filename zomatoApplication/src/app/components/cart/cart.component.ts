import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { order } from 'src/app/modal/order';
import { AuthService } from 'src/app/service/auth.service';
import { CartService } from 'src/app/service/cart.service';
import { ResMenuService } from 'src/app/service/res-menu.service';

declare var Razorpay: any;
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  restaurant: any;
  order: any;
  err: any;
  userData: any;
  userId: any;
  cartId: any;
  menuName: any;
  price: any;
  FOODPRICE: any;
  FOODNAME: any;
  orderId: any;
  totalPrice: any;

  
  

  constructor( private cartService:CartService, private http: HttpClient,private authService:AuthService) {}

  ngOnInit(): void {
    this.listorder();
     this.getCartDataByUserId();
  }
  addFoodForm = new FormGroup({
    menuName: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    quantity: new FormControl('', Validators.required),
    totalPrice: new FormControl('', Validators.required),
  });

  token = this.authService.getToken();
  requestHeader = new HttpHeaders({
    Authorization: `Bearer ${this.authService.getToken()}`,
  });

  Addorder() {
    this.cartService.AddCart(this.addFoodForm.value).subscribe(
      (_data) => {},
      (err) => console.log(err, 'Error')
    );

    let ref = document.getElementById('cancel');
    ref?.click();
    this.addFoodForm.reset();
    alert('cart added');
  }

  

  deleteFood(order: order) {
   
  }

  getcart() {
    this.cartService.getorder().subscribe((data) => {
      this.order = data;
    });

  }
  listorder() {
    this.cartService.getorder().subscribe((data) => {
      this.order = data;
    });
  }

 
 

  async checkout() {
   
  }

  async onSubmit() {
    this.userData = this.cartService.getDecodedAccessToken(this.token);
    this.userId = this.userData.id;
    this.http
      .get(`http://localhost:8085/api/z1/order/${this.cartId}`, {
        headers: this.requestHeader,
      })
      .subscribe((data: any) => {
        console.log('getcartdata()()()', data);
        this.orderId = data.orderId;
        console.log('cart id...', this.orderId);

        this.FOODNAME = data['order'].menuName;
      });
  }

  
    async getCartDataByUserId(){
      this.userData = this.cartService.getDecodedAccessToken(this.token);
      this.userId = this.userData.id;
      this.http.get(`http://localhost:8085/api/z1/order/${this.orderId}`, {headers: this.requestHeader})
      .subscribe((data: any)=>{
        console.log("get cart data()()()", data);
        this.orderId = data.orderId;
        console.log("cart id...", this.orderId);
        this.menuName =data["order"].menuName;
        this.price = data["totalPrice"];
      })
    }
}





 
