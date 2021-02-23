package com.DAO;

import java.sql.SQLException;
import com.javaBeans.Prescription;



public interface PrescriptionService {
	public Prescription getPrescriptionById(int id) throws SQLException;
	public int addPrescription(Prescription prescription) throws SQLException;
	public boolean deletePrescriptionById(int id_prescription) throws SQLException ;

}
