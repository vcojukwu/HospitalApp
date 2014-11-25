/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
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
@WebServlet(name = "DoctorController", urlPatterns = {"/AddVisitationRecord" , "/Doctor", "/PatientRecords"})
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
        
         if (request.getParameter("AddVisitationRecord") != null){
           this.AddVisitationRecord(request, session, response, "NULL");
         }
         else if (request.getParameter("SearchPatients") != null)
            this.SearchPatients(request, session, response);
         else if (request.getParameter("ViewPatientDetail") != null){
             String patientId = request.getParameter("ViewPatientDetail");
            this.NavigateToPatientView(request, session, response, patientId);
         }
         else if (request.getParameter("PatientRecord") != null){
                   String patientId = (String)request.getAttribute("ViewPatientDetail");
                   this.AddVisitationRecord(request, session, response, patientId);
                   this.NavigateToPatientView(request, session, response, patientId);
            }
        
        
        

    }

    private void NavigateToPatientView(HttpServletRequest request, HttpSession session, HttpServletResponse response, String patId)
        throws ServletException, IOException{
            
            PatientDao patientdao = new PatientDao();
            UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();                                //Get Doctor Id  
            
           
            //get the patient info to diplay on top currently ill display id only - we can add first name and last name later on
            request.setAttribute("patientId", patId);
            String[] VisitationRecordSA = {null,null,null,
                patId,user.getUserId(),null,null,null,null,
                null};
            String[] UserModelSA = {null, null, null , null, 
                null, null, null, null, null, 
                null, null};
            DoctorDao doctor = new DoctorDao();
            request.setAttribute("records", doctor.FindRecords(VisitationRecordSA, UserModelSA));
            request.setAttribute("procedures", doctor.GetProcedures());
            
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/DoctorView/patient_records.jsp");
        rd.forward(request, response);
        }
    private void SearchPatients(HttpServletRequest request, HttpSession session, HttpServletResponse response)
        throws ServletException, IOException{
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();                                //Get Doctor Id  
        PatientDao patientdao = new PatientDao();
        String[] PatientModelSA = {null,user.getUserId(), null,null,
            null,null, null, null, null};
        String[] UserModelSA = {null, (firstname == "")?  null : firstname , (lastname == "")?  null : lastname, null, 
            null, null, null, null, null, 
            null, null};
        //For now just get all patients, not sending in search criteria
         request.setAttribute("patients", patientdao.searchPatients(PatientModelSA, UserModelSA));
         
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Views/DoctorView/search_patients.jsp");
        rd.forward(request, response);
    }
    
    private void AddVisitationRecord(HttpServletRequest request, HttpSession session, HttpServletResponse response, String patientId)
        throws ServletException, IOException{
                
        DoctorDao doctor = new DoctorDao();
        
        String temp = request.getParameter("selectedNotes");
        
        VisitationRecordsModel visitationRecord = new VisitationRecordsModel();
        
        int recordType = Integer.parseInt(request.getParameter("selectedRecordType"));                   //0 = existing record, 1 = new record
        int originalRecordId = Integer.parseInt(request.getParameter("selectedOriginalRecordId"));
        int recordId = Integer.parseInt(request.getParameter("selectedRecordId"));
        int finalOriginalRecordId = 0;
        
        if(recordType == 0){
            if (originalRecordId == -1)                                                             
                finalOriginalRecordId = recordId;
            else
                finalOriginalRecordId = originalRecordId;
        }
        else{
            finalOriginalRecordId = -1;
        }
        visitationRecord.setOriginalRecordId(finalOriginalRecordId);
        visitationRecord.setProcedureId(Integer.parseInt(request.getParameter("selectedProcedureId")));
        UserModel user = ((UserProfileVM)session.getAttribute("profile")).getUser();                    //Here I am assuming that the current logged in user is the doctor hence grab his id
        visitationRecord.setDoctorId(user.getUserId()); 
        visitationRecord.setPatientId(patientId);                                              
        visitationRecord.setTimeStarted(ParseTimeRecords(request.getParameter("selectedDate"), request.getParameter("selectedTimeStarted")));
        visitationRecord.setTimeEnded(ParseTimeRecords(request.getParameter("selectedDate"), request.getParameter("selectedTimeEnded")));
        visitationRecord.setPrescriptions(request.getParameter("selectedPrecriptions"));
        visitationRecord.setDiagnosis(request.getParameter("selectedDiagnosis"));
        visitationRecord.setTreatmentSchedule("EMPTY");                                             // no treatment schedule field has been added yet
        visitationRecord.setNotes(request.getParameter("selectedNotes"));
        
        doctor.AddVisitationRecord(visitationRecord);
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
    
        public Timestamp ParseTimeRecords(String strDate, String strTime){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");   
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date temp = null;
        Date time = null;
        try{                                                                                    //parsing time started
            temp = sdf.parse(strTime);
            date = sdf1.parse(strDate);
            time = new Date();
            time.setHours(temp.getHours());
            time.setMinutes(temp.getMinutes());
            time.setSeconds(0);
            time.setDate(date.getDate());
        } catch (ParseException e){
            e.printStackTrace();
        }
        return new Timestamp(time.getTime());
    }
}
