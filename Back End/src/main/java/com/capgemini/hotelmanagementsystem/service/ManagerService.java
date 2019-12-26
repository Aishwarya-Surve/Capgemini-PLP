package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface ManagerService {

	// manager login
	public ManagerBean managerlogin(String managerEmail, String password);

	// list of manager
	public List<ManagerBean> managerList();

	// manager register
	public boolean managerRegister(ManagerBean managerBean);

	// remove Manager by admin
	public boolean deleteManager(int managerId) throws HotelManagementSystemExceptionController;
}
