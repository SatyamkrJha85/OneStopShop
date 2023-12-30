package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.ProductsDao;
import com.one.stop.shop.dao.RemoveProductDao;
import com.one.stop.shop.helper.ConnectionProvider;
import com.one.stop.shop.helper.Helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;

public class AdminRemoveProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pid = request.getParameter("pid");
            int cid = Integer.parseInt(request.getParameter("cid"));

            ProductsDao pd = new ProductsDao((OracleConnection) ConnectionProvider.getConnection());
            String image = pd.productImage(pid);
            String path1 = null;
            String path2 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "allproducts" + File.separator + image;
            
            if (cid == 1) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "men" + File.separator + image;
            } else if (cid == 2) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "women" + File.separator + image;
            } else if (cid == 3) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "footwear" + File.separator + image;
            } else if (cid == 4) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "jewellery" + File.separator + image;
            } else if (cid == 5) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "homeandliving" + File.separator + image;
            } else if (cid == 6) {
                path1 = "C:\\Users\\SATYAM JHA\\OneDrive\\Documents\\NetBeansProjects\\OneStopShop\\web" + File.separator
                    + "Resources" + File.separator + "category" + File.separator + "electronics" + File.separator + image;
            }
            Helper.deleteFile(path1);
//            Helper.deleteFile(path2);
            
            RemoveProductDao rd = new RemoveProductDao((OracleConnection) ConnectionProvider.getConnection());
            rd.removeProduct(pid, cid);

            if (cid == 1) {
                response.sendRedirect("./admin_helper/category_men.jsp");
            } else if (cid == 2) {
                response.sendRedirect("./admin_helper/category_women.jsp");
            } else if (cid == 3) {
                response.sendRedirect("./admin_helper/category_footwear.jsp");
            } else if (cid == 4) {
                response.sendRedirect("./admin_helper/category_jewellery.jsp");
            } else if (cid == 5) {
                response.sendRedirect("./admin_helper/category_homeandliving.jsp");
            } else if (cid == 6) {
                response.sendRedirect("./admin_helper/category_electronics.jsp");
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
