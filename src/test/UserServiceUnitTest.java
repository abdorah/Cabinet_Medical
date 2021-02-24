package test;

import com.javaBeans.Patient;
import com.javaBeans.User;
import org.junit.Test;

import java.sql.SQLException;

import com.DAO.UserDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceUnitTest {

    @Test
    public void userShouldBeLogin() throws SQLException {
        UserDAO userDAO = new UserDAO();
        User user =new User(50,"ux55664","kotbi","abderrahmane","06542525","kotbi@gmail.com","password");
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "password"),user);
    }

    @Test
    public void userShouldBeRegisteredAndExist() throws SQLException {
        UserDAO userDAO = new UserDAO();
        Patient patient = new Patient(51, "ux55664", "dokali", "mohamed", "06542525", "d.mohamed@gmail.com", "password", "1993-01-01", "homme");
        assertNotEquals(0,userDAO.register(patient));
        assertTrue(userDAO.isExist("k.mohamed@gmail.com","ux55664"));
    }

}
