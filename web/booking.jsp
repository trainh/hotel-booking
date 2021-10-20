<%-- 
    Document   : booking
    Created on : Oct 11, 2021, 7:49:53 AM
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
        <title>Booking Page</title>
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
        </div>
        <c:set scope="session" var="ROOM" value="${sessionScope.LIST_ROOM.get(param.posRoomID)}"></c:set>
            <div>
                <h1>Hotel: ${sessionScope.HOTEL}</h1>
            <h2>Room: ${sessionScope.ROOM.roomNumber}</h2>
            <h3>Kind Of Room: ${sessionScope.ROOM.kindOfRoom}</h3>
            <h3>Price: <fmt:formatNumber type="number" value="${sessionScope.ROOM.price}"></fmt:formatNumber>vnđ / day</h3>
            <c:set var="today" value="<%=new Date()%>"/>
            Booking Date: <fmt:formatDate type="date" value="${today}" pattern="MM/dd/yyyy"/> <p>(MM/dd/yyyy)</p>
            
            <form action="MainController">
                <input type="hidden" name="roomID" value="${sessionScope.ROOM.roomID}" />
                <input type="hidden" name="roomNumber" value="${sessionScope.ROOM.roomNumber}" />
                <input type="hidden" name="price" value="${sessionScope.ROOM.price}" />
                <input type="hidden" name="kindOfRoom" value="${sessionScope.ROOM.kindOfRoom}" />
                <input type="hidden" name="hotel" value="${sessionScope.HOTEL}" />
                <h3>Embroidery only for 1 month!</h3>
                Check out day: <input type="date" name="checkOutDate" value=""/><br/><br/>
                <h2>${requestScope.ERRORR_CHECKOUTDATE}</h2>
                Discount code: <input type="text" name="discountCode" value=""/><br/><br/>
                <input type="submit" name="bntAction" value="bookingNow" />
            </form>
                <h2>${requestScope.ERRORSTRING}</h2>
        </div>
    </body>
</html>