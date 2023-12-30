<%@page import="com.one.stop.shop.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href=".\CSS\login.css">
        <!-- Add this in the <head> section of your HTML -->
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
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
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
                <!-- Logo -->
                <div class="logo"><img src="./Resources/loginSignup/ONE STOP SHOP.png" alt="No image found"></div>
                <!-- Heading -->
                <div class="textheading">
                    <h2>Login to your account</h2>
                    <h4>Don't have an account? <a href="./signup.jsp">Sign Up Free!</a></h4>
                </div>

                <div class="input">
                    <form action="LoginServlet" method="POST">
                        <input type="email"  placeholder="Email Address" name="u_email" id="email" required>
                        <input type="password"  placeholder="Password" name="u_pass" id="pass" required>
                        <!-- Sign in button -->
                        <div class="submit">
                            <input type="submit" value="Sign in">
                        </div>
                        <span class="admin-login"><a href="./adminlogin.jsp">Click here to Admin Login</a></span>
                        <!-- Check box for terms and conditions and  forgot password -->
                        <div class="extrafeatures">
                            <div class="forgot-password"><a href="./forgotpassword.jsp">Forgot password?</a></div>
                        </div>
                    </form>
                </div>

            </div>
            <!-- RIGHT   -->
            <div class="right">
                <p class="welcome">Welcome back !</p>
                <!-- <p class="onestopshop">ONE STOP SHOP</p> -->
            </div>
        </div>
    </body>
</html>