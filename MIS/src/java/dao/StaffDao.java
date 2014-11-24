/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.DoctorModel;
import Model.HealthStateModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

/**
 *
 * @author TheKey
 */
public class StaffDao {
    
    private Connection connection;
    public StaffDao()
    {
        connection = DbUtil.getConnection();
    }
    public List<DoctorModel> getDoctors(){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<DoctorModel> doctors = new ArrayList<DoctorModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "SELECT DoctorId, FirstName, LastName FROM users INNER JOIN doctors ON doctors.DoctorID = users.UserId";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                DoctorModel doctor = new DoctorModel();
                doctor.setDoctorId(rs.getString("DoctorId"));
                doctor.setFirstName(rs.getString("FirstName"));
                doctor.setLastName(rs.getString("LastName"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return doctors;
    }
    
    public List<HealthStateModel> getHealthSates(){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<HealthStateModel> healthStates = new ArrayList<HealthStateModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "SELECT HealthStateId, HealthStateName FROM health_state";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                HealthStateModel healthState = new HealthStateModel();
                healthState.setHealthStateId(Integer.parseInt(rs.getString("HealthStateId")));
                healthState.setHealthStateName(rs.getString("HealthStateName"));
                healthStates.add(healthState);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return healthStates;
    }
}
