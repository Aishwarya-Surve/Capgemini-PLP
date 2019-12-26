import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { UserProfile } from '../user-profile';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

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
  constructor(private auth: AuthService) {
    const userDetails = JSON.parse(localStorage.getItem('user'));
    this.getProfile(userDetails.adminUserBean.userId);
  }

  getProfile(userId) {
    this.auth.getProfile(userId);

  }

  ngOnInit() {
  }

}
