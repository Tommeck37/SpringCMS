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
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<form:form modelAttribute="category" >
  <form:hidden path="id"/>
    Name: <form:input path="name"/>
    Description <form:textarea path="description"/>
    <input type="submit">
</form:form>
</body>
</html>