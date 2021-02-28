package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.javaBeans.MedicalFile;


public class MedicalFileDAO implements MedicaleFileService {
	private DbConfigDAO dbInstance;
	private Connection connection;
	
	public MedicalFileDAO() {
		dbInstance=DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public MedicalFile getMedicalFileById(int id_patient) throws SQLException {
		MedicalFile medicalFile = new MedicalFile();
		
		medicalFile.setId("KA1010110");
		
		PatientDAO patientDao = new PatientDAO();
		medicalFile.setPatient(patientDao.getPatientById(id_patient));
		
		AppointmentDAO appointmentDao = new AppointmentDAO();
		medicalFile.setAppointmentList(appointmentDao.getAllAppointmentById(id_patient));
		
		ConsultationDAO consultationDao = new ConsultationDAO();
		medicalFile.setConsultationList(consultationDao.getAllConsultationById(id_patient));
		
		medicalFile.setStatistiques(getStatistiquesById(id_patient));
		return medicalFile;
		
		
	}
	public HashMap<String,String> getStatistiquesById(int id_patient) throws SQLException{
		HashMap<String,String> statistiques = new HashMap<String,String>();
		PreparedStatement preStat;
		ResultSet result;
		//
		String query1 = "SELECT COUNT(*) FROM appointment WHERE id_patient = ?";
		preStat = connection.prepareStatement(query1);
		preStat.setInt(1, id_patient);
		result = preStat.executeQuery();
		result.next();
		int nbapp = result.getInt("COUNT(*)");
		
		statistiques.put("appointments",String.valueOf(nbapp));
		preStat.close();
		//
		String query2 = "SELECT COUNT(*) FROM consultation WHERE id_patient = ?";
		preStat = connection.prepareStatement(query2);
		preStat.setInt(1, id_patient);
		result = preStat.executeQuery();
		result.next();
		int nbcons = result.getInt(1);
		
		statistiques.put("consultations", String.valueOf(nbcons));
		preStat.close();
		//
		String query3 = "SELECT COUNT(*) FROM consultation WHERE id_patient = ? and id_prescription is NOT NULL";
		preStat = connection.prepareStatement(query3);
		preStat.setInt(1, id_patient);
		result = preStat.executeQuery();
		result.next();
		int nbpresc = result.getInt("COUNT(*)");
		preStat.close();
		
		statistiques.put("prescriptions", String.valueOf(nbpresc));
		preStat.close();
		//
		String query4 = "SELECT SUM(price) FROM consultation WHERE id_patient = ?";
		preStat = connection.prepareStatement(query4);
		preStat.setInt(1, id_patient);
		result = preStat.executeQuery();
		result.next();
		double totalPrice = result.getDouble(1);
		
		statistiques.put("price", String.valueOf(totalPrice));
		preStat.close();
		System.out.print(statistiques);
		
		return statistiques;
	}

}
