<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>

<h1>ユーザー登録</h1>

<form action="UserRegisterServlet" method="post">

    <p>
        ユーザー名：
        <input type="text" name="username">
    </p>

    <p>
        パスワード：
        <input type="password" name="password">
    </p>

    <input type="submit" value="登録">

</form>

<br>

<a href="login.jsp">ログイン画面へ</a>

</body>
</html>