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
    
    
    //This function should be used for updating a record as well, as we want to keep the old record, so no modify required --> Do we need to keep track of 
    //modified records?
    //Only need the prodecure id to add, have a finite list of procedures, so id has to exist
    public void AddVisitationRecord(VisitationRecordsModel visitationRecord, int procedureId){
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
            stmt.executeUpdate(query);
            
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
