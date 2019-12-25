package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.dao.RoomDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;
@Service
public class RoomServiceImplementation implements RoomService {
	@Autowired
	private RoomDAO roomDAO;

	@Override
	public boolean addRoom(RoomBean roomBean) {
		try {
			return roomDAO.addRoom(roomBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<RoomBean> getRoom() {
		try {
			return roomDAO.getRoom();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean removeRoom(int roomId) {
		try {
			return roomDAO.removeRoom(roomId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		try {
			return roomDAO.updateRoom(roomBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

}
