import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  message = null;
  statusCode = null;

  constructor(private auth: AuthService, private router: Router) { }

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
      if (response.statusCode === 201) {
        localStorage.setItem('user', JSON.stringify(response));
        const userDetail = localStorage.getItem('user');
        this.message = response.description;
        if (response.adminUserBean.userType === 'user') {
          alert(response.description);
          this.router.navigateByUrl('/bookings');
        } else {
          this.router.navigate(['/']);
        }
      } else if (response.statusCode === 401) {
        this.message = response.description;
        alert(this.message);
      } else {
        this.message = response.description;
        alert(this.message);
      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
