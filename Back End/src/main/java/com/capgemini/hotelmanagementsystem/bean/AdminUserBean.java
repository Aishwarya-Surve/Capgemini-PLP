package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class AdminUserBean {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Pattern(regexp = "[0-9]", message = "It Accepts only number")
	private int userId;

	@Column(name = "user_name")
	@NotBlank(message = "Name cannot be Blank...")
	@Pattern(regexp = "[a-zA-z]+([\\s][a-zA-z]+)*", message = "It Accepts only Characters")
	@Size(min = 6, max = 35, message = "It Accepts only 35 characters")
	private String userName;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "password")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,10}$", message = "Invalid Password Pattern!!!Password must\r\n"
			+ " contain atleast one uppercase letter,one lowercase letter and a digit.")
	@Size(min = 5, max = 10, message = "This field requires minimum 5 and maximum 10 characters")
	private String password;

	@Column(name = "user_email")
	@Email(message = "Email should be valid...")
	private String userEmail;

	// getter & setter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}// end of bean class
