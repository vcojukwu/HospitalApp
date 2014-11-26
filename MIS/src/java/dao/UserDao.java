/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.AddressModel;
import Model.DoctorModel;
import Model.PatientModel;
import Model.StaffDoctorModel;
import Model.StaffModel;
import Model.UserModel;
import ViewModel.UserProfileVM;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DbUtil;

/**
 *
 * @author Ish
 */
public class UserDao {
    private Connection connection;
    public UserDao()
    {
        connection = DbUtil.getConnection();
    }
    
   public void AddUser(UserModel user, AddressModel address, PatientModel patient,DoctorModel doctor, StaffModel staff){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        int userType    = user.getUserType();
        int addressId   = -1;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            query = "INSERT INTO address ( StreetNumber, StreetName, City, Province, Country, PostalCode) " + 
                    "VALUES ( " + address.getStreetNumber() + ", '" + address.getStreetName() + "' , '" +
                    address.getCity() + "', '" + address.getProvince() + "', '" + address.getCountry() +
                    "', '" + address.getPostalCode() + "');";           
            stmt.executeUpdate(query);            
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID() as last_id");
            while (rs.next()) {
                addressId = rs.getInt("last_id");
            }            
            query = "INSERT INTO users ( UserId, FirstName, LastName, Gender, DateOfBirth, UserType, "
                    + "Password, PhoneNumber, AddressId, EmergencyContactName, EmergencyContactPhoneNumber) "
                    + "VALUES ( '" + user.getUserId() + "', '" + user.getFirstName() + "' , '" +
                    user.getLastName() + "'," + user.isGender()+ ", '" + user.getDateOfBirth() +
                    "', '" + user.getUserType() + "', '" + user.getPassword()+ 
                    "', '" + user.getPhoneNumber() + "' ,'" + addressId + "' ,'" +
                    user.getEmergencyContactName() + "', '" + user.getEmergencyContactPhoneNumber() + "')";
            stmt.executeUpdate(query);
            
            if(userType == 1){
                query = "INSERT INTO mis_db.patients (PatientId, DoctorId, HealthStateId, "
                        + "HealthCardNumber, SocialInsuranceNumber, NumberOfVisits, IsActive, "
                        + "PatientNotes) VALUES ('" + patient.getPatientId()+ "', '" + patient.getDoctorId()
                        + "', " + patient.getHealthStateId() + ", " + patient.getHealthCardNumber()                      
                        + ", " + patient.getSocialInsuranceNumber() + ", " + patient.getNumberOfVisits() + ", "
                        + patient.isIsActive() + ", " + patient.getPatientNotes() + ");";                
                stmt.executeUpdate(query);                
                query = "INSERT INTO doctor_permissions (PatientId, DoctorId) VALUES ('" + patient.getPatientId() 
                    + "', '" + patient.getDoctorId() + "');";
                stmt.executeUpdate(query);
            } else if (userType == 2){
                query = "INSERT INTO mis_db.doctors (DoctorId, DoctorType) VALUES ('"
                        + doctor.getDoctorId()+ "' ,'" + doctor.getDoctorType() + "')";
                System.out.println(query);
                stmt.executeUpdate(query);
            } else if (userType == 3){
                query = "INSERT INTO mis_db.staff (StaffId) VALUES ('"
                        + user.getUserId() + "')";
                System.out.println(query);
                stmt.executeUpdate(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    public void ModifyUser(UserProfileVM userModified){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            query = "UPDATE users " +
                    "SET PhoneNumber='" + userModified.getUser().getPhoneNumber() + "' " + 
                    "WHERE UserId='" + userModified.getUser().getUserId() + "'; ";
            System.out.println(query);
            stmt.executeUpdate(query);
            query = "UPDATE address " +
                    "SET StreetNumber ='" + userModified.getAddress().getStreetNumber() + "', " + 
                    "StreetName = '" + userModified.getAddress().getStreetName() + "', " +
                    "City = '" + userModified.getAddress().getCity() + "', " +
                    "Province = '" + userModified.getAddress().getProvince() + "', " +
                    "PostalCode = '" + userModified.getAddress().getPostalCode() + "' " +
                    "WHERE AddressId=" + userModified.getAddress().getAddressId()+ ";";
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void AddStaffDoctor(StaffDoctorModel staff){
        Statement stmt  = null;
        String query    = null;
  
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "INSERT INTO mis_db.staff_doctor (StaffId, DoctorId)  VALUES ('" + 
                    staff.getStaffId() + "', '" + staff.getDoctorId() + "')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
