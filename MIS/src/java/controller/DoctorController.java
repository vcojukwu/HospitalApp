/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
import ViewModel.PatientUserVM;
import ViewModel.UserProfileVM;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
 *///, 
@WebServlet(name = "DoctorController", urlPatterns = {"/AddVisitationRecord" , "/Doctor"})
public class DoctorController extends HttpServlet {

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
            out.println("<title>Servlet DoctorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoctorController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        
            DoctorDao doctor = new DoctorDao();
            request.setAttribute("procedures", doctor.GetProcedures());     
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/DoctorView/enter_records.jsp");
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
        
         if (request.getParameter("AddVisitationRecord") != null)
            this.AddVisitationRecord(request, session, response);
         else if (request.getParameter("SearchPatients") != null)
            this.SearchPatients(request, session, response);
         else if (request.getParameter("ViewPatientDetail") != null){
            this.NavigateToPatientView(request, session, response);
        }
        

    }
    
    private void NavigateToPatientView(HttpServletRequest request, HttpSession session, HttpServletResponse response)
        throws ServletException, IOException{
            
            PatientDao patientdao = new PatientDao();
            //PatientUserVM puvm = patientdao.getPatient("");
            String temp = request.getParameter("ViewPatientDetail");
            String test = "";
        }
    private void SearchPatients(HttpServletRequest request, HttpSession session, HttpServletResponse response)
        throws ServletException, IOException{
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();                                //Get Doctor Id  
        PatientDao patientdao = new PatientDao();
        String[] PatientModelSA = {null,null, null,null,
            null,null, null, null, null};
        String[] UserModelSA = {null, (firstname == "")?  null : firstname , (lastname == "")?  null : lastname, null, 
            null, null, null, null, null, 
            null, null};
        //For now just get all patients, not sending in search criteria
         request.setAttribute("patients", patientdao.searchPatients(PatientModelSA, UserModelSA));
         
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/DoctorView/search_patients.jsp");
        rd.forward(request, response);
    }
    
    private void AddVisitationRecord(HttpServletRequest request, HttpSession session, HttpServletResponse response)
        throws ServletException, IOException{
                
        DoctorDao doctor = new DoctorDao();
        VisitationRecordsModel visitationRecord = new VisitationRecordsModel();
 
        visitationRecord.setProcedureId(Integer.parseInt(request.getParameter("procedureId")));
        UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();                //Here I am assuming that the current logged in user is the doctor hence grab his id
        visitationRecord.setDoctorId(user.getUserId()); 
        visitationRecord.setPatientId("patient1@email.com");                                              //need to get the patient id, either from current patient being viewed or someother way
        visitationRecord.setTimeStarted(ParseTime(request.getParameter("timestarted")));
        visitationRecord.setTimeEnded(ParseTime(request.getParameter("timeended")));
        visitationRecord.setPrescriptions(request.getParameter("prescriptions"));
        visitationRecord.setDiagnosis(request.getParameter("diagnosis"));
        visitationRecord.setTreatmentSchedule("EMPTY");                                             // no treatment schedule field has been added yet
        visitationRecord.setNotes(request.getParameter("comment"));
        
        doctor.AddVisitationRecord(visitationRecord);
        
        //Temp sending to profile page
        response.sendRedirect("Views/DoctorView/profile_doc.jsp");
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

    
    public Timestamp ParseTime(String strTime){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");        
        Date time = null;
        Date temp = null;
        try{                                                                                    //parsing time started
            temp = sdf.parse(strTime);
            time = new Date();
            time.setHours(temp.getHours());
            time.setMinutes(temp.getMinutes());
            time.setSeconds(0);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return new Timestamp(time.getTime());
    }
}
