/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DbUtil;
import Model.PatientModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author TheKey
 */

public class PatientDao {
    private Connection connection;
    
    public PatientDao() {
        connection = DbUtil.getConnection();
    }
    
    /*
    
    */
    public PatientModel getPatient(int patientid)
    {
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM patients where patientid = '" + patientid + "'";
        PatientModel pm = new PatientModel();
        try{
            stmt = DbUtil.getConnection().createStatement();
            rs = stmt.executeQuery(query); 
            while (rs.next()) {
                
                pm.setPatientId(rs.getString("PatientId"));
                pm.setDoctorId(rs.getString("DoctorId"));
                pm.setHealthStateId(rs.getInt("HealthStateId"));
                pm.setHealthCardNumber(rs.getInt("HealthCardNumber"));
                pm.setSocialInsuranceNumber(rs.getInt("SocialInsuranceNumber"));
                pm.setNumberOfVisits(rs.getInt("NumberOfVisits"));
                pm.setIsActive(rs.getBoolean("IsActive"));
                pm.setPatientNotes(rs.getString("PatientNotes"));
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        return pm;
    }
    
    public void addPatient(PatientModel patient)
    {
        
    }
    
    public void updatePatient(PatientModel patient)
    {
        
    }
    
    public void deletePatient(int id)
    {
        
    }
    
    public List<PatientModel> getAllPatients(){
        
        return null;
    }
}
