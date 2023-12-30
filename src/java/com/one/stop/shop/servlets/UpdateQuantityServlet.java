package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;

public class UpdateQuantityServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String pid = request.getParameter("id");
            String uEmail = request.getParameter("uid");
            int quantity = Integer.parseInt(request.getParameter("qty"));
            int action = Integer.parseInt(request.getParameter("action"));

            CartDao cd = new CartDao((OracleConnection) ConnectionProvider.getConnection());
            HttpSession session = request.getSession();

            if (action == 1) {
                //Decrease
                if (quantity == 0) {
                    cd.removeProduct(pid, uEmail);
                    session.setAttribute("jsCode", "showToast('Product removed successfully');");
                    response.sendRedirect("addtocart.jsp");
                } else {
                    cd.updateQuantity(uEmail, pid, quantity);
                    response.sendRedirect("addtocart.jsp");
                }
            } else if (action == 2) {
                //Increase
                cd.updateQuantity(uEmail, pid, quantity);
                response.sendRedirect("addtocart.jsp");
            } else if (action == 3) {
                //Remove
                cd.removeProduct(pid, uEmail);
                session.setAttribute("jsCode", "showToast('Product removed successfully');");
                response.sendRedirect("addtocart.jsp");
            }

        } finally {
            out.close();
        }
    }

}
