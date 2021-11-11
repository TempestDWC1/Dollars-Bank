package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.SavingsAccount;
import com.cognixia.jump.utility.ConsolePrinter;
import com.cognixia.jump.utility.DataGenerator;

public class DollarsBankController {
	
	public static void main(String[] args) {
		// ConsolePrinter is just to make System.out.println more compact
		ConsolePrinter cp = new ConsolePrinter();
		Scanner input = new Scanner(System.in);
		// in program memory for customers
		ArrayList<Customer> customers = new ArrayList<>();
		// current logged in customer
		Customer customer = null;
		// list of transactions
		ArrayList<String> transactions = new ArrayList<>();
		
		boolean keepGoing = true;
		boolean user = false;
		
		// set up testingdata
		customers = DataGenerator.testingDataList();
		
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
					Float initialBalance = input.nextFloat();
					customers.add(new Customer(name, username, password, initialBalance));
					transactions.add("Initial Deposit: " + initialBalance + " Date: " + new Date());
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
							break;
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
				
				// check the total transactions do not extend 5
				if(transactions.size() > 5) {
					transactions.remove(0);
				}
				
				switch(choice) {
				case "1":
					cp.print("\n--------- Deposit Amount ---------");
					cp.print("How much would you like to deposit: ");
					Float amount = input.nextFloat();
					if(customer.getAccount() != null) {
						SavingsAccount account = customer.getAccount();
						account.deposit(amount);
						transactions.add("Deposit: " + amount + " Date: " + new Date());
					}
					break;
					
				case "2":
					cp.print("\n-------- Withdraw Amount ---------");
					cp.print("How much would you like to withdraw: ");
					amount = input.nextFloat();
					if(customer.getAccount() != null) {
						SavingsAccount account = customer.getAccount();
						if(account.getBalance() - amount > 0) {
							account.withdraw(amount);
							transactions.add("Withdraw: " + amount + " Date: " + new Date());
						}else {
							cp.print("Transaction cancelled: Improper funds");
						}
					}
					break;
					
				case "3":
					cp.print("\n-------- Transfer Funds --------");
					try {
						cp.print("What is the username of the account you wish to transfer funds too?");
						String transferTarget = input.next();
						cp.print("How much are you transfering?");
						amount = input.nextFloat();
						if(customer.getAccount() != null) {
							SavingsAccount account = customer.getAccount();
							if(account.getBalance() - amount > 0) {
								for(Customer c: customers) {
									if( c.getUsername().equals(transferTarget) ) {
										c.getAccount().deposit(amount);
										customer.getAccount().withdraw(amount);
										transactions.add("Transfer amount: " + amount + " Transfer Receiver: " + c.getUsername() +" Date: " + new Date());
										break;
									}
								}
								cp.print("Unable to find account holder, cancelling transfer");
							}else {
								cp.print("Transaction cancelled: Improper funds");
							}
							
						}
					}catch(Exception e) {
						
					}
					break;
					
				case "4":
					cp.print("\n--------- 5 Recent Transactions --------");
					for(String transaction: transactions) {
						cp.print(transaction);
					}
					break;
					
				case "5":
					cp.print("\n-------- " + customer.getUsername() + " Info ---------");
					cp.print("Name: \t\t" + customer.getName());
					cp.print("Username: \t" + customer.getUsername());
					cp.print("Password: \t" + customer.getPassword());
					cp.print("Account ID: \t" + customer.getAccount().getId());
					cp.print("Type: \t\t" + customer.getAccount().type());
					cp.print("Balance: \t" + customer.getAccount().getBalance());
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
