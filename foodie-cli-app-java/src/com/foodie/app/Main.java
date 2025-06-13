package com.foodie.app;

import com.foodie.app.ui.Menu;
//import com.foodie.app.util.CsvReader;

public class Main {
	public static void main(String[] args) {
		/*CsvReader csvreader = new CsvReader();
		System.out.println(csvreader.readcustomersFromCsv());
	*/
		/*CustomerRepository customerRepository = new CustomerRepository();
		System.out.println(customerRepository.getAllCustomers());*/
		Menu menu = new Menu();
		menu.displayMenu();
	}

}
