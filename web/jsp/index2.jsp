<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<html>
<head>
    <title><fmt:message key="label.title" bundle="${rb}"/></title>
</head>
<body>

</body>
</html>
