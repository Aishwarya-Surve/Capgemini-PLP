package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Repository
public class RoomDAOImplementation implements RoomDAO {
	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean addRoom(RoomBean roomBean)  throws HotelManagementSystemExceptionController {
		boolean addRoom = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(roomBean);
			entityTransaction.commit();
			addRoom = true;
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		entityManager.close();
		return addRoom;
	}// end of addRoom()

	@Override
	public List<RoomBean> getRoom()  throws HotelManagementSystemExceptionController{
		List<RoomBean> roomList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from RoomBean";
			Query query = entityManager.createQuery(jpql);
			roomList = query.getResultList();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return roomList;
	}

	@Override
	public boolean removeRoom(int roomId) throws HotelManagementSystemExceptionController {
		boolean roomRemoved = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			RoomBean roomBean = entityManager.find(RoomBean.class, roomId);
			entityManager.remove(roomBean);
			entityTransaction.commit();
			roomRemoved = true;
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return roomRemoved;
	}// end of removeRoom()

	@Override
	public boolean updateRoom(RoomBean roomBean) throws HotelManagementSystemExceptionController {
		entityManager = entityManagerFactory.createEntityManager();
		RoomBean existingRoomDetails = entityManager.find(RoomBean.class, roomBean.getRoomId());
		boolean roomUpdated = false;

		if (existingRoomDetails != null) {
			double roomRent = roomBean.getRoomRent();
			if (roomRent > 0) {
				existingRoomDetails.setRoomRent(roomRent);

			}

			String roomType = roomBean.getRoomType();
			if (roomType != null) {
				existingRoomDetails.setRoomType(roomType);

			}
			int roomCapacity = roomBean.getRoomCapacity();
			if (roomCapacity > 0) {
				existingRoomDetails.setRoomCapacity(roomCapacity);

			}

			String roomStatus = roomBean.getRoomStatus();
			if (roomStatus != null) {
				existingRoomDetails.setRoomStatus(roomStatus);

			}

			String roomFacility = roomBean.getRoomFacility();
			if (roomFacility != null) {
				existingRoomDetails.setRoomFacility(roomFacility);

			}

			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingRoomDetails);
				entityTransaction.commit();
				roomUpdated = true;
			} catch (Exception e) {
				throw new HotelManagementSystemExceptionController("please enter your correct creatential");
			}

			entityManager.close();

		}
		return roomUpdated;
	}// end of updatedRoom()

}
