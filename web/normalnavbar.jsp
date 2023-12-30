
<%@page import="com.one.stop.shop.dao.CartDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/23ed75a8e5.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./CSS/normalnavbar.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="navbar">
                    <div class="logo">
                        <%  if (user != null) {
                        %>
                        <a href="landing.jsp">
                            <img src="./Resources/landing/ONE STOP SHOP.png" alt="No image found" width="70px">
                        </a>
                        <%
                        } else {
                        %>
                        <a href="index.jsp">
                            <img src="./Resources/landing/ONE STOP SHOP.png" alt="No image found" width="70px">
                        </a>
                        <%
                            }
                        %>
                    </div>
                    <div class="search-bar" style="border-radius:8px;">                  
                        <form action="SearchServlet" method="GET">
                            <label for="query"></label>
                            <input type="text" id="query" name="query" placeholder="Enter product name">
                            <button type="submit"><i class="fa-solid fa-search" style="color:#736d6d"></i></button>
                        </form>
                    </div>
                    <nav>
                        <ul id="MenuItems">
                            <%
                                if (user != null) {
                            %>
                            <li><a href="landing.jsp">Home</a></li>
                                <%
                                } else {
                                %>
                            <li><a href="index.jsp">Home</a></li>
                                <%
                                    }
                                %>
                            <li class="dropdown-button">
                                <div class="category-button">
                                    <a href="#" style="display: flex; align-items: center;">
                                        <span class="name">Category</span>
                                        <span class="material-icons">arrow_drop_down</span>
                                    </a>
                                </div>
                                <div class="dropdown-box">
                                    <div class="dropdown-menu">
                                        <a href="c_men.jsp">Men</a>
                                        <a href="c_women.jsp">Women</a>
                                        <a href="c_footwear.jsp">Footwear</a>
                                        <a href="c_jewellery.jsp">Jewellery</a>
                                        <a href="c_homeandliving.jsp">Home and living</a>
                                        <a href="c_electronics.jsp">Electronics</a>
                                    </div>
                                </div>
                            </li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contactus.jsp">Contact</a></li>
                        </ul>
                    </nav>

                    <div class="right-nav">
                        <a href="./addtocart.jsp" class="cart">
                            <i class="fas fa-shopping-cart"></i>
                            <%
                                if (user != null) {
                            %>
                            <%
                                CartDao ct = new CartDao((OracleConnection) ConnectionProvider.getConnection());
                            %>
                            <span><%=ct.countProducts(user.getuEmail())%></span>
                            <%}%>
                        </a>
                    </div>
                    <div id="userDropdown" class="dropdown" >
                        <i class="fas fa-user" style="color: black;padding-right: 5px"></i>
                        <div id="userDropdownContent" class="dropdown-content" >

                            <%
                                if (user != null) {
                            %>
                            <a href="profile.jsp">Account</a>
                            <a href="order.jsp">My Orders</a>
                            <a href="LogOutServlet?user=user">Log out</a>
                            <%
                            } else {
                            %>
                            <a href="login.jsp">Login</a>
                            <a href="signup.jsp">Sign up</a>
                            <%
                                }
                            %>

                        </div>

                        <%
                            if (user != null) {
                        %>
                        <%= user.getuName()%>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
