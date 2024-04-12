package com.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entities.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public boolean addUser(User user) {
		// System.out.println(firstName + " " + lastName + " " + email + " " +
		// password);

		// User user = new User(null, firstName, lastName, email, password);

		Serializable saveUser = userDao.saveUser(user);
		return saveUser != null ? true : false;
	}

	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	public Boolean deleteUsers(Integer userId) {
		Boolean isdeleted = false;

		try {
			userDao.deleteUsers(userId);
			isdeleted = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return isdeleted;
	}

	public User updateUsers(Integer userId) {

		return userDao.getUser(userId);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);

	}

}
