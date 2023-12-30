<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="com.one.stop.shop.entities.Users"%>
<%@ page import="java.util.List" %>
<%@ page import="com.one.stop.shop.entities.Product" %>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users user = (Users) session.getAttribute("currentUser");
    String q1 = request.getParameter("q");
%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="./CSS/category.css" />
        <link rel="stylesheet" href="./CSS/addtocart.css" />

        <!-- Add your head content here -->
        <title>Results for : <%=q1%></title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>
    <body>

        <div style="height: 5rem">
            <%@include file="./normalnavbar.jsp" %>
        </div>
        <div>
            <h2 style="padding:10px">Search Results : - </h2>

            <% List<Product> searchResults = (List<Product>) request.getAttribute("searchResults");
                if (searchResults != null && !searchResults.isEmpty()) { %>

            <% for (Product product : searchResults) {%>

            <div class="item">

                <div class="product1" style="background-image: url('./Resources/allproducts/<%=product.getImage()%>');"></div>
                <div id=text>
                    <p id="heading"><b><%=product.getName()%></b></p>
                    <br>
                    <p style="font-size:16px"><%=product.getDetails()%></p>
                </div>
                <div id="verticle-line"></div>
                <div id="last">
                    <b id="price">&#8377;<%=product.getPrice()%></b>
                    <div>
                        <%
                            if (user != null) {
                        %>
                        <a href="CartServlet?id=<%=product.getId()%>&uid=<%=user.getuEmail()%>&qty=1&return=<%=request.getRequestURI()%>">
                            <button class="add-to-cart-button">
                                <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                            </button>
                        </a>
                        <%} else {%>
                        <a href="#" onclick="redirect()">
                            <button class="add-to-cart-button">
                                <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                                 </button>
                        </a>
                        <% }%>
                    </div>
                </div>
            </div>

            <% } %>

            <% } else { %>
            <p>No results found.</p>
            <% }%>

        </div>
        <div id="toast"></div>
        <script src="./JAVASCRIPT/addtocart.js"></script>
        <%
            String jsCode = (String) session.getAttribute("jsCode");
            String query = (String) session.getAttribute("query");
            if (jsCode != null) {
        %>

        <script>
            <%= jsCode%>
                            window.location.href = "http://localhost:8080/OneStopShop/SearchServlet?query=<%=query%>";
        </script>
        <%
                session.removeAttribute("query");
            }

            session.removeAttribute("jsCode");
        %>
    </body>
</html>