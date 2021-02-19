package com.javaBeans;

import java.util.ArrayList;

public class Patient extends User{

	private ArrayList<Appointment> appointmentList;
	private MedicalFile medicalFile;
	
	public Patient(int id,String cin,String firstName, String lastName, String phone,String specialty ,String email, String password) {
		super(id,cin,firstName,lastName,phone,email, password);
		appointmentList=new ArrayList<Appointment>();
		
		
	}

	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public MedicalFile getMedicalFile() {
		return medicalFile;
	}

	public void setMedicalFile(MedicalFile medicalFile) {
		this.medicalFile = medicalFile;
	}

}
