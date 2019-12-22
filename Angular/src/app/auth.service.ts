import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  api = 'http://localhost:8080/';

  constructor(public http: HttpClient, private router: Router) { }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  registerData(data): Observable<any> {
    return this.http.put<any>(`${this.api}userRegister`, data);
  }

  loginData(data): Observable<any> {
    return this.http.get<any>(`${this.api}login?userEmail=${data.userEmail}&password=${data.password}`);
  }

}
