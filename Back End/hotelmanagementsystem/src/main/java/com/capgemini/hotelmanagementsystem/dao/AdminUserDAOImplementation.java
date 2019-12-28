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
import com.capgemini.hotelmanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.hotelmanagementsystem.exception.FetchNullListException;
import com.capgemini.hotelmanagementsystem.exception.InvalidLoginCredentials;
import com.capgemini.hotelmanagementsystem.exception.InvalidPasswordException;
import com.capgemini.hotelmanagementsystem.exception.UnableDeleteException;
import com.capgemini.hotelmanagementsystem.exception.UnableRegisterException;
import com.capgemini.hotelmanagementsystem.exception.UnableToUpdateException;

@Repository
public class AdminUserDAOImplementation implements AdminUserDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public AdminUserBean login(String userEmail, String password) {
		AdminUserBean adminUserBean = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from AdminUserBean where userEmail = :userEmail and password = :password   ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userEmail", userEmail);
			query.setParameter("password", password);
			adminUserBean = (AdminUserBean) query.getSingleResult();

		} catch (Exception e) {
			throw new InvalidLoginCredentials();
		}
		return adminUserBean;
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean){
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
			System.out.println("Exception");
			throw new UnableRegisterException();
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

			throw new FetchNullListException();
		}
		return userList;
		// End of showAllUsers()
	}

	@Override
	public List<AdminUserBean> getAllEmployee(){
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

			throw new FetchNullListException();
		}
		return employeeList;
	}

	@Override
	public boolean deleteEmployee(int userId){
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where userId =: userId ";
//			entityTransaction = entityManager.getTransaction();
//			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
//			entityTransaction.commit();
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {

			throw new UnableDeleteException();
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
//			entityTransaction = entityManager.getTransaction();
//			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
//			entityTransaction.commit();
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {
			throw new UnableDeleteException();
		}
		return isRemove;
	}

	@Override
	public boolean userProfile(int userId, long phoneNumber, String address, String nationality) {

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
			 throw new UnableToUpdateException();
		}
		return isUpdate;
	}

	@Override
	public List<UserInfoBean> displayUserProfile(int userId){
		List<UserInfoBean> displayUserProfile = null;
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		String jpql = "from UserInfoBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		try {
			query.setParameter("userId", userId);
			displayUserProfile =(List<UserInfoBean>) query.getSingleResult();
		} catch (Exception e) {
			 throw new FetchNullListException();
		}
		return displayUserProfile;
	}

	@Override
	public boolean emailPresent(String email) {
		entityManager = entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM AdminUserBean";
			Query query = entityManager.createQuery(jpql);
			List<AdminUserBean> userList = (List<AdminUserBean>) query.getResultList();
			for (AdminUserBean userBean : userList) {
				if (email.equals(userBean.getUserEmail())) {
					unique = true;
					return unique;
				}
			}	
		} catch (Exception e) {
			throw new EmailAlreadyExistException();
		}
		return unique;
	
	}
	
	@Override
	public boolean passwordChecker(String userEmail,String password) {
		entityManager = entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM AdminUserBean where userEmail=:userEmail";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userEmail", userEmail);
			AdminUserBean userList = (AdminUserBean) query.getSingleResult();
				if (password.equals(userList.getPassword())) {
					unique = true;
					return unique;
			}
			
		} catch (Exception e) {
			throw new InvalidPasswordException();
		}
		return unique;
	
	}

	@Override
	public List<AdminUserBean> managerList() {
		
		List<AdminUserBean> managerList = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String userType="manager";
			String jpql = "FROM AdminUserBean  where userType =: userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
		
			managerList = query.getResultList();
			entityManager.close();

		} catch (Exception e) {
			throw new FetchNullListException();
		}
		return managerList;
	}

	@Override
	public boolean deleteManager(int userId){
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hotelManagementSystem");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where userId =: userId";
//			entityTransaction = entityManager.getTransaction();
//			entityTransaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
//			entityTransaction.commit();
			System.out.println("Manager Deleted Successfully");
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {

			throw new UnableDeleteException();
		}
		return isRemove;
	}

	

}
