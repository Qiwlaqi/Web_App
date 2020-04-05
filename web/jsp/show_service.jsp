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
    <title>ServiceList</title>
</head>
<body>
<h2>Service list</h2>
<p><c:forEach var="service" items="${services}">
<p>ServiceName: <c:out value="${service.description}"/>
    </br>Price: <c:out value="${service.price}"/></p> <hr/>
</c:forEach> </p>
</body>
</html>
