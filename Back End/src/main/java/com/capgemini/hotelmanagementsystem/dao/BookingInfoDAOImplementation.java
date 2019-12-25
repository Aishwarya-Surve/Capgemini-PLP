package com.capgemini.hotelmanagementsystem.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.BookingInfoBean;
import com.capgemini.hotelmanagementsystem.bean.HotelBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Repository
public class BookingInfoDAOImplementation implements BookingInfoDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean bookingInfo(BookingInfoBean bookingInfoBean) throws HotelManagementSystemExceptionController {
		boolean isBooked = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bookingInfoBean);
			entityTransaction.commit();
			isBooked = true;
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
//		HotelBean hotelBean= new HotelBean();
//		String jpql="update HotelBean  set availableAcRoom =: availableAcRoom where hotelId=: hotelId ";
//		Query query=entityManager.createQuery(jpql);
//		
//		entityManager.close();
		return isBooked;

	}

	@Override
	public List<BookingInfoBean> bookedRoomList() throws HotelManagementSystemExceptionController{
		List<BookingInfoBean> bookedRoomList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean";
			Query query = entityManager.createQuery(jpql);
			bookedRoomList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return bookedRoomList;
	}

	@Override
	public boolean cancelBooking(int bookingId) throws HotelManagementSystemExceptionController{
		boolean cancelBooking = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			BookingInfoBean bookingInfoBean = entityManager.find(BookingInfoBean.class, bookingId);
			entityManager.remove(bookingInfoBean);
			entityTransaction.commit();
			cancelBooking = true;
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return cancelBooking;
	}

	@Override
	public float getDays(int bookingId) throws HotelManagementSystemExceptionController{
		float differenceBetweenDate = 0;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean where bookingId=:bookingId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("bookingId", bookingId);
			BookingInfoBean bookingInfoBean = (BookingInfoBean) query.getSingleResult();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
			Date checkInDate = bookingInfoBean.getCheckInDate();
			Date checkOutDate = bookingInfoBean.getCheckOutDate();
			long differenceBetweenDate2 = checkOutDate.getTime() - checkInDate.getTime();
			differenceBetweenDate = (differenceBetweenDate2 / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return differenceBetweenDate;

	}

	@Override
	public double getBill(int bookingId) throws HotelManagementSystemExceptionController {
		float daysBetween = 0;
		double totalBill = 0;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean where bookingId=:bookingId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("bookingId", bookingId);
			BookingInfoBean bookingInfoBean = (BookingInfoBean) query.getSingleResult();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
			Date checkInDate = bookingInfoBean.getCheckInDate();
			Date checkOutDate = bookingInfoBean.getCheckOutDate();
			long differenceBetweenDate = checkOutDate.getTime() - checkInDate.getTime();
			daysBetween = (differenceBetweenDate / (1000 * 60 * 60 * 24));
			totalBill = daysBetween * bookingInfoBean.getRoomAmount();
			System.out.println("Bill is" + totalBill);
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return totalBill;
	}

}
