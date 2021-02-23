package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaBeans.Patient;

public class PatientDAO implements PatientService{
	private DbConfigDAO dbInstance;
	private Connection connection;
	
	
	public PatientDAO() {
		dbInstance=DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Patient getPatientById(int id) throws SQLException {
		String query = "SELECT * FROM user,patient WHERE user.id_user=patient.id_patient and id_patient=?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		
		Patient patient;
		//informations personnelles du patient:
		if(result.next()) {
			patient = new Patient();
			patient.setId_user(result.getInt("id_patient"));
			patient.setCin(result.getString("cin"));
			patient.setFirstName(result.getString("firstName"));
			patient.setLastName(result.getString("lastName"));
			patient.setEmail(result.getString("email"));
			patient.setPhone(result.getString("phone"));
			patient.setSex(result.getString("sex"));
			patient.setBirthDate(result.getString("birthDate"));
		}else {
			patient = null;
		}
		
		
		return patient;
	}

}
