<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Forgot Password</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link href="./CSS/confirmPassword.css" rel="stylesheet" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
        
        <script
            src="https://kit.fontawesome.com/23ed75a8e5.js"
            crossorigin="anonymous"
        ></script>
    </head>
    <body>
        <div class="wrapper">
            <div class="set-pass">
                <%
                    String email = request.getParameter("email");
                %>
                <form id="cnf-form" action="ConfirmPasswordServlet?email=<%=email%>" method="POST">

                    <div class="password">
                        <div class="heading">
                            <h1>Create Password</h1>
                            <span
                                ><p>
                                    Your new Password should be different from the previous
                                    password.
                                </p></span
                            >
                        </div>
                        <label for="pass">New password</label>
                        <input
                            type="password"
                            name="password"
                            id="pass"
                            minlength="6"
                            maxlength="15"
                            required
                            pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$"
                            />
                        <i class="fa-regular fa-eye" id="toggle-pass1"></i>
                        <label for="confirm-pass">Confirm New password</label>
                        <input
                            type="password"
                            name="confirm-password"
                            id="confirm-pass"
                            minlength="6"
                            maxlength="15"
                            required
                            pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$"
                            />
                        <i class="fa-regular fa-eye" id="toggle-pass2"></i>
                        <p id="error-msg"></p>
                        <input  id="redirect-btn"  class="reset-btn" name="submitBtn" type="Submit" value="Reset password">
                    </div>
                </form>
            </div>
        </div>
                
        <script src="./JAVASCRIPT/confirmPassword.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
</html>