package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Patient;

public class PatientDAO implements PatientService{
	private DbConfigDAO dbInstance;
	private Connection connection;
	
	PreparedStatement preStat;
	ResultSet result;
	String query;
	
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
	
	public ArrayList<Patient> ListePatients() throws SQLException {
		
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		query="SELECT * FROM user ,patient  WHERE id_user = id_patient ";
		connection=dbInstance.getConnection();
		preStat=connection.prepareStatement(query);
		result=preStat.executeQuery();
		
		Patient patient=null;
		while(result.next()) {
			int id= result.getInt("id_user");
			String cin=result.getString("cin");
			String firstName=result.getString("firstName");
			String lastName=result.getString("lastName");
			String phone=result.getString("phone");
			String email=result.getString("email");
			String password=result.getString("password");
			
			String birthDate= result.getString("birthDate");
			String sex=result.getString("sex");

			patient = new Patient(id, cin, firstName, lastName, phone, email, password, birthDate, sex);
			patients.add(patient);
			
		}
		return patients;
	}
	
	public Patient AfficherPation(int id_p) throws SQLException {

		connection=dbInstance.getConnection();

		query="SELECT * FROM user ,patient  WHERE id_user = id_patient and id_user = ?";
		
		preStat=connection.prepareStatement(query);
		preStat.setLong(1,id_p);
		result=preStat.executeQuery();
		result.next();
				
		int id= result.getInt("id_user");
		String firstName=result.getString("firstName");
		String lastName=result.getString("lastName");
		String phone=result.getString("phone");
		String email=result.getString("email");
		String password=result.getString("password");
		
		String birthDate= result.getString("birthDate");
		String sex=result.getString("sex");
		
		Patient patient = new Patient(id, firstName, lastName, phone, email, password, birthDate, sex);
			
		return patient;
	}
	
	public int ModifierPation(int id_user, String firstName, String lastName, String phone, String email, String birthDate, String sex) throws SQLException {

		connection=dbInstance.getConnection();
		
		query="UPDATE patient SET BirthDate = ?, sex = ? WHERE id_patient = ?  ";
		preStat=connection.prepareStatement(query);
		preStat.setString(1,birthDate);
		preStat.setString(2,sex);
		preStat.setLong(3,id_user);
		int s1 = preStat.executeUpdate();

		query="UPDATE user SET firstName = ?, lastName = ?, phone = ?, email = ? WHERE id_user = ?  ";
		preStat=connection.prepareStatement(query);
		preStat.setString(1,firstName);
		preStat.setString(2,lastName);
		preStat.setString(3,phone);
		preStat.setString(4,email);
		preStat.setLong(5,id_user);
		int s2 = preStat.executeUpdate();

		if(s1>0 && s2>0) {
			return 1;
		}
			
		return 0;
	}
	
	public int SupprimerPation(int id_patient) throws SQLException {

		connection=dbInstance.getConnection();
		
		query="DELETE FROM patient WHERE id_patient = ?  ";
		preStat=connection.prepareStatement(query);
		preStat.setLong(1,id_patient);
		int s1 = preStat.executeUpdate();
		
		query="DELETE FROM user WHERE id = ?  ";
		preStat=connection.prepareStatement(query);
		preStat.setLong(1,id_patient);
		int s2 = preStat.executeUpdate();
		
		if(s1>0 && s2>0) {
			return 1;
		}
			
		return 0;
	}

}
