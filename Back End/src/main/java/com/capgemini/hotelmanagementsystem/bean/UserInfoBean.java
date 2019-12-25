package com.capgemini.hotelmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_other_info")
public class UserInfoBean {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
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

	@Column(name = "phone_no")
//	@Pattern(regexp = "[6-9] {1}[0-9] {9}", message = "Phone number should be of 10 digit.")
//	@Size(min = 10, max = 10, message = "Phone Number should be of 10 digit.")
	private long phoneNumber;

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "address")
	private String address;

	@Column(name = "nationality")
	@NotBlank(message = "Nationlity cacanot be null")
	@Pattern(regexp = "^[a-zA-z]+(?:[\\s-][a-zA-Z]+)*$", message = "It Accepts only characters")
	private String nationality;

	// getter & setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

}
