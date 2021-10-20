<%-- 
    Document   : index
    Created on : Oct 9, 2021, 6:29:45 PM
    Author     : trainh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css-index.css" rel="stylesheet" type="text/css"/>
        <title>Index Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LIST_HOTEL == null}">
            <c:redirect url="GetHotelController"></c:redirect>
        </c:if>
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
        <div class="nav">
            <div class="hotel">
                <c:forEach items="${sessionScope.LIST_HOTEL}" var="hotel">
                    <h5><a href="MainController?bntAction=getRoom&hotel=${hotel.hotel}">${hotel.hotel}</a></h5>
                    <p>Address: ${hotel.address}</p>
                </c:forEach>
            </div>

            <c:if test="${sessionScope.LIST_HOTEL != null && sessionScope.LIST_ROOM != null}">
                <div class="kind">
                    <form action="MainController">
                        <select name="kindOfRoom">
                            <option value="${sessionScope.KIND_OF_NAME}" selected hidden>${sessionScope.KIND_OF_NAME}</option>
                            <option value="All">All</option>
                            <c:forEach items="${sessionScope.LIST_KIND}" var="kind">
                                <option value="${kind.kindOfRoom}">${kind.kindOfRoom}</option>
                            </c:forEach>
                        </select>
                        <br/><br/>
                        <input type="hidden" name="hotel" value="${sessionScope.HOTEL}"/>
                        <input type="submit" name="bntAction" value="Search Kind" />
                    </form>
                </div>
            </c:if>
        </div>
        <div class="section">
            <h1>${requestScope.ERRORSTRING}</h1>
            <c:if test="${sessionScope.LIST_ROOM == null || sessionScope.LIST_KIND == null}">
                <h3>Choose a hotel</h3><br/>
                <h1><-------------</h1>
            </c:if>
            <p>${sessionScope.HOTEL} - ${sessionScope.KIND_OF_NAME}</p>
            <h3>${sessionScope.ERRORSTRING}</h3>
            <c:if test="${sessionScope.LIST_ROOM.size() == 0}"><h3>Don't any empty room!</h3></c:if>
            <c:remove scope="session" var="ERRORSTRING"></c:remove>
                <div class="room">
                <c:forEach begin="0" varStatus="counter" end="${sessionScope.LIST_ROOM.size()}" items="${sessionScope.LIST_ROOM}" var="room">
                    <div class="room-detail">
                        <h3>Room: ${room.roomNumber}</h3>
                        <h4>Kind of room: ${room.kindOfRoom}</h4>
                        <fmt:setLocale value = "vi_VN"/>
                        <h4>Price: <fmt:formatNumber type="number" value="${room.price}"></fmt:formatNumber>vnđ / day</h4>
                        <a href="booking.jsp?posRoomID=${counter.count - 1}" style="float: left">Booking Now</a>
                        <form action="MainController">
                            <input type="submit" name="bntAction" value="Add To Cart" style="float: left; margin-left: 10px"/>
                            <input type="hidden" name="roomID" value="${room.roomID}" />
                            <input type="hidden" name="hotel" value="${sessionScope.HOTEL}"/>
                            <input type="hidden" name="roomNumber" value="${room.roomNumber}" />
                            <input type="hidden" name="kindOfRoom" value="${room.kindOfRoom}" />
                            <input type="hidden" name="price" value="${room.price}" />
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
