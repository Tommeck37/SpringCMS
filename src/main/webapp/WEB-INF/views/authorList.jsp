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
  <title>Author</title>
</head>
<body>


<%--@elvariable id="author" type="java.util.List<pl.coderslab.entity.Author>"--%>
<table>
  <c:forEach var="item" items="${author}">
    <tr>
      <td>${item.id}</td>
      <td>${item.firstName}</td>
      <td>${item.lastName}</td>
      <td><a href="/remove-author/${item.id}">usuń</a></td>
      <td><a href="/edit-author/${item.id}">edytuj pozycję</a></td>
      <td><a href="/add-author">dodaj autora</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>