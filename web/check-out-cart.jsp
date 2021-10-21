<%-- 
    Document   : check-out-cart
    Created on : Oct 14, 2021, 7:45:05 PM
    Author     : trainh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out Cart Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h2>Check Out</h2>
        <div> 
            <c:if test="${sessionScope.USER != null}">
                <h1>Hello ${sessionScope.USER.name}!</h1>
                <a href="LogoutController">LOGOUT</a>
            </c:if>
            <a href="cart.jsp">CART</a>
        </div>
        <c:forEach items="${sessionScope.LIST_CHECKOUT}" var="room">
            <div class="room">
                <h2>Email: ${room.email}</h2>
                <h2>Hotel: ${room.hotel}</h2>
                <h3>Room: ${room.roomNumber}</h3>
                <h4>Kind Of Room: ${room.kindOfRoom}</h4>
                <c:set var="today" value="<%=new Date()%>"/>
                Booking date: <fmt:formatDate type="date" value="${today}" pattern="yyy/MM/dd"/> <p>(yyyy/MM/dd)</p>
                Check out date : ${room.checkOutDate}<br/><p>(yyyy/MM/dd)</p>
                <h4>Price: <fmt:formatNumber type="number" value="${room.price}"></fmt:formatNumber>vnđ</h4>
                <h4>Rental day: ${room.rentalDay}</h4>
                <h4>Discount code: ${room.codeDis}</h4>
                <h4>Discount: <fmt:formatNumber type = "number" value ="${(100 - room.discount * 100)}" />%</h4>
                <h3>Total a room: <fmt:formatNumber type="number" value="${room.total}"></fmt:formatNumber>vnđ</h3>
                <c:set var="total" value="${total + room.total}"></c:set>
                </div>
        </c:forEach>
        <div style=" width: 100%; float: left; margin: 10px">
            <h1>Total:</h1><h3><fmt:formatNumber type="number" value="${total}"></fmt:formatNumber>vnđ</h3>
            <form action="MainController" onsubmit="return confirm('Do you want to checkout?')">
                <input type="submit" name="bntAction" value="Checkout Cart" />
            </form>
        </div>

        <style>
            .room {
                box-sizing: border-box;
                float: left;
                width: 20%;
                border-bottom: solid 1px black;
                border-right: solid 1px black;
            }
        </style>
    </body>
</html>
