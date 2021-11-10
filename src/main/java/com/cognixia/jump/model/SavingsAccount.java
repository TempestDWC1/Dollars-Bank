package com.cognixia.jump.model;

public class SavingsAccount extends Account{

	private Integer id;
	private String type = "Savings";
	private Float balance;
	private Customer customer;
	
	public SavingsAccount(Float balance, Customer customer) {
		super();
		this.id = super.getId();
		this.balance = balance;
		this.customer = customer;
	}

	
	@Override
	public void deposit(Float amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(Float amount) {
		this.balance -= amount;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getBalance() {
		return balance;
	}
	
	public String type() {
		return type;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	
}
