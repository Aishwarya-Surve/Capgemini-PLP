package com.capgemini.hotelmanagementsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;
import com.capgemini.hotelmanagementsystem.service.AdminUserService;
import com.capgemini.hotelmanagementsystem.service.BookingInfoService;
import com.capgemini.hotelmanagementsystem.service.HotelService;
import com.capgemini.hotelmanagementsystem.service.RoomService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelmanagementsystemApplicationTests {
	public AdminUserBean adminUserBean;
	public BookingInfoBean bookingInfoBean;
	public HotelBean hotelBean;
	public RoomBean roomBean;
	public UserInfoBean userInfoBean;

	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private BookingInfoService bookingInfoService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;

	@BeforeEach
	public void createObject() {
		adminUserBean = new AdminUserBean();
		bookingInfoBean = new BookingInfoBean();
		hotelBean = new HotelBean();
		roomBean = new RoomBean();
	}

	// ********************** Junit On user,employee,manager&Admin
	// Funtionality*****************

	// admin login
	@Test
	public void testValidAdminLogin() {
		String userEmail = "sam@01gmail.com";
		String password = "sam@0123";
		adminUserBean = adminUserService.login(userEmail, password);
		String expected = "admin";
		String actual = adminUserBean.getUserType();

		Assert.assertEquals(expected, actual);
	}

	// employee login
	@Test
	public void testValidEmployeeLogin() {
		String userEmail = "om@02gmail.com";
		String password = "om@01234";
		adminUserBean = adminUserService.login(userEmail, password);
		String expected = "employee";
		String actual = adminUserBean.getUserType();

		Assert.assertEquals(expected, actual);
	}

	// manager login
	@Test
	public void testValidManagerLogin() {
		String userEmail = "ram@03gmail.com";
		String password = "ram@0123";
		adminUserBean = adminUserService.login(userEmail, password);
		String expected = "manager";
		String actual = adminUserBean.getUserType();

		Assert.assertEquals(expected, actual);
	}

	// user login
	@Test
	public void testValidUserLogin() {
		String userEmail = "niya@05gmail.com";
		String password = "niya@0123";
		adminUserBean = adminUserService.login(userEmail, password);
		String expected = "user";
		String actual = adminUserBean.getUserType();

		Assert.assertEquals(expected, actual);
	}

	// ****** user register with valid data
	@Test
	public void userRegister() {
		adminUserBean.setUserName("jam");
		adminUserBean.setUserType("user");
		adminUserBean.setPassword("jam@0123");
		adminUserBean.setUserEmail("jam@04gmail.com");

		boolean expected = true;
		boolean actual = adminUserService.userRegister(adminUserBean);
		Assert.assertEquals(expected, actual);
	}

//	@Test
//	public void testDeleteUser() {
//		adminUserBean = new AdminUserBean();
//		TestCase.assertEquals(true, adminUserService.deleteUser(5));
//	}

//	@Test
//	public void testDeleteEmployee() {
//		adminUserBean = new AdminUserBean();
//		TestCase.assertEquals(true, adminUserService.deleteEmployee(6));
//	}

	// update UserProfile by user
//	@Test
//	public void testUpadateUserProfile() {
//		userInfoBean = new UserInfoBean();
//		userInfoBean.setId(1);
//		userInfoBean.setUserId(4);
//		userInfoBean.setUserName("niya");
//		userInfoBean.setUserType("user");
//		userInfoBean.setPassword("piya@04");
//		userInfoBean.setUserEmail("piya@04gmail.com");
//		userInfoBean.setPhoneNumber("9807467894");
//		userInfoBean.setAddress("Goa,maharashtra");
//		userInfoBean.setNationality("Indiana");
//		TestCase.assertEquals(true, adminUserService.userProfile(userInfoBean));
//	}

//********************** Junit On Hotel Funtionality*****************

//	@Test
//	public void testAddHotel() {
//		hotelBean = new HotelBean();
//		hotelBean.setHotelName("Arfa");
//		hotelBean.setLocation("Mumbai");
//		hotelBean.setAvailableAcRoom(30);
//		hotelBean.setAvailableNonAcRoom(40);
//		boolean expected = true;
//		boolean actual = hotelService.addHotel(hotelBean);
//		Assert.assertEquals(expected, actual);
//	}

//	@Test
//	public void testUpdateHotel() {
//		hotelBean = new HotelBean();
//		hotelBean.setHotelId(6);
//		hotelBean.setHotelName(" Hotel Arfa");
//		hotelBean.setLocation("Mumbai");
//		hotelBean.setAvailableAcRoom(80);
//		hotelBean.setAvailableNonAcRoom(40);
//		boolean expected = true;
//		boolean actual = hotelService.updateHotel(hotelBean);
//		Assert.assertEquals(expected, actual);
//	}

//	@Test
//	public void testRemoveHotel() {
//		boolean expected = true;
//		boolean actual = hotelService.deleteHotel(6);
//		Assert.assertEquals(expected, actual);
//	}

	// ********************** Junit On Room Funtionality*****************

//	@Test
//	public void testAddRoom() {
//		roomBean=new RoomBean();
//		roomBean.setRoomRent(4000.000);
//		roomBean.setRoomType("2");
//		roomBean.setRoomCapacity(2);
//		roomBean.setRoomFacility("AC");
//		roomBean.setRoomStatus("UnAvailable");
//		roomBean.setHotelId(2);
//		boolean expected = true;
//		boolean actual = roomService.addRoom(roomBean);
//		Assert.assertEquals(expected, actual);
//	}

//	@Test
//	public void testUpdateRoom() {
//		roomBean=new RoomBean();
//		roomBean.setRoomId(8);
//		roomBean.setRoomRent(3000.000);
//		roomBean.setRoomType("1");
//		roomBean.setRoomCapacity(21);
//		roomBean.setRoomFacility("AC");
//		roomBean.setRoomStatus("Available");
//		roomBean.setHotelId(2);
//		boolean expected = true;
//		boolean actual = roomService.updateRoom(roomBean);
//		TestCase.assertEquals(expected, actual);
//	}

//	@Test
//	public void testRemoveRoom() {
//		boolean expected = true;
//		boolean actual = roomService.removeRoom(8);
//		Assert.assertEquals(expected, actual);
//		}

	// ********************** Junit On Booked Room Funtionality*****************

//	@Test   ********
//	public void testBookingRoom() {
//		bookingInfoBean= new BookingInfoBean();
//		bookingInfoBean.setRoomId(7);
//		bookingInfoBean.setUserId(4);
//		bookingInfoBean.setAmount(4000.000);
//		bookingInfoBean.setPaymentStatus("Paid");
//		bookingInfoBean.setModeOfPayment("cash");
//		bookingInfoBean.setCheckInDate(2019 12 22);
//		bookingInfoBean.setCheckOutDate(2019 12 24);
//		bookingInfoBean.setHotelId(1);
//		boolean expected = true;
//		boolean actual = bookingInfoService.bookingInfo(bookingInfoBean);
//		TestCase.assertEquals(expected, actual);
//	}

	@Test
	public void testCancelBooking() {
		boolean expected = true;
		boolean actual = bookingInfoService.cancelBooking(3);
		Assert.assertEquals(expected, actual);
	}

}
