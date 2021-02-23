package com.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.javaBeans.MedicalFile;


public interface MedicaleFileService {
	public MedicalFile getMedicalFileById(int id) throws SQLException;
	public Map<String,Double> getStatistiquesById(int id_patient) throws SQLException;

}
