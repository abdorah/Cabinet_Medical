package com.javaBeans;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicalFile {
	private String id;
	private Patient patient;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Consultation> consultationList;
	private HashMap<String,Double> statistiques;
	
	
	public MedicalFile() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public ArrayList<Consultation> getConsultationList() {
		return consultationList;
	}
	public void setConsultationList(ArrayList<Consultation> consultationList) {
		this.consultationList = consultationList;
	}
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public HashMap<String,Double> getStatistiques() {
		return statistiques;
	}
	public void setStatistiques(HashMap<String,Double> statistiques) {
		this.statistiques = statistiques;
	}
	
	

}
