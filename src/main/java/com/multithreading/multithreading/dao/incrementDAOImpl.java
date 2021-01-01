package com.multithreading.multithreading.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.multithreading.multithreading.entity.number;

@Repository
public class incrementDAOImpl implements incrementDAOInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	// @Async
	public synchronized String increment() {
		
		System.out.println("Inside increment() method");
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query curr_number = entityManager.createQuery("select n.number from number n", Integer.class);

		Object singleResult2 = curr_number.getSingleResult();

		// System.out.println("number id DB: " + singleResult2);

		Query updateQuery = entityManager.createQuery("update number set number=:curr_number");
		updateQuery.setParameter("curr_number", (int) singleResult2 + 1);
		updateQuery.executeUpdate();
		
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Query theQuery = entityManager.createQuery("select n.number from number n", Integer.class);

		// execute query and get result list
		Object singleResult = theQuery.getSingleResult();

		System.out.println("Current Value: " + singleResult);

		return singleResult.toString();

	}

	@Override
	// @Async
	public synchronized int check() {
		
		System.out.println("Inside check() method");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		Query curr_number = entityManager.createQuery("select n.number from number n", Integer.class);

		Object singleResult2 = curr_number.getSingleResult();

		// System.out.println("number id DB: " + singleResult2);

		return (int) singleResult2;
	}

}
