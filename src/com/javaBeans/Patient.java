package com.javaBeans;

import java.util.ArrayList;

public class Patient extends User{

	private ArrayList<Appointment> appointmentList;
	//private DossierMedical dossier;
	
	public Patient(int id, String firstName, String lastName, String phone,String specialty ,String email, String password) {
		super(id,firstName,lastName,phone,email, password);
		appointmentList=new ArrayList<Appointment>();
		
		
	}

	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
