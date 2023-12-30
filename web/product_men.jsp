<%@page import="com.one.stop.shop.entities.*"%>
<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>

<%
    String productId = request.getParameter("productId");
    ProductsDao pd = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
    Men w = pd.getMenProducts(productId);
    Users user = (Users) session.getAttribute("currentUser");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./CSS/product.css">
        <link rel="stylesheet" href="./CSS/addtocart.css" />
        <script src="https://kit.fontawesome.com/23ed75a8e5.js" crossorigin="anonymous"></script>
        <title><%=w.getpName()%></title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>


    <body>
        <div style="height:5rem">
            <%@include file="./normalnavbar.jsp" %>
        </div>
        <div class="container" style="margin:2rem;">
            <div class="main">
                <div  class="img" ><img class="mimg" src="./Resources/category/men/<%=w.getImage()%>" alt=""></div>
                <div class="details">
                    <!-- <div class="just bottom">Only special For you</div> -->
                    <h2 class="bottom"><%=w.getpName()%></h2>
                    <p class="p bottom"><%=w.getpDetails()%></p>
                    <h3 class="bottom">&#8377;<%=w.getPrice()%></h3>
                    <!-- <p class="pp bottom"> Flat72% OFF</p> -->
                    <h4 class="bottom">Product Details:</h4>
                    <table class="table" >

                        <tr class="row">
                            <td class="bold">Sleeve</td>
                            <td class="col"><%=w.getSleeve()%></td>
                        </tr>
                        <tr  class="row">
                            <td class="bold">Fit</td>
                            <td class="col"><%=w.getFit()%></td>
                        </tr>
                        <tr  class="row">
                            <td class="bold">Type</td>
                            <td class="col"> <%=w.getType()%></td>
                        </tr>
                        <tr  class="row">
                            <td class="bold" >Fabric</td>
                            <td class="col"><%=w.getFabric()%></td>
                        </tr>
                    </table>
                    <div>
                        <%
                            if (user != null) {
                        %>
                        <a href="CartServlet?id=<%=w.getpID()%>&uid=<%=user.getuEmail()%>&qty=1&return=<%=request.getRequestURI()%>">
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
        </div>
        <div id="toast"></div>
        <script src="./JAVASCRIPT/landing.js"></script>
        <script src="./JAVASCRIPT/addtocart.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

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