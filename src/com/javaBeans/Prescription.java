package com.javaBeans;



public class Prescription {
	private int id_prescription;
	private String title;
	private String dateOfPrescription;
	private String description;
	private String medicationList;
	
	public Prescription() {
		
	}

	public int getId_prescription() {
		return id_prescription;
	}

	public void setId_prescription(int id_prescription) {
		this.id_prescription = id_prescription;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateOfPrescription() {
		return dateOfPrescription;
	}

	public void setDateOfPrescription(String dateOfPrescription) {
		this.dateOfPrescription = dateOfPrescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(String medicationList) {
		this.medicationList = medicationList;
	}

	
	
	

}
