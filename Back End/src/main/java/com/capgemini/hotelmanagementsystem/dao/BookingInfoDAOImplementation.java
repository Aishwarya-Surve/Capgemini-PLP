package com.capgemini.hotelmanagementsystem.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Repository
public class BookingInfoDAOImplementation implements BookingInfoDAO {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	EntityTransaction entityTransaction;

	BookingInfoBean bookingInfoBean;
	@Override
	public BookingInfoBean booking(BookingInfoBean bookingInfoBean) throws HotelManagementSystemExceptionController {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		RoomBean roomBean;
		double daysBetween;
		try {
			entityTransaction = entityManager.getTransaction();
			bookingInfoBean.setCheckInDate(bookingInfoBean.getCheckInDate());
			bookingInfoBean.setCheckOutDate(bookingInfoBean.getCheckOutDate());
			String roomQuery = "from RoomBean where roomId=:roomId";
			Query query = entityManager.createQuery(roomQuery);
			query.setParameter("roomId", bookingInfoBean.getRoomId());
			roomBean = (RoomBean) query.getSingleResult();
			bookingInfoBean.setHotelId(roomBean.getHotelId());
			daysBetween = 0;
			daysBetween = ChronoUnit.DAYS.between(bookingInfoBean.getCheckInDate(), bookingInfoBean.getCheckOutDate());
			double bill = daysBetween * roomBean.getRoomRent();
			bookingInfoBean.setRoomAmount(bill);
			bookingInfoBean.setRoomId(bookingInfoBean.getRoomId());
			bookingInfoBean.setHotelId(bookingInfoBean.getHotelId());
			bookingInfoBean.setUserId(bookingInfoBean.getUserId());
			bookingInfoBean.setRoomAmount(bill);
			bookingInfoBean.setCheckInDate(bookingInfoBean.getCheckInDate());
			bookingInfoBean.setCheckOutDate(bookingInfoBean.getCheckOutDate());
			int roomQuantity = 1;
			if (roomBean.getRoomFacility() == "ac") {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableAcRoom(hotelBean.getAvailableAcRoom() - roomQuantity);
			} else {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableNonAcRoom(hotelBean.getAvailableNonAcRoom() - roomQuantity);
			}
			entityTransaction.begin();
			entityManager.persist(bookingInfoBean);
			entityTransaction.commit();

		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Something went wrong...Please enter valid Information");

		}
		entityManager.close();
		return bookingInfoBean;
	}// end of booking()

	@Override
	public List<BookingInfoBean> bookedRoomList() throws HotelManagementSystemExceptionController {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<BookingInfoBean> bookedList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean";
			Query query = entityManager.createQuery(jpql);
			bookedList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Unable to fetch Data ");
		}
		return bookedList;
	}// end of bookingList()

	@Override
	public boolean cancelBooking(int bookingId)
			throws HotelManagementSystemExceptionController {
		boolean canceled = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		System.err.println("Booking id"+ bookingId);
		BookingInfoBean bookingInfoBean = entityManager.find(BookingInfoBean.class, bookingId);
		try {
			//entityTransaction.begin();
			RoomBean roomBean = entityManager.find(RoomBean.class, bookingInfoBean.getRoomId());
			int roomQuantity = 1;
			if (roomBean.getRoomFacility() == "ac") {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableAcRoom(hotelBean.getAvailableAcRoom() + roomQuantity);
			} else {
				HotelBean hotelBean = entityManager.find(HotelBean.class, bookingInfoBean.getHotelId());
				hotelBean.setAvailableNonAcRoom(hotelBean.getAvailableNonAcRoom() + roomQuantity);
			}
			
			//bookingInfoBean = entityManager.find(BookingInfoBean.class, bookingId);
			entityTransaction.begin();
			entityManager.remove(bookingInfoBean);
			entityTransaction.commit();
			canceled = true;
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Something went wrong...Unable to Cancel Booking");
		}
		return canceled;
	}// end of cancelBooking()

	@Override
	
	public double getBill(BookingInfoBean bookingInfoBean) throws HotelManagementSystemExceptionController {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		double totalBill = 0;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			LocalDate checkInDate = bookingInfoBean.getCheckInDate();
			LocalDate checkOutDate = bookingInfoBean.getCheckOutDate();
			double daysBetween = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
			String roomQuery = "from RoomBean where roomId=: roomId";
			Query query6 = entityManager.createQuery(roomQuery);
			query6.setParameter("roomId", bookingInfoBean.getRoomId());
			RoomBean roomBean = (RoomBean) query6.getSingleResult();
			totalBill = daysBetween * roomBean.getRoomRent();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Something went wrong...Unable to get Bill");
		}
		return totalBill;
	}

}// end of implementation
