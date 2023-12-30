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
<html>
    <head>
        <script
            src="https://kit.fontawesome.com/e8fa2e31b4.js"
            crossorigin="anonymous"
        ></script>
        <title>Payment</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link rel="stylesheet" href="./CSS/payment.css" />
    </head>
    <body>
        <%
            String userEmail = request.getParameter("email");
            String price = request.getParameter("price");
            String fullname = request.getParameter("firstName");
            String Address = request.getParameter("address");
        %>
        <div class="container">
            <div class="left">
                <p>Payment</p>
                <hr style="border: 1px solid #ccc; margin: 0 15px" />
                <div class="methods">
                    <div onclick="doFun()" id="tColorA" style="color: greenyellow">
                        <i class="fa-solid fa-credit-card" style="color: greenyellow"></i>
                        Debit/Credit card
                    </div>

                </div>
            </div>
            <div class="center">
                <a href="https://www.shift4shop.com/credit-card-logos.html"
                   ><img
                        alt="Credit Card Logos"
                        title="Credit Card Logos"
                        src="https://www.shift4shop.com/images/credit-card-logos/cc-lg-4.png"
                        width="250"
                        height="auto"
                        /></a>
                <hr style="border: 1px solid #ccc; margin: 0 15px" />

                <div class="card-details">
                    <form action="PaymentServlet?price=<%=price%>&fullname=<%=fullname%>&email=<%=userEmail%>&address=<%=Address%>" method="post">
                        <p>Card number</p>
                        <div class="c-number" id="c-number">
                            <input
                                id="number"
                                class="cc-number"
                                placeholder="Card number"
                                maxlength="19"
                                required
                                />
                            <i class="fa-solid fa-credit-card" style="margin: 0"></i>
                        </div>

                        <div class="c-details">
                            <div>
                                <p>Expiry date</p>
                                <input
                                    id="e-date"
                                    class="cc-exp"
                                    placeholder="MM/YY"
                                    required
                                    maxlength="5"
                                    required
                                    />
                            </div>
                            <div>
                                <p>CVV</p>
                                <div class="cvv-box" id="cvv-box">
                                    <input
                                        id="cvv"
                                        class="cc-cvv"
                                        placeholder="CVV"
                                        required
                                        maxlength="3"
                                        required
                                        />
                                    <i
                                        class="fa-solid fa-circle-question"
                                        title="3 digits on the back of the card"
                                        style="cursor: pointer"
                                        ></i>
                                </div>
                            </div>
                        </div>
                        <button>PAY &#8377; <%=price%></button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
