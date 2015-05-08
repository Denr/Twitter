<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap.min.css">
    <script src="script/jquery-1.11.2.min.js"></script>
    <script src="script/bootstrap.min.js"></script>
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <meta charset="UTF-8">
<%--
    Куки работают, но с ними тесты не проходят :)
<%
        String login = "";
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("login")) {
                login = cookies[i].getValue();
            }
        }
        if (login.equals("")) {
    %>--%>
    <title>Twits</title>
</head>
<body>
<div class="header"><h1>Добро пожаловать в Twits!</h1></div>
<div align="center">
    <h3>Есть аккаунт? Входите!</h3>

    <form method="post" action="sign" name="sign">
        <div class="form-group" align="left">
            <label>Логин:</label>
            <input type="text" class="form-control" name="sign_login" placeholder="Введите Ваш логин" required>
        </div>
        <div class="form-group" align="left">
            <label>Пароль:</label>
            <input type="password" class="form-control" name="sign_pass" placeholder="Введите Ваш пароль" required>
        </div>
        <input type="submit" class="btn btn-default" value="Войти">
    </form>
    <h3>Нет? Не проблема!</h3>

    <form method="post" action="reg" name="reg">
        <div class="form-group" align="left">
            <label>Логин:</label>
            <input type="text" class="form-control" name="reg_login" placeholder="Введите желаемый логин" required>
        </div>
        <div class="form-group" align="left">
            <label>Пароль:</label>
            <input type="password" class="form-control" name="reg_pass" placeholder="Введите желаемый пароль" required>
        </div>
        <input type="submit" class="btn btn-default" value="Регистрация">
    </form>
</div>
</body>
<%--<%
    } else {
    response.sendRedirect("http://localhost:8080/twit/sign");
    }
%>--%>
</html>
