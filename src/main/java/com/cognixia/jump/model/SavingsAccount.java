package com.cognixia.jump.model;

public class SavingsAccount extends Account{

	private Integer id;
	private String type = "Savings";
	private Double balance;
	private Customer customer;
	
	public SavingsAccount(Double balance, Customer customer) {
		super();
		this.id = super.getId();
		this.balance = balance;
		this.customer = customer;
	}

	
	@Override
	public void deposit(int amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(int amount) {
		this.balance -= amount;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
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
