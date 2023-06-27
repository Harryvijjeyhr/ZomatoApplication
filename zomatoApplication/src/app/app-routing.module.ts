import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { LoginComponent } from './components/login/login.component';
import { MenuItemComponent } from './components/menu-item/menu-item.component';
import { MenuaddComponent } from './components/menuadd/menuadd.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { RestaurantComponent } from './components/restaurant/restaurant.component';
import { RestaurantaddComponent } from './components/restaurantadd/restaurantadd.component';
import { StartpageComponent } from './components/startpage/startpage.component';


const routes: Routes = [
  {
    path:'',component:StartpageComponent
  },
  {
    path:'startPage',component:StartpageComponent
  },
 {
   path:'login',component:LoginComponent
 },
 {
   path:'signup',component:RegistrationComponent
 },
 {
   path:'restaurant',component:RestaurantComponent
 },
 {
   path:'restaurant/menuItem',component:MenuItemComponent
 },
 {
   path:'addRestaurant',component:RestaurantaddComponent
 },
 {
   path:'addMenu',component:MenuaddComponent
 },
 {
   path:'restaurant/cart',component:CartComponent
 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
