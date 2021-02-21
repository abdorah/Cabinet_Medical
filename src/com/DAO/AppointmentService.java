package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Appointment;


public interface AppointmentService {
	public Appointment getAppointmentById(int id) throws SQLException;
	public ArrayList<Appointment> getAllAppointmentById(int id_patient) throws SQLException;
	public boolean deleteAppointmentById(int id) throws SQLException;

}
