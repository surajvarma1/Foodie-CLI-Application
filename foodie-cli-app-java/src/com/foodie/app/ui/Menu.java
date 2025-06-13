package com.foodie.app.ui;

import java.util.List;
import java.util.Scanner;

import com.foodie.app.controller.CustomerController;
import com.foodie.app.controller.DishController;
import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.model.Customer;
import com.foodie.app.model.Dish;
import com.foodie.app.util.Factory;

public class Menu {
  /*  public Menu() {

    }

    public void displayMenuHeader(String header){
        printDashLine();
        String spaces = new String(new char[70]).replace('\0',' ');
        System.out.printf("%-40s %-10s %-40s \n",spaces,header,spaces);
        printDashLine();
    }

    public  void printDashLine(){
        String dashLines = new String(new char[150]).replace('\0','-');
        System.out.println(dashLines);
    }*/

    public void displayMenu(){
          
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select the option..!");
                System.out.println("---------------------------");
                System.out.println("1. Customer Section");
                System.out.println("2. Restaurant Section");
                System.out.println("3. Dishes Section");
                System.out.println("4. Order Section");
                System.out.println("5. Exit");
                System.out.println("Please Enter Your Choice 1 - 7");

                int input = scanner.nextInt();
                switch (input){
                    case 1:
                	    displayRegisterMenu();
                	    break;
                    case 3:
                    	displayDishesList();
                    	break;
                    case 5 : 
                        System.out.println("Thanks for choosing Foodie App,See you again..!");
                        System.exit(0);
                    default:
                    	System.out.println("Invalid Input.Please enter valid input from 1 - 5");
                }
            }
          }
        private void displayDishesList() {
        	DishController dishController = Factory.getDishController();
        	//System.out.println(dishController.getDishesList());
            List<Dish> dishesList = dishController.getDishesList();
            String dashesLine = new String(new char[150]).replace('\0', '-');
            displayMenuHeader("Dish Items");
            System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
            System.out.println(dashesLine);
            dishesList.forEach(dish -> {
                System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
            });
		
}
		private void displayMenuHeader(String menuHeader) {
			 String dashesLine = new String(new char[150]).replace('\0', '-');
			 System.out.println(dashesLine);
			 String spaces = new String(new char[70]).replace('\0', ' ');
		     System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
		     System.out.println(dashesLine);
			
		}
		private void displayRegisterMenu() {
        	 Scanner scanner = new Scanner(System.in);
             System.out.println("Please Update entering the following details\n");
             System.out.println("Enter Your Id");
             String id = scanner.nextLine();
             System.out.println("Enter Name");
             String name = scanner.nextLine();
             System.out.println("Enter E-mail");
             String email = scanner.nextLine();
             System.out.println("Enter Password");
             String password = scanner.nextLine();
             Customer customer = new Customer();
             customer.setId(id)
                     .setName(name)
                     .setEmail(email)
                     .setPassword(password);
             
             CustomerController customerController = Factory.getCustomerController();
             try {
            	 Customer savedCustomer = customerController.save(customer);
            	 if(savedCustomer != null) {
                 System.out.println("Customer Registration Successful");
                 System.out.println("Details:");
                 System.out.println("Id : " + customer.getCustomerId());
                 System.out.println("Name: " + customer.getName());
                 System.out.println("E-mail: " + customer.getEmail());
                 System.out.println("Password: " + customer.getPassword());
            	 }else {
            		 System.out.println("Some internal error occured , please try again");
            		 displayRegisterMenu();
            	 }
                 
             }catch (CustomerExistException e) {
            	 System.out.println(e.getMessage());
            	 System.out.println("please login using main menu");
            	 displayMenu();
             }
        }

           
               

    
	

}
