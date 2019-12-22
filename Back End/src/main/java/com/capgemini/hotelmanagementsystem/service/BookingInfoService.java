package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;

public interface BookingInfoService {
	public boolean bookingInfo(BookingInfoBean bookingInfoBean);

	public boolean cancelBooking(int bookingId);

	public List<BookingInfoBean> bookedRoomList();

	// To Get Days
	public float getDays(int bookingId);

	// To get Bill
	public double getBill(int bookingId);
}
