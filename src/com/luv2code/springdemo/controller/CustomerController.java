package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject CustomerDAO
		@Autowired
		private CustomerDAO customerDAO;

		@RequestMapping("/list")
		public String listCustomer(Model theModel) {
			List<Customer> theCustomers=customerDAO.getCustomers();
			
			theModel.addAttribute("customers",theCustomers);
			return "list-customers";
		}
}
