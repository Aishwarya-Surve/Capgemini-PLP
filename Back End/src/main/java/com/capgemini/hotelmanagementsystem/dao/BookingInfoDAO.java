package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;

public interface BookingInfoDAO {
	//To Book Room
	public boolean bookingInfo(BookingInfoBean bookingInfoBean);

    //To cancel Booking
	public boolean cancelBooking(int bookingId);

	// get all BookedRoom
	public List<BookingInfoBean> bookedRoomList();

	// To Get Days
	public float getDays(int bookingId);

	// To get Bill
	public double getBill(int bookingId);

}