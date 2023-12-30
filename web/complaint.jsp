
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
        <title>Complaint</title>
        <link rel="stylesheet" href="./CSS/complaint.css">
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <!-- <div class="main-container"> -->

        <div class="form-section">
            <form action="ComplaintServlet">
                <div class="logo">
                    <img src="./Resources/landing/ONE STOP SHOP.png" alt="No image found">
                </div>

                <div class="heading">
                    <p>Customer Complaint Form</p>
                </div>

                <div class="name">
                    <div class="firstname">
                        <label for="firstname">First Name</label><br>
                        <input type="text" name="firstname" placeholder="First Name" class="txt" required="" >
                    </div>
                    <div class="lastname">
                        <label for="lastname">Last Name</label><br>
                        <input type="text" name="lastname" placeholder="Last Name"class="txt" required="">
                    </div>
                </div>

                <div class="email">
                    <label for="email">Email Address</label>
                    <input type="email" name="email" placeholder="Email address" class="txtbox" required="">
                </div>

                <div class="phone">
                    <label for="number">Phone number</label>
                    <input type="tel" name="number" placeholder="Phone number" class="txtbox" required="">
                </div>

                <div class="reason">
                    <label for="reasons">Reason for Complaint</label>
                    <select id="reasons" name="reasons" class="issue" required>
                        <option value="" selected disabled>Choose a reason for contacting us</option>
                        <option value="wrongProduct">Wrong product delivered</option>
                        <option value="delayedDelivery">Delivery time delayed</option>
                        <option value="differentSize">Product size was different</option>
                        <option value="highShippingCharges">Shipping charges too high</option>
                        <option value="noShippingLocation">Shipping not available to your location</option>
                        <option value="others">Others</option>
                    </select>
                </div>

                <div class="text-msg">
                    <label for="textarea">Description</label>
                    <textarea type="textarea" name="subject" class="msg" placeholder="Write Down Your Complaint" required=""></textarea>
                </div>

                <div class="submit">
                    <input type="submit" value="Submit">
                </div>

            </form>
        </div>
    </body>
</html>