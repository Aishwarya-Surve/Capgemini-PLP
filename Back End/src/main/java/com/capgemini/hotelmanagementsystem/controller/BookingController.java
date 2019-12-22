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

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;
import com.capgemini.hotelmanagementsystem.service.BookingInfoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class BookingController {
	@Autowired
	public BookingInfoService bookingInfoService;

	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@PostMapping("/booking")
	public HotelManagementResponse bookingRoom(@RequestBody BookingInfoBean bookingInfoBean) {
		boolean isRoomBooked = bookingInfoService.bookingInfo(bookingInfoBean);
		if (isRoomBooked) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Room Booked Successfully");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to Book Room");
		}
		return hotelManagementResponse;
	}// end of bookingRoom()

	@GetMapping("/getBookedRoomList")
	public HotelManagementResponse getRoomList() {
		List<BookingInfoBean> boookedRoomList = bookingInfoService.bookedRoomList();
		if (boookedRoomList != null && !boookedRoomList.isEmpty()) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("boookedRoomList ");
			hotelManagementResponse.setBoookedRoomList(boookedRoomList);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to fetch boookedRoomList ");
		}
		return hotelManagementResponse;
	}// end of getBookedRoomList()

	@DeleteMapping("/cancelBooking")
	public HotelManagementResponse cancelBooking(@RequestParam int bookingId) {
		boolean cancelBooking = bookingInfoService.cancelBooking(bookingId);
		if (cancelBooking) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Removed Successfully");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to remove");
		}
		return hotelManagementResponse;
	}// end of cancelBooking()

	@GetMapping("/days")
	public HotelManagementResponse days(@RequestParam int bookingId) {
		float days = bookingInfoService.getDays(bookingId);
		if (days > 0.0) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Days" + days);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable");
		}
		return hotelManagementResponse;
	}// end of days()

	@GetMapping("/getBill")
	public HotelManagementResponse getBill(@RequestParam int bookingId) {
		double totalAmount = bookingInfoService.getBill(bookingId);
		if (totalAmount > 0.0) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Days" + totalAmount);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable");
		}
		return hotelManagementResponse;
	}// end of getBill()

}
