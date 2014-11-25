/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import Model.ProceduresModel;
import Model.VisitationRecordsModel;
import java.util.List;

/**
 *
 * @author TheKey
 */
public class DoctorMonitorVM 
{
    private List<VisitationRecordsModel> VisitRecords;
    private List<ProceduresModel> ProcedureList;
    private int UniquePatientCount;

    public List<VisitationRecordsModel> getVisitRecords() {
        return VisitRecords;
    }

    public void setVisitRecords(List<VisitationRecordsModel> VisitRecords) {
        this.VisitRecords = VisitRecords;
    }

    public List<ProceduresModel> getProcedureList() {
        return ProcedureList;
    }

    public void setProcedureList(List<ProceduresModel> ProcedureList) {
        this.ProcedureList = ProcedureList;
    }

    public int getUniquePatientCount() {
        return UniquePatientCount;
    }

    public void setUniquePatientCount(int PatientSeenCount) {
        this.UniquePatientCount = PatientSeenCount;
    }
}
