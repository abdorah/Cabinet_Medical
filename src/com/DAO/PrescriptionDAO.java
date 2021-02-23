package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.javaBeans.Prescription;

public class PrescriptionDAO implements PrescriptionService{
	private DbConfigDAO dbInstance;
	private Connection connection;
	
	
	public PrescriptionDAO() {
		dbInstance=DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Prescription getPrescriptionById(int id) throws SQLException {
		String query = "SELECT * FROM prescription WHERE id_prescription= ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		
		Prescription prescription;
		
		if(result.next()) {
			prescription = new Prescription();
			prescription.setId_prescription(result.getInt("id_prescription"));
			prescription.setTitle(result.getString("title"));
			prescription.setDateOfPrescription(result.getString("dateOfPrescription"));
			prescription.setDescription(result.getString("description"));
			prescription.setMedicationList(result.getString("medicationList"));
			
		}else {
			prescription = null;
		}
		
		
		return prescription;
	}

	@Override
	public int addPrescription(Prescription prescription) throws SQLException {
		String query = "INSERT INTO prescription(title,dateOfPrescription,description,medicationList) VALUES (?,?,?,?)";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, prescription.getTitle());
		preStat.setString(2, prescription.getDateOfPrescription());
		preStat.setString(3, prescription.getDescription());
		preStat.setString(4, prescription.getMedicationList());
		
		int result = preStat.executeUpdate();
		
		if(result != 0) {
			String maxIdQuery = "SELECT MAX(id_prescription) FROM prescription";
			PreparedStatement preStatMax = connection.prepareStatement(maxIdQuery);
			ResultSet maxId = preStatMax.executeQuery();
			maxId.next();
			
			return maxId.getInt("MAX(id_prescription)");
		}
		else {
			return 0;
		}
		
	}
	@Override
	public boolean deletePrescriptionById(int id_prescription) throws SQLException {
		String query = "DELETE FROM prescription WHERE id_prescription= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_prescription);
		int state = preStat.executeUpdate();
		
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
