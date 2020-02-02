<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24.01.2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form name="Language" action="controller" method="post">
    <hr/>
    <fmt:message key="label.language" bundle="${rb}"/><br/><br/>
    <input type="hidden" name="command" value="language"/>
    <input type="hidden" name="jsp" value="${pageContext.request.requestURI}"/>
    <input type="radio" name="lang" value="de" />DE
    <input type="radio" name="lang" value="en" />EN<br/><br/>
     <c:out value="${languageerror}"/><br/>
    <input type='submit' value ='<fmt:message key="label.save" bundle="${rb}"/>' />
</form>
<p>Copyright ©Max & Cleaning, Inc. 2020.</p>
</body>
</html>
