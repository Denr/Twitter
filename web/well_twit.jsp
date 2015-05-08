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
    <title>Twits</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="header"><h1>Добро пожаловать в Twits!</h1></div>
<div align="center">
    <h2><span class="alert-success">Затвичено!</span></h2>
    <a href="http://localhost:8080/twit/sign"><button class="btn btn-default">Назад</button></a>
</div>
</body>
</html>