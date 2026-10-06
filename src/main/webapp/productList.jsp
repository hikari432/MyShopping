<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>

<h1>商品一覧</h1>

 <%
        List<Product> products = (List<Product>) request.getAttribute("products");
    %>
    
    
<table border="1">

    <tr>
        <th>ID</th>
        <th>商品名</th>
        <th>価格</th>
        <th>カテゴリ</th>
        <th>メモ</th>
        <th>操作</th>
    </tr>

    <%
        for (Product product : products) {
    %>

    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %>円</td>
        <td><%= product.getCategory() %></td>
        <td><%= product.getMemo() %></td>
        <td>
    <form action="CartServlet" method="post">

    <input type="hidden"
           name="productId"
           value="<%= product.getId() %>">

    <input type="number"
           name="quantity"
           value="1"
           min="1">

    <input type="submit"
           value="カートに入れる">

</form>
</td>
    </tr>

    <%
        }
    %>

</table>

<br>

<a href="SubCategoryListServlet?categoryId=<%= request.getAttribute("categoryId") %>">
    サブカテゴリー選択に戻る
</a>

<br>

<a href="CategoryListServlet">カテゴリー選択に戻る</a>
    
</body>
</html>