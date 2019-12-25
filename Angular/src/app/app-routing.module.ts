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
import { AuthGuard } from './auth.guard';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminControlComponent } from './admin-control/admin-control.component';
import { EmployeesCounterComponent } from './employees-counter/employees-counter.component';
import { CustomersCounterComponent } from './customers-counter/customers-counter.component';
import { RoomsCounterComponent } from './rooms-counter/rooms-counter.component';
import { HotelsCounterComponent } from './hotels-counter/hotels-counter.component';
import { AddHotelComponent } from './add-hotel/add-hotel.component';
import { AddManagerComponent } from './add-manager/add-manager.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ManagerControlComponent } from './manager-control/manager-control.component';
import { ManagerCounterComponent } from './manager-counter/manager-counter.component';
import { DeleteUpdateManagerComponent } from './delete-update-manager/delete-update-manager.component';
import { DeleteUpdateEmployeeComponent } from './delete-update-employee/delete-update-employee.component';
import { SearchedHotelsComponent } from './searched-hotels/searched-hotels.component';
import { AdminHotelCounterComponent } from './admin-hotel-counter/admin-hotel-counter.component';
import { BookRoomComponent } from './book-room/book-room.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'bookings', component: BookingsComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'services', component: ServicesComponent },
  { path: 'reservation', component: ReservationComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'userProfile', component: UserProfileComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'adminControl', component: AdminControlComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'managerControl', component: ManagerControlComponent, canActivate: [AuthGuard], data: { expectedRole: ['manager'] } },
  { path: 'managerCounter', component: ManagerCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['manager'] } },
  { path: 'employeesCounter', component: EmployeesCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'customersCounter', component: CustomersCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'roomsCounter', component: RoomsCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'hotelsCounter', component: HotelsCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['manager'] } },
  { path: 'adminhotelsCounter', component: AdminHotelCounterComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'addHotel', component: AddHotelComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'deleteUpdateManager', component: DeleteUpdateManagerComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'deleteUpdateEmployee', component: DeleteUpdateEmployeeComponent, canActivate: [AuthGuard], data: { expectedRole: ['manager'] } },
  { path: 'addManager', component: AddManagerComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
  { path: 'addEmployee', component: AddEmployeeComponent, canActivate: [AuthGuard], data: { expectedRole: ['manager'] } },
  { path: 'food-order', component: FoodOrderComponent },
  { path: 'userRegister', component: UserRegisterComponent },
  { path: 'searchedHotel', component: SearchedHotelsComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: 'bookRoom', component: BookRoomComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
