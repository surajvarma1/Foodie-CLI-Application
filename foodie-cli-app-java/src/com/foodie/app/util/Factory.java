package com.foodie.app.util;

import com.foodie.app.controller.CustomerController;
import com.foodie.app.controller.DishController;
import com.foodie.app.repository.CustomerRepository;
import com.foodie.app.repository.DishRepository;
import com.foodie.app.service.CustomerServiceImpl;
import com.foodie.app.service.DishServiceImpl;

public class Factory {
	public static CustomerRepository getCustomerRepository() {
		return new CustomerRepository();
		}
		public static CustomerServiceImpl getCustomerService() {
			return new CustomerServiceImpl(getCustomerRepository());
		}
		public static CustomerController getCustomerController() {
			return new CustomerController(getCustomerService());
		}
		public static CsvReader getCsvReader() {
			return new CsvReader();
		}
		public static DishRepository getDishRepository() {
			return new DishRepository();
		}
		public static DishServiceImpl getDishService() {
			return new DishServiceImpl(getDishRepository());
		}
		public static DishController getDishController() {
			return new DishController(getDishService());
		}
}
