package com.javaBeans;

public class Consultation {
	private int id_consultation;
	private String motif;
	private String consulationDate;
	private double price;
	private Prescription prescription;
	private Patient patient;
	
	 public Consultation(){
		
	 }

	public int getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(int id_consultation) {
		this.id_consultation = id_consultation;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getConsulationDate() {
		return consulationDate;
	}

	public void setConsulationDate(String consulationDate) {
		this.consulationDate = consulationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	 
	
	
	

}
