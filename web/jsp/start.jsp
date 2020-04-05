<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.title" bundle="${rb}"/></title>
    <link rel="stylesheet" type="text/css" href="../WEB-INF/header.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#cleaners">Services</a>
    <a href="#contact">Cleaners</a>
    <a href="#about">Clients</a>
    <a href="#about">Users</a>
    <a href="#about">Orders</a>
    <a><img src="images/sunlight-cleaning-logotype.png" width="65%" id="icon"></a>
    <a id="welcome">Welcome, guest</a>
    <a id="de">
        <form name="Language" action="controller" method="post">
            <input type="hidden" name="command" value="language"/>
            <input type="hidden" name="jsp" value="${pageContext.request.requestURI}"/>
            <button type="submit" value="de">DE</button>
        </form>
    </a>
    <a id="en">
        <form name="Language" action="controller" method="post">
            <input type="hidden" name="command" value="language"/>
            <input type="hidden" name="jsp" value="${pageContext.request.requestURI}"/>
            <button type="submit" value="en">EN</button>
        </form>
    </a>
</div>
<h2>Form to show services</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_service"/>
    <button type="submit" value="show"></button>
    <input type="submit" name="button" value="show services"/>
</form>
<hr/>
<h2>Form to show cleaners</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_cleaner"/>
    <input type="submit" name="button" value="show cleaners"/>
</form>
<hr/>
<h2>Form to show orders</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_order"/>
    <input type="submit" name="button" value="show orders"/>
</form>
<br/>
<hr/>
<form action="controller" method="post">
    <h2>Form to create order</h2>
    <input type="hidden" name="command" value="create_order"/>
    <br/>Service description: <input name="service"/> <br/><br/>
    Cleaner: <input name="cleaner"/><br/><br/>
    Date: <input name="date"/><br/><br/>
    <input type="submit" value="submit"/>
</form>
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="update_client"/>
    <h2>Form to update client</h2>
    <br/>
    Password: <input name="password"/><br/><br/>
    Name: <input name="name"/><br/><br/>
    Surname: <input name="surname"/><br/><br/>
    Phone: <input name="phone"/><br/><br/>
    Rooms: <input name="rooms"/><br/><br/>
    <input type="submit" value="update client"/>
</form>
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_order"/>
    <h2>Form to delete order</h2>
    <br/> Input order's id to delete: <input name="orderId"/>
    <input type="submit" value="delete"/>
</form>
<hr/>
<h2>Form to show orders</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_order"/>
    <input type="submit" name="button" value="show orders"/>
</form>
<hr/>
<h2>Form to show orders</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_order"/>
    <input type="submit" name="button" value="show orders"/>
</form>
<hr/>
<h2>Form to show users</h2> <br/>
<form action="controller" method="get">
    <input type="hidden" name="command" value="show_user"/>
    <input type="submit" name="button" value="show users"/>
</form>
<hr/>
<h2>Form to show clients</h2> <br/>

<form action="controller" method="get">
    <input type="hidden" name="command" value="show_client"/>
    <input type="submit" name="button" value="show clients"/>
</form>
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_order"/>
    <h2>Form to delete order</h2>
    <br/> Input order's id to delete: <input name="orderId"/>
    <input type="submit" value="delete"/>
</form>

<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="delete_user"/>
    <h2>Form to delete user</h2>
    <br/> Input user's login to delete: <input name="login"/>
    <input type="submit" value="delete"/>
</form>
<hr/>
<h2>Form to create cleaner</h2>
<form action="controller" method="post">
    <input type="hidden" name="command" value="create_cleaner"/>
    <br/>
    Login: <input name="login"/><br/><br/>
    Password: <input name="password"/><br/><br/>
    Name: <input name="name"/><br/><br/>
    Surname: <input name="surname"/><br/><br/>
    Phone: <input name="phone"/><br/><br/>
    Category: <input name="category"/><br/><br/>
    Seniority: <input name="seniority"/><br/><br/>
    <input type="submit" value="create cleaner"/>
</form>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>
