package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
import com.capgemini.hotelmanagementsystem.dao.AdminUserDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Service
public class AdminUserServiceImplementation implements AdminUserService {

	@Autowired
	private AdminUserDAO adminUserDAO;

	@Override
	public AdminUserBean login(String userEmail, String password) {

		try {
			return adminUserDAO.login(userEmail, password);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		try {
			return adminUserDAO.userRegister(adminUserBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		try {
			return adminUserDAO.getAllUsers();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<AdminUserBean> getAllEmployee() {
		try {
			return adminUserDAO.getAllEmployee();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean deleteUser(int userId) {
		try {
			return adminUserDAO.deleteUser(userId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int userId) {
		try {
			return adminUserDAO.deleteEmployee(userId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public boolean userProfile(int userId,long phoneNumber, String address, String nationality) {
		try {
			return adminUserDAO.userProfile(userId, phoneNumber, address, nationality);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<UserInfoBean> displayUserProfile(int userId) {
		try {
			return adminUserDAO.displayUserProfile(userId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean deleteManager(int userId) {
		try {
			return adminUserDAO.deleteManager(userId);
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public List<AdminUserBean> getAllManager() {
		try {
			return adminUserDAO.getAllManager();
		} catch (HotelManagementSystemExceptionController e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<AdminUserBean> displayUserProfileById(int userId) {
		return adminUserDAO.displayUserProfileById(userId);
	}

	
}
