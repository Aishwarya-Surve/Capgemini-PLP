package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;

public interface BookingInfoService {

	public List<BookingInfoBean> bookedRoomList();

	public boolean cancelBooking(int bookingId);

	public double getBill(BookingInfoBean bookingInfoBean);
	
	//To Book Room
			public BookingInfoBean booking(BookingInfoBean bookingInfoBean);
}// end of interface
