<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.dao.LastProductID"%>
<%@page import="com.one.stop.shop.entities.Message"%>
<%@page errorPage="error.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("userAdmin");
    if (user == null) {
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
        <title>Add Jewellery</title>
        <link rel="apple-touch-icon" sizes="180x180" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../Resources/admin/logo.png">
    </head>

    <body >
        <div class="formbody">
            <h1 style="font-size:29px;">Add Product in Jewellery</h1>
            <form action="http://localhost:8080/OneStopShop/AdminJewelleryServlet" method="post" enctype="multipart/form-data">
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
                <input type="text" name="product_id" id="product_id" value="<%=ld.lastJewellery()%> - Last product of the table" required><br>

                <label for="category_id">Category ID:</label>
                <input type="text" name="category_id" id="category_id" value="4" readonly required><br>

                <label for="product_name">Product Name:</label>
                <input type="text" name="product_name" id="product_name" required><br>

                <label for="product_description">Product Description:</label><br>
                <textarea name="product_description" id="product_description" rows="4" cols="50" maxlength="200"
                          required></textarea><br>

                <label for="product_price">Product Price:</label>
                <input type="text" name="product_price" id="product_price" pattern="[0-9]+" required><br>

                <label for="Clasp Type">Clasp Type:</label>
                <select name="Clasp_Type" id="Clasp_Type">
                    <option value="Hook_Clasp">Hook Clasp</option>
                    <option value="Lobster_Clasp">Lobster Clasp</option>
                </select>

                <label for="Material_Type">Material Type:</label>
                <select name="Material_Type" id="Material_Type">
                    <option value="Metal">Metal</option>
                    <option value="Rhinestone">Rhinestone</option>
                    <option value="Gold_Plated">Gold Plated</option>
                    <option value="Pearl">Pearl</option>
                    <option value="Silver">Silver</option>
                    <option value="Diamond">Diamond</option>
                    <option value="Faux_Pearl">Faux Pearl</option>
                </select>

                <label for="Metal_Type">Metal Type:</label>
                <select name="Metal_Type" id="Metal_Type">
                    <option value="Gold Plated">Gold Plated</option>
                    <option value="Silver Plated">Silver Plated</option>
                    <option value="No_metal_type">No Metal Type</option>
                    <option value="Yellow_Gold">Yellow Gold</option>
                </select>

                <label for="Gem_Type">Gem Type:</label>
                <select name="Gem_Type" id="Gem Type">
                    <option value="Diamond">Diamond</option>
                    <option value="Fancy">Fancy</option>
                    <option value="CubicZirconia">Cubic Zirconia</option>
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