package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.AdminUserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;

	@PostMapping(path = "/login")
	public HotelManagementResponse adminUserLogin(@RequestParam String userEmail, @RequestParam String password) {

		AdminUserBean adminUserBean = adminUserService.login(userEmail, password);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (adminUserBean != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Log In Scussessfully!!!");
			hotelManagementResponse.setAdminUserBean(adminUserBean);
		} 
		return hotelManagementResponse;

	}// End of adminLogin()

	@PostMapping(path = "/userRegister")
	public HotelManagementResponse userRegister(@RequestBody AdminUserBean adminUserBean) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		String email = adminUserBean.getUserEmail();
		boolean isEmailPresent = adminUserService.emailPresent(email);
		if (!isEmailPresent) {
			boolean registerUser = adminUserService.userRegister(adminUserBean);
			if (registerUser) {
				hotelManagementResponse.setStatusCode(201);
				hotelManagementResponse.setMessage("Success");
				hotelManagementResponse.setDescription("User Registered Successfully.......");
			} 
//			else {
//				hotelManagementResponse.setStatusCode(401);
//				hotelManagementResponse.setMessage("Failed");
//				hotelManagementResponse.setDescription("User Registration Failed........");
//			}
			return hotelManagementResponse;
		} 
		else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Email Already Exists........");
			return hotelManagementResponse;
		}
	}

	@GetMapping(path = "/getAllUsers", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse getAllUsers() {
		List<AdminUserBean> userList = adminUserService.getAllUsers();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (userList != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("This Are All User");
			hotelManagementResponse.setUserList(userList);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Information is not found");
//		}
		return hotelManagementResponse;
	}// End of getAllUsers()

	@GetMapping(path = "/getAllEmployees", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public HotelManagementResponse getAllEmployees() {
		List<AdminUserBean> userList = adminUserService.getAllEmployee();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (userList != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("This Are All User");
			hotelManagementResponse.setUserList(userList);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Information is not found");
//		}
		return hotelManagementResponse;
	}// End of getAllUsers()

	@DeleteMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse deleteUser(@RequestParam int userId) {
		boolean userDelete = adminUserService.deleteUser(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (userDelete) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("User Deleted successfully.......");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable To Delete User........");
		}
		return hotelManagementResponse;
	} // End of deleteUser()

	@DeleteMapping(path = "/deleteEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponse deleteEmployee(@RequestParam int userId) {
		boolean userDelete = adminUserService.deleteUser(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (userDelete) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Employee Deleted successfully.......");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable To Delete Employee........");
//		}
		return hotelManagementResponse;
	} // End of deleteUser()

	@PostMapping(path = "/userProfile")
	public HotelManagementResponse userProfile(@RequestBody UserInfoBean userInfoBean) {
		boolean userProfile = adminUserService.userProfile(userInfoBean.getUserId(), userInfoBean.getPhoneNumber(),
				userInfoBean.getAddress(), userInfoBean.getNationality());
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (userProfile) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("User Profile Update Scussessfully!!");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Failed To Update...");
//		}
		return hotelManagementResponse;
	}// End of userProfile()

	@GetMapping(path = "/getUserProfile")
	public HotelManagementResponse getUserProfile(@RequestParam int userId) {
		List<UserInfoBean> getUserProfile = adminUserService.displayUserProfile(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (getUserProfile != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setGetUserProfile(getUserProfile);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Information is not found");
//		}
		return hotelManagementResponse;
	}// End of getUserProfile()

	@GetMapping(path = "/getAllManager")
	public HotelManagementResponse getAllManager() {
		List<AdminUserBean> getAllManager = adminUserService.managerList();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (getAllManager != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setGetAllManager(getAllManager);
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Information is not found");
//		}
		return hotelManagementResponse;
	}// End of getUserProfile()

	@DeleteMapping(path = "/deleteManager")
	public HotelManagementResponse deleteManager(@RequestParam int userId) {
		boolean deleteManager = adminUserService.deleteManager(userId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (deleteManager) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Manager Deleted successfully.......");
		} 
//		else {
//			hotelManagementResponse.setStatusCode(401);
//			hotelManagementResponse.setMessage("Failed");
//			hotelManagementResponse.setDescription("Unable To Delete Manager........");
//		}
		return hotelManagementResponse;
	} // End of deleteManager()

}
