package com.javaBeans;

import java.util.ArrayList;

public class MedicalFile {
	private int id;
	private Patient patient;
	private ArrayList<Appointment> appointmentList;
	private ArrayList<Consultation> consultationList;
	
	
	public MedicalFile() {
		setAppointmentList(new ArrayList<Appointment>());
		consultationList = new ArrayList<Consultation>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	

}
