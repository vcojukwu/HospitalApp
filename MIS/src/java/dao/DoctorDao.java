/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.VisitationRecordsModel;
import Model.ProceduresModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DbUtil;
import java.util.List;

/**
 *
 * @author Abbasali
 */
public class DoctorDao {
    private Connection connection;
    public DoctorDao()
    {
        connection = DbUtil.getConnection();
    }
    
    
    public void AddVisitationRecord(VisitationRecordsModel visitationRecord){
        PreparedStatement pstmt = null;
        String query = null;
        try{
            //Form prepared statment query
            query = "INSERT INTO visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //Form preparedstatement from query
            pstmt = DbUtil.getConnection().prepareStatement(query);
            
            //Add elements of prepared statement
            pstmt.setInt(1, visitationRecord.getOriginalRecordId());                                        //Set OriginalRecordId
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
            
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
       
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
    
    //This is the same as above, except above we make originalrecorid = -1 as its a new record but here, we add the original recordId. 
    //We could merge the two above, by forcing controller to assign origianl RecordId = -1 if new record else the id itself. 
    
    //THIS logic can be done in controller, in the visitationRecord, just ensure OriginalRecordId is 
    //-1 if the UI is in add new, or the current RecordId of the record being modified. Then this function
    //is not needed
    public void ModifyVisitationRecord(VisitationRecordsModel visitationRecord, int OriginalRecordId){
        PreparedStatement pstmt = null;
        String query = null;
        try{
            //Add new record
            query = "INSERT INTO visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES ( ?,?,?,?,?,?,?,?,?,?)";
            
            //Form preparedstatement from query
            pstmt = DbUtil.getConnection().prepareStatement(query);
            
            //Add elements of prepared statement
            pstmt.setInt(1, visitationRecord.getOriginalRecordId()); //Set OriginalRecordId
            pstmt.setInt(2, visitationRecord.getProcedureId());         //Set ProcedureId
            pstmt.setString(3, visitationRecord.getPatientId());        //Set PatientId
            pstmt.setString(4, visitationRecord.getDoctorId());         //Set DoctorId
            pstmt.setTimestamp(5, visitationRecord.getTimeStarted());   //Set TimeStarted
            pstmt.setTimestamp(6, visitationRecord.getTimeEnded());     //Set TimeEnded
            pstmt.setString(7, visitationRecord.getPrescriptions());    //Set Prescriptions
            pstmt.setString(8, visitationRecord.getDiagnosis());        //Set Diagnosis
            pstmt.setString(9, visitationRecord.getTreatmentSchedule());//Set TreatmentSchedule
            pstmt.setString(10, visitationRecord.getNotes());           //Set Notes
            
            System.out.print(pstmt.toString());
            
            //Execute prepared statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public List<VisitationRecordsModel> FindRecords(){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;
        List<VisitationRecordsModel> vr = new ArrayList<VisitationRecordsModel>();
        try{
            stmt = DbUtil.getConnection().createStatement();
            
            //Add new record
            query = "select * FROM visitation_records WHERE PatientId=" + "'" + "patient1@email.com" + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                VisitationRecordsModel vrm = new VisitationRecordsModel();
                vrm.setRecordId(rs.getInt("RecordId"));
                vrm.setOriginalRecordId(rs.getInt("OriginalRecordId"));
                vrm.setProcedureId(rs.getInt("ProcedureId"));
                vrm.setPatientId(rs.getString("PatientId"));
                vrm.setDoctorId(rs.getString("DoctorId"));
                vrm.setTimeStarted(rs.getTimestamp("TimeStarted"));
                vrm.setTimeEnded(rs.getTimestamp("TimeEnded"));
                vrm.setPrescriptions(rs.getString("Prescriptions"));
                vrm.setDiagnosis(rs.getString("Diagnosis"));
                vrm.setNotes(rs.getString("Notes"));
                
                vr.add(vrm);   
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        
        
        
        return vr;
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
