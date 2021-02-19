package com.javaBeans;

import java.sql.Date;
import java.util.ArrayList;

public class Prescription {
	private int id;
	private String title;
	private Date dateOfPresc;
	private String description;
	private ArrayList<Medication> medicationList;
	
	public Prescription(int id, String title, Date dateOfPresc, String description,
			ArrayList<Medication> medicationList) {
		super();
		this.id = id;
		this.title = title;
		this.dateOfPresc = dateOfPresc;
		this.description = description;
		this.medicationList = medicationList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateOfPresc() {
		return dateOfPresc;
	}

	public void setDateOfPresc(Date dateOfPresc) {
		this.dateOfPresc = dateOfPresc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(ArrayList<Medication> medicationList) {
		this.medicationList = medicationList;
	}


}
