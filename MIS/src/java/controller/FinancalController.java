/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ViewModel.DoctorMonitorVM;
import com.google.gson.Gson;
import dao.FinanceDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TheKey
 */
@WebServlet(name = "FinancalController", urlPatterns = {"/Financal/*", "/Financial/Monitor","/Financial/PatientSearch"},
        loadOnStartup = 1,
        asyncSupported = true)
public class FinancalController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinancalController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinancalController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String forward="";
        String requestURL = request.getRequestURL().toString();
        FinanceDao finance = new FinanceDao();
        if(requestURL.contains("Monitor")){
            request.setAttribute("doctors", finance.getDoctors());
            forward = "/Views/FinancialView/doctor_search.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);            
            rd.forward(request, response);
        }
        else if(requestURL.contains("PatientSearch"))
        {
            
            String doctorId = request.getParameter("userId");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            DoctorMonitorVM vm = finance.getPatientList(doctorId, startDate, endDate);
            String json = new Gson().toJson(vm);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        
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
