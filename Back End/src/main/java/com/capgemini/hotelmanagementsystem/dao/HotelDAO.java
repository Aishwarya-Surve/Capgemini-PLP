package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface HotelDAO {
	// add hotel by admin
	public boolean addHotel(HotelBean hotelBean) throws HotelManagementSystemExceptionController;

	// delete hotel by admin
	public boolean deleteHotel(int hotelId) throws HotelManagementSystemExceptionController;

	// update hotel by admin
	public boolean updateHotel(HotelBean hotelBean) throws HotelManagementSystemExceptionController;

	// get all hotel list
	public List<HotelBean> getAllHotel() throws HotelManagementSystemExceptionController;

	// serach hotel by location
	public List<HotelBean> searchHotel(String location)throws HotelManagementSystemExceptionController;

}
