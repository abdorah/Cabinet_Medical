package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Consultation;


public class ConsultationDAO implements ConsultationService {
	private DbConfigDAO dbInstance;
	private Connection connection;
	
	
	public ConsultationDAO() {
		dbInstance = DbConfigDAO.getInstance();
		
	}
	@Override
	public Consultation getConsultationById(int id) throws SQLException {
		String query = "SELECT * FROM consultation WHERE id_consultation = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();
		
		Consultation consultation;
		
		if(result.next()) {
			consultation = new Consultation();
			consultation.setId_consultation(result.getInt("id_consultation"));
			consultation.setMotif(result.getString("motif"));
			consultation.setPrice(result.getFloat("price"));
			consultation.setConsulationDate(result.getString("ConsultationDate"));
			
			PatientDAO patientDAO = new PatientDAO();
			consultation.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));
			
			PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
			consultation.setPrescription(prescriptionDAO.getPrescriptionById(result.getInt("id_prescription")));
		}else {
			consultation = null;
		}
		
		
		return consultation;
	}
	@Override
	public ArrayList<Consultation> getAllConsultationById(int id_patient) throws SQLException {
		String query = "SELECT id_consultation FROM consultation WHERE id_patient = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();
		
		ArrayList<Consultation> consultationList = new ArrayList<Consultation>();
		while(result.next()) {
			consultationList.add(this.getConsultationById(result.getInt("id_consultation")));
			
		}
		
		return consultationList;
	}

}
