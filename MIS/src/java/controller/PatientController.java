/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.UserModel;
import ViewModel.UserProfileVM;
import dao.DoctorDao;
import dao.PatientDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TheKey
 */
@WebServlet(name = "PatientController", urlPatterns = { "/Patients", "/Views/PatientView/Profile", "/Views/PatientView/SearchRecords", "/Views/PatientView/PastAppointments"})
public class PatientController extends HttpServlet {

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
       
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PatientController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PatientController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        String forward = null;
        String requestURL = request.getRequestURL().toString();
        PatientDao patient = new PatientDao();
        if (requestURL.contains("Views/PatientView/Profile")) {
            HttpSession session = request.getSession();
            UserProfileVM user = (UserProfileVM) session.getAttribute("profile");
            request.setAttribute("upcomingAppointments", patient.getUpcomingAppointmens(user.getUser().getUserId()));
            forward = "/Views/PatientView/profile.jsp";
        }
        else if (requestURL.contains("Views/PatientView/SearchRecords")) {
            DoctorDao doctor = new DoctorDao();
            request.setAttribute("procedures", doctor.GetProcedures());
            forward = "/Views/PatientView/search_patient_record.jsp";
        }
        else if (requestURL.contains("Views/PatientView/PastAppointments")) {
            HttpSession session = request.getSession();
            DoctorDao doctor = new DoctorDao();
            UserProfileVM user = (UserProfileVM) session.getAttribute("profile");
            request.setAttribute("PastAppointments", doctor.getPastAppointments(user.getUser().getUserId()));
            forward = "/Views/PatientView/appointments.jsp";
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
        
        HttpSession session = request.getSession(false); 
        
        if(request.getParameter("SearchRecords") != null){
            this.SearchRecords(request, session, response);
        }
    }
    
        private void SearchRecords(HttpServletRequest request, HttpSession session, HttpServletResponse response)
        throws ServletException, IOException{
            
            String prescriptions = request.getParameter("prescriptions");
            String diagnosis = request.getParameter("diagnosis");
            String recorddate = request.getParameter("recorddate");
            String procedureid = request.getParameter("procedureId");
            String treatmentSchedule = request.getParameter("treatmentschedule");
                           
             UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();   
            //PatientUserVM patient = patientdao.getPatient(patId);
           
            //get the patient info to diplay on top currently ill display id only - we can add first name and last name later on
            String[] VisitationRecordSA = {null,null, (procedureid.equals("0"))? null : procedureid,
                user.getUserId(), null, (recorddate == "")? null : recorddate, null,
                (prescriptions == "")? null : prescriptions, (diagnosis == "")? null : diagnosis, (treatmentSchedule == "")?null : treatmentSchedule,
                null};
            String[] UserModelSA = {null, null, null , null, 
                null, null, null, null, null, null, null};
            
            DoctorDao doctor = new DoctorDao();
            request.setAttribute("records", doctor.FindRecords(VisitationRecordSA, UserModelSA));
            request.setAttribute("procedures", doctor.GetProcedures());
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/PatientView/search_patient_record.jsp");
            rd.forward(request, response);
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
