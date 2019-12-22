package com.capgemini.hotelmanagementsystem.response;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelManagementResponse {
	private int statusCode;
	private String message;
	private String description;

	public AdminUserBean adminUserBean;

	public List<AdminUserBean> userList;
	public List<RoomBean> roomList;

	public List<HotelBean> hotelList;

	public List<BookingInfoBean> boookedRoomList;

	public List<BookingInfoBean> getBoookedRoomList() {
		return boookedRoomList;
	}

	public void setBoookedRoomList(List<BookingInfoBean> boookedRoomList) {
		this.boookedRoomList = boookedRoomList;
	}

	public List<HotelBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelBean> hotelList) {
		this.hotelList = hotelList;
	}

	public List<RoomBean> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomBean> roomList) {
		this.roomList = roomList;
	}

	public List<AdminUserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<AdminUserBean> userList) {
		this.userList = userList;
	}

	public AdminUserBean getAdminUserBean() {
		return adminUserBean;
	}

	public void setAdminUserBean(AdminUserBean adminUserBean) {
		this.adminUserBean = adminUserBean;
	}

	// getter & setter
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
