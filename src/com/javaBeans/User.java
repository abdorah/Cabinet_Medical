package com.javaBeans;

public class User {
	
	private int id_user;
	private String cin;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private String accountType;
	
	public User() {
		super();
	}
	
	public User(int id_user,String cin,String firstName,String lastName,String phone,String email,String password) {
		this.id_user=id_user;
		this.cin=cin;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		this.email=email;
		this.password=password;
		
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id) {
		this.id_user = id;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
