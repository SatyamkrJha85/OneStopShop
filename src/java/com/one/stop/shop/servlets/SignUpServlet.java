package com.one.stop.shop.servlets;

import com.one.stop.shop.helper.sEmail;
import com.one.stop.shop.dao.*;
import com.one.stop.shop.entities.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;

public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String check = request.getParameter("condition");

            if (check == null) {
                out.println("Box not checked");
            } else {
                // Fetching the data from form
                String name = request.getParameter("u_name");
                String email = request.getParameter("u_email");
                String password = request.getParameter("u_pass");
                String nickname = request.getParameter("hint-pass");
                Random random = new Random();
                int x = 0;
                while (x < 1000) {
                    x = random.nextInt(9999);
                }
                String msg = "OTP : " + x;
                String userName = "onestopshop.ecommerce@gmail.com";
                String userPassword = "jyfw qrql dabn cvhr";
                String subject = "Email Verification";

                HttpSession sess = request.getSession(true);
                sess.setAttribute("otp", x);
                sess.setAttribute("name", name);
                sess.setAttribute("email", email);

                sEmail mail = new sEmail();
                mail.sendEmail(userName, userPassword, email, subject, msg);
                response.sendRedirect("verifyotp.jsp");

                Users user = new Users(name, email, password, nickname);

                UsersDao dao = new UsersDao((OracleConnection) ConnectionProvider.getConnection());
                if (dao.saveUser(user)) {
                    out.println("done");
                } else {
                    out.println("error");
                }
            }
        }
    }
}
