package com.javaBeans;

public class Medication {
	private int id;
    private String title;
    private String description;
    private String dosage;
    
    
	public Medication() {
		
	}


	public Medication(int id, String title, String description, String dosage) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dosage = dosage;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDosage() {
		return dosage;
	}


	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	
    
    
    
    

}
