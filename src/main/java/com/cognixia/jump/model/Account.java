package com.cognixia.jump.model;

/*
 * Account interface that will force all accounts to have
 * the basic functionality of a bank account
 */

public abstract class Account {
	
	Integer idCounter = 0;
	
	protected Integer getId() {
		return idCounter++;
	}

	public abstract void deposit(Double amount);
	
	public abstract void withdraw(Double amount);
	
}
