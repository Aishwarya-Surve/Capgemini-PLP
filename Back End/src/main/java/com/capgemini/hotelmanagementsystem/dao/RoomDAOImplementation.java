package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.RoomBean;

@Repository
public class RoomDAOImplementation implements RoomDAO {
	@PersistenceUnit
	public EntityManagerFactory entityManagerFactory;

	EntityManager entityManager;
	EntityTransaction entityTransaction;

	@Override
	public boolean addRoom(RoomBean roomBean) {
		boolean addRoom = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(roomBean);
			entityTransaction.commit();
			addRoom = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return addRoom;
	}// end of addRoom()

	@Override
	public List<RoomBean> getRoom() {
		List<RoomBean> roomList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from RoomBean";
			Query query = entityManager.createQuery(jpql);
			roomList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomList;
	}

	@Override
	public boolean removeRoom(int roomId) {
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
			e.printStackTrace();
		}
		return roomRemoved;
	}// end of removeRoom()

	@Override
	public boolean updateRoom(RoomBean roomBean) {
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
				e.printStackTrace();
			}

			entityManager.close();

		}
		return roomUpdated;
	}// end of updatedRoom()

}
