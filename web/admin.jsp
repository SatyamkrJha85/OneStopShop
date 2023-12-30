<%@page import="com.one.stop.shop.dao.OrderDao"%>
<%@page import="com.one.stop.shop.dao.ProductsDao"%>
<%@page import="com.one.stop.shop.dao.UsersDao"%>
<%@page import="com.one.stop.shop.dao.UsersDao"%>
<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("userAdmin");
    if(user == null){
        response.sendRedirect("adminlogin.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>One Stop Shop (<%=user%>)</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="stylesheet" href="./CSS/admin.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <!-- START ASIDE -->
            <aside>
                <div class="top"> 
                    <div class="logo">
                        <img src="./Resources/admin/logo.png" alt="Logo">
                        <h2>ONE STOP<span class="danger">SHOP</span></h2>
                    </div>
                    <div class="close-btn" id="close-btn">
                        <span class="material-icons">close</span>
                    </div>
                </div>
                <div class="sidebar">
                    <a href="admin.jsp" class="Dashboard" id="dashboard-link">
                        <span class="material-icons">grid_view</span>
                        <h3>Dashboard</h3>
                    </a>
                    <a href="./admin_helper/signupuser.jsp" class="active">
                        <span class="material-icons">person</span>
                        <h3>Sign up User</h3>
                    </a>
                    <a href="./admin_helper/loginuser.jsp">
                        <span class="material-icons">contacts</span>
                        <h3>Login User</h3>
                    </a>
                    <a href="./admin_helper/admincomplaint.jsp" >
                        <span class="material-icons">priority_high</span>
                        <h3>Complaint Box</h3>
                    </a>
                    <a href="./admin_helper/userfeedback.jsp">
                        <span class="material-icons">rate_review</span>
                        <h3>User Feedback</h3>
                    </a>
                    <!-- Drop Down Menu Items-->
                    <div class="dropdown-button">
                        <a href="#">
                            <span class="material-icons">shopping_cart</span>
                            <h3>Add Products</h3>
                            <span class="material-icons">arrow_drop_down</span>
                        </a>
                        <div class="dropdown-menu">
                            <a href="./admin_helper/men.jsp">Men</a>
                            <a href="./admin_helper/women.jsp">Women</a>
                            <a href="./admin_helper/footwear.jsp">Footwear</a>
                            <a href="./admin_helper/jewellery.jsp">Jewellery</a>
                            <a href="./admin_helper/home&living.jsp">Home and living</a>
                            <a href="./admin_helper/electronics.jsp">Electronics</a>
                        </div>
                    </div>
                    <!-- Drop Down Menu Items  End -->
                    <a href="./admin_helper/adminorder.jsp">
                        <span class="material-icons">list</span>
                        <h3>See Orders</h3>
                        <%
                        OrderDao od = new OrderDao((OracleConnection) ConnectionProvider.getConnection());
                        %>
                        <span class="message-count"><%=od.countOrders()%></span>
                    </a>
                    <a href="LogOutServlet?user=admin">
                        <span class="material-icons">logout</span>
                        <h3>Logout</h3>
                    </a>
                </div>
            </aside>
            <!-- END ASIDE -->
            <main>
                <div class="profileheading">
                    <h1>Dashboard</h1>
                    <div class="right">
                        <!-- PROFILE TOP START -->
                        <div class="top">
                            <button id="menu-btn">
                                <span class="material-icons">menu</span>
                            </button>
                            <div class="profile">
                                <div class="info">
                                    <p>Hey, <b>One Stop Shop</b></p>
                                    <small class="text-muted">Admin</small>
                                </div>
                            </div>
                        </div>
                        <!-- PROFILE TOP END -->
                    </div>
                </div>

                <!-- START CHART -->
                <div class="insights">
                    <div class="sales">
                        <span class="material-icons">person</span>
                        <div class="middle">
                            <div class="left">
                                <%
                                    UsersDao ud = new UsersDao((OracleConnection) ConnectionProvider.getConnection());
                                %>
                                <h3>Registered Users</h3>
                                <h1><%=ud.countUsers()%></h1>
                            </div>
                            <div class="verifieduser">
                                <span class="material-icons">verified_user</span>
                            </div>
                        </div>
                    </div>
                    <div class="expenses">
                        <span class="material-icons">local_mall</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Number Of Product</h3>
                                <%
                                    ProductsDao p = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
                                %>
                                <h1><%=p.countTotalProducts()%></h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx="38" cy="38" r="34"></circle>
                                </svg>
                                <div class="number">
                                    <p>74%</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="income">
                        <span class="material-icons">category</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Number of Categories</h3>
                                <h1>6</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx="38" cy="38" r="36"></circle>
                                </svg>
                                <div class="number">
                                    <p>100%</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END CHART -->

                <!-- Category START -->
                <div class="Category">
                    <h2>Category</h2>
                    <!-- Main Category div -->
                    <div class="categorybox">
                        <div class="men">
                            <a href="./admin_helper/category_men.jsp">
                                <img src="./Resources/admin/men.png" alt="Category 1">
                                <p class="category-text">Men</p>
                            </a>
                        </div>

                        <div class="women">
                            <a href="./admin_helper/category_women.jsp">
                                <img src="./Resources/admin/women.jpg" alt="Category 1">
                                <p class="category-text">Women</p>
                            </a>
                        </div>

                        <div class="footwear">
                            <a href="./admin_helper/category_footwear.jsp">
                                <img src="./Resources/admin/footwear.png" alt="Category 1">
                                <p class="category-text">Footwear</p>
                            </a>
                        </div>

                        <div class="Jewellry">
                            <a href="./admin_helper/category_jewellery.jsp">
                                <img src="./Resources/admin/jewellery.png" alt="Category 1">
                                <p class="category-text">Jewellery</p>
                            </a>
                        </div>

                        <div class="Homeliving">
                            <a href="./admin_helper/category_homeandliving.jsp">
                                <img src="./Resources/admin/homeandliving.jpg" alt="Category 1">
                                <p class="category-text">Home & Living</p>
                            </a>
                        </div>

                        <div class="electronics">
                            <a href="./admin_helper/category_electronics.jsp">
                                <img src="./Resources/admin/electronic.jpg" alt="Category 1">
                                <p class="category-text">Electronics</p>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- Category END-->
            </main>
        </div>
    </body>
</html>