<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify OTP</title>
        <link rel="stylesheet" href=".\CSS\verifyotp.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>
    <body>
        <%!
            String vname, votp, vemail;
        %>
        <%
            HttpSession sess = request.getSession(false);
            try {
                if (sess != null) {
                    vname = sess.getAttribute("name").toString();
                    votp = sess.getAttribute("otp").toString();
                    vemail = sess.getAttribute("email").toString();
                }
            } catch (Exception ex) {
        %>
        <script>
            alert("Session was not created!!!");
            alert("Redirecting for logging==>>");
            location.href = "signup.jsp";
        </script>
        <%
            }
            if (request.getParameter("bVerify") != null) {
                if (request.getParameter("tbOTP").equals(votp)) {
        %>
        <script>
            alert("OTP verified successfully!!!");
            location.href = "login.jsp";
        </script>
        <%
        } else {
        %> 
        <h3 style="color:red">Wrong OTP. Please try again!!!</h3>                 
        <%
                }
            }
        %>
        <h2 class="page-title">OTP Verification Form</h2>
        <div class="otp-container">
            <form name="frmOTP" method="POST" action="./verifyotp.jsp">
                <div class="otp-form">
                    <div class="otp-input">
                        <label for="otpInput">Enter OTP:</label>
                        <input type="number" size="4" name="tbOTP" required/>
                    </div>
                    <div class="otp-buttons">
                        <button type="submit" name="bVerify" id="verify">Verify</button>
                        <button type="reset" name="bReset" id="reset">Reset</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>