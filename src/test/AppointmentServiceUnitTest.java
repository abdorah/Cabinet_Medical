package test;

import static org.junit.Assert.assertNotEquals;

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
    public void dbConnectionAssert(){
        appointmentDAO = new AppointmentDAO();
        patientDAO = new PatientDAO();
        Patient patient = new Patient(1, "UB98226", "abderrahmane", "kotbi", "0633559921", "specialty", "kotbi@gmail.com", "password");
        appointment = new Appointment("04/16/2020 16:24:33","peniciline","vaccination",true,patient);
    }

    @Test
    public void appointmentShouldBetaken() throws SQLException {
        assertNotEquals(0, appointmentDAO.takeAppointment(appointment));
    }
}
