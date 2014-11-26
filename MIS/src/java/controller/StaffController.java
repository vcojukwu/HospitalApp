/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.AppointmentsModel;
import Model.PatientModel;
import dao.PatientDao;
import dao.StaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "StaffController", urlPatterns = {"/Staff", "/AssignPatients", "/AddNewUser", "/Appointments", "/AddAppointments"})
public class StaffController extends HttpServlet {

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
            out.println("<title>Servlet StaffController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffController at " + request.getContextPath() + "</h1>");
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
        StaffDao staff = new StaffDao();
        if(requestURL.contains("AddNewUser")){
            request.setAttribute("healthStates", staff.getHealthSates());
            request.setAttribute("doctors", staff.getDoctors());
            forward = "/Views/StaffView/new_user.jsp";
        } else if (requestURL.contains("AssignPatients")){
            request.setAttribute("doctors", staff.getDoctors());
            request.setAttribute("patients", staff.getAllPatientsDropdown());
            forward = "/Views/StaffView/assign.jsp";
        } else if (requestURL.contains("Appointments")){
            request.setAttribute("doctors", staff.getDoctors());
            request.setAttribute("patients", staff.getAllPatientsDropdown());
            request.setAttribute("appointments", staff.getAllAppointments());
            forward = "/Views/StaffView/staff_appointments.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);            
        rd.forward(request, response);
    }

    private void editAppointment(HttpServletRequest request){
        StaffDao staff = new StaffDao();
        AppointmentsModel appointment = new AppointmentsModel();
        appointment.setAppointmentId(Integer.parseInt(request.getParameter("appointmentIdFinal")));
        appointment.setDoctorId(request.getParameter("docIdFinal"));
        appointment.setPatientId(request.getParameter("patIdFinal"));
        appointment.setDurationScheduled(Integer.parseInt(request.getParameter("durationFinal")));
        appointment.setTimeScheduled(ParseTimeRecords(request.getParameter("dateFinal"), request.getParameter("timeFinal")));
        staff.editAppointment(appointment);
    }
    
    private void addAppointment(HttpServletRequest request){
        StaffDao staff = new StaffDao();
        AppointmentsModel appointment = new AppointmentsModel();
        appointment.setDoctorId(request.getParameter("docIdFinal"));
        appointment.setPatientId(request.getParameter("patIdFinal"));
        appointment.setDurationScheduled(Integer.parseInt(request.getParameter("durationFinal")));
        appointment.setTimeScheduled(ParseTimeRecords(request.getParameter("dateFinal"), request.getParameter("timeFinal")));
        staff.addAppointment(appointment);
    }
    
    private void deleteAppointment(HttpServletRequest request){
        StaffDao staff = new StaffDao();
        AppointmentsModel appointment = new AppointmentsModel();
        appointment.setAppointmentId(Integer.parseInt(request.getParameter("appointmentIdFinal")));
        //appointment.setDoctorId(request.getParameter("docIdFinal"));
        //appointment.setPatientId("patIdFinal");
        //appointment.setDurationScheduled(Integer.parseInt(("durationFinal")));
        //appointment.setTimeScheduled(ParseTimeRecords(request.getParameter("dateFinal"), request.getParameter("timeFinal")));
        staff.deleteAppointment(appointment);
    }
    
    private void assignPatients(HttpServletRequest request){
        StaffDao staff = new StaffDao();
        PatientModel patient = new PatientModel();
        String[] array = request.getParameter("patientIDs").split(","); 
        patient.setDoctorId(request.getParameter("doctorId"));            
        for (String patientId : array) {
            patient.setPatientId(patientId);
            staff.AssignPatients(patient);
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
        RequestDispatcher view = null;
        String forward = null;
        if (request.getParameter("function").equals("EditAppointment")){
            this.editAppointment(request);
            forward = "MIS/Appointments";
        }            
        else if (request.getParameter("function").equals("AddAppointment")){
            this.addAppointment(request);
            forward = "MIS/Appointments";
        }
        
        else if (request.getParameter("function").equals("DeleteAppointment")){
            this.deleteAppointment(request);
            forward = "MIS/Appointments";
        }
        
        else if(request.getParameter("function").equals("AssignPatients")){
           this.assignPatients(request);
           forward = "MIS/AssignPatients";
        }
        //view = request.getServletContext().getRequestDispatcher(forward);
        //view.forward(request, response);
        //response.sendRedirect(forward);  
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
            time.setMonth(date.getMonth());
            time.setYear(date.getYear());
        } catch (ParseException e){
            e.printStackTrace();
        }
        return new Timestamp(time.getTime());
    }

}
