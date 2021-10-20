<%-- 
    Document   : cart
    Created on : Oct 13, 2021, 10:47:16 PM
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
        <title>Cart Page</title>
    </head>
    <body>
        <h1><a href="index.jsp">Hotel Booking</a></h1>
        <h2>Cart</h2>
        <div class="function">
            <c:if test="${sessionScope.USER == null}">
                <a href="login.html">LOGIN</a>
            </c:if>
            <c:if test="${sessionScope.USER != null}">
                <h1>Hello ${sessionScope.USER.name}!</h1>
                <a href="LogoutController">LOGOUT</a>
            </c:if>
                <a href="index.jsp">HOME</a>
        </div>
        <c:if test="${sessionScope.CART.getCart().size() != 0 && sessionScope.CART != null}">
            <div>
                <c:forEach items="${sessionScope.CART.getCart().values()}" var="room">
                    <div class="room">
                        <h2>Hotel: ${room.hotel}</h2>
                        <h3>Room: ${room.roomNumber}</h3>
                        <h4>Kind Of Room: ${room.kindOfRoom}</h4>
                        <h4>Price: <fmt:formatNumber type="number" value="${room.price}"></fmt:formatNumber>vnđ</h4>
                            <form action="MainController" onSubmit="return confirm('Do you want to delete?')">
                                <input type="submit" name="bntAction" value="Delete" />
                                <input type="hidden" name="roomID" value="${room.roomID}" />
                        </form>
                    </div>
                </c:forEach>
                <div style=" width: 100%; float: left; margin: 10px">
                    <c:set var="today" value="<%=new Date()%>"/>
                    Booking Date: <fmt:formatDate type="date" value="${today}" pattern="MM/dd/yyyy"/> <p>(MM/dd/yyyy)</p>
                    <form action="MainController">
                        <h3>Embroidery only for 1 month!</h3>
                        Check out Date: <input type="date" name="checkOutDate" value=""/><br/><br/>
                        <h2>${requestScope.ERRORSTRING}</h2>
                        Discount code: <input type="text" name="discountCode" value=""/><br/><br/>
                        <input type="submit" name="bntAction" value="Booking Room In Cart" />
                    </form>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.CART.getCart().size() == 0 || sessionScope.CART == null}">
            <h2>Don't have any room in cart</h2>
            <a href="index.jsp">Comeback Home</a>
        </c:if>
            <h1>${sessionScope.ERROR_CHECKOUT}</h1>
            <c:remove scope="session" var="ERROR_CHECKOUT"></c:remove>
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
