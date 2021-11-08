package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.SavingsAccount;
import com.cognixia.jump.utility.ConsolePrinter;

public class DollarsBankController {
	
	public static void main(String[] args) {
		
		ConsolePrinter cp = new ConsolePrinter();
		Scanner input = new Scanner(System.in);
		ArrayList<Customer> customers = new ArrayList<>();
		Customer customer = null;
		
		boolean keepGoing = true;
		boolean user = false;
		
		while(keepGoing) {//------------------------------------------------------------------
			if(!user) {
				
				
				cp.print("\n--------- DOLLARSBANK Welomes You! ---------");
				cp.print("1. Create New Account");
				cp.print("2. Login");
				cp.print("3. Exit");
				cp.print("\nEnter Choice (1,2, or 3)");
				String choice = input.nextLine();
				

				switch(choice) {
				case "1":
					cp.print("\n--------- Enter Details For New Account -----------");
					cp.print("Customer Name: ");
					String name = input.nextLine();
					cp.print("Customer Username: ");
					String username = input.nextLine();
					cp.print("Password : 8 Characters with Lower, Upper & Special");
					String password = input.nextLine();
					cp.print("Initial Deposit Amount");
					Double initialBalance = input.nextDouble();
					customers.add(new Customer(name, username, password, initialBalance));
					break;
					
				case "2":
					cp.print("\n--------- Enter Login Details -----------");
					cp.print("Username: ");
					username = input.nextLine();
					cp.print("Password: ");
					password = input.nextLine();
					// Check the credentials and leave the Login while loop
					for(Customer c: customers) {
						if( c.getUsername().equals(username) && 
							c.getPassword().equals(password) ) {
							
							customer = c;
							user = true;
						}else {
							cp.print("Invalid Credentials. Try Again!");
						}
					}
					break;
					
				case "3":
					cp.print("GoodBye!");
					keepGoing = false;
					break;
				default:
					cp.print("Please enter the number of your choice only");
				}
				
				
			}else {
				
				cp.print("\n--------- Welcome " + customer.getUsername() + " ----------" );
				cp.print("1. Deposit Amount");
				cp.print("2. Withdraw Amount");
				cp.print("3. Funds Transfer");
				cp.print("4. View 5 Recent Transactions");
				cp.print("5. Display Customer Information");
				cp.print("6. Sign Out");
				cp.print("\nEnter Choice (1,2,3,4,5, or 6)");
				String choice = input.nextLine();
				
				switch(choice) {
				case "1":
					cp.print("\n--------- Deposit Amount ---------");
					cp.print("Which Account are you depositing into: ");
					Integer id = input.nextInt();
					cp.print("How much would you like to deposit: ");
					Double amount = input.nextDouble();
					if(customer.getAccountById(id) != null) {
						SavingsAccount account = (SavingsAccount)customer.getAccountById(id);
						account.deposit(amount);
					}
					break;
				case "2":
					cp.print("\n-------- Withdraw Amount ---------");
					cp.print("Which Account are you depositing into: ");
					id = input.nextInt();
					cp.print("How much would you like to withdraw: ");
					amount = input.nextDouble();
					if(customer.getAccountById(id) != null) {
						SavingsAccount account = (SavingsAccount)customer.getAccountById(id);
						if(account.getBalance() - amount > 0) {
							account.withdraw(amount);
						}
					}
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					cp.print("\n-------- " + customer.getPassword() + " Info ---------");
					cp.print("Name: " + customer.getName());
					cp.print("Username: " + customer.getUsername());
					cp.print("Password: " + customer.getPassword());
//					for(Account a: customer.getAccounts()) {
//						a = (SavingsAccount)a;
//						cp.print("type: " + a.);
//					}
					break;
				case "6":
					cp.print("Signing Out...");
					user = false;
					customer = null;
					break;
				default:
					cp.print("Please enter the number of your choice only");
				}
			}
			
		}// End of while loop----------------------------------------------------------------
		
		input.close();
	}
	
}
