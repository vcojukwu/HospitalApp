/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.AddressModel;
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
        
        HttpSession session = request.getSession(true);
        UserProfileVM userModified = (UserProfileVM) session.getAttribute("profile");
        userModified.getAddress().setStreetNumber(Integer.parseInt(request.getParameter("streetNumber")));
        userModified.getAddress().setStreetName(request.getParameter("streetName"));
        userModified.getAddress().setCity(request.getParameter("city"));
        userModified.getAddress().setProvince(request.getParameter("state"));
        userModified.getAddress().setPostalCode(request.getParameter("zip"));
        userModified.getUser().setPhoneNumber(request.getParameter("phone"));
//        Security hashPassword = new Security();        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
//        java.util.Date date = null;
//        try{
//            date = sdf.parse(request.getParameter("dob"));
//        } catch (ParseException e){
//            e.printStackTrace();
//        }        
//               
//
//        String UserId = request.getParameter("email");
//        String FirstName = request.getParameter("fname");
//        String LastName = request.getParameter("lname");
//        boolean Gender = (Integer.parseInt(request.getParameter("gender")) == 0)? false : true;        
//        int UserType = Integer.parseInt(request.getParameter("userType"));
//        String Password = hashPassword.hashedPassword(request.getParameter("password"));
//        java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
//        String PhoneNumber = request.getParameter("phone");
//        String EmergencyContactName = request.getParameter("emergencyContactName");
//        String EmergencyContactPhoneNumber = request.getParameter("emergencyContactNumber");
//
//        UserModel user = new UserModel();
//        user.setUserId(UserId);
//        user.setFirstName(FirstName);
//        user.setLastName(LastName);
//        user.setGender(Gender);
//        user.setDateOfBirth(dateOfBirth);
//        user.setUserType(UserType);
//        user.setPassword(Password);
//        user.setPhoneNumber(PhoneNumber);
//        user.setEmergencyContactName(EmergencyContactName);
//        user.setEmergencyContactPhoneNumber(EmergencyContactPhoneNumber);
//       
//        
//        int StreetNumber = Integer.parseInt(request.getParameter("street_num"));
//        String StreetName = request.getParameter("street_name");
//        String City = request.getParameter("city");
//        String Province = request.getParameter("province");
//        String Country = request.getParameter("country");
//        String PostalCode = request.getParameter("zip");
//        
//        AddressModel address = new AddressModel();
//        address.setStreetNumber(StreetNumber);
//        address.setStreetName(StreetName);
//        address.setCity(City);
//        address.setProvince(Province);
//        address.setCountry(Country);
//        address.setPostalCode(PostalCode);
//        
        UserDao userData = new UserDao();
        userData.ModifyUser(userModified);
        
//        userData.AddUser(user, address);        
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
