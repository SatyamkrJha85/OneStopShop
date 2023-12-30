package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.entities.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String pid = request.getParameter("id");
            String uEmail = request.getParameter("uid");
            int quantity = Integer.parseInt(request.getParameter("qty"));
            String returnPage = request.getParameter("return");

            CartDao cd = new CartDao((OracleConnection) ConnectionProvider.getConnection());
            Cart cart = new Cart();
            Cart ct = cd.getCartByProductId(pid, uEmail, quantity);
            int qty = cd.getQuantityById(uEmail, pid);

            HttpSession session = request.getSession();

            if (qty == 0) {
                cart.setUserId(uEmail);
                cart.setQuantity(quantity);
                cart.setProductId(pid);
                cart.setProductName(ct.getProductName());
                cart.setPrice(ct.getPrice());
                cd.addToCart(cart);
                session.setAttribute("jsCode", "showToast('Product added successfully');");

                response.sendRedirect(returnPage + "?productId=" + pid);
//                response.sendRedirect(returnPage);

            } else {
                cart.setUserId(uEmail);
                cd.updateQuantity(uEmail, pid, qty + 1);
                session.setAttribute("jsCode", "showToast('Quantity increased');");
                response.sendRedirect(returnPage + "?productId=" + pid);

//                response.sendRedirect(returnPage);
            }

        } catch (SQLException ex) {
            out.print("{\"status\": \"error\", \"message\": \"" + ex.getMessage() + "\"}");
        } finally {
            out.close();
        }
    }

}
