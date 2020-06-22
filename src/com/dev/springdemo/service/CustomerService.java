package com.dev.springdemo.service;

import java.util.List;

import com.dev.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theID);

	public void deleteCustomer(int theID);
}
