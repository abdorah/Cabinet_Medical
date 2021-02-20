package com.javaBeans;

public class Patient extends User{
	
	private String BirthDate;
	private String sex;
	private MedicalFile medicalFile;
	
	public Patient() {
		
	}
	
	public Patient(int id,String cin,String firstName, String lastName, String phone,String specialty ,String email, String password) {
		super(id,cin,firstName,lastName,phone,email, password);
			
	}

	public MedicalFile getMedicalFile() {
		return medicalFile;
	}

	public void setMedicalFile(MedicalFile medicalFile) {
		this.medicalFile = medicalFile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

}
