package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import com.DAO.PatientDAO;
import com.DAO.UserDAO;
import com.javaBeans.Patient;

import org.junit.Test;

public class UserServiceUnitTest {

    @Test
    public void userShouldBeLogin() throws SQLException {
        UserDAO userDAO = new UserDAO();
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient(50,"ux55664","kotbi","abderrahmane","6542525","kotbi@gmail.com","password", "1993-01-01", "homme");
        assertEquals(0,userDAO.register(patient));
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getCin(),patient.getCin());
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getFirstName(),patient.getFirstName());
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getLastName(),patient.getLastName());
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getPhone(),patient.getPhone());
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getEmail(),patient.getEmail());
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password").getPassword(),patient.getPassword());
        assertEquals(patientDAO.getPatientById(userDAO.checkLogin("kotbi@gmail.com", "password").getId_user()).getSex(),patient.getSex());
    }

    @Test
    public void userShouldBeRegisteredAndExist() throws SQLException {
        UserDAO userDAO = new UserDAO();
        Patient patient = new Patient(51, "ux55664", "dokali", "mohamed", "06542525", "d.mohamed@gmail.com", "password", "1993-01-01", "homme");
        assertEquals(0,userDAO.register(patient));
        assertTrue(userDAO.isExist("d.mohamed@gmail.com","ux55664"));
    }

}
