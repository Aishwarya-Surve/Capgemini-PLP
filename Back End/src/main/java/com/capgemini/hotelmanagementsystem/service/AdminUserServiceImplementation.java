package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
import com.capgemini.hotelmanagementsystem.dao.AdminUserDAO;

@Service
public class AdminUserServiceImplementation implements AdminUserService {

	@Autowired
	private AdminUserDAO adminUserDAO;

	@Override
	public AdminUserBean login(String userEmail, String password) {

		return adminUserDAO.login(userEmail, password);
	}

//	@Override
//	public AdminUserBean managerLogin(String userEmail, String password) {
//		return adminUserDAO.managerLogin(userEmail, password);
//	}
//
//	@Override
//	public AdminUserBean userLogin(String userEmail, String password) {
//		return adminUserDAO.userLogin(userEmail, password);
//	}
//
//	@Override
//	public AdminUserBean employeeLogin(String userEmail, String password) {
//		return adminUserDAO.employeeLogin(userEmail, password);
//	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		return adminUserDAO.userRegister(adminUserBean);
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return adminUserDAO.getAllUsers();
	}

	@Override
	public List<AdminUserBean> getAllEmployee() {
		// TODO Auto-generated method stub
		return adminUserDAO.getAllEmployee();
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return adminUserDAO.deleteUser(userId);
	}

	@Override
	public boolean deleteEmployee(int userId) {
		return adminUserDAO.deleteEmployee(userId);
	}

	@Override
	public boolean userProfile(UserInfoBean userInfoBean) {
		return adminUserDAO.userProfile(userInfoBean);
	}

}
