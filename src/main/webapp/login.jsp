<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

<h1>ログイン</h1>

<form action="LoginServlet" method="post">

    <p>
        ユーザー名：
        <input type="text" name="username">
    </p>

    <p>
        パスワード：
        <input type="password" name="password">
    </p>

    <input type="submit" value="ログイン">

</form>

<br>

<a href="userRegister.jsp">ユーザー登録はこちら</a>

</body>
</html>