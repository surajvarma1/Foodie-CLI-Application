package com.foodie.app.service;

import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.model.Customer;

public interface CustomerService {
	public Customer save(Customer customer) throws CustomerExistException;
	

	
}
