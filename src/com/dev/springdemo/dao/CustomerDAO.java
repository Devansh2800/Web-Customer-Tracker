package com.dev.springdemo.dao;

import java.util.List;

import com.dev.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theID);

	public void deleteCustomer(int theID);
}
