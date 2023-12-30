<%@page import="java.util.List"%>
<%@page import="com.one.stop.shop.dao.CartDao"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.entities.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.one.stop.shop.entities.Users"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="java.sql.*"%>
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
        <meta charset="UTF-8" />
        <title>Shopping Cart</title>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./CSS/addtocart.css" />
        <link rel="stylesheet" href="./CSS/normalnavbar.css" />
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>

    <body>
        <div style="height:5rem">
            <%@include file="./normalnavbar.jsp" %>
        </div>
        <%            
            String userEmail = user.getuEmail();

            CartDao cd = new CartDao((OracleConnection) ConnectionProvider.getConnection());
            List<Cart> cart = cd.getCartListByUserId(userEmail);
            int totalPrice = 0;
            if (cart == null || cart.isEmpty()) {
        %>
        <div class="cart-empty" style="    display:flex;
             justify-content: center;
             align-items: center;
             flex-direction: column;">
            <img src="./Resources/addtocart/empty-cart.png">
            <h2>Your cart is empty</h2>
        </div>
        <%
        } else {
        %>
        <table class="cart-table">
            <thead>
                <tr>
                    <th> Item id </th>
                    <th>Item name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total price</th>
                    <th>Action</th>
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
                    <td><a href="UpdateQuantityServlet?uid=<%=userEmail%>&id=<%=cartItem.getProductId()%>&qty=<%=cartItem.getQuantity() - 1%>&action=1"><button> - </button></a>
                        <span style="margin:10px"><%=cartItem.getQuantity()%></span>
                        <a href="UpdateQuantityServlet?uid=<%=userEmail%>&id=<%=cartItem.getProductId()%>&qty=<%=cartItem.getQuantity() + 1%>&action=2"><button> + </button></a>
                    </td>
                    <% int TPrice = cartItem.getQuantity() * cartItem.getPrice();%>
                    <td>&#8377 <%=TPrice%></td>
                    <td>
                        <a href="UpdateQuantityServlet?uid=<%=userEmail%>&id=<%=cartItem.getProductId()%>&qty=0&action=3" '>
                            <button >Remove</button>
                        </a>
                    </td>

                </tr>

                <% totalPrice += cartItem.getQuantity() * cartItem.getPrice();%>
                <%
                    }
                %>
            </tbody>
            <tr><td colspan=6 style="font-size:20px; font-weight:600;">Total Price: &#8377  <%=totalPrice%></td></tr>
        </table>
        <div class="cart-total">
            <a href="checkout.jsp?price=<%=totalPrice%>&uid=<%=userEmail%>"
               <button id="checkout-button" class="checkout-btn">Checkout</button>
            </a>
        </div>
        <%
            }
        %>
        <div id='toast'></div>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="./JAVASCRIPT/addtocart.js"></script>

        <%
            String jsCode = (String) session.getAttribute("jsCode");
        %>
        <script>
            <%= jsCode%>
        </script>
        <%
            session.removeAttribute("jsCode");
        %>
    </body>
</html>