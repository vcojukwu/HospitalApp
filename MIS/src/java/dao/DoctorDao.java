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
    
    
    public void AddVisitationRecord(VisitationRecordsModel visitationRecord, int procedureId){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            //Add new record
            query = "INSERT INTO visitation_records ( OriginalRecordId, ProcedureId, PatientId, DoctorId, TimeStarted, TimeEnded, "
                    + "Prescriptions, Diagnosis, TreatmentSchedule, Notes) "
                    + "VALUES ( '" + -1 + "', '" + procedureId + "' , '" +
                    visitationRecord.getPatientId() + "'," + visitationRecord.getDoctorId() + ", '" + visitationRecord.getTimeStarted() +
                    "', '" + visitationRecord.getTimeEnded() + "', '" + visitationRecord.getPrescriptions() +  
                    "', '" + visitationRecord.getDiagnosis() + "' ,'" + visitationRecord.getTreatmentSchedule() + "' ,'" +
                    visitationRecord.getNotes() + "')";
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
