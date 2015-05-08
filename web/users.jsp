<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.UserBean" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<bean.UserBean> usersList = (ArrayList<bean.UserBean>) request.getAttribute("usersList"); %>
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
    <h3>Все пользователи:</h3>
    <%
        for (int i = 0; i < usersList.size(); i++) {
    %>
    <div class="twit">
        <%=usersList.get(i).getLogin()%>
    </div>
    <%}%>
</div>
</body>
</html>