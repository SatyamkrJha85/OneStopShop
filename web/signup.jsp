<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign up</title>
        <link rel="stylesheet" href="./CSS/signup.css">
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
                <!-- Logo -->
                <div class="logo"><img src="./Resources/loginSignup/ONE STOP SHOP.png" alt="No image found"></div>
                <!-- Heading -->
                <div class="textheading">
                    <h2>Create your account</h2><br>
                </div>
                <!-- Input email and password -->
                <div class="input">
                    <form id="reg-form" action="http://localhost:8080/OneStopShop/SignUpServlet" method="POST">
                        <label for="user-name">Name<span class="star">*</span></label>
                        <input name="u_name" id="user-name" type="text" placeholder="Enter your name" required>

                        <label for="email">Email<span class="star">*</span></label>
                        <input name="u_email" id="email" type="email"  placeholder="Enter your email" required>

                        <label for="password">Password<span class="star">*</span></label>
                        <input name="u_pass" id="password" type="password" minlength="6" maxlength="15"  placeholder="Enter your password" required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]+$" />
                        <p class="alphaNumeric">(Atleast alphabet and number should be there)</p>
                        <label for="hint-pass">Hint Question (Nick Name)<span class="star">*</span></label>
                        <input name="hint-pass" id="hint-pass" type="text" minlength="4" maxlength="15"  placeholder="Enter your nick name" required />
                        <!-- Check box for terms and conditions and  forgot password -->
                        <div class="extrafeatures">
                            <div class="check-box">
                                <input name="condition" type="checkbox" id="condition" required>
                                <p id="terms_condition">I agree to all Terms & conditions</p>
                            </div>
                        </div>
                        <div class="modal" id="terms-modal">
                            <div class="modal-content">
                                <h3>Terms of use</h3>
                                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laborum eos non nesciunt magnam odio praesentium aliquam harum earum perferendis qui libero maiores blanditiis ipsam atque, ab reprehenderit impedit sapiente nobis?</p>
                                <button id="close-btn" class="terms-btn">Close</button>
                            </div>
                        </div>
                        <div class="submit">
                            <input type="submit" value="Sign Up">
                        </div>
                    </form>
                </div>
                <!-- Sign in button -->

                <div class="login">Already have an account?<a style="margin-left:2px;" href="./login.jsp">Log in</a></div>
            </div>
            <!-- RIGHT   -->
            <div class="right">
                <p class="welcome">Welcome to</p>
                <p class="onestopshop">ONE STOP SHOP</p>
            </div>
        </div>

        <script src="./JAVASCRIPT/signup.js"></script>

    </body>
</html>
