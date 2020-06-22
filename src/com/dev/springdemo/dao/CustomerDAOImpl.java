package com.dev.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session ses=sessionfactory.getCurrentSession();
		Query<Customer> query=ses.createQuery("from Customer order by firstName",Customer.class);
		List<Customer> customers=query.getResultList();
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		Session ses=sessionfactory.getCurrentSession();
		ses.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomers(int theID) {
		Session ses=sessionfactory.getCurrentSession();
		Customer c1=ses.get(Customer.class, theID);
		return c1;
	}


	@Override
	public void deleteCustomer(int theID) {
		Session ses=sessionfactory.getCurrentSession();
		Customer c1=ses.get(Customer.class, theID);
		ses.delete(c1);
		
	}

}
