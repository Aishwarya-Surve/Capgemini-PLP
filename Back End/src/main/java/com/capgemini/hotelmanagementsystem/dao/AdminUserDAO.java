package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

//login for Admin as well as  manager
public interface AdminUserDAO {
	// login for Admin
	public AdminUserBean login(String userEmail, String password) throws HotelManagementSystemExceptionController;

	//user registeration
	public boolean userRegister(AdminUserBean adminUserBean) throws HotelManagementSystemExceptionController;

	// see all user which is present in database
	public List<AdminUserBean> getAllUsers() throws HotelManagementSystemExceptionController;

	// see all employee which is present in database
	public List<AdminUserBean> getAllEmployee() throws HotelManagementSystemExceptionController;

	// delete customer by admin
	public boolean deleteUser(int userId)throws HotelManagementSystemExceptionController;

	// delete Employee by admin
	public boolean deleteEmployee(int userId) throws HotelManagementSystemExceptionController;

	// user update his details or add
	public boolean userProfile(int userId, long phoneNumber, String address, String nationality)throws HotelManagementSystemExceptionController;

	// display userprofile
	public List<UserInfoBean> displayUserProfile(int userId) throws HotelManagementSystemExceptionController;
	
	// display userprofile by id
			public List<AdminUserBean> displayUserProfileById(int userId);

	// remove Manager by admin
	public boolean deleteManager(int userId)throws HotelManagementSystemExceptionController;

	// see all Manager which is present in database
	public List<AdminUserBean> getAllManager()throws HotelManagementSystemExceptionController;

}
