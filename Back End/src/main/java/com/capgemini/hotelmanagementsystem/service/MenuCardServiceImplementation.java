package com.capgemini.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.dao.MenuCardDAO;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Service
public class MenuCardServiceImplementation implements MenuCardService {
	@Autowired
	private MenuCardDAO menuCardDAO;

	@Override
	public List<MenuCardBean> menuCard() {
		try {
			return menuCardDAO.menuCard();
		} catch (HotelManagementSystemExceptionController e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addMenu(MenuCardBean menuCardBean) {
		try {
			return menuCardDAO.addMenu(menuCardBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMenu(int foodId) {
		try {
			return menuCardDAO.deleteMenu(foodId);
		} catch (HotelManagementSystemExceptionController e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateMenu(MenuCardBean menuCardBean) {
		try {
			return menuCardDAO.updateMenu(menuCardBean);
		} catch (HotelManagementSystemExceptionController e) {
			e.printStackTrace();
		}
		return false;
	}

}
