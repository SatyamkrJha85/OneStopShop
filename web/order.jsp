<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="com.one.stop.shop.entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.one.stop.shop.dao.OrderDao"%>
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
        <meta charset="UTF-8" />
        <title>My Orders</title>
        <link rel="stylesheet" href="./CSS/order.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>
    <body>
        <div style="height:5rem">
            <%@include file="./normalnavbar.jsp" %>
        </div>
        <header>
            <h1>My Orders</h1>
        </header>
        <%            
            OrderDao od = new OrderDao((OracleConnection) ConnectionProvider.getConnection());
            ProductsDao pd = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
            List<Order> order = od.getOrderListByUserId(user.getuEmail());
        %>
        <main>
            <section class="orders">

                <%
                    for (Order ord : order) {
                        String pid = ord.getpId();
                %>
                <div class="order-list">
                    <div class="order">
                        <div class="container">
                            <div style="background-image: url('./Resources/allproducts/<%=pd.productImage(pid)%>');
                                 width:200px;
                                 height:200px;
                                 background-size: cover;
                                 border-radius:10px"></div>
                            <div style="width:25rem">
                                <h3>Order #<%=ord.getOrderId()%></h3>
                                <h4><%=ord.getpName()%></h4>
                            </div>
                            <div style="width:12rem; text-align: center">
                                <%
                                    if (ord.getStatus().equals("Cancelled")) {
                                %>
                                <h3 style="color: red;"><%=ord.getStatus()%></h3>
                                <%} else if (ord.getStatus().equals("Order confirmed")) {%>
                                <h3 style="color: orange;"><%=ord.getStatus()%></h3>
                                <%} else {%>
                                <h3 style="color: green;"><%=ord.getStatus()%></h3>
                                <%}%>
                            </div>

                            <div class="product-details">
                                <p>Date: <%=ord.getOrderDate()%></p>
                                <p>Total: &#8377;<%=ord.getPrice()%></p>
                                <a href="OrderCancelServlet?oid=<%=ord.getOrderId()%>&pid=<%=ord.getpId()%>">
                                    <button class="cancel-btn">Cancel Item</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </section>
        </main>

    </body>
</html>