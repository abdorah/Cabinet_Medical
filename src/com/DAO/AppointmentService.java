package com.DAO;

import java.sql.SQLException;

import com.javaBeans.Appointment;

public interface AppointmentService {

    public void takeAppointment(Appointment appointment) throws SQLException;

}