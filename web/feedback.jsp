<%@page import="com.one.stop.shop.dao.SecondaryDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.entities.Users"%>
<!DOCTYPE html>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users user = (Users) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./CSS/feedback.css">
        <title>Feedback</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet" />
    </head>

    <body>
        <img src="./Resources/feedback/feedback-img.jpg">
        <div class="container">
            <h2>Submit Your Feedback</h2>
            <%
                SecondaryDao dao = new SecondaryDao((OracleConnection) ConnectionProvider.getConnection());
                int fid = 0;

                if (dao.maxFeedbackID() == 0) {
                    fid = 101;
                } else {
                    fid = dao.maxFeedbackID() + 1;
                }
            %>
            <form action="http://localhost:8080/OneStopShop/FeedbackServlet?id=<%=fid%>" method="POST">
                <input type="email" id="email" name="email" placeholder="Your Email" required>
                <textarea id="comment" name="subject" rows="5" placeholder="Your Feedback" required></textarea>
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>

</html>