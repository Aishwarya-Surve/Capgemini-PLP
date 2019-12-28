package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.FoodOrderBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.service.AdminUserService;
import com.capgemini.hotelmanagementsystem.service.BookingInfoService;
import com.capgemini.hotelmanagementsystem.service.FoodOrderService;
import com.capgemini.hotelmanagementsystem.service.HotelService;
import com.capgemini.hotelmanagementsystem.service.MenuCardService;
import com.capgemini.hotelmanagementsystem.service.RoomService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvalidTestCases {
	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private BookingInfoService bookingInformationService;
	@Autowired
	private FoodOrderService foodOrderService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private MenuCardService menuCardService;
	@Autowired
	private RoomService roomService;
	// *****************Invalid test cases**********************

	@Test
	public void testFalseLogin() {
		AdminUserBean adminUserBean = new AdminUserBean();
		String userEmail = "mayuri.com";
		String password = "Mayuri";
		adminUserBean = adminUserService.login(userEmail, password);
		String expected = "user";
		String actual = adminUserBean.getUserType();
		Assert.assertEquals(expected, actual);
	}// End of TestLogin()

	@Test
	public void testFalseDeleteUser() {
		AdminUserBean adminUserBean = new AdminUserBean();
		TestCase.assertEquals(true, adminUserService.deleteUser(0));
	}// End of TestDeleteUser()

	@Test
	public void testFalseDeleteEmployee() {
		AdminUserBean adminUserBean = new AdminUserBean();
		TestCase.assertEquals(true, adminUserService.deleteEmployee(0));
	}// End of testDeleteEmployee()

	@Test
	public void testFalseCancelBooking() {
		int bookingId = 0;
		boolean expected = false;
		boolean actual = bookingInformationService.cancelBooking(bookingId);
		Assert.assertEquals(expected, actual);
	}// End of testCancelBooking()

	@Test
	public void testFalseOrder() {
		boolean expected = false;
		boolean actual = foodOrderService.foodOrder(0, 2, 0, 15);
		Assert.assertEquals(expected, actual);
	}// End of TestOrder()

	@Test
	public void testFalseDEleteOrder() {
		FoodOrderBean foodOrderBean = new FoodOrderBean();
		TestCase.assertEquals(true, foodOrderService.deleteOrder(20));
	}// End of TestDEleteOrder()

	@Test
	public void testFalseGetBill() {
		FoodOrderBean foodOrderBean = new FoodOrderBean();
		Double expected = 0.00;
		Double actual = foodOrderService.foodBill(8);
		Assert.assertEquals(expected, actual);
	}// End of TestGetBill()

	@Test
	public void testFalseAddHotel() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(3);
		hotelBean.setHotelName("Arfa hotel");
		hotelBean.setLocation("Banglore");
		hotelBean.setAvailableAcRoom(50);
		hotelBean.setAvailableNonAcRoom(30);
		boolean expected = false;
		boolean actual = hotelService.addHotel(hotelBean);
		Assert.assertEquals(expected, actual);

	}// End of TestAddHotel()

	@Test
	public void testFalseDeleteHotel() {
		boolean expected = false;
		boolean actual = hotelService.deleteHotel(15);
		Assert.assertEquals(expected, actual);
	}// End of TestDeleteHotel()

	@Test
	public void testFalseUpdateHotel() {
		HotelBean hotelBean = new HotelBean();
		hotelBean.setHotelId(0);
		hotelBean.setHotelName("1234");
		hotelBean.setLocation("Mumbai");
		hotelBean.setAvailableAcRoom(20);
		hotelBean.setAvailableNonAcRoom(30);
		boolean expected = false;
		boolean actual = hotelService.updateHotel(hotelBean);
		Assert.assertEquals(expected, actual);
	}// End of testFalseUpdateHotel()

	

	@Test
	public void testfalseDeleteManager() {
		TestCase.assertEquals(true, adminUserService.deleteManager(0));
	}// End of testDeleteManager()

//	@Test
//	public void testFalseAddMenu() {
//		MenucardBean menucardBean = new MenucardBean();
//		menucardBean.setFoodType("Veg");
//		menucardBean.setFoodName("");
//		menucardBean.setFoodPrice(0);
//		boolean expected = false;
//		boolean actual = menuCardService.addMenu(menucardBean);
//		Assert.assertEquals(expected, actual);
//	}// End of testFalseAddMenu()

//	@Test
//	public void testFalseDeleteMenu() {
//		MenucardBean menucardBean = new MenucardBean();
//		TestCase.assertEquals(false, menuCardService.deleteMenu(0));
//	}// End of TestDeleteMenu()
//
//	@Test
//	public void testFalseUpdateMenu() {
//		MenucardBean menucardBean = new MenucardBean();
//		menucardBean.setFoodId(1);
//		menucardBean.setFoodName("Puri bhaji");
//		menucardBean.setFoodType("Veg");
//		menucardBean.setFoodPrice(200);
//		boolean expected = false;
//		boolean actual = menuCardService.updateMenu(menucardBean);
//		Assert.assertEquals(expected, actual);
//	}// End of TestUpdateMenu()

	@Test
	public void testFalseAddRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(0);
		roomBean.setRoomRent(4000.000);
		roomBean.setRoomType("2");
		roomBean.setRoomCapacity(2);
		roomBean.setRoomFacility("");
		roomBean.setRoomStatus("UnAvailable");
		roomBean.setHotelId(2);
		boolean expected = false;
		boolean actual = roomService.addRoom(roomBean);
		Assert.assertEquals(expected, actual);
	}// End of testAddRoom()

	@Test
	public void testFalseUpdateRoom() {
		RoomBean roomBean = new RoomBean();
		roomBean.setRoomId(0);
		roomBean.setRoomRent(3000.000);
		roomBean.setRoomType("1");
		roomBean.setRoomCapacity(21);
		roomBean.setRoomFacility("AC");
		roomBean.setRoomStatus("Available");
		roomBean.setHotelId(2);
		boolean expected = false;
		boolean actual = roomService.updateRoom(roomBean);
		TestCase.assertEquals(expected, actual);
	}// End of testUpdateRoom()

	@Test
	public void testFalseRemoveRoom() {
		boolean expected = false;
		boolean actual = roomService.removeRoom(0);
		Assert.assertEquals(expected, actual);
	}// End of testRemoveRoom()
}// End of class
