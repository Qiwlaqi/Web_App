<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 06.02.2020
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderList</title>
</head>
<body>
<h2>${ordermessage}</h2>
<p><c:forEach var="order" items="${orders}">
<p>OrderId: <c:out value="${order.orderId}"/>
    </br>Description: <c:out value="${order.description}"/>
    </br>Date: <c:out value="${order.date}"/></p> <hr/>
</c:forEach> </p>
</body>
</html>
