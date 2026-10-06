<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="model.Category" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>カテゴリー選択</title>

</head>

<body>

<h1>カテゴリーを選択</h1>

<%
    List<Category> categories =
            (List<Category>) request.getAttribute("categories");
%>

<form action="SubCategoryListServlet" method="get">

    <select name="categoryId">

        <%
            for (Category category : categories) {
        %>

            <option value="<%= category.getId() %>">
                <%= category.getCategoryName() %>
            </option>

        <%
            }
        %>

    </select>

    <input type="submit" value="商品を見る">

</form>
</body>

</html>