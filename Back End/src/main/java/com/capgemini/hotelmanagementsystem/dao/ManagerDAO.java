package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface ManagerDAO {

	// manager login
	public ManagerBean managerlogin(String userEmail, String password) throws HotelManagementSystemExceptionController;

	// list of manager
	public List<ManagerBean> managerList() throws HotelManagementSystemExceptionController;

	// manager register
	public boolean managerRegister(ManagerBean managerBean) throws HotelManagementSystemExceptionController;

	// remove Manager by admin
	public boolean deleteManager(int managerId) throws HotelManagementSystemExceptionController;

}
