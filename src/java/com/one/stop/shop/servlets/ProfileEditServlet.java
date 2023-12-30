package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.entities.*;
import com.one.stop.shop.helper.*;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import oracle.jdbc.OracleConnection;

@MultipartConfig
public class ProfileEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String userName = request.getParameter("full-name");
            String userGender = request.getParameter("gender");
            String userMobile = request.getParameter("mobile-number");
            String userEmail = request.getParameter("email");
            String userAddress = request.getParameter("address");
            Part part = request.getPart("image");
            String imageName = part.getSubmittedFileName();

            HttpSession s = request.getSession();
            Users user = (Users) s.getAttribute("currentUser");

            user.setuName(userName);
            user.setuGender(userGender);
            user.setuMobile(userMobile);
            user.setuEmail(userEmail);
            user.setuAddress(userAddress);
            String oldFile = user.getuProfile();

            UsersDao u = new UsersDao((OracleConnection) ConnectionProvider.getConnection());

            if (imageName == "") {
                String path = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web\\profile" + File.separator + oldFile;

                out.println("done");
            } else {
                user.setuProfile(imageName);
//                String rootDirectory = request.getServletContext().getRealPath("/");
                String path = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web\\profile" + File.separator + user.getuProfile();

                String pathDelete = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web\\profile" + File.separator + oldFile;
                if (u.checkImage(oldFile)) {
                    Helper.deleteFile(pathDelete);
                }

                if (Helper.saveFile(part.getInputStream(), path)) {
                    out.println("done");
                } else {
                    out.println("error");
                }
            }
            u.updateUser(user);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
