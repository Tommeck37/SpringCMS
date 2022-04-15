<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 03/04/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Add Article Form</title>
</head>
<body>
<%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
<form:form modelAttribute="article" method="post">
    Title: <form:input path="title"/>
<%--    Author <form:select itemValue="id" itemLabel="lastName" path="author"--%>
<%--                 items="${authors}" />--%>

    <form:select items="${authors}" path="author" itemValue="id"  />
    Content: <form:input path="content"/><br><br>
    <input type="submit">
</form:form>
</body>
</html>