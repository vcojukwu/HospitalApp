/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.AddressModel;
import Model.DoctorModel;
import Model.PatientModel;
import Model.StaffModel;
import Model.UserModel;
import ViewModel.UserProfileVM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        UserDao userData = new UserDao();
        //HttpSession session = request.getSession(true);
        //UserProfileVM userModified = (UserProfileVM) session.getAttribute("profile");
        //userModified.getAddress().setStreetNumber(Integer.parseInt(request.getParameter("streetNumber")));
        //userModified.getAddress().setStreetName(request.getParameter("streetName"));
        //userModified.getAddress().setCity(request.getParameter("city"));
        //userModified.getAddress().setProvince(request.getParameter("state"));
        //userModified.getAddress().setPostalCode(request.getParameter("zip"));
        //userModified.getUser().setPhoneNumber(request.getParameter("phone"));
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
        user.setGender((Integer.parseInt(request.getParameter("gender")) == 0)? false : true);
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
        }      
        //userData.ModifyUser(userModified);                
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
