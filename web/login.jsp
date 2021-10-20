<%-- 
    Document   : login
    Created on : Sep 24, 2021, 10:17:25 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css-form.css" rel="stylesheet" type="text/css"/>
        <script src="js/js.js" type="text/javascript"></script>
        <title>Login Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h2>Login Page</h2>
        <h4><a href="register.html">Sing Up</a></h4>
        <form action="MainController" method="POST">
            Email: <input type="text" name="txtEmail" value="${param.email}" /><br/>
            <p3>${sessionScope.ErrorStringLogin.errorEmail}</p3><br/>
            Password: <input type="password" name="txtPassword" value="" /><br/>
            <p3>${sessionScope.ErrorStringLogin.errorPassword}</p3><br/>
            <input type="submit" value="Login" name="bntAction" />
        </form>
        <c:remove scope="session" var="ErrorStringLogin"></c:remove>
        <style>
            input {
                margin: 10px;
            }
        </style>
    </body>
</html>
