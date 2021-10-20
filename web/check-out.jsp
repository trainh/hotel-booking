<%-- 
    Document   : check-out
    Created on : Oct 11, 2021, 9:16:14 PM
    Author     : trainh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h2>Check Out </h2>
        <c:set value="${sessionScope.CHECK_OUT}" var="history" ></c:set>
        <h2>Email: ${history.email}</h2>
        <h2>Hotel: ${history.hotel}</h2>
        <h3>Room: ${history.roomNumber}</h3>
        <h4>Kind Of Room: ${history.kindOfRoom}</h4>
        <c:set var="today" value="<%=new Date()%>"/>
        Booking date: <fmt:formatDate type="date" value="${today}" pattern="yyy/MM/dd"/> <p>(yyyy/MM/dd)</p>
        Check out date : ${history.checkOutDate}<br/><p>(yyyy/MM/dd)</p>
        <h4>Price: <fmt:formatNumber type="number" value="${history.price}"></fmt:formatNumber>vnđ</h4>
        <h4>Rental day: ${history.rentalDay}</h4>
        <h4>Discount code: ${history.codeDis}</h4>
        <h4>Discount: <fmt:formatNumber type = "number" value = "${(100 - history.discount * 100)}" />%</h4>
        <h3>Total: <fmt:formatNumber type="number" value="${history.total}"></fmt:formatNumber>vnđ</h3>
        <form action="MainController">
            <input type="submit" name="bntAction" value="Check Out One Room" />
        </form>
        <a href="booking.jsp">Come back booking</a>
    </body>
</html>
