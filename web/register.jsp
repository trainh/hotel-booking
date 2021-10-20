<%-- 
    Document   : register
    Created on : Oct 9, 2021, 7:03:24 PM
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
        <title>Sign Up Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h2>Sign Up</h2>
        <div>
            <form action="MainController" method="POST">               
                Name <input type="text" name="txtName" value="${param.name}" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.nameError}</p><br/>
                Phone <input type="text" name="txtPhone" value="${param.phone}" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.phoneError}</p><br/>
                Address <input type="text" name="txtAddress" value="${param.address}" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.addressError}</p><br/>
                Email <input type="email" name="txtEmail" value="${param.email}" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.emailError}</p><br/>
                Password <input type="password" name="txtPassword" value="" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.passwordError}</p><br/>
                Confirm <input type="password" name="txtConfirm" value="" /><br/>
                <p>${sessionScope.ErrorRegisterAccount.comfirmPassword}</p>
                <input type="submit" name="bntAction" value="Register" />
            </form>
            <a href="login.html">Comeback Login Page</a>
        </div>
        <c:remove scope="session" var="ErrorRegisterAccount"></c:remove>
        <h3>${sessionScope.StatusRegisterAccount}</h3>
        <c:remove scope="session" var="StatusRegisterAccount"></c:remove>
    </body>
</html>
