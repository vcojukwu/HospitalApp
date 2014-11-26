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
import Model.UserModel;
import Model.VisitationRecordsModel;
import ViewModel.DoctorVisitationRecordVM;
import ViewModel.PatientUserVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private static String[] VisitationRecordModelColumns = {"RecordId","OriginalRecordId",
        "ProcedureId","PatientId","DoctorId","TimeStarted","TimeEnded","Prescriptions",
        "Diagnosis","TreatmentSchedule", "Notes"};
    private static String[] VisitationRecordModelTypes = {"int","int",
        "int","String","String","Timestamp","Timestamp","String",
        "String","String", "String"};
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
    
    public List<AppointmentsModel> getUpcomingAppointmens(String StaffId){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<AppointmentsModel> appointments = new ArrayList<AppointmentsModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();
            query = "SELECT appointments.DoctorId, PatientId, TImeScheduled, DurationScheduled from appointments JOIN STAFF_DOCTOR ON appointments.`DoctorId` = staff_doctor.`DoctorId` "
                    + "WHERE APPOINTMENTS.TIMESCHEDULED>NOW() AND STAFF_DOCTOR.STAFFID = '" + StaffId + "'"
                    + "ORDER BY TimeScheduled limit 5";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                AppointmentsModel appointment = new AppointmentsModel();
                appointment.setDoctorId(rs.getString("DoctorId"));
                appointment.setPatientId(rs.getString("PatientId"));
                appointment.setTimeScheduled(rs.getTimestamp("TimeScheduled"));
                appointment.setDurationScheduled(rs.getInt("DurationScheduled"));
                appointments.add(appointment);
                //appointment.getTimeScheuledUI()
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return appointments;
    }
    //This function returns a result 
    public List<PatientUserVM> searchPatients(String[] PatientSearchAttr, String[] UserSearchAttr, String staffid){
        List<PatientUserVM> result = new ArrayList<PatientUserVM>();
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<String> elementType = new ArrayList<String>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from mis_db.patients left join mis_db.users on patients.PatientId = users.UserId ";
        PatientUserVM puvm = null;
        PatientModel patientmodel= null;
        UserModel usermodel= null;
        String allowedIds = " (";
        
        if(PatientSearchAttr[1]==null){
            //patient is logged in and doing a search
            PatientDao pdao = new PatientDao();
            result.add(pdao.getPatient(PatientSearchAttr[1]));
            return result;
        }
        //This request will get a list of PatientIds for which the given DoctorId is allowed to view
        List<String> AllowedPatientIds = GetPatientIDsAllowed(staffid);

        if(PatientSearchAttr[0]==null){ 
            for(String id:AllowedPatientIds){
                allowedIds += "'" + id + "',";
            }
            allowedIds = allowedIds.substring(0, allowedIds.length()-1)+") ";
            query += " WHERE patients.PatientId IN"+allowedIds;
        }
        else{              //PatiendID given and DoctorID null
            if(AllowedPatientIds.contains(PatientSearchAttr[0])){
                allowedIds += "'" + PatientSearchAttr[0] + "') ";
                query += " WHERE patients.PatientId IN"+allowedIds;
            }
            else{
                return null;
            }
        }
        
        //Patient Model column search gets handled here
        for(int i=0; i<PatientModelColumns.length; i++){
            if(PatientModelColumns[i].equalsIgnoreCase("DoctorId")||PatientModelColumns[i].equalsIgnoreCase("PatientId")){
                //since patient and doctor id 
                continue;
            }
            if(PatientSearchAttr[i] != null){
                query += " AND ";
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
        //User Model column search gets handled here
        for(int i=0; i<UserModelColumns.length; i++){
            if(UserSearchAttr[i] != null){
                query += " AND ";
                if(UserModelTypes[i].equals("boolean") || UserModelTypes[i].equals("int")){
                    query += "users." + UserModelColumns[i] + " = ? ";
                }
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
                        pstmt.setString(i,elements.get(i-1).substring(0, 10)+"%");
                        break;
                    case "Timestamp":
                        pstmt.setString(i,elements.get(i-1).substring(0, 10)+"%");
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
    
     public List<DoctorVisitationRecordVM> FindRecords(String[] VRecordParams, String[] UserParams, String staffid){
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<String> elementType = new ArrayList<String>();
        PreparedStatement pstmt = null;
        ResultSet rs    = null;
        DoctorVisitationRecordVM vrum = null;
        VisitationRecordsModel vrm = null;
        UserModel um = null;
        String basequery ="select * from "
                + "(select * from "
                    + "(select * from mis_db.visitation_records left join mis_db.users on visitation_records.PatientId = users.UserId ORDER BY visitation_records.RecordId desc) "
                + "as max group by max.OriginalRecordId) "
                + "as p";
        
        List<DoctorVisitationRecordVM> result = new ArrayList<DoctorVisitationRecordVM>();
        String allowedIds = " (";
        
        List<String> AllowedPatientIds = GetPatientIDsAllowed(staffid);
        if(VRecordParams[3]==null){
            for(String id:AllowedPatientIds){
                allowedIds += "'" + id + "',";
            }
            allowedIds = allowedIds.substring(0, allowedIds.length()-1)+") ";
            basequery += " WHERE p.PatientId IN"+allowedIds;
        }
        else{
            if(AllowedPatientIds.contains(VRecordParams[3])){
                allowedIds += "'" + VRecordParams[3] + "') ";
            basequery += " WHERE p.PatientId IN"+allowedIds;
            }
            else{
                return null;
            }
        }
        
        for(int i=0; i<VisitationRecordModelColumns.length; i++){
            if(VisitationRecordModelColumns[i].equalsIgnoreCase("DoctorId")||VisitationRecordModelColumns[i].equalsIgnoreCase("PatientId")){
                //since patient id or doctor id have been accounted for above
                continue;
            }
            if(VRecordParams[i] != null){
                basequery += " AND ";
                if(VisitationRecordModelTypes[i].equals("boolean") || VisitationRecordModelTypes[i].equals("int")){
                    basequery += "p." + VisitationRecordModelColumns[i] + " = ? ";
                }
                else{
                    basequery += "p." + VisitationRecordModelColumns[i] + " LIKE ? ";
                }
                elements.add(VRecordParams[i]);
                elementType.add(VisitationRecordModelTypes[i]);
            }
        }
        //User Model column search gets handled here
        for(int i=0; i<UserModelColumns.length; i++){
            if(UserParams[i] != null){
                basequery += " AND ";
                if(UserModelTypes[i].equals("boolean") || UserModelTypes[i].equals("int")){
                    basequery += "p." + UserModelColumns[i] + " = ? ";
                }
                else{
                    basequery += "p." + UserModelColumns[i] + " LIKE ? ";
                }
                elements.add(UserParams[i]);
                elementType.add(UserModelTypes[i]);
            }
        }
        try{
            pstmt = DbUtil.getConnection().prepareStatement(basequery);
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
                        pstmt.setString(i,elements.get(i-1).substring(0, 10)+"%");
                        break;
                    case "Timestamp":
                        pstmt.setString(i,elements.get(i-1).substring(0, 10)+"%");
                        break;
                }
                
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                vrum = new DoctorVisitationRecordVM();
                vrm = new VisitationRecordsModel();
                um = new UserModel();
                
                vrm.setRecordId(rs.getInt(VisitationRecordModelColumns[0]));
                vrm.setOriginalRecordId(rs.getInt(VisitationRecordModelColumns[1]));
                vrm.setProcedureId(rs.getInt(VisitationRecordModelColumns[2]));
                vrm.setPatientId(rs.getString(VisitationRecordModelColumns[3]));
                vrm.setDoctorId(rs.getString(VisitationRecordModelColumns[4]));
                vrm.setTimeStarted(rs.getTimestamp(VisitationRecordModelColumns[5]));
                vrm.setTimeEnded(rs.getTimestamp(VisitationRecordModelColumns[6]));
                vrm.setPrescriptions(rs.getString(VisitationRecordModelColumns[7]));
                vrm.setDiagnosis(rs.getString(VisitationRecordModelColumns[8]));
                vrm.setTreatmentSchedule(rs.getString(VisitationRecordModelColumns[9]));
                vrm.setNotes(rs.getString(VisitationRecordModelColumns[10]));
               
                um.setUserId(rs.getString(UserModelColumns[0]));
                um.setFirstName(rs.getString(UserModelColumns[1]));
                um.setLastName(rs.getString(UserModelColumns[2]));
                um.setGender(rs.getBoolean(UserModelColumns[3]));
                um.setDateOfBirth(rs.getDate(UserModelColumns[4]));
                um.setUserType(rs.getInt(UserModelColumns[5]));
                um.setPassword(rs.getString(UserModelColumns[6]));
                um.setPhoneNumber(rs.getString(UserModelColumns[7]));
                um.setAddressId(rs.getInt(UserModelColumns[8]));
                um.setEmergencyContactName(rs.getString(UserModelColumns[9]));
                um.setEmergencyContactPhoneNumber(rs.getString(UserModelColumns[10]));

                
                vrum.setVisitationRecord(vrm);
                vrum.setUser(um);
                
                result.add(vrum);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
     
    public List<String> GetPatientIDsAllowed(String staffid){
        PreparedStatement pstmt = null;
        ResultSet rs;
        String query="select * from mis_db.staff_doctor left join mis_db.patients on staff_doctor.DoctorId = patients.DoctorId";
        List<String> result = new ArrayList<String>();
        
        try{
            pstmt=DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, staffid);
            rs=pstmt.executeQuery();
            while(rs.next()){
                result.add(rs.getString("PatientId"));
            }
            rs.close();
            pstmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    } 
}
