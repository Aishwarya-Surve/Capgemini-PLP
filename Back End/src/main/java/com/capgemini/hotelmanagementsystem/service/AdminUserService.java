package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;

public interface AdminUserService {

	public AdminUserBean login(String userEmail, String password);

	// login for manager
//	public AdminUserBean managerLogin(String userEmail, String password);
//
//	// login for user(customer)
//	public AdminUserBean userLogin(String userEmail, String password);
//
//	// login for employee
//	public AdminUserBean employeeLogin(String userEmail, String password);

	// registeration only for customer
	public boolean userRegister(AdminUserBean adminUserBean);

	// see all customer which is present in database
	public List<AdminUserBean> getAllUsers();

	// see all employee which is present in database
	public List<AdminUserBean> getAllEmployee();

	// delete customer by admin
	public boolean deleteUser(int userId);

	// delete Employee by admin
	public boolean deleteEmployee(int userId);
	
	//user update his details or add
		public boolean userProfile( UserInfoBean userInfoBean );
}
