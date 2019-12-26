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
	private BookingInfoService bookingInfoService;

	HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();

	@GetMapping("/bookingList")
	public HotelManagementResponse bookedRoom() {
		List<BookingInfoBean> bookedRoomList = bookingInfoService.bookedRoomList();
		if (bookedRoomList != null) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Booked Room List");
			hotelManagementResponse.setBookedRoomList(bookedRoomList);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to fetch List");
		}
		return hotelManagementResponse;
	}// end of bookedRoom()

	@DeleteMapping("/cancelBooking")
	public HotelManagementResponse cancelBooking(@RequestParam int bookingId) {
		boolean canceled = bookingInfoService.cancelBooking(bookingId);
		if (canceled) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Booking Canceled Successfully");
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable to Cancel Booking");
		}
		return hotelManagementResponse;
	}// end of cancelBooking()

	@PostMapping("/bill")
	public HotelManagementResponse bill(@RequestBody BookingInfoBean bookingInfoBean) {
		System.err.println("Check in Date " + bookingInfoBean.getCheckInDate());
		System.err.println("Check out Date " + bookingInfoBean.getCheckOutDate());
		double totalAmount = bookingInfoService.getBill(bookingInfoBean);
		if (totalAmount > 0.0) {
			hotelManagementResponse.setStatusCode(201);
			hotelManagementResponse.setMessage("Success");
			hotelManagementResponse.setDescription("Total Bill :" + totalAmount);
			hotelManagementResponse.setBill(totalAmount);
		} else {
			hotelManagementResponse.setStatusCode(401);
			hotelManagementResponse.setMessage("Failed");
			hotelManagementResponse.setDescription("Unable");
		}
		return hotelManagementResponse;
	}

	@PostMapping("/booking")
	public HotelManagementResponse booking(@RequestBody BookingInfoBean bookingInfoBean) {
		BookingInfoBean roomBooking = bookingInfoService.booking(bookingInfoBean);
		HotelManagementResponse roomBookingResponse = new HotelManagementResponse();
		if (roomBooking != null) {
			roomBookingResponse.setStatusCode(201);
			roomBookingResponse.setMessage("Success");
			roomBookingResponse.setDescription("Room Booked Successfully");
			// roomBookingResponse.setDays(roomBooking);
		} else {
			roomBookingResponse.setStatusCode(401);
			roomBookingResponse.setMessage("Failed");
			roomBookingResponse.setDescription("Room Not Available");
		}
		return roomBookingResponse;
	}// end of booking()
}// end of controller
