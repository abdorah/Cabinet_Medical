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
	
	@Override
	public boolean addConsultation(Consultation consultation) throws SQLException {
		
		connection = dbInstance.getConnection();
		PreparedStatement preStat;
		
		if(consultation.getPrescription() != null) {
			String query = "INSERT INTO consultation(motif,ConsultationDate,price,id_patient,id_prescription) VALUES (?,?,?,?,?)";
			
			preStat = connection.prepareStatement(query);
			preStat.setString(1, consultation.getMotif());
			preStat.setString(2, consultation.getConsulationDate());
			preStat.setDouble(3, consultation.getPrice());
			preStat.setInt(4, consultation.getPatient().getId_user());
			preStat.setInt(5, consultation.getPrescription().getId_prescription());
			
		}else {
			String query = "INSERT INTO consultation(motif,ConsultationDate,price,id_patient) VALUES (?,?,?,?)";
			connection = dbInstance.getConnection();
			preStat = connection.prepareStatement(query);
			preStat.setString(1, consultation.getMotif());
			preStat.setString(2, consultation.getConsulationDate());
			preStat.setDouble(3, consultation.getPrice());
			preStat.setInt(4, consultation.getPatient().getId_user());
			
			
		}
		
		
		
		int result = preStat.executeUpdate();
		
		boolean isInsert = result == 0 ? false : true;
		return isInsert;
		
	}
	@Override
	public boolean deleteConsultationById(int id_consultation) throws SQLException {
		String query = "DELETE FROM consultation WHERE id_consultation= ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_consultation);
		int state = preStat.executeUpdate();
		
		boolean isDelete = state == 0 ? false : true;
		return isDelete;
	}

}
