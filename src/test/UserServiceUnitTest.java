package test;

import com.javaBeans.User;
import org.junit.Test;

import java.sql.SQLException;

import com.DAO.UserDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserServiceUnitTest {

    @Test
    public void userShouldBeLogin() throws SQLException {
        UserDAO userDAO = new UserDAO();
        User user =new User(1,"ux55664","kotbi","abderrahmane","6542525","kotbi@gmail.com","password");
        assertEquals(userDAO.checkLogin("kotbi@gmail.com", "ux55664"),user);
    }

    @Test
    public void userShouldBeRegistered() throws SQLException {
        UserDAO userDAO = new UserDAO();
        User user =new User(2,"kotbi","ux55664","mohamed","6542525","k.mohamed@gmail.com","password");
        userDAO.register(user);
        assertTrue(userDAO.isExist("k.mohamed@gmail.com","ux55664"));
    }

}
