
package com.one.stop.shop.servlets;

import com.one.stop.shop.dao.SecondaryDao;
import com.one.stop.shop.helper.ConnectionProvider;
import com.one.stop.shop.helper.sEmail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleConnection;

public class ComplaintServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String fname = request.getParameter("firstname");
            String lname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String phone = request.getParameter("number");
            String reason = request.getParameter("reasons");
            
            SecondaryDao dao = new SecondaryDao((OracleConnection) ConnectionProvider.getConnection());
            int cid = 0;

            if (dao.maxComplaintID() == 0) {
                cid = 101;
            } else {
                cid = dao.maxComplaintID() + 1;
            }
            if (dao.saveComplaint(cid,fname, lname, email, phone,reason, subject)) {
                sEmail s = new sEmail();
                String userName = "satyamkrjha85@gmail.com";
                String userPassword = "nrfl zstr hqtu chfn";
                String msg = "First name : "+ fname + "\n" +
                                        "Last name : "+lname + "\n" +
                                        "Email : "+ email + "\n" +
                                        "Reason : "+ reason+"\n"+
                                        "Subject : "+ subject + "\n" +
                                        "Phone number : "+ phone + "\n" ;
                
                s.sendEmail(userName,userPassword,"onestopshop.ecommerce@gmail.com","Your Complaint Submited Sucessfully",msg);
                              out.println("<script>alert('Complaint submitted successfully') ; window.location.href='index.jsp';</script>");

            } else {
                out.println("Error");
            }
//            
            
            
            
            
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