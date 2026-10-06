<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.SubCategory" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サブカテゴリー選択</title>
</head>
<body>

<h1>サブカテゴリーを選択</h1>

<%
    List<SubCategory> subCategories =
            (List<SubCategory>) request.getAttribute("subCategories");
%>

<form action="ProductListServlet" method="get">
    <input type="hidden"
           name="categoryId"
           value="<%= request.getAttribute("categoryId") %>">

    <select name="subCategoryId">

        <%
            for (SubCategory subCategory : subCategories) {
        %>

            <option value="<%= subCategory.getId() %>">
                <%= subCategory.getSubCategoryName() %>
            </option>

        <%
            }
        %>

    </select>

    <input type="submit" value="商品を見る">

</form>
<br>

<a href="CategoryListServlet">カテゴリー選択に戻る</a>

</body>
</html>