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

}
