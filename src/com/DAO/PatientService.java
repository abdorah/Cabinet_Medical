package com.DAO;

import java.sql.SQLException;

import com.javaBeans.Patient;

public interface PatientService {
	
	public Patient getPatientById(int id) throws SQLException;

}
