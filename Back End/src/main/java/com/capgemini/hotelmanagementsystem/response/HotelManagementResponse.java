package com.capgemini.hotelmanagementsystem.response;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
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

	private UserInfoBean userInfoBean;

	public List<UserInfoBean> getUserProfile;

	public ManagerBean managerBean;

	private List<ManagerBean> getAllManager;

	private List<MenuCardBean> listMenuCard;

	private MenuCardBean menuCardBean;

	private List<FoodOrderBean> foodList;

	private List<BookingInfoBean> bookedRoomList;
	
	private double bill;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public double foodBill;

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

	public AdminUserBean getAdminUserBean() {
		return adminUserBean;
	}

	public void setAdminUserBean(AdminUserBean adminUserBean) {
		this.adminUserBean = adminUserBean;
	}

	public List<AdminUserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<AdminUserBean> userList) {
		this.userList = userList;
	}

	public List<RoomBean> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomBean> roomList) {
		this.roomList = roomList;
	}

	public List<HotelBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelBean> hotelList) {
		this.hotelList = hotelList;
	}

	public List<BookingInfoBean> getBoookedRoomList() {
		return boookedRoomList;
	}

	public void setBoookedRoomList(List<BookingInfoBean> boookedRoomList) {
		this.boookedRoomList = boookedRoomList;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public List<UserInfoBean> getGetUserProfile() {
		return getUserProfile;
	}

	public void setGetUserProfile(List<UserInfoBean> getUserProfile) {
		this.getUserProfile = getUserProfile;
	}

	public ManagerBean getManagerBean() {
		return managerBean;
	}

	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}

	public List<ManagerBean> getGetAllManager() {
		return getAllManager;
	}

	public void setGetAllManager(List<ManagerBean> getAllManager) {
		this.getAllManager = getAllManager;
	}

	public List<MenuCardBean> getListMenuCard() {
		return listMenuCard;
	}

	public void setListMenuCard(List<MenuCardBean> listMenuCard) {
		this.listMenuCard = listMenuCard;
	}

	public MenuCardBean getMenuCardBean() {
		return menuCardBean;
	}

	public void setMenuCardBean(MenuCardBean menuCardBean) {
		this.menuCardBean = menuCardBean;
	}

	public List<FoodOrderBean> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodOrderBean> foodList) {
		this.foodList = foodList;
	}

	public double getFoodBill() {
		return foodBill;
	}

	public void setFoodBill(double foodBill) {
		this.foodBill = foodBill;
	}

	public List<BookingInfoBean> getBookedRoomList() {
		return bookedRoomList;
	}

	public void setBookedRoomList(List<BookingInfoBean> bookedRoomList) {
		this.bookedRoomList = bookedRoomList;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
	
	

}
