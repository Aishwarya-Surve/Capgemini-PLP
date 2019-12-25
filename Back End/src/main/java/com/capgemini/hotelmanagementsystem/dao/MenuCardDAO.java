package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import com.capgemini.hotelmanagementsystem.bean.MenuCardBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

public interface MenuCardDAO {
	// To get Menu Cart
	public List<MenuCardBean> menuCard() throws HotelManagementSystemExceptionController;

	// To Add New Menu
	public boolean addMenu(MenuCardBean menuCardBean) throws HotelManagementSystemExceptionController;

	// To Delete Menu
	public boolean deleteMenu(int foodId) throws HotelManagementSystemExceptionController;

	// To Update Menu
	public boolean updateMenu(MenuCardBean menuCardBean)throws HotelManagementSystemExceptionController;
}
