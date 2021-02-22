package com.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javaBeans.Consultation;


public interface ConsultationService {
	public Consultation getConsultationById(int id) throws SQLException;
	public ArrayList<Consultation> getAllConsultationById(int id_patient) throws SQLException;
	public boolean addConsultation(Consultation consultation) throws SQLException;
	public boolean deleteConsultationById(int id_appointment) throws SQLException ;

}
