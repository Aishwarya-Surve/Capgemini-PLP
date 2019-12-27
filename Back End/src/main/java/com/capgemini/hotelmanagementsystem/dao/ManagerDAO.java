package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;

public interface ManagerDAO {

	// manager login
	public ManagerBean managerlogin(String userEmail, String password);

	// list of manager
	public List<ManagerBean> managerList();

	// manager register
	public boolean managerRegister(ManagerBean managerBean);

	// remove Manager by admin
	public boolean deleteManager(int managerId);

}
