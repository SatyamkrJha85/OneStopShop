<%@page import="com.one.stop.shop.entities.Users"%>
<%@page import="com.one.stop.shop.entities.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.one.stop.shop.dao.CartDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>
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
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Check out</title>
        <link rel="stylesheet" href="./CSS/checkout.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>

        <header>
            <h1>Checkout</h1>
        </header>

        <%
            String price = request.getParameter("price");
            String userEmail = request.getParameter("uid");
        %>
        <div class="main-container">
            <div class="container">
                <%
                    CartDao cd = new CartDao((OracleConnection) ConnectionProvider.getConnection());
                    List<Cart> cart = cd.getCartListByUserId(userEmail);
                %>

                <table class="cart-table" style="font-size: 12px;width:37.5rem">
                    <thead>
                        <tr>
                            <th> Item id </th>
                            <th>Item name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Cart cartItem : cart) {
                        %>
                        <tr>
                            <td><%=cartItem.getProductId()%></td>
                            <td><%=cartItem.getProductName()%></td>
                            <td>&#8377 <%=cartItem.getPrice()%></td>
                            <td><%=cartItem.getQuantity()%></td>
                            <% int TPrice = cartItem.getQuantity() * cartItem.getPrice();%>
                            <td>&#8377 <%=TPrice%></td>

                            <%
                                }
                            %>
                    </tbody>
                </table>
                <div id="totalAmount">Total Amount: &#8377;<%=price%></div>
            </div>
            <div class="container">
                <form action="payment.jsp?email=<%=userEmail%>&price=<%=price%>" method="post">
                    <div class="form-group">
                        <label for="firstName">Your name:</label>
                        <input type="text" id="firstName" name="firstName" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Your shipping address:</label>
                        <textarea name="address" id="address" rows="4" cols="50" required style="resize: none"></textarea>
                    </div>
                    <a >
                        <button type="submit">Continue</button>
                    </a>
                </form>
            </div>
        </div>

    </body>
</html>