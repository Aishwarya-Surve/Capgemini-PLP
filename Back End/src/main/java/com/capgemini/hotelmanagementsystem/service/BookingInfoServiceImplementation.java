package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.dao.BookingInfoDAO;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {
	@Autowired
	private BookingInfoDAO bookingInfoDAO;

	@Override
	public boolean bookingInfo(BookingInfoBean bookingInfoBean) {
		return bookingInfoDAO.bookingInfo(bookingInfoBean);
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		return bookingInfoDAO.cancelBooking(bookingId);
	}

	@Override
	public List<BookingInfoBean> bookedRoomList() {
		return bookingInfoDAO.bookedRoomList();
	}

	@Override
	public float getDays(int bookingId) {
		return bookingInfoDAO.getDays(bookingId);
	}

	@Override
	public double getBill(int bookingId) {
		return bookingInfoDAO.getBill(bookingId);
	}

}
