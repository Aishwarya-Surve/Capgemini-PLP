package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface RoomDAO  {
	// To add Room in Hotel
	public boolean addRoom(RoomBean roomBean) throws HotelManagementSystemExceptionController;

	// To Get List of All Rooms in Hotel
	public List<RoomBean> getRoom() throws HotelManagementSystemExceptionController;

	// To Remove Room from Hotel
	public boolean removeRoom(int roomId) throws HotelManagementSystemExceptionController;

	// To Update Details of Room
	public boolean updateRoom(RoomBean roomBean)throws HotelManagementSystemExceptionController;
}
