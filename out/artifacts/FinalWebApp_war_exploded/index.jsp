<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title><fmt:message key="label.title" bundle="${rb}"/></title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/header.css">
    <style>
        <%@include file="/WEB-INF/header.css"%>
    </style>
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
<br>
<div class="slider">
    <div class="item">
        <img src="images/1.jpg" alt="Первый слайд">
        <div class="slideText">Welcome to Cleaning Service in New York of high-quality and convenient pricing policy </div>

    </div>



    <br>
    <div id = "cleaners">

        <h2 id = "sun">Sunlight Cleaning Services</h2> <br/>

        <ul id = "list"></a>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning company NYC check icon we can guarantee you the high quality of cleaning works</li>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning company NYC check icon we always arrive on time</li>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning services New York check icon we have no extra charges (we include supplies in price)</li>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning services New York check icon we work until the job is complete</li>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning company NYC check icon we are always ready to answer any of your questions</li>
            <li style="list-style-image: url(images/icon-checked.png);">Sunlight cleaning company NYC check icon our cleanings are fully insured and bonded</li></ul>
        <div><img src = "images/service.jpg" id = "ser"></div>
        <form action="controller" method="get">
            <input type="hidden" name="command" value="show_service"/>
            <button type="submit" id = "serv">View our services</button>
        </form>
    </div>
    <br>
    <div id = "firf">

        <p id = "firsttext" align = "center">FINDING RELIABLE CLEANING SERVICE PROFESSIONALS FOR YOU</p>
        <p id= "secondtext" align = "center" >We know inviting someone into your home is a big deal. All Sunlight cleaners are carefully checked
            out by our cleaning company NYC, so we choose the right person to care for your home.</p>
        <form action="controller" method="get">
            <input type="hidden" name="command" value="show_cleaner"/>
            <button type="submit" id = "clean">View cleaners</button>
        </form>
        <button onclick="document.getElementById('id01').style.display='block'" id = "cle"> Create new cleaner</button>
    </div>


    <!-- Button to open the modal -->


    <!-- The Modal (contains the Sign Up form) -->
    <div id="id01" class="modal">
        <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal"></span>
        <form class="modal-content" action="controller" method="post">
            <div class="container" >
                <hr>
                <%--<label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <label for="psw-repeat"><b>Repeat Password</b></label>
                <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
                    <input type="hidden" name="command" value="create_cleaner"/>
                    <br/>--%>
                <input type="hidden" name="command" value="create_cleaner"/>
                <label for="email"><b>Login</b></label>
                <input type="text" name="login" required/>
                <label for="email"><b>Password</b></label>
                <input type="password" name="password" required/>
                <label for="email"><b>Name</b></label>
                <input type="text" name="name" required/>
                <label for="email"><b>Surname</b></label>
                <input type="text" name="surname" required/>
                <label for="email"><b>Phone</b></label>
                <input type="text" name="phone" required/>
                <label for="email"><b>Category</b></label>
                <input type="text" name="category" required/>
                <label for="email"><b>Seniority</b></label>
                <input type="text" name="seniority" required/>
                <div class="clearfix" >
                    <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn" >Cancel</button>
                    <button type="submit" class="signup" id = "bt">Sign Up</button>
                </div>
            </div>
        </form>
    </div>
    <script>

        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
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
<jsp:include page="jsp/footer.jsp"/>
</body>
</html>
