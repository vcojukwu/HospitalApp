/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ViewModel.DoctorMonitorVM;
import ViewModel.RevenueVM;
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
@WebServlet(name = "FinancalController", urlPatterns = {"/Financal/*", "/Financial/Monitor","/Financial/Revenue"},
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
        
        if(request.getParameter("SearchRecords") != null)
        {     
            String doctorId = request.getParameter("doctorId");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            forward = "/Views/FinancialView/doctor_search.jsp";
            DoctorMonitorVM vm = finance.getPatientList(doctorId, startDate, endDate);
            request.setAttribute("patientCount", vm.getUniquePatientCount());
            request.setAttribute("searchRecords", vm.getVisitRecords());
            request.setAttribute("procedureList", vm.getProcedureList());
            request.setAttribute("doctors", finance.getDoctors());
            request.setAttribute("startDate",startDate);
            request.setAttribute("endDate",endDate);
            request.setAttribute("doctorUserId",doctorId);
            if(startDate.equals("") || endDate.equals(""))
                request.setAttribute("invalid", 1); 
            else
                request.setAttribute("invalid", 0);
        }
        else if(requestURL.contains("Monitor")){
            request.setAttribute("doctors", finance.getDoctors());
            request.setAttribute("patientCount", 0);

            forward = "/Views/FinancialView/doctor_search.jsp";

        }  
        else if (requestURL.contains("Revenue"))
        {
            forward = "/Views/FinancialView/revenue.jsp";
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            
            RevenueVM vm = finance.getRevenue(startDate, endDate);
            vm.setTotalRevenue();
            request.setAttribute("visitCount", vm.getVisitCount());
            request.setAttribute("totalRevenue", vm.getTotalRevenue());
            request.setAttribute("procedureRevenue", vm.getTotalProcedureRevenue());
            request.setAttribute("startDate", startDate);
            request.setAttribute("endDate", endDate);
            if(startDate == null || endDate == null)
                request.setAttribute("invalid", 1); 
            else
                request.setAttribute("invalid", 0);
        }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);            
            rd.forward(request, response);
            
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
