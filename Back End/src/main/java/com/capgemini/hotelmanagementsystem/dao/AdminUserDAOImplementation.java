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
import com.capgemini.hotelmanagementsystem.exception.HotelManagementSystemExceptionController;

@Repository
public class AdminUserDAOImplementation implements AdminUserDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public AdminUserBean login(String userEmail, String password) throws HotelManagementSystemExceptionController {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password   ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userEmail", userEmail);
			query.setParameter("password", password);
			AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();
			System.out.println(" login successfully");
			return adminUserBean;

		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}

	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) throws HotelManagementSystemExceptionController {
		boolean isRegister = false;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(adminUserBean);
			entityTransaction.commit();
			isRegister = true;
			entityManager.close();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("please enter your correct creatential");
		}
		return isRegister;
	}

	@Override
	public List<AdminUserBean> getAllUsers() throws HotelManagementSystemExceptionController {
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

			throw new HotelManagementSystemExceptionController("Unable To Fetch All Users");
		}
		return userList;
		// End of showAllUsers()
	}

	@Override
	public List<AdminUserBean> getAllEmployee() throws HotelManagementSystemExceptionController {
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

			throw new HotelManagementSystemExceptionController("Unable To Fetch All employeeList");
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int userId) throws HotelManagementSystemExceptionController {
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

			throw new HotelManagementSystemExceptionController("Unable To Delete Employee!!!");
		}
		return isRemove;
	}

	@Override
	public boolean deleteUser(int userId) throws HotelManagementSystemExceptionController {
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
			throw new HotelManagementSystemExceptionController(
					"Unable To Delete customer!!!  May be your is not our customer ");
		}
		return isRemove;
	}

	@Override
	public boolean userProfile(int userId, long phoneNumber, String address, String nationality)
			throws HotelManagementSystemExceptionController {

		boolean isUpdate = false;

		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		String jpql = "from AdminUserBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		AdminUserBean adminUserBean = (AdminUserBean) query.getSingleResult();

		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setUserId(userId);
		userInfoBean.setUserName(adminUserBean.getUserName());
		userInfoBean.setUserEmail(adminUserBean.getUserEmail());
		userInfoBean.setPassword(adminUserBean.getPassword());
		userInfoBean.setUserType(adminUserBean.getUserType());
		userInfoBean.setPhoneNumber(phoneNumber);
		userInfoBean.setAddress(address);
		userInfoBean.setNationality(nationality);

		try {
			entityTransaction.begin();
			entityManager.persist(userInfoBean);
			entityTransaction.commit();
			isUpdate = true;
			entityManager.close();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("May be you is not our user please register yourself");
		}
		return isUpdate;
	}

	@Override
	public List<UserInfoBean> displayUserProfile(int userId) throws HotelManagementSystemExceptionController {
		List<UserInfoBean> displayUserProfile = null;
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction(); 
		String jpql = "from UserInfoBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		try {
			entityTransaction.begin();
			query.setParameter("userId", userId);
			entityTransaction.commit();
			displayUserProfile = query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("May be you is not our user please register yourself");
		}
		return displayUserProfile;
	}

	@Override
	public boolean deleteManager(int userId) throws HotelManagementSystemExceptionController {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where userId =: userId";
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
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

	@Override
	public List<AdminUserBean> getAllManager() throws HotelManagementSystemExceptionController {
		List<AdminUserBean> managerList = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType = "manager";
			String jpql = "FROM AdminUserBean where userType=:userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			managerList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			throw new HotelManagementSystemExceptionController("Unable To Fetch All employeeList");
		}
		return managerList;
	}

	@Override
	public List<AdminUserBean> displayUserProfileById(int userId) {
		List<AdminUserBean> displayUserProfile = null;
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction(); 
		String jpql = "from AdminUserBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		try {
			entityTransaction.begin();
			query.setParameter("userId", userId);
			entityTransaction.commit();
			displayUserProfile = query.getResultList();
			entityManager.close();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		return displayUserProfile;
	}

}
