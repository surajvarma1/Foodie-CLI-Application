package com.foodie.app.service;

import java.util.Optional;

import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.model.Customer;
import com.foodie.app.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;
	
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}







	@Override
	public Customer save(Customer customer) throws CustomerExistException {
		// TODO Auto-generated method stub
		Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
		if(customerById.isPresent())
			throw new CustomerExistException("Customeralready exist with this id : " + customer.getCustomerId());
		return this.customerRepository.save(customer);
	} 
	

}
