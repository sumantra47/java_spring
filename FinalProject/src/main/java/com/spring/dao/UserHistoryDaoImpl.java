package com.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.UserHistory;
import com.spring.model.UserTrx;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class UserHistoryDaoImpl implements UserHistoryDao {
	
	
	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.openSession();
	} 

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addtrx(UserHistory userhistory) {
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(userhistory);
			tx.commit();
			System.out.println("Trx Created");
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UserHistory> gettalltrx(UserTrx useTrx) {
		Session session = getSession();
		System.out.println(useTrx.getAccountnumber());
		System.out.println(useTrx.getBegindate());
		System.out.println(useTrx.getEnddate());
		Transaction tx = session.beginTransaction();
		Query query=session.createQuery("from UserHistory where accountdetail.accountnumber=:accnum and trxdate between :start and :end");  
		query.setParameter("accnum", useTrx.getAccountnumber());
		query.setParameter("start", useTrx.getBegindate());
		query.setParameter("end", useTrx.getEnddate());
		System.out.println("Inside UserHistory");
		List<UserHistory> uhist = query.list();
		for(UserHistory user:uhist) {
			System.out.println(user);
		}
		return uhist;
	}

}
