<%@page import="java.util.Objects"%>
<%@page import="com.one.stop.shop.entities.FeaturedProducts"%>
<%@page import="java.util.List"%>
<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.entities.LatestProducts"%>
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
<html>
    <head>
        <link rel="stylesheet" href="./CSS/landing.css" />
        <link rel="stylesheet" href="./CSS/normalnavbar.css" />
        <link rel="stylesheet" href="./CSS/addtocart.css" />
        <link rel="icon" type="image/x-icon" href="/images/favicon.ico">
        <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
        <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v2.1.6/css/unicons.css">
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/23ed75a8e5.js" crossorigin="anonymous"></script>
        <title>One Stop Shop</title>
    </head>
    <body>
        <div >
            <%@include file="./normalnavbar.jsp" %>
        </div>

        <div class="carousel" data-flickity='{ "autoPlay": 2000 }'>
            <div class="carousel-cell" ><img src="./Resources/landing/ban1.png" alt="no image found" /></div>
            <div class="carousel-cell" ><img src="./Resources/landing/ban2.png" alt="no image found" /></div>
            <div class="carousel-cell" ><img src="./Resources/landing/ban3.png" alt="no image found" /></div>
            <div class="carousel-cell" ><img src="./Resources/landing/ban4.png" alt="no image found" /></div>
            <div class="carousel-cell" ><img src="./Resources/landing/ban5.png" alt="no image found" /></div>
            <div class="carousel-cell" ><img src="./Resources/landing/ban6.jpg" alt="no image found" /></div>
        </div>
        <!-- Featured categories -->
        <div class="categories" id="category">
            <div class="small-container">
                <h2 class="title">Category</h2>
                <div class="row">
                    <div class="col-3">
                        <a href="c_men.jsp">
                            <div style="background-image: url('./Resources/landing/man.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Men</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="c_women.jsp">
                            <div style="background-image: url('./Resources/landing/woman.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Women</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="c_footwear.jsp">
                            <div style="background-image: url('./Resources/landing/sneaker.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Footwear</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="c_jewellery.jsp">
                            <div style="background-image: url('./Resources/landing/ring.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Jewellery</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="c_homeandliving.jsp">
                            <div style="background-image: url('./Resources/landing/shelf.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Home & Living</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="c_electronics.jsp">
                            <div style="background-image: url('./Resources/landing/electronic.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3>Electronics</h3>
                        </a>
                    </div>
                </div>
            </div>
        </div>


        <%            
            ProductsDao pd = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
            List<LatestProducts> latestProducts = pd.getLatestProducts();
            List<FeaturedProducts> featuredProducts = pd.getFeaturedProducts();
        %>
        <!-- Featured products -->
        <div class="small-container" id="featured_product">
            <h2 class="title">Featured Products</h2>
            <div class="row">
                <%
                    if (!featuredProducts.isEmpty()) {
                        for (FeaturedProducts m : featuredProducts) {
                %>
                <div class="col-4">
                    <a href="product_featured.jsp?productId=<%= m.getpID()%>">
                        <div 
                            class="imagelatest" 
                            style="background-image: url('./Resources/featuredproducts/<%= m.getImage()%>');">
                        </div>
                        <h4><%=m.getpName()%></h4>
                        <p style="padding-top:.5rem;">&#8377;<%=m.getPrice()%></p>
                    </a>

                    <%
                        if (user != null) {
                    %>
                    <a href="CartServlet?id=<%=m.getpID()%>&uid=<%=user.getuEmail()%>&qty=1&return=<%=request.getRequestURI()%>">
                        <button class="add-to-cart-button">
                            <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                        </button>
                    </a>
                    <%} else {%>
                    <a href="#">
                        <button class="add-to-cart-button">
                            <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                             </button>
                    </a>
                    <% } %>
                </div>
                <%
                        }
                    }
                %>
            </div>

            <!--Latest Products-->
            <h2 class="title" id="latest_product">Latest Products</h2>
            <div class="row">
                <%
                    if (!latestProducts.isEmpty()) {
                        for (LatestProducts m : latestProducts) {
                %>
                <div class="col-4">
                    <a href="product_latest.jsp?productId=<%= m.getpID()%>">
                        <div 
                            class="imagelatest" 
                            style="background-image: url('./Resources/latestproducts/<%= m.getImage()%>');">
                        </div>
                            <h4><%=m.getpName()%></h4>
                        <p style="padding-top:.5rem;">&#8377;<%=m.getPrice()%></p>
                    </a>
                    <%
                        if (user != null) {
                    %>
                    <a href="CartServlet?id=<%=m.getpID()%>&uid=<%=user.getuEmail()%>&qty=1&return=<%=request.getRequestURI()%>">
                        <button class="add-to-cart-button">
                            <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                        </button>
                    </a>
                    <%} else {%>
                    <a href="#">
                        <button class="add-to-cart-button">
                            <i class="fas fa-cart-plus" style="color:white"></i> Add to Cart
                             </button>
                    </a>
                    <% } %>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>

        <div class="categories">
            <div class="small-container">
                <div class="row">
                    <div class="col-3">
                        <div style="background-image: url('./Resources/landing/delivery-truck.gif'); height: 100px; width: 100px; background-size: cover"></div>
                        <a >
                            <h3><span style="font-weight:800">Fast </span>Delivery</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a>
                            <div style="background-image: url('./Resources/landing/payment.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3><span style="font-weight:800">Secure </span>Payment</h3>
                        </a>
                    </div>
                    <div class="col-3">
                        <a>
                            <div style="background-image: url('./Resources/landing/support.gif'); height: 100px; width: 100px; background-size: cover"></div>
                            <h3><span style="font-weight:800">24/7 </span>Support</h3>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <div class="footer">
            <div class="container">
                <div class="row-ft">
                    <div class="footer-col-2">
                        <h3>Navigation link</h3>
                        <ul>
                            <li><a href="index.jsp" id="ft">Home</a></li>
                            <li><a href="about.jsp" id="ft">About</a></li>
                            <li><a href="#category" id="ft">Category</a></li>
                            <li><a href="#featured_product" id="ft">Featured Products</a></li>
                            <li><a href="#latest_product" id="ft">Latest Products</a></li>
                        </ul>
                    </div>

                    <div class="footer-col-3">
                        <h3>Useful link</h3>
                        <ul>
                            <li><a href="complaint.jsp" id="ft">Complaint</a></li>
                            <li><a href="feedback.jsp" id="ft">Feedback</a></li>
                            <li><a href="contactus.jsp" id="ft">Contact us</a></li>
                        </ul>
                    </div>



                    <div class="footer-col-4">
                        <h3>Follow us</h3>
                        <ul>
                            <a href="#" id="ft"><i class="uil uil-facebook-f" style="color:#4267B2; height:2em;width: 2em"></i> Facebook</a>
                            <a href="#" id="ft"><i class="uil uil-instagram-alt" style="color:#E4405F"></i> Instagram</a>
                            <a href="#" id="ft"><i class="uil uil-twitter" style="color:#4267B2"></i> Twitter</a>
                            <a href="#" id="ft"><i class="uil uil-linkedin-alt" style="color:#2867B2"></i> Linkedin</a>
                        </ul>
                    </div>

                    <div class="footer-col-5">
                        <div style="background-image: url('./Resources/landing/ONE STOP SHOP1.png'); height: 100px; width: 100px; background-size: cover"></div>
                        <p style="color:white">Description is any type of communication that aims to make vivid a place, object, person, group, or other physical entity. Description is one of four rhetorical modes, along with exposition, argumentation, and narration.</p>
                    </div>
                </div>
                <hr />
                <p class="copyright">Copyright &copy; One Stop Shop 2023</p>
            </div>
        </div>

        <div id="toast"></div>
        <!-- js for toggle menu -->
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
        <script src="./JAVASCRIPT/landing.js"></script>
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
