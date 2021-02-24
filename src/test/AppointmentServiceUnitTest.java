package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import com.DAO.AppointmentDAO;
import com.DAO.PatientDAO;
import com.javaBeans.Appointment;
import com.javaBeans.Patient;

import org.junit.Before;
import org.junit.Test;

public class AppointmentServiceUnitTest {

    PatientDAO patientDAO;
    AppointmentDAO appointmentDAO;
    Appointment appointment;

    @Before
    public void init(){
        appointmentDAO = new AppointmentDAO();
        patientDAO = new PatientDAO();
        Patient patient = new Patient(10, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        appointment = new Appointment("04/16/2020 16:24:33","peniciline","vaccination",true,patient);
    }

    @Test
    public void appointmentShouldBetaken() throws SQLException {
        assertNotEquals(0, appointmentDAO.takeAppointment(appointment));
        assertEquals(10, appointmentDAO.getAppointmentById(appointment.getId_appointment()));
    }

    @Test
    public void appointmentShouldNotExist() throws SQLException {
        assertTrue(appointmentDAO.deleteAppointmentById(appointment.getId_appointment()));
    }

}
