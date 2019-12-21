import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  message = null;
  statusCode = null;

  constructor(private auth: AuthService) { }

  isLoggedIn(): boolean {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }

  loginForm(form: NgForm) {
    this.auth.loginData(form.value).subscribe(response => {
      console.log(response);
      form.reset();
      localStorage.setItem('user', JSON.stringify(response));
      const userDetail = localStorage.getItem('user');
      console.log(response.statusCode);
      this.statusCode = response.statusCode;
      if (response.statusCode === '201') {
        this.message = response.description;
        console.log(this.message);
      } else if (response.statusCode === '401') {
        this.message = response.description;
      } else {
        this.message = response.description;
      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
