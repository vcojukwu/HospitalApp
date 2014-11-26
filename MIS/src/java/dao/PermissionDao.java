/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

/**
 *
 * @author Anish
 */
public class PermissionDao {
    public List<String> getDoctorsExceptCurrent(String doctorid){
        PreparedStatement pstmt = null;
        List<String> doctorids = new ArrayList<String>();
        String query;
        ResultSet rs = null;
        try{
            query = "SELECT DoctorId FROM doctors where DoctorId <> ?";
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, doctorid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                doctorids.add(rs.getString("DoctorId"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return doctorids;
    }
    
    public List<String> getPatientIdsForCurrentDoc (String doctorid){
         PreparedStatement pstmt = null;
        List<String> patientids = new ArrayList<String>();
        String query;
        ResultSet rs = null;
        try{
            query = "SELECT PatientId FROM patients where DoctorId = ?";
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, doctorid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                patientids.add(rs.getString("PatientId"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return patientids;
    }
    
    public List<DoctorPermissionsModel> GetPermissions (String doctorid){
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM mis_db.doctor_permissions where DoctorId = ?";
        List<DoctorPermissionsModel> permissions = new ArrayList<DoctorPermissionsModel>();
        DoctorPermissionsModel dpm = null;
        ResultSet rs= null;
        try{
            pstmt = DbUtil.getConnection().prepareStatement(doctorid);
            pstmt.setString(1, doctorid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dpm = new DoctorPermissionsModel();
                dpm.setDoctorId(rs.getString("DoctorId"));
                dpm.setPatientId(rs.getString("PatientId"));
                permissions.add(dpm);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return permissions;
    }
    
    public void AddPermission (String doctorid, String patientid){
        PreparedStatement pstmt = null;
        String query;
        try{
            query = "INSERT INTO mis_db.doctor_permissions (PatientId, DoctorId) VALUES ('?', '?')";
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, patientid);
            pstmt.setString(2, doctorid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
