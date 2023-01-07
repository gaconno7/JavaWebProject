<%--
  Created by IntelliJ IDEA.
  User: trant
  Date: 1/7/2023
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Sign up</h1>

    <form:form method="post" action="signup-action" modelAttribute="user">
        <form:label path="username">Username</form:label>
        <form:input path="username" name="username" id="username" />

        <form:label path="password">Password</form:label>
        <form:password path="password" name="password" id="password" />

        <form:button name="signup" id="signup">Sign up</form:button>
    </form:form>
</body>
</html>
