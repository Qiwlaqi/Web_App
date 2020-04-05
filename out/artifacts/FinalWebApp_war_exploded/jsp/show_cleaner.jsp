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
    <title>CleanerList</title>
</head>
<body>
<h2>Cleaner list</h2>
<p><c:forEach var="cleaner" items="${cleaners}">
<p>Name: <c:out value="${cleaner.name}"/>
    </br>Surname: <c:out value="${cleaner.surname}"/>
    </br>Category: <c:out value="${cleaner.category}"/>
    </br>Seniority: <c:out value="${cleaner.seniority}"/></p> <hr/>
</c:forEach> </p>
</body>
</html>
