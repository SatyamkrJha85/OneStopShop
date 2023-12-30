<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <style>
            .error-image{
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
            }
            .error-image h3{
                font-size: 40px;
                font-weight: 400;
                font-family:serif;
            }
            .error-image a{
                padding: 0.8rem;
                padding-top: 0.4rem;
                padding-bottom: 0.4rem;
                margin: 1.5rem;
                background-color: #3876BF;
                color: white;
                border-radius: 5px;
                text-decoration: none;
                font-family:serif;
            }
        </style>
    </head>
    <%@page import="com.one.stop.shop.entities.Users"%>
    <%
        Users user = (Users) session.getAttribute("currentUser");
    %>
    <body>
        <div class="error-image">
            <img src="./Resources/error/error.png" alt="Girl in a jacket" width="300" height="250">
            <h3>Sorry! Something went wrong ... </h3>
            <%= exception%>
            <%if (user != null) {%>
            <a href="landing.jsp">Home</a>
            <%} else {%>
            <a href="index.jsp">Home</a>
            <%}%>
        </div>
    </body>
</html>
