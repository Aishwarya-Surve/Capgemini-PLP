import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserProfile } from '../user-profile';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  userProfile: UserProfile = {
    userId: null,
    userName: null,
    userType: null,
    emailId: null,
    address: null,
    nationality: null,
    phoneNumber: null,
    password: null
  };

  constructor(private auth: AuthService, private router: Router) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    console.log(userDetails.adminUserBean.userId);
    this.userProfile.userId = userDetails.adminUserBean.userId;
    this.userProfile.userName = userDetails.adminUserBean.userName;
    this.userProfile.userType = userDetails.adminUserBean.userType;
    this.userProfile.password = userDetails.adminUserBean.password;
    this.userProfile.emailId = userDetails.adminUserBean.userEmail;
  }

  update(updateProfile: NgForm) {
    this.userProfile.address = updateProfile.value.address;
    this.userProfile.nationality = updateProfile.value.nationality;
    this.userProfile.phoneNumber = updateProfile.value.phoneNumber;
    console.log(this.userProfile);
    this.auth.updateProfile(this.userProfile).subscribe(response => {
      console.log(response);
      this.router.navigateByUrl('/userProfile');
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
