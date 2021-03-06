package com.wct.springdemo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wct.springdemo.Dao.CustomerDao;
import com.wct.springdemo.entity.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		 
		return customerDao.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		 customerDao.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDao.getCustomer(theId);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		return customerDao.searchCustomers(theSearchName);
	}


}
