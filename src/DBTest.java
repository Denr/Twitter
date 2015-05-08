import com.mysql.jdbc.Connection;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.AfterBegin;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBTest {
    Connection connection;

    @Before
    public void setDriver() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/twitbd";
        String name = "root";
        String password = "root";
        connection = (Connection) DriverManager.getConnection(url, name, password);
    }

    @Test
    public void testSign() throws Exception {
        String user = "SELECT * FROM users WHERE login = ? AND pass = ?";
        PreparedStatement userStatement = connection.prepareStatement(user);
        userStatement.setString(1, "Putin");
        userStatement.setString(2, "Putin");
        ResultSet usersSet = userStatement.executeQuery();
        boolean status;
        if (usersSet.first()) {
            status = true;
        } else {
            status = false;
        }
        assertTrue(status);
    }

    @Test
    public void testRegistration() throws Exception {
        String user = "SELECT * FROM users WHERE login = ?";
        PreparedStatement userStatement = connection.prepareStatement(user);
        int i = 10;
        userStatement.setString(1, "Tester" + i);
        ResultSet usersSet = userStatement.executeQuery();
        boolean status;
        if (!usersSet.first()) {
            status = true;
            i++;
        } else {
            status = false;
        }
        assertTrue(status);
    }
}