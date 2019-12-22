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

@Repository
public class BookingInfoDAOImplementation implements BookingInfoDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean bookingInfo(BookingInfoBean bookingInfoBean) {
		boolean isBooked = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bookingInfoBean);
			entityTransaction.commit();
			isBooked = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isBooked;

	}

	@Override
	public List<BookingInfoBean> bookedRoomList() {
		List<BookingInfoBean> bookedRoomList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean";
			Query query = entityManager.createQuery(jpql);
			bookedRoomList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookedRoomList;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
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
			e.printStackTrace();
		}
		return cancelBooking;
	}

	@Override
	public float getDays(int bookingId) {
		float daysBetween = 0;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from BookingInfoBean where bookingId=:bookingId";
			Query query = entityManager.createQuery(jpql);
			BookingInfoBean bookingInfoBean = (BookingInfoBean) query.getSingleResult();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
			Date checkInDate = bookingInfoBean.getCheckInDate();
			Date checkOutDate = bookingInfoBean.getCheckOutDate();
			long differenceBetweenDate = checkOutDate.getTime() - checkInDate.getTime();
			differenceBetweenDate = (differenceBetweenDate / (1000 * 60 * 60 * 24));
			System.out.println("Number of days between dates:" + daysBetween);
			double bill = daysBetween * bookingInfoBean.getAmount();
			System.out.println("Bill is" + bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double getBill(int bookingId) {
		return 0;
	}

}
