/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.VisitationRecordsModel;
import Model.ProceduresModel;
import java.sql.Connection;
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
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            //Add new record
            query = "INSERT INTO visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES ( '" + -1 + "', '" + visitationRecord.getProcedureId() + "' , '" +
                    visitationRecord.getPatientId() + "', '" + visitationRecord.getDoctorId() + "', '" + visitationRecord.getTimeStarted() +
                    "', '" + visitationRecord.getTimeEnded() + "', '" + visitationRecord.getPrescriptions() +  
                    "', '" + visitationRecord.getDiagnosis() + "' ,'" + visitationRecord.getTreatmentSchedule() + "' ,'" +
                    visitationRecord.getNotes() + "')";
            System.out.print(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    
    //This is the same as above, except above we make originalrecorid = -1 as its a new record but here, we add the original recordId. 
    //We could merge the two above, by forcing controller to assign origianl RecordId = -1 if new record else the id itself. 
    public void ModifyVisitationRecord(VisitationRecordsModel visitationRecord, int procedureId){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            //Add new record
            query = "INSERT INTO visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES ( '" + visitationRecord.getOriginalRecordId() + "', '" + procedureId + "' , '" +
                    visitationRecord.getPatientId() + "'," + visitationRecord.getDoctorId() + ", '" + visitationRecord.getTimeStarted() +
                    "', '" + visitationRecord.getTimeEnded() + "', '" + visitationRecord.getPrescriptions() +  
                    "', '" + visitationRecord.getDiagnosis() + "' ,'" + visitationRecord.getTreatmentSchedule() + "' ,'" +
                    visitationRecord.getNotes() + "')";
            stmt.executeUpdate(query);
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
