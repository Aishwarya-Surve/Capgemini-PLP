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
	private BookingInfoDAO bookingInfoDAO;

	@Override
	public boolean bookingInfo(BookingInfoBean bookingInfoBean) {
		try {
			return bookingInfoDAO.bookingInfo(bookingInfoBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		try {
			return bookingInfoDAO.cancelBooking(bookingId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

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
	public float getDays(int bookingId) {
		try {
			return bookingInfoDAO.getDays(bookingId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return bookingId;
	}

	@Override
	public double getBill(int bookingId) {
		try {
			return bookingInfoDAO.getBill(bookingId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return bookingId;
	}

}
