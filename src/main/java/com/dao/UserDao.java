package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entities.User;
import com.util.HibernateUtil;

@Repository
public class UserDao {

	public Serializable saveUser(User user) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();

		Transaction beginTransaction = openSession.beginTransaction();

		Serializable save = openSession.save(user);
		beginTransaction.commit();
		openSession.close();
		System.out.println(user);
		return save;
	}

	public List<User> getAllUsers() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();

		List<User> list = openSession.createQuery("from User", User.class).list();
		return list;
	}

	public void deleteUsers(Integer userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.delete(new User(userId));
		beginTransaction.commit();
		openSession.close();
	}

	public User getUser(Integer userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();

		return openSession.get(User.class, userId);
	}

	public void updateUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.saveOrUpdate(user);
		beginTransaction.commit();
	}

}
