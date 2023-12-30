package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.*;
import com.one.stop.shop.helper.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;

public class OrderCancelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String oid = request.getParameter("oid");
            String pid = request.getParameter("pid");
            String Status = "Cancelled";
            OrderDao od = new OrderDao((OracleConnection) ConnectionProvider.getConnection());
            
            od.updateStatus(oid, pid, Status);
            response.sendRedirect("order.jsp");
        }

    }
}
