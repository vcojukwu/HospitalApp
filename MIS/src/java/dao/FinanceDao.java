/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.DoctorModel;
import Model.ProceduresModel;
import Model.VisitationRecordsModel;
import ViewModel.DoctorMonitorVM;
import ViewModel.RevenueVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

/**
 *
 * @author TheKey
 */
public class FinanceDao {
    private Connection connection;
    
    public FinanceDao() {
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
    
    public DoctorMonitorVM getPatientList(String doctorId, String startDate, String endDate )
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        String query = "SELECT * FROM visitation_records X INNER JOIN procedures Y ON " +
                        "X.ProcedureId = Y.ProcedureID where TimeStarted BETWEEN '" + startDate +
                        "' and '" + endDate + "' And DoctorId = '" + doctorId + "' ORDER BY RecordId";
        List<VisitationRecordsModel> result = new ArrayList<VisitationRecordsModel>();
        /*ability to monitor any doctor to determine how many patients he/she 
        saw in a given time period,how many times a given patient was seen, 
        what the diagnosis/result was, any drugs prescribed,etc*/ 
        String query2 = "SELECT * FROM procedures";
        List<ProceduresModel> procedureList = new ArrayList<ProceduresModel>();
        DoctorMonitorVM vm = new DoctorMonitorVM();

        try
        {
            pstmt = DbUtil.getConnection().prepareStatement(query2); 
            rs2 = pstmt.executeQuery(query2);
            while(rs2.next())
            {
                ProceduresModel procedure = new ProceduresModel();
                procedure.setProcedureId(Integer.parseInt(rs2.getString("ProcedureId")));
                procedure.setProcedureType(rs2.getString("ProcedureType"));
                procedure.setProcedureName(rs2.getString("ProcedureName"));
                procedure.setProcedureCost(rs2.getInt("ProcedureCost"));
                procedureList.add(procedure);
            }
            
            pstmt = DbUtil.getConnection().prepareStatement(query);            
            rs = pstmt.executeQuery(query);
            
            while(rs.next()){
                VisitationRecordsModel record = new VisitationRecordsModel();
                if (rs.getInt("OriginalRecordId") != 0)
                {
                    for(VisitationRecordsModel rcd : result)
                    {
                        rcd.setRecordId(rs.getInt("RecordId"));
                        rcd.setOriginalRecordId(rs.getInt("OriginalRecordId"));
                        rcd.setProcedureId(rs.getInt("ProcedureId"));
                        rcd.setPatientId(rs.getString("PatientId"));
                        rcd.setTimeStarted(rs.getTimestamp("TimeStarted"));
                        rcd.setTimeEnded(rs.getTimestamp("TimeEnded"));
                        rcd.setPrescriptions(rs.getString("Prescriptions"));
                        rcd.setDiagnosis(rs.getString("Diagnosis"));
                        rcd.setTreatmentSchedule(rs.getString("TreatmentSchedule"));
                        rcd.setNotes(rs.getString("Notes"));
                    }
                }
                else
                {
                    record.setRecordId(rs.getInt("RecordId"));
                    record.setOriginalRecordId(rs.getInt("OriginalRecordId"));
                    record.setProcedureId(rs.getInt("ProcedureId"));
                    record.setPatientId(rs.getString("PatientId"));
                    record.setTimeStarted(rs.getTimestamp("TimeStarted"));
                    record.setTimeEnded(rs.getTimestamp("TimeEnded"));
                    record.setPrescriptions(rs.getString("Prescriptions"));
                    record.setDiagnosis(rs.getString("Diagnosis"));
                    record.setTreatmentSchedule(rs.getString("TreatmentSchedule"));
                    record.setNotes(rs.getString("Notes"));
                    result.add(record);
                }
                                
            }
            HashSet uniquePatients = new HashSet();
            for(VisitationRecordsModel p : result)
            {
                uniquePatients.add(p.getPatientId());
            }
            vm.setUniquePatientCount(uniquePatients.size());
            vm.setProcedureList(procedureList);
            vm.setVisitRecords(result);
            return vm;
        } catch (SQLException e) {
                e.printStackTrace();
        }
        vm.setProcedureList(new ArrayList<ProceduresModel>());
        vm.setUniquePatientCount(0);
        vm.setVisitRecords(new ArrayList<VisitationRecordsModel>());
        return vm;
    }
 
    public RevenueVM getRevenue(String startDate , String endDate)
    {
        /* Also, the finance department needs to know revenues generated by 
        individual doctors,procedures, visits, etc. The hospital also needs to 
        bill the provincial health insurance on a monthly basis.
        Assume a flat rate fee for visits, however, each procedure
        has its own listed fee.*/
        PreparedStatement pstmt = null;
        ResultSet rs = null;
         String query = "SELECT Y.ProcedureCost, X.OriginalRecordId FROM visitation_records X INNER JOIN procedures Y ON " +
                        "X.ProcedureId = Y.ProcedureID where TimeStarted BETWEEN '" + startDate +
                        "' and '" + endDate + "'";
        RevenueVM vm = new RevenueVM();
        int flatRateVisitFee = 10;
        try 
        { 
            pstmt = DbUtil.getConnection().prepareStatement(query);
            rs = pstmt.executeQuery(query);
            
            while(rs.next())
            {
                if (rs.getInt("OriginalRecordId") != 0)
                {
                    vm.setVisitCount(vm.getVisitCount() + 1);
                    vm.setTotalProcedureRevenue(vm.getVisitRevenue() + rs.getInt("ProcedureCost"));
                }
            }
            vm.setVisitRevenue(vm.getVisitCount() * 10 );
            return vm;
        } catch (SQLException e) {
            e.printStackTrace();        
        }
        return vm;
    }
    
}
