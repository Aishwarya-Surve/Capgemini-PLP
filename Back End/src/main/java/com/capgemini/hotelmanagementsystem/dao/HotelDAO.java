package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;

public interface HotelDAO {
	// add hotel by admin
	public boolean addHotel(HotelBean hotelBean);

	// delete hotel by admin
	public boolean deleteHotel(int hotelId);

	// update hotel by admin
	public boolean updateHotel(HotelBean hotelBean);

	// get all hotel list
	public List<HotelBean> getAllHotel();

	// serach hotel by location
	public List<HotelBean> searchHotel(String location);

}
