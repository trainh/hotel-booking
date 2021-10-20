<%-- 
    Document   : invalid
    Created on : Oct 10, 2021, 5:28:02 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h1>${sessionScope.ERROR_STRING}</h1>
        <c:remove scope="session" var="ERROR_STRING"></c:remove>
        <h1>${requestScope.ERROR_STRING}</h1>
    </body>
</html>
