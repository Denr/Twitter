import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String login = request.getParameter("reg_login");
        String pass = request.getParameter("reg_pass");
        try {
            InitialContext initialContext = new InitialContext();

            DataSource dataSource = (javax.sql.DataSource) initialContext
                    .lookup("jdbc/twits");
            Connection connection = dataSource.getConnection();
            String user = "SELECT * FROM users WHERE login = ?";
            PreparedStatement userStatement = connection.prepareStatement(user);
            userStatement.setString(1, login);
            ResultSet usersSet = userStatement.executeQuery();
            if (!usersSet.first()) {
                String reg = "insert into users (login, pass) values (?, ?)";
                PreparedStatement regStatement = connection.prepareStatement(reg);
                regStatement.setString(1, login);
                regStatement.setString(2, pass);
                regStatement.execute();
                request.getRequestDispatcher("well_reg.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("fall_reg.jsp").forward(request, response);
            }

        } catch (NamingException namingException) {
            namingException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
