package com.cognixia.jump.model;

public class Customer {

	private Integer id;
	private String name;
	private String username;
	private String password;
	// this allows for any object that is/extends Account
	// so both my savings and checking accounts can implement Account
	// and be put into the list of customer accounts
	SavingsAccount account;
	
	private static Integer idCounter = 0;
	
	public Customer(String name, String username, String password, Float balance) {
		super();
		this.id = idCounter++;
		this.name = name;
		this.username = username;
		this.password = password;
		this.account = new SavingsAccount(balance, this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SavingsAccount getAccount() {
		return account;
	}
	
	
}
