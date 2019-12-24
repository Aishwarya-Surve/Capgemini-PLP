import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user = {
    userName: null,
    password: null,
    userType: null,
    userEmail: null
  };

  message = null;

  constructor(private auth: AuthService) { }

  RegisterUser(registrationForm: NgForm) {
    this.user.userName = registrationForm.value.userName;
    this.user.password = registrationForm.value.password;
    this.user.userType = 'employee';
    this.user.userEmail = registrationForm.value.userEmail;
    this.auth.registerData(this.user).subscribe(response => {
      console.log(response);
      registrationForm.reset();
      console.log(response.statusCode);
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
