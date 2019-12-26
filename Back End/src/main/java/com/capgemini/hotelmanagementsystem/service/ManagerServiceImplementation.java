package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.dao.ManagerDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Service
public class ManagerServiceImplementation implements ManagerService {
	@Autowired
	private ManagerDAO managerDAO;

	@Override
	public ManagerBean managerlogin(String managerEmail, String password) {
		return managerDAO.managerlogin(managerEmail, password);

	}

	@Override
	public List<ManagerBean> managerList() {
		return managerDAO.managerList();
	}

	@Override
	public boolean managerRegister(ManagerBean managerBean) {
		return managerDAO.managerRegister(managerBean);
	}

	@Override
	public boolean deleteManager(int managerId) {
		return managerDAO.deleteManager(managerId);
	}

}
