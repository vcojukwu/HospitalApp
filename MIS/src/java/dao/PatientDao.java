/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DbUtil;
import Model.*;
import ViewModel.PatientUserVM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author TheKey
 */

public class PatientDao {
    private static String[] PatientModelColumns = {"PatientId","DoctorId","HealthStateId","HealthCardNumber",
            "SocialInsuranceNumber","NumberOfVisits","IsActive","LastVisitDate","PatientNotes"};
    private static String[] PatientModelTypes = {"String","String","int","int",
            "int","int","boolean","Timestamp","String"};
    private static String[] UserModelColumns = {"UserId", "FirstName", "LastName", "Gender", 
        "DateOfBirth", "UserType", "Password", "PhoneNumber", "AddressId", 
        "EmergencyContactName", "EmergencyContactPhoneNumber"};
    private static String[] UserModelTypes = {"String", "String", "String", "boolean", 
        "Date", "int", "String", "String", "int", 
        "String", "String"};
    
    
    public PatientModel getPatient(String patientid)
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM patients where patientid = ?";
        PatientModel pm = new PatientModel();
        try{
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, patientid);
            rs = pstmt.executeQuery(query); 
            while (rs.next()) {
                
                pm.setPatientId(rs.getString("PatientId"));
                pm.setDoctorId(rs.getString("DoctorId"));
                pm.setHealthStateId(rs.getInt("HealthStateId"));
                pm.setHealthCardNumber(rs.getInt("HealthCardNumber"));
                pm.setSocialInsuranceNumber(rs.getInt("SocialInsuranceNumber"));
                pm.setNumberOfVisits(rs.getInt("NumberOfVisits"));
                pm.setIsActive(rs.getBoolean("IsActive"));
                pm.setLastVisitDate(rs.getTimestamp("LastVisitDate"));
                pm.setPatientNotes(rs.getString("PatientNotes"));
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        return pm;
    }
    
    //This method will update all attributes as given in the patient model parameter
    //Returns true if executed successfully, else false
    public boolean updatePatient(PatientModel patient)
    {
        PreparedStatement pstmt = null;
        String query = "UPDATE patients SET DoctorId = ?, HealthStateId = ?, HealthCardNumber = ?, "
                + "SocialInsuranceNumber = ?, NumberOfVisits = ?, IsActive = ?, "
                + "LastVisitDate = ?, PatientNotes = ? where patientid = ?";
        try{
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, patient.getDoctorId());
            pstmt.setInt(2, patient.getHealthStateId());
            pstmt.setInt(3, patient.getHealthCardNumber());
            pstmt.setInt(4, patient.getSocialInsuranceNumber());
            pstmt.setInt(5, patient.getNumberOfVisits());
            pstmt.setBoolean(6, patient.isIsActive());
            pstmt.setTimestamp(7, patient.getLastVisitDate());
            pstmt.setString(8, patient.getPatientNotes());
            pstmt.setString(9, patient.getPatientId());
            pstmt.executeUpdate(); 
            return true;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return false;
    }
    
    public void deletePatient(int id)
    {
        
    }
    
    
    //This function returns a result 
    public List<PatientUserVM> searchPatients(String[] PatientSearchAttr, String[] UserSearchAttr){
        List<PatientUserVM> result = new ArrayList<PatientUserVM>();
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<String> elementType = new ArrayList<String>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from mis_db.patients left join mis_db.users on patients.PatientId = users.UserId ";
        PatientUserVM puvm = null;
        PatientModel patientmodel= null;
        UserModel usermodel= null;
        
        boolean whereSet =false;
        for(int i=0; i<PatientModelColumns.length; i++){
            if(PatientSearchAttr[i] != null){
                if(whereSet==false){
                    query += " WHERE ";
                    whereSet = true;
                }
                else{
                     query += " AND ";
                    
                }
                
                if(PatientModelTypes[i].equals("boolean") || PatientModelTypes[i].equals("int")){
                    query += "patients." + PatientModelColumns[i] + " = ? ";
                }
                else{
                    query += "patients." + PatientModelColumns[i] + " LIKE ? ";
                }
                elements.add(PatientSearchAttr[i]);
                elementType.add(PatientModelTypes[i]);
            }
        }
        for(int i=0; i<UserModelColumns.length; i++){
            if(UserSearchAttr[i] != null){
                if(whereSet==false){
                    query += " WHERE ";
                    whereSet = true;
                }
                else{
                     query += " AND ";
                    
                }
            
                if(UserModelTypes[i].equals("boolean") || UserModelTypes[i].equals("int")){
                    query += "users." + UserModelColumns[i] + " = ? ";
                }
                /*else if(UserModelTypes[i].equals("Date")){
                    query += "(users." + UserModelColumns[i] + " BETWEEN ? AND ?) ";
                }*/
                else{
                    query += "users." + UserModelColumns[i] + " LIKE ? ";
                }
                elements.add(UserSearchAttr[i]);
                elementType.add(UserModelTypes[i]);
            }
        }
        
        
        try{
            
            pstmt = DbUtil.getConnection().prepareStatement(query);
            for(int i=1;i<=elements.size(); i++){
                switch(elementType.get(i-1)){
                    case "String":
                        pstmt.setString(i, "%"+elements.get(i-1)+"%");
                        break;
                    case "int":
                        pstmt.setInt(i, Integer.parseInt(elements.get(i-1)));
                        break;
                    case "boolean":
                        if(elements.get(i-1).equalsIgnoreCase("true")||elements.get(i-1).equalsIgnoreCase("1")){
                            pstmt.setBoolean(i, true);
                        }
                        else{
                            pstmt.setBoolean(i, false);
                        }
                        break;
                    case "Date":
                        pstmt.setDate(i, new java.sql.Date(Long.parseLong(elements.get(i-1))));
                        break;
                }
                
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                puvm = new PatientUserVM();
                
                patientmodel = new PatientModel();
                usermodel = new UserModel();
                
                patientmodel.setPatientId(rs.getString(PatientModelColumns[0]));
                patientmodel.setDoctorId(rs.getString(PatientModelColumns[1]));
                patientmodel.setHealthStateId(rs.getInt(PatientModelColumns[2]));
                patientmodel.setHealthCardNumber(rs.getInt(PatientModelColumns[3]));
                patientmodel.setSocialInsuranceNumber(rs.getInt(PatientModelColumns[4]));
                patientmodel.setNumberOfVisits(rs.getInt(PatientModelColumns[5]));
                patientmodel.setIsActive(rs.getBoolean(PatientModelColumns[6]));
                patientmodel.setLastVisitDate(rs.getTimestamp(PatientModelColumns[7]));
                patientmodel.setPatientNotes(rs.getString(PatientModelColumns[8]));
               
                usermodel.setUserId(rs.getString(UserModelColumns[0]));
                usermodel.setFirstName(rs.getString(UserModelColumns[1]));
                usermodel.setLastName(rs.getString(UserModelColumns[2]));
                usermodel.setGender(rs.getBoolean(UserModelColumns[3]));
                usermodel.setDateOfBirth(rs.getDate(UserModelColumns[4]));
                usermodel.setUserType(rs.getInt(UserModelColumns[5]));
                usermodel.setPassword(rs.getString(UserModelColumns[6]));
                usermodel.setPhoneNumber(rs.getString(UserModelColumns[7]));
                usermodel.setAddressId(rs.getInt(UserModelColumns[8]));
                usermodel.setEmergencyContactName(rs.getString(UserModelColumns[9]));
                usermodel.setEmergencyContactPhoneNumber(rs.getString(UserModelColumns[10]));

                
                puvm.setPatient(patientmodel);
                puvm.setUser(usermodel);
                
                result.add(puvm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public List<PatientModel> getAllPatients(){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM patients";
        PatientModel pm = null;
        List<PatientModel> patients = new ArrayList<PatientModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();
            rs = stmt.executeQuery(query); 
            while (rs.next()) {
                pm = new PatientModel();
                pm.setPatientId(rs.getString("PatientId"));
                pm.setDoctorId(rs.getString("DoctorId"));
                pm.setHealthStateId(rs.getInt("HealthStateId"));
                pm.setHealthCardNumber(rs.getInt("HealthCardNumber"));
                pm.setSocialInsuranceNumber(rs.getInt("SocialInsuranceNumber"));
                pm.setNumberOfVisits(rs.getInt("NumberOfVisits"));
                pm.setIsActive(rs.getBoolean("IsActive"));
                pm.setPatientNotes(rs.getString("PatientNotes"));
                patients.add(pm);
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        return patients;
    }
}
