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
	public HashMap<String,Double> getStatistiquesById(int id_patient) throws SQLException{
		HashMap<String,Double> statistiques = new HashMap<String,Double>();
		
		String query1 = "SELECT COUNT(*) FROM appointment WHERE id_patient = ?";
		PreparedStatement preStat1 = connection.prepareStatement(query1);
		preStat1.setInt(1, id_patient);
		ResultSet result1 = preStat1.executeQuery();
		result1.next();
		int nbapp = result1.getInt("COUNT(*)");
		
		statistiques.put("appointments", (double) nbapp);
		
		String query2 = "SELECT COUNT(*) FROM consultation WHERE id_patient = ?";
		PreparedStatement preStat2 = connection.prepareStatement(query2);
		preStat2.setInt(1, id_patient);
		ResultSet result2 = preStat1.executeQuery();
		result2.next();
		int nbcons = result2.getInt(1);
		
		statistiques.put("consultations", (double) nbcons);
		
		String query3 = "SELECT COUNT(*) FROM consultation WHERE id_patient = ? and id_prescription is NOT NULL";
		PreparedStatement preStat3 = connection.prepareStatement(query3);
		preStat3.setInt(1, id_patient);
		ResultSet result3 = preStat1.executeQuery();
		result3.next();
		int nbpresc = result3.getInt("COUNT(*)");
		
		
		
		statistiques.put("prescriptions", (double) nbpresc);
		
		String query4 = "SELECT SUM(price) FROM consultation WHERE id_patient = ?";
		PreparedStatement preStat4 = connection.prepareStatement(query4);
		preStat4.setInt(1, id_patient);
		ResultSet result4 = preStat1.executeQuery();
		result4.next();
		double totalPrice = result4.getDouble(1);
		
		statistiques.put("price", totalPrice);
		System.out.print(statistiques);
		return statistiques;
	}

}
