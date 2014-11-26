/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.AddressModel;
import Model.DoctorModel;
import Model.PatientModel;
import Model.StaffDoctorModel;
import Model.StaffModel;
import Model.UserModel;
import ViewModel.UserProfileVM;
import dao.StaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import util.Security;

/**
 *
 * @author Ish
 */
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }
    
    private void EditUser(HttpServletRequest request, HttpSession session)
    {
        UserDao userData = new UserDao();
        //HttpSession session = request.getSession(false);
        UserProfileVM userModified = (UserProfileVM) session.getAttribute("profile");
        userModified.getAddress().setStreetNumber(Integer.parseInt(request.getParameter("streetNumber")));
        userModified.getAddress().setStreetName(request.getParameter("streetName"));
        userModified.getAddress().setCity(request.getParameter("city"));
        userModified.getAddress().setProvince(request.getParameter("state"));
        userModified.getAddress().setPostalCode(request.getParameter("zip"));
        userModified.getUser().setPhoneNumber(request.getParameter("phone"));        
        userData.ModifyUser(userModified);
    }
    
    private void AddUser(HttpServletRequest request)
    {
        UserDao userData = new UserDao();
        Security hashPassword = new Security();        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        java.util.Date date = null;
        try{
            date = sdf.parse(request.getParameter("dob"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        
        int userType = Integer.parseInt(request.getParameter("userType"));

        UserModel user = new UserModel();
        user.setUserId(request.getParameter("email"));
        user.setFirstName(request.getParameter("fname"));
        user.setLastName(request.getParameter("lname"));
        user.setGender((Integer.parseInt(request.getParameter("gender")) != 0));
        user.setDateOfBirth(new java.sql.Date(date.getTime()));
        user.setUserType(userType);
        user.setPassword(hashPassword.hashedPassword(request.getParameter("password")));
        user.setPhoneNumber(request.getParameter("phone"));
        user.setEmergencyContactName(request.getParameter("emergencyContactName"));
        user.setEmergencyContactPhoneNumber(request.getParameter("emergencyContactNumber"));
       
        AddressModel address = new AddressModel();
        address.setStreetNumber(Integer.parseInt(request.getParameter("street_num")));
        address.setStreetName(request.getParameter("street_name"));
        address.setCity(request.getParameter("city"));
        address.setProvince(request.getParameter("province"));
        address.setCountry(request.getParameter("country"));
        address.setPostalCode(request.getParameter("zip"));
        
        if(userType == 1){
            PatientModel patient = new PatientModel();
            patient.setPatientId(request.getParameter("email"));
            patient.setDoctorId(request.getParameter("doctorId"));
            patient.setHealthStateId(Integer.parseInt(request.getParameter("healthStateId")));
            patient.setHealthCardNumber(Integer.parseInt(request.getParameter("healthNum")));
            patient.setSocialInsuranceNumber(Integer.parseInt(request.getParameter("sin")));
            patient.setIsActive(true);
            patient.setNumberOfVisits(0);
            patient.setPatientNotes(null);
            userData.AddUser(user, address, patient, null, null);            
        } else if (userType == 2) {
            DoctorModel doctor = new DoctorModel();
            doctor.setDoctorId(request.getParameter("email"));
            doctor.setDoctorType(request.getParameter("docType"));
            userData.AddUser(user, address, null, doctor, null);
        } else if (userType == 3) {
            StaffModel staff = new StaffModel();            
            staff.setStaffId(request.getParameter("email"));
            userData.AddUser(user, address, null, null, staff);
            
            StaffDoctorModel staffDoctor = new StaffDoctorModel();
            String[] array = request.getParameter("doctorIds").split(",");
            staffDoctor.setStaffId(request.getParameter("email"));
            for (String doctorId : array) {
                staffDoctor.setDoctorId(doctorId);
                userData.AddStaffDoctor(staffDoctor);
            }
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
        HttpSession session = request.getSession(false);
        RequestDispatcher view = null;

        if (request.getParameter("Edit") != null)
            this.EditUser(request, session);
        else if(request.getParameter("Add") != null)
            this.AddUser(request); 
        UserProfileVM user = (UserProfileVM)session.getAttribute("profile");
        int userType = user.getUser().getUserType();
        String forward = "";
        if(userType == 1) //Patient
                forward = "/Views/PatientView/profile.jsp";
            else if(userType == 2) //Doctor
                forward = "/Views/DoctorView/profile_doc.jsp";
            else if(userType == 3){ //Staff
                //StaffDao staff = new StaffDao();
                //request.setAttribute("upcomingAppointments", staff.getUpcomingAppointmens(user.getUser().getUserId()));
                forward = "/Views/StaffView/profile_staff.jsp";
            }
            else if(userType == 4) //Finanace
                forward = "/Views/FinancialView/profile_financial.jsp";
        view = request.getServletContext().getRequestDispatcher(forward);
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
