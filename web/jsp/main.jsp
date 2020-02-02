<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 27.01.2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome</h2>
    <hr/>
        ${user}, hello!
    <hr/>
    You are ${role}
    <hr/>
    <jsp:forward page="start.jsp"/>
    <a href="controller?command=logout">Logout</a>
</body>
</html>
