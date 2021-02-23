package com.DAO;

import java.sql.SQLException;

import com.javaBeans.Prescription;



public interface PrescriptionService {
	public Prescription getPrescriptionById(int id) throws SQLException;

}
