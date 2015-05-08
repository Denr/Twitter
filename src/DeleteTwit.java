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

public class DeleteTwit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id_twit"));
            InitialContext initialContext = new InitialContext();

            DataSource dataSource = (javax.sql.DataSource) initialContext
                    .lookup("jdbc/twits");
            Connection connection = dataSource.getConnection();
            String delete = "DELETE FROM twits WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(delete);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            //response.setHeader("Refresh", "2; URL=http://localhost:8080/twit/sign");
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
