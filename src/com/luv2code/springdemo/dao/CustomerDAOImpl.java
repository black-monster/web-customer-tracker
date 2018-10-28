package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		@SuppressWarnings("deprecation")
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		// execute query and get result list
		List<Customer>customers = theQuery.getResultList();
		// return the results
		return customers;
		
	}

}