/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ViewModel.UserProfileVM;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LoginDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author TheKey
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})

public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LoginController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold  desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
       // processRequest(request, response);
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
        //processRequest(request, response);
        LoginDao authenticate = new LoginDao();
        UserProfileVM user = authenticate.Login(request.getParameter("userId"), request.getParameter("pwd"));
        String forward = "";
        HttpSession session = request.getSession(true);
        forward = "/Views/login_failed.jsp";

        if (user != null)
        {
            int userType = user.getUser().getUserType();
            if(userType == 1) //Patient
            {
                session.setAttribute("profile", user);
                forward = "/Views/PatientView/profile.jsp";
            }
            else if(userType == 2) //Doctor
            {
                session.setAttribute("profile", user);
                forward = "/Views/DoctorView/profile_doc.jsp";
            }
            else if(userType == 3) //Staff
            {
                session.setAttribute("profile", user);
                forward = "/Views/StaffView/profile_staff.jsp";
            }
            else if(userType == 4) //Finanace
            {
                session.setAttribute("profile", user);
                forward = "/Views/FinancialView/profile_financial.jsp";
            }
        }
        
        RequestDispatcher view = request.getServletContext().getRequestDispatcher(forward);
        view.forward(request, response);
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
