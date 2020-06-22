package com.dev.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.springdemo.dao.CustomerDAO;
import com.dev.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theID) {
		return customerDAO.getCustomers(theID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theID) {
		customerDAO.deleteCustomer(theID);
	}

}
