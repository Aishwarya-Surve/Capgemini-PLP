import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { BookingsComponent } from './bookings/bookings.component';
import { ServicesComponent } from './services/services.component';
import { ReservationComponent } from './reservation/reservation.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminControlComponent } from './admin-control/admin-control.component';
import { EmployeesCounterComponent } from './employees-counter/employees-counter.component';
import { AuthGuard } from './sign-in/auth.guard';
import { CustomersCounterComponent } from './customers-counter/customers-counter.component';
import { RoomsCounterComponent } from './rooms-counter/rooms-counter.component';
import { HotelsCounterComponent } from './hotels-counter/hotels-counter.component';
import { AddHotelComponent } from './add-hotel/add-hotel.component';
import { SearchedHotelsComponent } from './searched-hotels/searched-hotels.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'bookings', component: BookingsComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'services', component: ServicesComponent },
  { path: 'reservation', component: ReservationComponent },
  { path: 'food-order', component: FoodOrderComponent },
  { path: 'userRegister', component: UserRegisterComponent },
  { path: 'userProfile', component: UserProfileComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'adminControl', component: AdminControlComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'employeesCounter', component: EmployeesCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'customersCounter', component: CustomersCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'roomsCounter', component: RoomsCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'hotelsCounter', component: HotelsCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'addHotel', component: AddHotelComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'searchedHotel', component: SearchedHotelsComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
