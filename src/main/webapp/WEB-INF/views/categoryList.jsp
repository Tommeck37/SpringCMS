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
  <title>Title</title>
</head>
<body>


<%--@elvariable id="category" type="java.util.List<pl.coderslab.entity.Category>"--%>
<table>
  <c:forEach var="item" items="${category}">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.description}</td>
      <td><a href="/removeCategory/${item.id}">usuń</a></td>
      <td><a href="/editCategory/${item.id}">edytuj pozycję</a></td>
      <td><a href="/add-category">dodaj kategorię</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>