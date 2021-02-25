package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import com.DAO.AppointmentDAO;
import com.DAO.UserDAO;
import com.javaBeans.Appointment;
import com.javaBeans.Patient;

import org.junit.Test;

public class AppointmentServiceUnitTest {

    @Test
    public void appointmentShouldBetaken() throws SQLException {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        UserDAO userDAO = new UserDAO();
        Patient patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        Appointment appointment = new Appointment("2020-04-11 16:24:33","peniciline","vaccination",true,patient);
        assertEquals(0,userDAO.register(patient));
        assertNotEquals(0, appointmentDAO.takeAppointment(appointment));
    }

    @Test
    public void appointmentShouldNotExist() throws SQLException {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        UserDAO userDAO = new UserDAO();
        Patient patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        Appointment appointment = new Appointment("2020-04-11 16:24:33","peniciline","vaccination",true,patient);
        assertEquals(0,userDAO.register(patient));
        assertNotEquals(0, appointmentDAO.takeAppointment(appointment));
        assertNotEquals(0, appointmentDAO.SupprimerAppointmentPatient(patient.getId_user()));
    }

}
