package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javaBeans.Appointment;

public class AppointmentDAO implements AppointmentService {

    DbConfigDao bdInstance;
    Connection connection;
    PreparedStatement preStat;
    ResultSet result;
    String query;
    Appointment appointment;

    public AppointmentDAO() {
        bdInstance = DbConfigDao.getInstance();
    }

    public void takeAppointment(Appointment appointment) throws SQLException {
        query = "insert into Appointment(DateofChecking, DateofAppointment, id_patient, TypeofIllness, Description, notification) values(?,?,?,?,?,?);";
        preStat = connection.prepareStatement(query);
        preStat.setDate(1, (Date) appointment.getDateofChecking());
        preStat.setDate(2, (Date) appointment.getDateofAppointment());
        preStat.setInt(3, appointment.getPatient());
        preStat.setString(4, appointment.getTypeofIllness());
        preStat.setString(5, appointment.getReason());
        preStat.setBoolean(6, appointment.isNotification());
        preStat.execute();
        Statement statement = connection.createStatement();
        result = statement.executeQuery(
                "select  id from Appointment where id_patient=" + "'" + appointment.getPatient() + "'" + ";");
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
        }
    }

}