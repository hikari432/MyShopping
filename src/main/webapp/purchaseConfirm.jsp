<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認</title>
</head>
<body>

<h1>購入確認</h1>

<p>以下の商品を購入しますか？</p>

<%
    List<CartItem> cart =
            (List<CartItem>) request.getAttribute("cart");
%>

<table border="1">

    <tr>
        <th>商品名</th>
        <th>価格</th>
        <th>数量</th>
        <th>小計</th>
        <th>カテゴリ</th>
    </tr>

<%
    int total = 0;

    for (CartItem item : cart) {

        int subtotal =
                item.getProduct().getPrice()
                * item.getQuantity();

        total += subtotal;
%>

    <tr>

        <td>
            <%= item.getProduct().getName() %>
        </td>

        <td>
            <%= item.getProduct().getPrice() %>円
        </td>

        <td>
            <%= item.getQuantity() %>個
        </td>

        <td>
            <%= subtotal %>円
        </td>

        <td>
            <%= item.getProduct().getCategory() %>
        </td>

    </tr>

<%
    }
%>

    <tr>
        <th>合計</th>
        <th></th>
        <th></th>
        <th><%= total %>円</th>
        <th></th>
    </tr>

</table>

<br>

<form action="PurchaseServlet" method="post">

    <input type="hidden"
           name="action"
           value="confirm">

    <input type="submit"
           value="購入を確定する">

</form>

</body>
</html>