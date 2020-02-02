<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25.01.2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>User list</h2>
<p><c:forEach var="user" items="${users}">
     <p>Login: <c:out value="${user.login}"/>
    </br>Name: <c:out value="${user.name}"/>
    </br>Surname: <c:out value="${user.surname} "/>
    </br>Phone: <c:out value="${user.phone}"/></p> <hr/>
</c:forEach> </p>
</body>
</html>
