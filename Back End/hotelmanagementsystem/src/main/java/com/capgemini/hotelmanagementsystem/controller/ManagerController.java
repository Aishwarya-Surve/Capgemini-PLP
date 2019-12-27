package com.capgemini.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.ManagerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@GetMapping(path = "/managerLogin")
	public HotelManagementResponse adminUserLogin(@RequestParam String managerEmail, @RequestParam String password) {
		ManagerBean managerBean = managerService.managerlogin(managerEmail, password);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (managerBean != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Log In Scussessfully!!!");
			hotelManagementResponse.setManagerBean(managerBean);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage(" Log In Failed!!!");
			hotelManagementResponse.setDescription(
					"Please enter password which contain atleast one uppercase letter,one lowercase letter and a digit.");

		}
		return hotelManagementResponse;
	}// End of adminLogin()

	@PostMapping(path = "/managerRegister")
	public HotelManagementResponse userRegister(@RequestBody ManagerBean managerBean) {
		boolean registerManager = managerService.managerRegister(managerBean);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (registerManager) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("You Registered Scussessfully!!");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage(" Register Failed");
			hotelManagementResponse.setDescription(
					"Please enter  valid password which contain atleast one uppercase letter,one lowercase letter and a digit.");
		}
		return hotelManagementResponse;
	}// End of userRegister()

	@GetMapping(path = "/getAllManager")
	public HotelManagementResponse getAllManager() {
		List<ManagerBean> getAllManager = managerService.managerList();
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (getAllManager != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setGetAllManager(getAllManager);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Information is not found");
		}
		return hotelManagementResponse;
	}// End of getUserProfile()

	@DeleteMapping(path = "/deleteManager")
	public HotelManagementResponse deleteManager(@RequestParam int managerId) {
		boolean deleteManager = managerService.deleteManager(managerId);
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		if (deleteManager) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Manager Deleted successfully.......");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable To Delete Manager........");
		}
		return hotelManagementResponse;
	} // End of deleteManager()

}
