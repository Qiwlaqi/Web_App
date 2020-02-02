<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 27.01.2020
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="label.title" bundle="${rb}"/></title>
</head>
<body>
<form name="Login" action="controller" method="post">
    <input type="hidden" name="command" value="login"/>
    <fmt:message key="label.login" bundle="${rb}"/><br/>
    <input type="text" name="login" value=""/>
    <br/><fmt:message key="label.password" bundle="${rb}"/><br/>
    <input type="password" name="password" value=""/>

    <br/> <c:out value="${errorLoginPassMessage}"/>
    <br/> <c:out value="${wrongaction}"/>
    <br/> <c:out value="${nullPage}"/><br/>
    <input type="submit" value="<fmt:message key="label.log.in" bundle="${rb}"/>"/>
</form>
<hr/>
<form name="Register" action="controller" method="post">
    <fmt:message key="label.register" bundle="${rb}"/><br/><br/>
    <input type="hidden" name="command" value="register"/>
    <input type="submit" value="<fmt:message key="label.register.submit" bundle="${rb}"/>"/>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
