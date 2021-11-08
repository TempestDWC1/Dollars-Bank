package com.cognixia.jump.controller;

import java.util.Scanner;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.utility.ConsolePrinter;

public class DollarsBankController {
	
	public static void main(String[] args) {
		
		ConsolePrinter cp = new ConsolePrinter();
		Scanner input = new Scanner(System.in);
		
		boolean keepGoing = true;
		boolean user = false;
		
		while(keepGoing && !user) {//---------------------------------
			cp.print("--------- DOLLARSBANK Welomes You! ---------");
			cp.print("1. Create New Account");
			cp.print("2. Login");
			cp.print("3. Exit");
			cp.print("/nEnter Choice (1,2, or 3)");
			String choice = input.nextLine();
			
			switch(choice) {
			case "1":
				cp.print("--------- Enter Details For New Account -----------");
				cp.print("Customer Name: ");
				String name = input.nextLine();
				cp.print("Customer Username: ");
				String username = input.nextLine();
				cp.print("Password : 8 Characters with Lower, Upper & Special");
				String password = input.nextLine();
				cp.print("Initial Deposit Amount");
				Double initialBalance = input.nextDouble();
				new Customer(name, username, password, initialBalance);
				break;
			case "2":
				break;
			case "3":
				keepGoing = false;
				break;
			default:
				cp.print("Please enter the number of your choice only");
			}
		}// End of customer create/login while loop------------------------
		
		input.close();
	}
	
}
