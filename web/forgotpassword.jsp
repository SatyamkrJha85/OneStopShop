<!DOCTYPE html>
<%@page import="com.one.stop.shop.entities.Message"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./CSS/forgotpassword.css" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <title>Forgot Password</title>
    </head>
    <body>
        <!--<div class="form">-->
        <form id="forgot-pass" action="ForgotPasswordServlet" method="POST">    
            <div class="outer-logo">
                <div class="logo">
                    <img src="./Resources/forgotpassword/logo.jpeg" alt ="logo">
                </div>
            </div>     
            <div class="heading">
                <p>Enter the email address associated with your account.</p>
            </div>
            <div class="email">
                <label for="email-id">Email</label>
                <input name="cnfemail" type="email" class="txtbox" placeholder="Enter your email" id="email-id" required>
            </div>
            <!--Invalid  Credential start-->
            <%
                Message m = (Message) session.getAttribute("msg");
                if (m != null) {
                    String type = m.getType();
                    if (type == "error") {
            %>
            <div style="font-size: 12px; 
                 text-align: center;
                 width:24rem;
                 margin-top: -1.5rem;
                 margin-bottom: 1rem;
                 color: red">
                <%=m.getContent()%>
            </div>
            <%
            } else {
            %>
            <div style="font-size: 12px; 
                 text-align: center;
                 width:24rem;
                 margin-top: -1.5rem;
                 margin-bottom: 1rem;
                 color: green">
                <%=m.getContent()%>
                <%
                        }
                        session.removeAttribute("msg");
                    }
                %>
                <!--Invalid Credential end-->
                <div class="submit">
                    <input id="submit" type="submit" value="Continue">
                </div>
                <div class="sign-up">
                    <p>Don't have an account? <a href="./signup.jsp">Sign up</a></p>
                </div>
        </form>
        <!--</div>-->

    </body>
</html>