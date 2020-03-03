package com.wct.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wct.springdemo.entity.Customer;
import com.wct.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customerController")
public class CustomerController {
	
	// Injecting CustomerDao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// Get customer from CustomerDao
		List<Customer> customers = customerService.getCustomers();
		 
		// Add those customers to the Spring model
		theModel.addAttribute("theCustomers", customers);
		
		return "list-customers";
		
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer tempCustomer = new Customer();
		theModel.addAttribute("customer", tempCustomer);
		
		return "customer-form";
		
	}
	
	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customerController/list";
		
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
			
	}
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customerController/list";
		
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Customer> customers = customerService.searchCustomers(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("theCustomers", customers);

		return "list-customers";		
	}


	

}
