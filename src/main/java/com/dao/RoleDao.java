package com.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.entities.Roles;
import com.util.HibernateUtil;

@Repository
public class RoleDao {

	public Roles save(Roles role) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = sessionFactory.openSession();

		Transaction beginTransaction = openSession.beginTransaction();

		openSession.saveOrUpdate(role);
		beginTransaction.commit();
		openSession.close();
		System.out.println(role);
		return role;
	}

}
