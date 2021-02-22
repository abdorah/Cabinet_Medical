package test;

import com.DAO.DbConfigDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConfigUnitTest {

    @Test
    public void dbConnectionTest() throws SQLException {
        Connection con = DbConfigDAO.getInstance().getConnection();
        Assert.assertNotNull(con);
        Assert.assertTrue(con.isValid(0));
        con.close();
    }
}
