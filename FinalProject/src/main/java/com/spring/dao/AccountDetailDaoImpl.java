package com.spring.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.AccountDetail;
import com.spring.model.UserPass;


@Repository
@Transactional
public class AccountDetailDaoImpl implements AccountDetailDao {
	
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
	public void createaccount(AccountDetail accountdetail) {
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(accountdetail);
			tx.commit();
			System.out.println("Account Created");
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public AccountDetail getaccountinfo(long accountnumber) {
		try {
			Session session = getSession();
			AccountDetail accountdetail =session.byId(AccountDetail.class).load(accountnumber);
			return accountdetail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateaccountname(long accountnumber, String name) {
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			AccountDetail accountdetail =session.byId(AccountDetail.class).load(accountnumber);
			accountdetail.setName(name);
			session.save(accountdetail);
			tx.commit();
			System.out.println("Account updated");
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public float getaccbalance(long accountnumber) {
		try {
			Session session = getSession();
			
			AccountDetail accountdetail =session.byId(AccountDetail.class).load(accountnumber);
			System.out.println("Inside getaccbal");
			System.out.println(accountdetail.getAccountnumber());
			System.out.println(accountdetail.getAcctype());
			System.out.println(accountdetail.getBalance());
			return accountdetail.getBalance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateaccbalance(long accountnumber, float balance) {
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			AccountDetail accountdetail =session.byId(AccountDetail.class).load(accountnumber);
			accountdetail.setBalance(balance);
			System.out.println("Inside updateaccbal");
			System.out.println(accountdetail.getAccountnumber());
			System.out.println(accountdetail.getAcctype());
			System.out.println(accountdetail.getBalance());
			session.save(accountdetail);
			tx.commit();
			System.out.println("Balance updated");
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
