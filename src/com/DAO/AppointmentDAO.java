package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Appointment;



public class AppointmentDAO implements AppointmentService {
	
	private DbConfigDAO dbInstance;
	private Connection connection;

	
	public AppointmentDAO() {
		dbInstance=DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Appointment getAppointmentById(int id) throws SQLException {
		String query = "SELECT * FROM appointment WHERE id_appointment = ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		
		Appointment appointment;
		//informations personnelles du patient:
		if(result.next()) {
			appointment = new Appointment();
			appointment.setId_appointment(result.getInt("id_appointment"));
			appointment.setDateofChecking(result.getString("DateofChecking"));
			appointment.setDateofAppointment(result.getString("DateofAppointment"));
			appointment.setDescription(result.getString("Description"));
			appointment.setTypeofIllness(result.getString("TypeofIllness"));
			
			PatientDAO patientDAO = new PatientDAO();
			appointment.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));
			
		}else {
			appointment = null;
		}
		
		
		return appointment;
		
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentById(int id_patient) throws SQLException {
		String query = "SELECT id_appointment FROM appointment WHERE id_patient = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();
		
		
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		while(result.next()) {
			
			appointmentList.add(this.getAppointmentById(result.getInt("id_appointment")));
			
		}
		
		return appointmentList;
	}

	@Override
	public boolean deleteAppointmentById(int id_appointment) throws SQLException {
		String query = "DELETE FROM appointment WHERE id_appointment = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_appointment);
		int state = preStat.executeUpdate();
		
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
