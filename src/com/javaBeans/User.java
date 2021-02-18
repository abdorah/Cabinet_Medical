package com.javaBeans;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	
	public User() {
		
	}
	
	public User(int id,String firstName,String lastName,String phone,String email,String password) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		this.email=email;
		this.password=password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFristName() {
		return firstName;
	}

	public void setFristName(String fristName) {
		this.firstName = fristName;
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
	

}
