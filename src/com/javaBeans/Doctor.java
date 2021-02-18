package com.javaBeans;

public class Doctor extends User {
	private String specialty;

	public Doctor(int id, String firstName, String lastName, String phone,String specialty ,String email, String password) {
		super(id, firstName, lastName, phone, email, password);
		this.specialty=specialty;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
}
