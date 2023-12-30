package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.ProductsDao;
import com.one.stop.shop.entities.Product;
import com.one.stop.shop.entities.Users;
import com.one.stop.shop.helper.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleConnection;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        HttpSession session = request.getSession();
        session.setAttribute("query", query);
        Users user = (Users) session.getAttribute("currentUser");

        if (query == null || query.isEmpty()) {
            if (user != null) {
                response.sendRedirect("landing.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }

        } else {
            ProductsDao productsDao = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
            List<Product> searchResults = productsDao.searchProducts(query);

            request.setAttribute("searchResults", searchResults);
            request.getRequestDispatcher("search.jsp?q="+query).forward(request, response);
        }
    }
}
