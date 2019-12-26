package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.dao.BookingInfoDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {
	@Autowired
	BookingInfoDAO bookingInfoDAO;

	@Override
	public List<BookingInfoBean> bookedRoomList() {
		try {
			return bookingInfoDAO.bookedRoomList();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		try {
			return bookingInfoDAO.cancelBooking(bookingId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return true;
	}

	@Override
	public double getBill(BookingInfoBean bookingInfoBean) {
		try {
			return bookingInfoDAO.getBill(bookingInfoBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return 0;
	}

	@Override
	public BookingInfoBean booking(BookingInfoBean bookingInfoBean) {
		try {
			return bookingInfoDAO.booking(bookingInfoBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return bookingInfoBean;
	}

}// end of service
