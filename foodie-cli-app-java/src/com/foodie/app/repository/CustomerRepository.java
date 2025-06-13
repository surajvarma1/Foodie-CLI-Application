package com.foodie.app.repository;

import java.util.List;
import java.util.Optional;

import com.foodie.app.model.Customer;
import com.foodie.app.util.CsvReader;
import com.foodie.app.util.Factory;

public class CustomerRepository {
	private List<Customer> customersList;

	public CustomerRepository() {
		
		this.customersList = Factory.getCsvReader().readcustomersFromCsv();
	}
	public List<Customer> getAllCustomers(){
		return this.customersList;
	}
	public Customer save(Customer customer) {
		this.customersList.add(customer);
		return customer;
	}
	public Optional<Customer> findCustomerById(String id){
		return this.customersList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
	}

}
