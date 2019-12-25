package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface BookingInfoDAO {
	//To Book Room
	public boolean bookingInfo(BookingInfoBean bookingInfoBean)throws HotelManagementSystemExceptionController;

    //To cancel Booking
	public boolean cancelBooking(int bookingId) throws HotelManagementSystemExceptionController;

	// get all BookedRoom
	public List<BookingInfoBean> bookedRoomList() throws HotelManagementSystemExceptionController;

	// To Get Days
	public float getDays(int bookingId) throws HotelManagementSystemExceptionController;

	// To get Bill
	public double getBill(int bookingId) throws HotelManagementSystemExceptionController;

}