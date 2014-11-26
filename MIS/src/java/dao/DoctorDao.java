/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.*;
import Model.ProceduresModel;
import ViewModel.DoctorVisitationRecordVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.DbUtil;
import java.util.List;

/**
 *
 * @author Abbasali
 */
public class DoctorDao {
    
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
    
    
    public void AddVisitationRecord(VisitationRecordsModel visitationRecord){
        PreparedStatement pstmt = null;
        String query = null;
        ResultSet rs = null;
        long OrigId;
        try{
            //Form prepared statment query
            query = "INSERT INTO mis_db.visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //Form preparedstatement from query
            pstmt = DbUtil.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            //Add elements of prepared statement
            pstmt.setInt(1, visitationRecord.getOriginalRecordId());    //Set OriginalRecordId
            pstmt.setInt(2, visitationRecord.getProcedureId());         //Set ProcedureId
            pstmt.setString(3, visitationRecord.getPatientId());        //Set PatientId
            pstmt.setString(4, visitationRecord.getDoctorId());         //Set DoctorId
            pstmt.setTimestamp(5, visitationRecord.getTimeStarted());   //Set TimeStarted
            pstmt.setTimestamp(6, visitationRecord.getTimeEnded());     //Set TimeEnded
            pstmt.setString(7, visitationRecord.getPrescriptions());    //Set Prescriptions
            pstmt.setString(8, visitationRecord.getDiagnosis());        //Set Diagnosis
            pstmt.setString(9, visitationRecord.getTreatmentSchedule());//Set TreatmentSchedule
            pstmt.setString(10, visitationRecord.getNotes());           //Set Notes
            
            //Increment NumOfVisits and update LastVisitDate
            UpdateVisitation(visitationRecord.getPatientId());
            
            System.out.print(pstmt.toString());
            
            //Execute prepared statement
            pstmt.executeUpdate();
            
            if(visitationRecord.getOriginalRecordId()==-1){
                rs = pstmt.getGeneratedKeys();
                OrigId = -1;
                while(rs.next()){
                    OrigId = rs.getLong(1);
                }
                query = "UPDATE mis_db.visitation_records SET OriginalRecordId = '"+OrigId+"' WHERE RecordId = '"+OrigId+"'";
                pstmt.executeUpdate(query);
            }
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
       
    //This updates the patients table for the given patient to increment the number of visits and update the lastvisitdate
    public void UpdateVisitation(String patientid)
    {
        PreparedStatement pstmt = null;
        String query = "UPDATE mis_db.patients SET NumberOfVisits = NumberOfVisits+1, LastVisitDate = NOW() where patientid = ?";
        try{
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, patientid);
            pstmt.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<DoctorVisitationRecordVM> FindRecords(String[] VRecordParams, String[] UserParams){
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<String> elementType = new ArrayList<String>();
        PreparedStatement pstmt = null;
        ResultSet rs    = null;
        DoctorVisitationRecordVM vrum = null;
        VisitationRecordsModel vrm = null;
        UserModel um = null;
        String query = "select * from mis_db.visitation_records left join mis_db.users "
                    + "on visitation_records.PatientId = users.UserId ";
        List<DoctorVisitationRecordVM> result = new ArrayList<DoctorVisitationRecordVM>();
        String allowedIds = " (";
        
        List<String> AllowedPatientIds = GetAllowedPatientList(VRecordParams[4]);
        if(VRecordParams[3]==null){
            for(String id:AllowedPatientIds){
                allowedIds += "'" + id + "',";
            }
            allowedIds = allowedIds.substring(0, allowedIds.length()-1)+") ";
            query += " WHERE visitation_records.PatientId IN"+allowedIds;
        }
        else{
            if(AllowedPatientIds.contains(VRecordParams[3])){
                allowedIds += "'" + VRecordParams[3] + "') ";
            query += " WHERE visitation_records.PatientId IN"+allowedIds;
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
                query += " AND ";
                if(VisitationRecordModelTypes[i].equals("boolean") || VisitationRecordModelTypes[i].equals("int")){
                    query += "visitation_records." + VisitationRecordModelColumns[i] + " = ? ";
                }
                else{
                    query += "visitation_records." + VisitationRecordModelColumns[i] + " LIKE ? ";
                }
                elements.add(VRecordParams[i]);
                elementType.add(VisitationRecordModelTypes[i]);
            }
        }
        //User Model column search gets handled here
        for(int i=0; i<UserModelColumns.length; i++){
            if(UserParams[i] != null){
                query += " AND ";
                if(UserModelTypes[i].equals("boolean") || UserModelTypes[i].equals("int")){
                    query += "users." + UserModelColumns[i] + " = ? ";
                }
                else{
                    query += "users." + UserModelColumns[i] + " LIKE ? ";
                }
                elements.add(UserParams[i]);
                elementType.add(UserModelTypes[i]);
            }
        }
        query += " ORDER BY visitation_records.RecordId desc ";
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
            String FinalQuery = "Select * from ("+ pstmt.toString().substring(pstmt.toString().indexOf("select")) + ") as max group by max.OriginalRecordId";
            rs = pstmt.executeQuery(FinalQuery);
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
    
    public List<AppointmentsModel> getAllAppointments(String doctorid){
        PreparedStatement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<AppointmentsModel> appointments = new ArrayList<AppointmentsModel>();
        try{
            query = "SELECT AppointmentId, PatientId, DoctorId, TimeScheduled, DurationScheduled FROM appointments "
                    + "WHERE DoctorId = ? AND TimeScheduled >= NOW()";
            stmt = DbUtil.getConnection().prepareStatement(query);  
            stmt.setString(1, doctorid);
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
    
    
    public List<ProceduresModel> GetProcedures(){
               
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<ProceduresModel> procedures = new ArrayList<ProceduresModel>();
        
        
        try{
            stmt = DbUtil.getConnection().createStatement();
                        
            //get all procedures --> It is a finite list.
            query = "SELECT * FROM procedures";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                ProceduresModel pm = new ProceduresModel();
                pm.setProcedureId(rs.getInt("ProcedureId"));
                pm.setProcedureType(rs.getString("ProcedureType"));
                pm.setProcedureName(rs.getString("ProcedureName"));
                pm.setProcedureCost(rs.getInt("ProcedureCost"));
                procedures.add(pm);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return procedures;
    }
    
    public List<String> GetAllowedPatientList(String doctorid){
        List<String> patientsAllowed = new ArrayList<String>();
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        String query = "SELECT * FROM mis_db.doctor_permissions where DoctorId = ?";
        try{
            pstmt = DbUtil.getConnection().prepareStatement(query);
            pstmt.setString(1, doctorid);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                patientsAllowed.add(rs.getString("PatientId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return patientsAllowed;
    } 
}
