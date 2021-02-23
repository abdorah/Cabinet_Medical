package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.javaBeans.Appointment;
import java.sql.Statement;
import com.javaBeans.Patient;

public class AppointmentDAO implements AppointmentService {

	private DbConfigDAO dbInstance;
	private Connection connection;

	public AppointmentDAO() {
		dbInstance = DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Appointment getAppointmentById(int id) throws SQLException {
		String query = "SELECT * FROM appointment WHERE id_appointment = ?;";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id);
		ResultSet result = preStat.executeQuery();

		Appointment appointment;
		// informations personnelles du patient:
		if (result.next()) {
			appointment = new Appointment();
			appointment.setId_appointment(result.getInt("id_appointment"));
			appointment.setDateofChecking(result.getString("DateofChecking"));
			appointment.setDateofAppointment(result.getString("DateofAppointment"));
			appointment.setDescription(result.getString("Description"));
			appointment.setTypeofIllness(result.getString("TypeofIllness"));

			PatientDAO patientDAO = new PatientDAO();
			appointment.setPatient(patientDAO.getPatientById(result.getInt("id_patient")));

		} else {
			appointment = null;
		}

		return appointment;
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentById(int id_patient) throws SQLException {
		String query = "SELECT id_appointment FROM appointment WHERE id_patient = ?;";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_patient);
		ResultSet result = preStat.executeQuery();

		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		while (result.next()) {

			appointmentList.add(this.getAppointmentById(result.getInt("id_appointment")));
		}
		return appointmentList;
	}

	@Override
	public boolean deleteAppointmentById(int id_appointment) throws SQLException {
		String query = "DELETE FROM appointment WHERE id_appointment = ?";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setInt(1, id_appointment);
		int state = preStat.executeUpdate();

		boolean isDelete = state == 0 ? false : true;
		return isDelete;

	}
	@Override
	public int takeAppointment(Appointment appointment) throws SQLException {
		String query = "insert into appointment(DateofChecking, DateofAppointment, id_patient, TypeofIllness, Description, notification) values(NOW(),?,?,?,?,?);";
		connection = dbInstance.getConnection();
		PreparedStatement preStat = connection.prepareStatement(query);

		//preStat.setString(1, appointment.getDateofChecking());
		preStat.setString(1, appointment.getDateofAppointment());
		preStat.setInt(2, appointment.getPatient().getId_user());
		preStat.setString(3, appointment.getTypeofIllness());
		preStat.setString(4, appointment.getDescription());
		preStat.setInt(5, appointment.isNotification() ? 1 : 0);
		
		preStat.execute();

		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery("select  id_appointment from appointment where id_patient=" + "'"
				+ appointment.getPatient() + "'" + ";");

		int id = 0;
		while (result.next()) {
			id = result.getInt("id_appointment");
		}
		return id;
    }

	

	@Override
	public int SupprimerAppointmentPatient(int id_p) throws SQLException {

	    PreparedStatement preStat;
	    String query;
	    
		connection=dbInstance.getConnection();
		
		query="DELETE FROM Appointment WHERE id_patient = ?  ";
		preStat=connection.prepareStatement(query);
		preStat.setLong(1,id_p);
		int r = preStat.executeUpdate();

		if(r>0) {
			return 1;
		}
			
		return 0;
	}
	
	@Override 
	public ArrayList<Appointment> ListeAppointmentNF() throws SQLException {
			
	    PreparedStatement preStat;
	    ResultSet result;
	    String query;
	    Appointment appointment;
		
		query="SELECT * FROM Appointment a, user u, patient p WHERE u.id = p.id_patient and p.id_patient = a.id_patient and DateofAppointment > NOW()";
		connection=dbInstance.getConnection();
		preStat=connection.prepareStatement(query);
		result=preStat.executeQuery();

		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		Patient patient=null;
		
		while(result.next()) {
			int id_patient= result.getInt("id_patient");
			String firstName=result.getString("firstName");
			String lastName=result.getString("lastName");
			String phone=result.getString("phone");
			String email=result.getString("email");
			String password=result.getString("password");
			String birthDate= result.getString("birthDate");
			String sex=result.getString("sex");

			patient = new Patient(id_patient, firstName, lastName, phone, email, password, birthDate, sex);
			
			int id_appointment= result.getInt("id_appointment");
			String dateofChecking=result.getString("DateofChecking");
			String dateofAppointment=result.getString("DateofAppointment");
			String description=result.getString("Description");
			String typeofIllness=result.getString("TypeofIllness");
			boolean notification=result.getBoolean("notification");
			
			appointment = new Appointment(id_appointment, dateofChecking, dateofAppointment, description, typeofIllness, notification, patient);
			appointments.add(appointment);						
		}
		return appointments;
	}
	@Override
	public ArrayList<Appointment> ListeAppointmentF() throws SQLException {
		
	    PreparedStatement preStat;
	    ResultSet result;
	    String query;
	    Appointment appointment;
		
		query="SELECT * FROM Appointment a, user u, patient p WHERE u.id = p.id_patient and p.id_patient = a.id_patient and DateofAppointment < NOW()";
		connection=dbInstance.getConnection();
		preStat=connection.prepareStatement(query);
		result=preStat.executeQuery();

		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		Patient patient=null;
		
		while(result.next()) {
			int id_patient= result.getInt("id_patient");
			String firstName=result.getString("firstName");
			String lastName=result.getString("lastName");
			String phone=result.getString("phone");
			String email=result.getString("email");
			String password=result.getString("password");
			String birthDate= result.getString("birthDate");
			String sex=result.getString("sex");

			patient = new Patient(id_patient, firstName, lastName, phone, email, password, birthDate, sex);
			
			int id_appointment= result.getInt("id_appointment");
			String dateofChecking=result.getString("DateofChecking");
			String dateofAppointment=result.getString("DateofAppointment");
			String description=result.getString("Description");
			String typeofIllness=result.getString("TypeofIllness");
			boolean notification=result.getBoolean("notification");
			
			appointment = new Appointment(id_appointment, dateofChecking, dateofAppointment, description, typeofIllness, notification, patient);
			appointments.add(appointment);						
		}
		return appointments;
	}
}
