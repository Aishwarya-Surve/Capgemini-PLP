package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.dao.HotelDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Service
public class HotelServiceImplementation implements HotelService {
	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public boolean addHotel(HotelBean hotelBean) {
		try {
			return hotelDAO.addHotel(hotelBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		try {
			return hotelDAO.deleteHotel(hotelId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean updateHotel(HotelBean hotelBean) {
		try {
			return hotelDAO.updateHotel(hotelBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<HotelBean> getAllHotel() {
		try {
			return hotelDAO.getAllHotel();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<HotelBean> searchHotel(String location) {
		try {
			return hotelDAO.searchHotel(location);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

}
