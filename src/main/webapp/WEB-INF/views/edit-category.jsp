<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 03/04/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Edit Category</title>
</head>
<body>
<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<form:form modelAttribute="category" method="post">
  <form:hidden path="id"/>
    Name: <form:input path="name"/>
    Description <form:textarea path="description"/>
    <input type="submit">
</form:form>
</body>
</html>