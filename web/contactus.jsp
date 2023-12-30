<%@page import="com.one.stop.shop.entities.Users"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users user = (Users) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact us</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link rel="stylesheet" href="./CSS/contactus.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <div id="container">
            <div id="back">
                <div id="messageform">
                    <form action="ContactUsServlet" method="POST">
                        <h2>Send a Message</h2>
                        <input type="text" name="firstname" placeholder="First Name" required>
                        <input type="text" name="lastname" placeholder="Last Name" required>
                        <input type="email" name="email"  placeholder="Email" required>
                        <input type="text" name="phone"  placeholder="Phone Number" required>
                        <textarea name="subject" required placeholder="Type your text here...."></textarea>
                        <input type="submit" value="Send" id="button">
                    </form>

                    <div id="two">
                        <div id="twoin">
                            <h2>Contact Info</h2>

                            <p><i class="fa-solid fa-location-dot fa-1x"></i>Saltlake, Kolkata</p>

                            <p><i class="fa-regular fa-envelope fa-1x"></i>onestopshop.ecommerce@gmail.com</p>

                            <p><i class="fa-solid fa-mobile-screen-button fa-1x"></i>6133-462-369</p>
                            <div id="twofoot">
                                <i class="fa-brands fa-facebook-f fa-2x"></i>

                                <i class="fa-brands fa-twitter fa-2x"></i>

                                <i class="fa-brands fa-instagram fa-2x"></i>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
    </body>
</html>