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
import java.sql.SQLException;

public class WriteTwit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id_user"));
        String twit = request.getParameter("text_twit");
        try {
            InitialContext initialContext = new InitialContext();

            DataSource dataSource = (javax.sql.DataSource) initialContext
                    .lookup("jdbc/twits");
            Connection connection = dataSource.getConnection();
            String setTwit = "INSERT INTO twits (id_user, twit) VALUES (?, ?)";
            PreparedStatement setTwitStatement = connection.prepareStatement(setTwit);
            setTwitStatement.setInt(1, id);
            setTwitStatement.setString(2, twit);
            setTwitStatement.execute();
            //response.setHeader("Refresh", "2; URL=http://localhost:8080/twit/sign");
            request.getRequestDispatcher("well_twit.jsp").forward(request, response);
        } catch (NamingException namingException) {
            namingException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
