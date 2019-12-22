package com.capgemini.hotelmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagementsystem.bean.AdminUserBean;
import com.capgemini.hotelmanagementsystem.bean.UserInfoBean;

@Repository
public class AdminUserDAOImplementation implements AdminUserDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public AdminUserBean login(String userEmail, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password   ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userEmail", userEmail);
		query.setParameter("password", password);
		AdminUserBean adminUserBean=null;
		try {
			adminUserBean = (AdminUserBean) query.getSingleResult();
			System.out.println(" login successfully");
		} catch (Exception e) {
			System.out.println("Not logged in");
		}
		
		return adminUserBean;

	}

//	@Override
//	public AdminUserBean managerLogin(String userEmail, String password) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password  and userType='manager' ";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter("userEmail", userEmail);
//		query.setParameter("password", password);
//		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
//		System.out.println(" manager login successfully");
//		return adminUserBean;
//	}
//
//	@Override
//	public AdminUserBean userLogin(String userEmail, String password) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password and userType='user' ";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter("userEmail", userEmail);
//		query.setParameter("password", password);
//		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
//		System.out.println(" user login successfully");
//		return adminUserBean;
//	}
//
//	@Override
//	public AdminUserBean employeeLogin(String userEmail, String password) {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password  and userType='employee' ";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter("userEmail", userEmail);
//		query.setParameter("password", password);
//		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
//		System.out.println(" employee login success");
//		return adminUserBean;
//	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		boolean isRegister = false;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(adminUserBean);
			System.out.println("Register Successfully!!!");
			System.out.println("***Now Login To Use Our Online Facilities***");
			entityTransaction.commit();
			isRegister = true;
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return isRegister;
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		List<AdminUserBean> userList = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType = "user";
			String jpql = "FROM AdminUserBean where userType=:userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			userList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Fetch All Users");
		}
		return userList;
		// End of showAllUsers()
	}

	@Override
	public List<AdminUserBean> getAllEmployee() {
		List<AdminUserBean> employeeList = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType = "employee";
			String jpql = "FROM AdminUserBean where userType=:userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			employeeList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Fetch All employeeList");
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int userId) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where userId =: userId ";
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
			entityTransaction.commit();
			System.out.println("Employee Deleted Successfully");
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Delete Employee!!!");
		}
		return isRemove;
	}

	@Override
	public boolean deleteUser(int userId) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where userId =: userId ";
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
			entityTransaction.commit();
			System.out.println("customer Deleted Successfully");
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Delete customer!!!");
		}
		return isRemove;
	}

	@Override
	public boolean userProfile(UserInfoBean userInfoBean) {

		boolean isUpdate = false;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(userInfoBean);
			entityTransaction.commit();
			isUpdate = true;
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return isUpdate;
	}


}
