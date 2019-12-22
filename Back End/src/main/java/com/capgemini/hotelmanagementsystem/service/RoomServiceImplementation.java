package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.dao.RoomDAO;
@Service
public class RoomServiceImplementation implements RoomService {
	@Autowired
	private RoomDAO roomDAO;

	@Override
	public boolean addRoom(RoomBean roomBean) {
		return roomDAO.addRoom(roomBean);
	}

	@Override
	public List<RoomBean> getRoom() {
		return roomDAO.getRoom();
	}

	@Override
	public boolean removeRoom(int roomId) {
		return roomDAO.removeRoom(roomId);
	}

	@Override
	public boolean updateRoom(RoomBean roomBean) {
		return roomDAO.updateRoom(roomBean);
	}

}
