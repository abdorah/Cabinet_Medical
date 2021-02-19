package com.javaBeans;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Date dateofChecking;
    private Date dateofAppointment;
    private String reason;
    private String typeofIllness;
    private int id_patient;
    private boolean notification;
    
    public Appointment(Date dateofAppointment, String reason, String typeofIllness, int id_patient,
			boolean notification) {
    	
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        
		try {
			this.dateofChecking = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}  ;
		
		this.dateofAppointment = dateofAppointment;
		this.reason = reason;
		this.typeofIllness = typeofIllness;
		this.id_patient = id_patient;
		this.notification = notification;
	}
    
    public int getId() {
        return id;
    }
	public Date getDateofChecking() {
        return dateofChecking;
    }
    public void setDateofChecking(Date dateofChecking) {
        this.dateofChecking = dateofChecking;
    }
    public Date getDateofAppointment() {
        return dateofAppointment;
    }
    public void setDateofAppointment(Date dateofAppointment) {
        this.dateofAppointment = dateofAppointment;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getTypeofIllness() {
        return typeofIllness;
    }
    public void setTypeofIllness(String typeofIllness) {
		this.typeofIllness = typeofIllness;
	}
	public int getPatient() {
        return id_patient;
    }
    public void setPatient(int patient) {
        this.id_patient = patient;
    }
    public boolean isNotification() {
        return notification;
    }
    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}