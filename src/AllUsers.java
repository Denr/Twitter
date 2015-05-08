import bean.UserBean;

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
import java.util.ArrayList;

public class AllUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        ArrayList<UserBean> usersList = new ArrayList<UserBean>();
        int id_user = Integer.parseInt(request.getParameter("id_user"));
        try {
            InitialContext initialContext = new InitialContext();

            DataSource dataSource = (javax.sql.DataSource) initialContext
                    .lookup("jdbc/twits");
            Connection connection = dataSource.getConnection();
            String users = "SELECT login FROM users WHERE id <> ?";
            PreparedStatement userStatement = connection.prepareStatement(users);
            userStatement.setInt(1, id_user);
            ResultSet usersSet = userStatement.executeQuery();
            if (!usersSet.first()) {
                request.getRequestDispatcher("not_users").forward(request, response);
            } else {
                while (usersSet.next()) {
                    String login = usersSet.getString("login");
                    usersList.add(new UserBean(login));
                }
                request.setAttribute("usersList", usersList);
                request.getRequestDispatcher("users.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
