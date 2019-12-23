import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { BookingsComponent } from './bookings/bookings.component';
import { ServicesComponent } from './services/services.component';
import { ReservationComponent } from './reservation/reservation.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminControlComponent } from './admin-control/admin-control.component';
import { EmployeesCounterComponent } from './employees-counter/employees-counter.component';
import { CustomersCounterComponent } from './customers-counter/customers-counter.component';
import { RoomsCounterComponent } from './rooms-counter/rooms-counter.component';
import { HotelsCounterComponent } from './hotels-counter/hotels-counter.component';
import { AddHotelComponent } from './add-hotel/add-hotel.component';
import { SearchedHotelsComponent } from './searched-hotels/searched-hotels.component';
import { SearchedHotelsDetailsComponent } from './searched-hotels-details/searched-hotels-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SignInComponent,
    AboutUsComponent,
    BookingsComponent,
    ServicesComponent,
    ReservationComponent,
    FoodOrderComponent,
    PageNotFoundComponent,
    UserRegisterComponent,
    UserProfileComponent,
    AdminControlComponent,
    EmployeesCounterComponent,
    CustomersCounterComponent,
    RoomsCounterComponent,
    HotelsCounterComponent,
    AddHotelComponent,
    SearchedHotelsComponent,
    SearchedHotelsDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
