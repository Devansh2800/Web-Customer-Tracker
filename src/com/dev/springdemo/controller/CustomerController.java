package com.dev.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.springdemo.entity.Customer;
import com.dev.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customers=customerservice.getCustomers();
		
		theModel.addAttribute("customer", customers);
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer thecustomer=new Customer();
		theModel.addAttribute("customer",thecustomer);
		return "Add-Customer";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerservice.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theID,Model theModel) {
		Customer theCustomer =customerservice.getCustomers(theID);
		theModel.addAttribute("customer",theCustomer);
		return "Add-Customer";

	}
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerID") int theID,Model theModel) {
		customerservice.deleteCustomer(theID);
		
		return "redirect:/customer/list";
	}

}
