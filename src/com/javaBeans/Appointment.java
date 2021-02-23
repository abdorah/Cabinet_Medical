package com.javaBeans;

public class Appointment {
	private int id_appointment;
	private String dateofChecking;
	private String dateofAppointment;
	private String description;
	private String typeofIllness;
	private boolean notification;
	private Patient patient;

	public Appointment(String dateofAppointment, String description, String typeofIllness, boolean notification,
			Patient patient) {
		this.dateofAppointment = dateofAppointment;
		this.description = description;
		this.typeofIllness = typeofIllness;
		this.notification = notification;
		this.patient = patient;
	}
	public Appointment(int id_appointment,String dateofChecking, String dateofAppointment, String description, String typeofIllness, boolean notification,
			Patient patient) {
		this.id_appointment = id_appointment;
		this.dateofChecking = dateofChecking ;
		this.dateofAppointment = dateofAppointment;
		this.description = description;
		this.typeofIllness = typeofIllness;
		this.notification = notification;
		this.patient = patient;
	}

	public Appointment() {
		
	}

	public int getId_appointment() {
		return id_appointment;
	}

	public void setId_appointment(int id_appointment) {
		this.id_appointment = id_appointment;
	}

	public String getDateofChecking() {
		return dateofChecking;
	}

	public void setDateofChecking(String dateofChecking) {
		this.dateofChecking = dateofChecking;
	}

	public String getDateofAppointment() {
		return dateofAppointment;
	}

	public void setDateofAppointment(String dateofAppointment) {
		this.dateofAppointment = dateofAppointment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeofIllness() {
		return typeofIllness;
	}

	public void setTypeofIllness(String typeofIllness) {
		this.typeofIllness = typeofIllness;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
