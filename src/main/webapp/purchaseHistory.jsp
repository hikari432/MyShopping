<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Purchase" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴</title>
</head>
<body>

<h1>購入履歴</h1>

<%
    List<Purchase> purchases =
            (List<Purchase>) request.getAttribute("purchases");
%>

<%
    if (purchases.isEmpty()) {
%>

    <p>購入履歴はありません。</p>

<%
    } else {
%>

<table border="1">

    <tr>
        <th>商品名</th>
        <th>価格</th>
        <th>数量</th>
        <th>小計</th>
        <th>購入日時</th>
    </tr>

<%
    for (Purchase purchase : purchases) {
%>

    <tr>
        <td><%= purchase.getProductName() %></td>
        <td><%= purchase.getPrice() %>円</td>
        <td><%= purchase.getQuantity() %>個</td>

        <td>
        <%= purchase.getPrice() * purchase.getQuantity() %>円
        </td>
        <td><%= purchase.getPurchaseDate() %></td>
    </tr>

<%
    }
%>

</table>

<%
    }
%>

<br>

<a href="CategoryListServlet">買い物に戻る</a>

</body>
</html>