package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.services.CustomerService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject CustomerDAO
		@Autowired
		private CustomerService customerService;

		@RequestMapping("/list")
		public String listCustomer(Model theModel) {
			List<Customer> theCustomers=customerService.getCustomers();
			
			theModel.addAttribute("customers",theCustomers);
			return "list-customers";
		}

		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			// create model attribute to bind form data
			
			Customer theCustomer = new Customer();
			theModel.addAttribute("customer",theCustomer);
			
			return "customer-form";
		}
		
}
