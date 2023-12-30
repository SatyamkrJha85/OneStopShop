<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.dao.LastProductID"%>
<%@page import="com.one.stop.shop.entities.Message"%>
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
        <script src="../JAVASCRIPT/adminform.js"></script>
        <link rel="stylesheet" href="../CSS/adminform.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Home and living</title>
        <link rel="apple-touch-icon" sizes="180x180" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../Resources/admin/logo.png">
    </head>

    <body>
        <h1 style="font-size:29px;">Add Product in Home And Living</h1>
        <div class="formbody">
            <form action="http://localhost:8080/OneStopShop/AdminHomeAndLivingServlet" method="post" enctype="multipart/form-data">
                <!--Invalid  Credential start-->
                <%
                    Message m = (Message) session.getAttribute("msg");
                    if (m != null) {
                        String type = m.getType();
                        if (type == "error") {
                %>
                <div style="display: flex;flex-direction: column;align-items: center">
                    <img src="../Resources/admin/warning.png">
                    <div style="font-size: 18px; text-align: center;color: red;margin: 2rem">
                        <%=m.getContent()%>
                    </div>
                </div>
                <%
                } else {
                %>
                <div style="display: flex;flex-direction: column;align-items: center">
                    <img src="../Resources/admin/checked.png">
                    <div style="font-size: 18px; text-align: center;color: green;margin: 2rem">
                        <%=m.getContent()%>
                    </div>
                </div>
                <%
                        }
                        session.removeAttribute("msg");
                    }
                %>
                <!--Invalid Credential end-->
                <label for="product_id">Product ID:</label>
                <% LastProductID ld = new LastProductID((OracleConnection) ConnectionProvider.getConnection());%>
                <input type="text" name="product_id" id="product_id" value="<%=ld.lastHomeAndLiving()%> - Last product of the table" required><br>

                <label for="category_id">Category ID:</label>
                <input type="text" name="category_id" id="category_id" value="5" readonly required><br>

                <label for="product_name">Product Name:</label>
                <input type="text" name="product_name" id="product_name" required><br>

                <label for="product_description">Product Description:</label><br>
                <textarea name="product_description" id="product_description" rows="4" cols="50" maxlength="200" required></textarea><br>

                <label for="Use">Use</label>
                <input type="text" name="Use" id="Use" required><br>

                <label for="product_price">Product Price:</label>
                <input type="text" name="product_price" id="product_price" pattern="[0-9]+" required><br>

                <label for="Color">Color:</label>
                <select name="Color" id="Color">
                    <option value="White">White</option>
                    <option value="Green">Green</option>
                    <option value="Red">Red</option>
                    <option value="Pink">Pink</option>
                    <option value="Yellow">Yellow</option>
                    <option value="Blue">Blue</option>
                    <option value="Sky">Sky</option>
                    <option value="Dark Blue">Dark Blue</option>
                    <option value="Black">Black</option>
                </select>

                <label for="Material">Material:</label>
                <select name="Material" id="Material">
                    <option value="Plastic">Plastic</option>
                    <option value="Iron">Iron</option>
                    <option value="Copper">Copper</option>
                    <option value="Steel">Steel</option>
                    <option value="Wood">Wood</option>
                    <option value="Wood">Cotton</option>
                </select>


                <label for="Country_Origin">Country Origin:</label>
                <select name="Country_Origin" id="Country_Origin">
                    <option value="India">India</option>
                    <option value="Taiwan">Taiwan</option>
                    <option value="China">China</option>
                </select>

                <div class="selectimg">
                    <input name="image" type="file" id="profile-pic-input" accept="image/*" onchange="previewImage(this)" required>
                    <button id="change-pic-button" type="button" onClick="openFilePicker()">Choose Image</button>
                </div>
                <div id="image-preview">
                    <h2>Image Preview:</h2>
                    <img id="preview" src="#" alt="Preview">
                </div>
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>