package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
			
			// save the customer using our service
			customerService.saveCustomer(theCustomer);
			
			return "redirect:/customer/list";
		}
		
		
		
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId")int theId,Model theModel) {
			
//			System.out.println(1);
			// get the customer from our service
			Customer theCustomer = customerService.getCustomer(theId);
			// set customer as model attribute to prepopulate the form
			System.out.println(theCustomer);
			theModel.addAttribute("customer",theCustomer);
			//send over to customer-form
			return "customer-form";
		}
		
		@GetMapping("/delete")
		public String deleteCustomer(@RequestParam("customerId")int theId) {
			// delete this customer
			customerService.deleteCustomer(theId);
			return "redirect:/customer/list";
		}
}
