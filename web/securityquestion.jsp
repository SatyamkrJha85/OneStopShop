<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./CSS/securityquestion.css" rel="stylesheet">
        <title>Security Question</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <img src="./Resources/securityquestion/illustrations.jpg">
        <div class="main-container">
            <h1>Security Question</h1>
            <form action="SecurityQuestionServlet" method="post">
                <%
                    String email = request.getParameter("email");
                %>
                <input type="hidden" id="answer" name="email" value="<%=email%>"><br>
                <input type="text" placeholder="Enter your nickname" id="answer" name="answer" required><br>
                <input type="submit" name="Submit" id="submit">
            </form>
        </div>
    </body>
</html>