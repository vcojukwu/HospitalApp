/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.AppointmentsModel;
import Model.DoctorModel;
import Model.HealthStateModel;
import Model.PatientDropDownModel;
import Model.PatientModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

    public List<PatientDropDownModel> getAllPatientsDropdown(){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<PatientDropDownModel> patients = new ArrayList<PatientDropDownModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "SELECT PatientId, FirstName, LastName FROM patients INNER JOIN users ON patients.PatientId = users.UserID";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                PatientDropDownModel patient = new PatientDropDownModel();
                patient.setPatientId(rs.getString("PatientId"));
                patient.setFirstName(rs.getString("FirstName"));
                patient.setLastName(rs.getString("LastName"));                
                patients.add(patient);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return patients;
    }
        
    public void AssignPatients(PatientModel patient){
        Statement stmt  = null;
        String query    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "UPDATE patients " +
                    "SET DoctorId='" + patient.getDoctorId() + "' " + 
                    "WHERE PatientId='" + patient.getPatientId() + "'; ";
            stmt.executeUpdate(query);
            query = "DELETE FROM doctor_permissions WHERE PatientId = '" + patient.getPatientId() + "'";
            stmt.executeUpdate(query);
            query = "INSERT INTO doctor_permissions (PatientId, DoctorId) VALUES ('" + patient.getPatientId() 
                    + "', '" + patient.getDoctorId() + "');";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void addAppointment(AppointmentsModel appointment){
        Statement stmt  = null;
        String query    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "INSERT INTO appointments (PatientId, DoctorId, TimeScheduled, DurationScheduled)" + 
                    "VALUES ('" + appointment.getPatientId() + "', '" + appointment.getDoctorId() + 
                    "', '" + appointment.getTimeScheduled()+ "'," + appointment.getDurationScheduled() 
                    + ");";  
            System.out.println(query);
            stmt.executeUpdate(query); 

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }  
    
    public void editAppointment(AppointmentsModel appointment){
        Statement stmt  = null;
        String query    = null;
        
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "UPDATE appointments " +
                    "SET PatientId='" + appointment.getPatientId() + "', " +
                    "DoctorId='" + appointment.getDoctorId() + "', " +
                    "TimeScheduled='" + appointment.getTimeScheduled()+ "', " +
                    "DurationScheduled='" + appointment.getDurationScheduled()+ "' " +
                    "WHERE AppointmentId='" + appointment.getAppointmentId() + "'; ";
            stmt.executeUpdate(query);

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void deleteAppointment(AppointmentsModel appointment){
        Statement stmt  = null;
        String query    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "DELETE FROM appointments WHERE AppointmentId = '" + appointment.getAppointmentId() + "';";
            stmt.executeUpdate(query); 

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public List<AppointmentsModel> getAllAppointments(){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<AppointmentsModel> appointments = new ArrayList<AppointmentsModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();            
            query = "SELECT AppointmentId, PatientId, DoctorId, TimeScheduled, DurationScheduled FROM appointments";
            rs = stmt.executeQuery(query);
        
            while(rs.next()){
                AppointmentsModel appointment = new AppointmentsModel();
                appointment.setAppointmentId(rs.getInt("AppointmentId"));
                appointment.setDoctorId(rs.getString("DoctorId"));
                appointment.setPatientId(rs.getString("PatientId"));
                appointment.setTimeScheduled(rs.getTimestamp("TimeScheduled"));
                appointment.setDurationScheduled(rs.getInt("DurationScheduled"));
                appointments.add(appointment);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return appointments;
    }
}
