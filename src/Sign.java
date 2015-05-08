import bean.TwitBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

public class Sign extends HttpServlet {
    public String login;
    public String pass;
    public ArrayList<TwitBean> twitsList;

    public void connectionDB(HttpServletRequest request, HttpServletResponse response) {
        try {
            InitialContext initialContext = new InitialContext();

            DataSource dataSource = (javax.sql.DataSource) initialContext
                    .lookup("jdbc/twits");
            Connection connection = dataSource.getConnection();
            String user = "SELECT * FROM users WHERE login = ? AND pass = ?";
            PreparedStatement userStatement = connection.prepareStatement(user);
            userStatement.setString(1, login);
            userStatement.setString(2, pass);
            ResultSet usersSet = userStatement.executeQuery();
            if (usersSet.first()) {
                int id = usersSet.getInt("id");
                String twits = "SELECT * FROM twits WHERE id_user = ?";
                PreparedStatement twitStatement = connection.prepareStatement(twits);
                twitStatement.setInt(1, id);
                ResultSet twitsSet = twitStatement.executeQuery();
                while (twitsSet.next()) {
                    int id_twit = twitsSet.getInt("id");
                    String twit = twitsSet.getString("twit");
                    twitsList.add(new TwitBean(id_twit, twit));
                }
                request.setAttribute("id", id);
                request.setAttribute("user", login);
                request.setAttribute("twitsList", twitsList);
                request.getRequestDispatcher("twit.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("fall_sign.jsp").include(request, response);
            }

        } catch (NamingException namingException) {
            namingException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        login = request.getParameter("sign_login");
        pass = request.getParameter("sign_pass");
        twitsList = new ArrayList<TwitBean>();
        Cookie cookie_login = new Cookie("login", login);
        response.addCookie(cookie_login);
        connectionDB(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        twitsList = new ArrayList<TwitBean>();
        if (!login.equals("") && !pass.equals("")) {
            connectionDB(request, response);
        }
    }
}
