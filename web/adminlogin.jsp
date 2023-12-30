<%@page import="com.one.stop.shop.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link rel="stylesheet" href=".\CSS\adminlogin.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Righteous&family=Satisfy&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <!-- Login container -->
        <div class="main">
            <!-- LEFT -->
            <div class="left">
                <!--Invalid  Credential start-->
                <%
                    Message m = (Message) session.getAttribute("msg");
                    if (m != null) {
                        String type = m.getType();
                        if (type == "error") {
                %>
                <div style="font-size: 12px; text-align: center;color: red">
                    <%=m.getContent()%>
                </div>
                <%
                } else {
                %>
                <div style="font-size: 12px; text-align: center;color: green">
                    <%=m.getContent()%>
                </div>
                <%
                        }
                        session.removeAttribute("msg");
                    }
                %>
                <!--Invalid Credential end-->

                <div class="logo"><img src="./Resources/loginSignup/ONE STOP SHOP.png" alt="No image found"></div>
                <div class="textheading">
                    <h2>Admin Login</h2>
                </div>
                <div class="input">
                    <form action="AdminLoginServlet" method="POST">
                        <input type="text"  placeholder="Username" name="u_name" id="user-name" required>
                        <input type="password"  placeholder="Password" name="u_pass" id="pass" required>
                        <!-- Sign in button -->
                        <div class="submit">
                            <input type="submit" value="Sign in">
                        </div>
                        <span class="admin-login"><a href="./login.jsp">Click here to User Login</a></span>
                    </form>
                </div>
            </div>
            <div class="right">
                <p class="welcome">Welcome<br> Admin !</p>
            </div>
        </div>
    </body>
</html>