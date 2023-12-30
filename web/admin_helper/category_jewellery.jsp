<%@page import="com.one.stop.shop.entities.*"%>
<%@page import="java.util.List"%>
<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("userAdmin");
    if (user == null) {
        response.sendRedirect("adminlogin.jsp");
    }
    ProductsDao pd = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
    List<Jewellery> jewellery = pd.getJewellery();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Jewellery</title>
        <link rel="apple-touch-icon" sizes="180x180" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../Resources/admin/logo.png">
        <link rel="stylesheet" href="../CSS/admincategory.css" />
        <link
            href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Mukta:wght@200;300;400;500;600;700;800&family=Poppins:wght@200;300&family=Roboto+Mono:wght@300;400&family=Space+Mono&display=swap"
            rel="stylesheet"
            />
        <script src="https://kit.fontawesome.com/23ed75a8e5.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <%
            if (!jewellery.isEmpty()) {
                for (Jewellery m : jewellery) {
        %>
        <!-- product -->
        <div class="item">
            <span id="product-id"><p>#<%=m.getpID()%></p></span>
            <div class="product1" style="background-image: url('../Resources/allproducts/<%=m.getImage()%>');"></div>
            <div class="mid" style="height:20rem; padding-top:2.3rem;">
                <ul id=text>
                    <li id="heading"><%=m.getpName()%></li>
                    <li id="p-details"><%=m.getpDetails()%></li>
                    <li><strong>Clasp type</strong> <%=m.getClaspType()%></li>
                    <li><strong>Material type:</strong> <%=m.getMaterialType()%></li>
                    <li><strong>Metal type:</strong> <%=m.getMetalType()%></li>
                    <li><strong>Gem type:</strong>  <%=m.getGemType()%></li>
                    <li style="font-size:16px"></li>
                </ul>
            </div>
            <div id="verticle-line"></div>
        </a>
        <div id="last">
            <b id="price">&#8377;<%=m.getPrice()%></b>
            <a href="http://localhost:8080/OneStopShop/AdminRemoveProductServlet?pid=<%=m.getpID()%>&cid=4">
                <button class="add-to-cart-button">
                    <i class="fa-solid fa-circle-xmark"></i>
                </button>
            </a>
        </div>        
    </div>
    <%
            }
        }
    %>
    <div id="toast"></div>

    <script src="./JAVASCRIPT/addtocart.js"></script>
    <script src="./JAVASCRIPT/landing.js"></script>
</body>
</html>