<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 06.02.2020
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ClientList</title>
</head>
<body>
<h2>Client list</h2>
<p><c:forEach var="client" items="${clients}">
<p>Login: <c:out value="${client.login}"/>
    </br>Name: <c:out value="${client.name}"/>
    </br>Surname: <c:out value="${client.surname}"/>
    </br>Phone: <c:out value="${client.phone}"/>
    </br>Rooms: <c:out value="${client.rooms}"/></p> <hr/>
</c:forEach> </p>
</body>
</html>
