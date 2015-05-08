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
    <title>Twits</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="header"><h1>Добро пожаловать в Twits!</h1></div>
<div align="center">
    <h2><span class="alert-danger">Неверный логин и/или пароль!</span></h2>
    <h3>Есть аккаунт? Входите!</h3>

    <form method="post" action="sign">
        <div class="form-group" align="left">
            <label>Логин:</label>
            <input type="text" class="form-control" name="sign_login" placeholder="Введите Ваш логин" required>
        </div>
        <div class="form-group" align="left">
            <label>Пароль:</label>
            <input type="password" class="form-control" name="sign_pass" placeholder="Введите Ваш пароль" required>
        </div>
        <button type="submit" class="btn btn-default">Войти</button>
    </form>
    <h3>Нет? Не проблема!</h3>

    <form method="post" action="reg">
        <div class="form-group" align="left">
            <label>Логин:</label>
            <input type="text" class="form-control" name="reg_login" placeholder="Введите желаемый логин" required>
        </div>
        <div class="form-group" align="left">
            <label>Пароль:</label>
            <input type="password" class="form-control" name="reg_pass" placeholder="Введите желаемый пароль" required>
        </div>
        <button type="submit" class="btn btn-default">Регистрация</button>
    </form>
</div>
</body>
</html>
