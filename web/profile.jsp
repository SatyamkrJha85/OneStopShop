<%@page import="com.one.stop.shop.entities.Message"%>
<!DOCTYPE html>
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
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./CSS/profile.css">
        <script src="https://kit.fontawesome.com/23ed75a8e5.js" crossorigin="anonymous"></script>
        <title>Profile</title>
        <link rel="apple-touch-icon" sizes="180x180" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="32x32" href="./Resources/admin/logo.png">
        <link rel="icon" type="image/png" sizes="16x16" href="./Resources/admin/logo.png">
    </head>
    <body>
        <div style="height: 3rem">
            <%@include file="./normalnavbar.jsp" %>
        </div>
        <div class="profile-details">
            <form id="profile-form" action="ProfileEditServlet" method="post" enctype="multipart/form-data">
                <div class="profile-container">
                    <div class="profile-picture">
                        <img src="./profile/<%=user.getuProfile()%>" alt="Profile Picture" id="profile-pic">
                        <input name="image" type="file" id="profile-pic-input" accept="image/*" style="display: none;" >
                        <button id="change-pic-button" type="button" onClick="openFilePicker()">Change profile picture</button>
                    </div>

                    <div class="profile-form">
                        <h1>Account Info</h1>
                        <label for="full-name">First name</label>
                        <input type="text" id="full-name" name="full-name" value="<%=user.getuName()%>" required>

                        <div class="gen-mob">
                            <div class="gen"> 
                                <label for="gender">Gender</label>
                                <select id="gender" name="gender">
                                    <option value="male" <%=user.getuGender().equals("Male") ? "selected" : ""%>>Male</option>
                                    <option value="female" <%=user.getuGender().equals("Female") ? "selected" : ""%>>Female</option>
                                    <option value="other" <%=user.getuGender().equals("Other") ? "selected" : ""%>>Other</option>
                                </select>
                            </div>
                            <div class="mob">
                                <label for="mobile-number">Mobile Number</label>
                                <input type="tel" id="mobile-number" name="mobile-number" pattern="[0-9]{10}" value="<%=user.getuMobile()%>"  required>
                            </div>
                        </div>

                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" value="<%=user.getuEmail()%>" readonly >
                        <label for="address">Address</label>
                        <textarea name="address" id="address" cols="30" rows="10"><%=user.getuAddress()%></textarea>
                        <div class="save-cng">
                            <button type="submit">Save Changes</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <script src="./JAVASCRIPT/normalnavbar.js"></script>
        <script src="./JAVASCRIPT/profile.js"></script>
        <!-- js for toggle menu -->
        <script src="./JAVASCRIPT/landing.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <script>
                            $(document).ready(function () {
                                console.log("loaded.....");
                                $('#profile-form').on('submit', function (event) {
                                    event.preventDefault();

                                    let form = new FormData(this);
                                    // Send data to SignUpServlet using AJAX
                                    $.ajax({
                                        url: "ProfileEditServlet",
                                        type: 'POST',
                                        data: form,

                                        success: function (data, textStatus, jqXHR) {
                                            console.log(data);
                                            console.log(data.trim());
                                            if (data.trim() === 'done') {
                                                Swal.fire({
                                                    position: 'top-end',
                                                    icon: 'success',
                                                    title: 'Updated successfully',
                                                    showConfirmButton: false,
                                                    timer: 1500
                                                })
                                                        .then((value) => {
                                                            window.location = "profile.jsp";
                                                        });
                                            } else {
                                                Swal.fire({
                                                    icon: 'error',
                                                    title: 'Oops...',
                                                    text: 'Something went wrong!',
                                                });
                                            }

                                        },
                                        error: function (jqXHR, textStatus, errorThrown) {
                                            console.log(jqXHR);
                                        },
                                        processData: false,
                                        contentType: false

                                    });
                                });
                            });
        </script>

    </body>
</html>
