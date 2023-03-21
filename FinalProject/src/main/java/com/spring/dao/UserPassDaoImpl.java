package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.UserPass;

@Repository
@Transactional
public class UserPassDaoImpl implements UserPassDao {

	@Autowired
	public SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(UserPass userpass) {
		try {
			System.out.println("Inside adduser ");
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(userpass);
			tx.commit();
			session.close();
			System.out.println("User added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserPass getUserinfo(String username) {
		try {
			Session session = getSession();
			UserPass userpass = session.byId(UserPass.class).load(username);
			return userpass;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
