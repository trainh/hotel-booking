<%-- 
    Document   : history
    Created on : Oct 15, 2021, 5:26:24 PM
    Author     : trainh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <div class="function">
            <c:if test="${sessionScope.USER == null}">
                <a href="login.html">LOGIN</a>
            </c:if>
            <c:if test="${sessionScope.USER != null}">
                <h1>Hello ${sessionScope.USER.name}!</h1>
                <a href="LogoutController">LOGOUT</a>
            </c:if>
            <c:if test="${sessionScope.USER != null}">
                <a href="MainController?bntAction=history">HISTORY</a>
            </c:if>
            <c:if test="${sessionScope.CART.getSize() != null}">
                <a href="cart.jsp">CART: ${sessionScope.CART.getSize()}</a>
            </c:if>
        </div>
        <c:if test="${sessionScope.LIST_HISTORY.size() == 0 || sessionScope.LIST_HISTORY == null}">
            <h2>Don't have any purchase history</h2>
            <a href="index.jsp">Come back Home Page</a>
        </c:if>
        <c:forEach items="${sessionScope.LIST_HISTORY}" var="room">
            <div class="room">
                <h2>Hotel: ${room.hotel}</h2>
                <h3>Room: ${room.roomNumber}</h3>
                <h4>Kind Of Room: ${room.kindOfRoom}</h4>
                <c:set var="today" value="<%=new Date()%>"/>
                Booking date: <fmt:formatDate type="date" value="${today}" pattern="yyy/MM/dd"/> <p>(yyyy/MM/dd)</p>
                Check out date : ${room.checkOutDate}<br/><p>(yyyy/MM/dd)</p>
                <h4>Price: <fmt:formatNumber type="number" value="${room.price}"></fmt:formatNumber>vnđ</h4>
                <h4>Rental day: ${room.rentalDay}</h4>
                <h4>Discount code: ${room.codeDis}</h4>
                <h4>Discount: <fmt:formatNumber type = "number" value = "${(100 - room.discount * 100)}" />%</h4>
                <h3>Total a room: <fmt:formatNumber type="number" value="${room.total}"></fmt:formatNumber>vnđ</h3>
                <c:set var="total" value="${total + room.total}"></c:set>
                    <form action="MainController" onSubmit="return confirm('Do you want to delete?')">
                        <input type="submit" name="bntAction" value="Delete Room History" />
                        <input type="hidden" name="historyID" value="${room.historyID}" />
                </form>
            </div>
        </c:forEach>
        <style>
            .room {
                box-sizing: border-box;
                float: left;
                width: 15%;
                border-bottom: solid 1px black;
                border-right: solid 1px black;
            }
        </style>
    </body>
</html>
