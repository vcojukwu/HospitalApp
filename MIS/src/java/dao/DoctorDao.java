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
            
            System.out.print(pstmt.toString());
            
            //Execute prepared statement
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
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
        
        
        /*
        Procedure:
        From the patient table we need to get all the patients with the name provided. 
        
        
        */
        
        
        return null;
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
    
}
