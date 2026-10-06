<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>

<h1>カート</h1>

<%
    List<CartItem> cart =
            (List<CartItem>) request.getAttribute("cart");
%>

<%
    if (cart.isEmpty()) {
%>

    <p>カートは空です。</p>

<%
    } else {
%>

<table border="1">

    <tr>
        <th>商品名</th>
        <th>価格</th>
        <th>数量</th>
        <th>小計</th>
        <th>カテゴリ</th>
        <th>操作</th>
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
        <td><%= item.getProduct().getName() %></td>

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

        <td>
            <form action="CartServlet" method="post">

                <input type="hidden"
                       name="deleteProductId"
                       value="<%= item.getProduct().getId() %>">

                <input type="submit" value="削除">

            </form>
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
        <th></th>
    </tr>

</table>

<br>

<form action="PurchaseServlet" method="post">
    <input type="submit" value="購入する">
</form>
<br>

<a href="CategoryListServlet">買い物を続ける</a>

<%
    }
%>

</body>
</html>