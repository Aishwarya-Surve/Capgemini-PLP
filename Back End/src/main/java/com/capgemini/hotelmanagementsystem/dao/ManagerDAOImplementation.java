package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.ManagerBean;
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Repository
public class ManagerDAOImplementation implements ManagerDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public ManagerBean managerlogin(String managerEmail, String password) throws HotelManagementSystemExceptionController {
		ManagerBean managerBean = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from ManagerBean where managerEmail = :managerEmail and password = :password   ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("managerEmail", managerEmail);
			query.setParameter("password", password);
			managerBean = (ManagerBean) query.getSingleResult();
			System.out.println(" manager login successfully");

		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct createntials!!!!!");
		}
		return managerBean;
	}

	@Override
	public boolean managerRegister(ManagerBean managerBean) throws HotelManagementSystemExceptionController {
		boolean isRegister = false;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(managerBean);
			entityTransaction.commit();
			isRegister = true;
			entityManager.close();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your   proper createntials !!!");
		}
		return isRegister;
	}

	@Override
	public List<ManagerBean> managerList() throws HotelManagementSystemExceptionController {
		List<ManagerBean> managerList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
		
			String jpql = "FROM ManagerBean ";
			Query query = entityManager.createQuery(jpql);
		
			managerList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Unable To Fetch All employeeList");
		}
		return managerList;
	}

	@Override
	public boolean deleteManager(int managerId) throws HotelManagementSystemExceptionController {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete ManagerBean where managerId =: managerId";
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("managerId", managerId);
			query.executeUpdate();
			entityTransaction.commit();
			System.out.println("Manager Deleted Successfully");
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {

			throw new HotelManagementSystemExceptionController("Unable To Manager customer!!!");
		}
		return isRemove;
	}

}
