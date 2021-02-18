package com.javaBeans;

import java.util.ArrayList;

public class MedicalFile {
	private int id;
	private Patient patient;
	private ArrayList<Consultation> consultationList;
	
	
	public MedicalFile(int id, Patient patient, ArrayList<Consultation> consultationList) {
		this.id = id;
		this.patient = patient;
		this.consultationList = consultationList;
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
	
	

}
