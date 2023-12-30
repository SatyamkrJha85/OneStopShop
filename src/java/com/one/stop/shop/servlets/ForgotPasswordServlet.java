package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.entities.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;

public class ForgotPasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("cnfemail");

            UsersDao dao = new UsersDao((OracleConnection) ConnectionProvider.getConnection());

            if (dao.checkEmail(email)) {
                out.println("done");
                String msg = "http://localhost:8080/OneStopShop/securityquestion.jsp?email=" + email;
                String userName = "onestopshop.ecommerce@gmail.com";
                String userPassword = "jyfw qrql dabn cvhr";
                String subject = "Change Password";

                sEmail mail = new sEmail();
                mail.sendEmail(userName, userPassword, email, subject, msg);

                Message message = new Message("Link send to your email", "success");

                HttpSession s = request.getSession();
                s.setAttribute("msg", message);
                response.sendRedirect("forgotpassword.jsp");
            } else {
                Message msg = new Message("Email ID does not exist", "error");

                HttpSession s = request.getSession();
                s.setAttribute("msg", msg);
                response.sendRedirect("forgotpassword.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
