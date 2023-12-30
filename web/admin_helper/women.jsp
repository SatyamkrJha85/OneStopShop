<%@page import="com.one.stop.shop.helper.ConnectionProvider"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="oracle.jdbc.OracleConnection"%>
<%@page import="com.one.stop.shop.dao.LastProductID"%>
<%@page import="com.one.stop.shop.entities.Message"%>
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
        <title>Add Women</title>  
        <link rel="apple-touch-icon" sizes="180x180" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="../Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="../Resources/admin/logo.png">
    </head>

    <body >
        <div class="formbody">
            <h1 style="font-size:29px;">Add Product in Women</h1>
            <form action="http://localhost:8080/OneStopShop/AdminWomenServlet" method="post" enctype="multipart/form-data">
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
                <input type="text" name="product_id" id="product_id" value="<%=ld.lastWomen()%> - Last product of the table" required><br>

                <label for="category_id">Category ID:</label>
                <input type="text" name="category_id" id="category_id" value="2" readonly required><br>

                <label for="product_name">Product Name:</label>
                <input type="text" name="product_name" id="product_name" required><br>

                <label for="product_description">Product Description:</label><br>
                <textarea name="product_description" id="product_description" rows="4" cols="50" maxlength="200"
                          required></textarea><br>

                <label for="product_price">Product Price:</label>
                <input type="text" name="product_price" id="product_price" pattern="[0-9]+" required><br>

                <label for="Pattern">Pattern:</label>
                <select name="pattern" id="Pattern">
                    <option value="Plain">Plain</option>
                    <option value="printed">printed</option>
                    <option value="Not-Plain">Not-Plain</option>
                    <option value="checkered">checkered</option>
                </select>

                <label for="fitting">Fitting:</label>
                <select name="fitting" id="fitting">
                    <option value="Fit">Fit</option>
                    <option value="slim">Slim</option>
                </select>

                <label for="type">Type:</label>
                <select name="type" id="type">
                    <option value="Handloom">Handloom</option>
                    <option value="Regular">Regular</option>
                </select>

                <label for="fabric">Fabric:</label>
                <select name="fabric" id="fabric">
                    <option value="Polyester">Polyester</option>
                    <option value="Cotton">Cotton</option>
                    <option value="denim">Denim</option>
                    <option value="silk">Silk</option>
                    <option value="Cotton- Blend">Cotton- Blend</option>
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