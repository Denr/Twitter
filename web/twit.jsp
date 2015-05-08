<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.TwitBean" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<bean.TwitBean> twitsList = (ArrayList<bean.TwitBean>) request.getAttribute("twitsList"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <script src="script/jquery-1.11.2.min.js"></script>
    <script src="script/bootstrap.min.js"></script>
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <%--    <%
            String login = "";
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("login")) {
                    login = cookies[i].getValue();
                }
            }
            if (!login.equals("")) {
        %>--%>
    <title>Ваш твиттер</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="header">
    <h1>Добро пожаловать в Twits!</h1>
</div>
<div align="center">
    <h3>Твиттер пользователя: <%=request.getAttribute("user")%>.
    </h3>
    <table class="table">
        <tr>
            <td>
                <form action="all_users" method="post" name="all_users">
                    <input type="hidden" name="id_user" value=<%=request.getAttribute("id")%>>
                    <input type="submit" class="btn-default btn" value="Все пользователи">
                </form>
            </td>
            <td>
                <form action="friends" method="post" name="friends">
                    <input type="submit" class="btn-default btn" value="Друзья">
                </form>
            </td>
            <td>
                <form action="logout" method="post" name="logout">
                    <input type="submit" class="btn-danger btn" value="Выйти">
                </form>
            </td>
        </tr>
    </table>
    <br>

    <form method="post" action="set_twit" name="twit">
        <div class="form-group" align="left">
            <label>Твит:</label>
            <textarea class="form-control" rows="3" name="text_twit" placeholder="Введите Ваш твит" required></textarea>
        </div>
        <input type="submit" class="btn btn-default" value="Затвитить">
        <input type="hidden" name="id_user" value=<%=request.getAttribute("id")%>>
    </form>
    <h3>Ваши твиты:</h3>
    <%
        for (int i = twitsList.size() - 1; i >= 0; i--) {
    %>
    <div class="twit">
        <form action="delete" method="post" name="delete">
            <input type="hidden" value="<%=twitsList.get(i).getId()%>" name="id_twit">
            <%=twitsList.get(i).getTwit()%>
            <br>

            <p></p>
            <input type="submit" class="btn btn-danger btn-sm" value="Удалить">

            <p></p>
        </form>
    </div>
    <%}%>
</div>
</body>
<%--<%
    } else {
        response.sendRedirect("http://localhost:8080/twit/");
    }
%>--%>
</html>