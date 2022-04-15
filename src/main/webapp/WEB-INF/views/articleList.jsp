<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 03/04/2022
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Article List</title>
</head>
<body>


<%--@elvariable id="article" type="java.util.List<pl.coderslab.entity.Article>"--%>
<table>
    <c:forEach var="item" items="${article}">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.author.lastName}</td>
            <td>${item.author.firstName}</td>
            <td>${item.content}</td>
            <td>${item.created}</td>
            <td>${item.updated}</td>
            <td><a href="/remove-article/${item.id}">usuń artykuł</a></td>
            <td><a href="/edit-article/${item.id}">edytuj artykuł</a></td>
            <td><a href="/add-article">dodaj artykuł</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>