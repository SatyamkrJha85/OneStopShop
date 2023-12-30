package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.entities.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;

public class PaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String userEmail = request.getParameter("email");
            String price = request.getParameter("price");
            String fullname = request.getParameter("fullname");
            String Address = request.getParameter("address");

            CartDao cd = new CartDao((OracleConnection) ConnectionProvider.getConnection());
            List<Cart> cart = cd.getCartListByUserId(userEmail);

            OrderDao od = new OrderDao((OracleConnection) ConnectionProvider.getConnection());

            int orderID = 0;

            if (od.maxOrderID() == 0) {
                orderID = 1001;
            } else {
                orderID = od.maxOrderID() + 1;
            }

            for (Cart cartItem : cart) {
                Order ord = new Order();
                ord.setOrderId(orderID);
                ord.setuId(userEmail);
                ord.setpId(cartItem.getProductId());
                ord.setpName(cartItem.getProductName());
                ord.setPrice(cartItem.getPrice());
                ord.setQuantity(cartItem.getQuantity());
                ord.setFullName(fullname);
                ord.setAddress(Address);

                od.saveOrder(ord);
            }
            cd.removeAllProduct(userEmail);

            response.sendRedirect("order.jsp");
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
