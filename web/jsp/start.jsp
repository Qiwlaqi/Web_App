<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<html>
<head>
    <title><fmt:message key="label.title" bundle="${rb}"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<h2>Form to show users</h2> <br/>
<form action="controller" method="get">
    <input type="hidden" name="command" value="show_user"/>
    <input type="submit" name="button" value="show list"/>
</form>
<br/>
<hr/>
<form action="controller" method="post">
    <h2>Form to add user</h2>
    <input type="hidden" name="command" value="create_user"/>
    <br/>Login: <input name="login"/> <br/><br/>
    Password: <input name="password"/><br/><br/>
    Name: <input name="name"/><br/><br/>
    Surname: <input name="surname"/><br/><br/>
    Phone: <input name="phone"/><br/><br/>
    Role: <input name="role"/><br/><br/>
    <input type="submit" value="submit"/>
</form>
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_user"/>
    <h2>Form to delete user</h2>
    <br/> Input user's login to delete: <input name="login"/>
    <input type="submit" value="delete"/>
</form>
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="update_user"/>
    <h2>Form to update user</h2>
    <br/>Login: <input name="login"/> <br/><br/>
    Password: <input name="password"/><br/><br/>
    Name: <input name="name"/><br/><br/>
    Surname: <input name="surname"/><br/><br/>
    Phone: <input name="phone"/><br/><br/>
    <input type="submit" value="submit"/>
</form>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>
