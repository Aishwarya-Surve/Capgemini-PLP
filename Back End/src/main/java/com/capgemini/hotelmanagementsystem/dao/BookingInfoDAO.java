package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface BookingInfoDAO {

	//To get List of all Booked Rooms
	public List<BookingInfoBean> bookedRoomList() throws HotelManagementSystemExceptionController;
	
	//To cancel the booking
	public boolean cancelBooking(int bookingId) throws HotelManagementSystemExceptionController;
	
	//To get Bill
	public double getBill(BookingInfoBean bookingInfoBean) throws HotelManagementSystemExceptionController;
	
	//To Book Room
		public BookingInfoBean booking(BookingInfoBean bookingInfoBean) throws HotelManagementSystemExceptionController;
		
}// end of interface
