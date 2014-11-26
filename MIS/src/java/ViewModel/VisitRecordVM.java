/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import java.sql.Timestamp;

/**
 *
 * @author TheKey
 */
public class VisitRecordVM 
{
    private int RecordId;
    private int OriginalRecordId;
    private String ProcedureName;
    private int ProcedureCost;
    private String PatientId;
    private Timestamp TimeStarted;
    private Timestamp TimeEnded;
    private String Prescriptions;
    private String Diagnosis;
    private String TreatmentSchedule;
    private String Notes;

    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int RecordId) {
        this.RecordId = RecordId;
    }

    public int getOriginalRecordId() {
        return OriginalRecordId;
    }

    public void setOriginalRecordId(int OriginalRecordId) {
        this.OriginalRecordId = OriginalRecordId;
    }

    public String getProcedureName() {
        return ProcedureName;
    }

    public void setProcedureName(String ProcedureName) {
        this.ProcedureName = ProcedureName;
    }

    public int getProcedureCost() {
        return ProcedureCost;
    }

    public void setProcedureCost(int ProcedureCost) {
        this.ProcedureCost = ProcedureCost;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String PatientId) {
        this.PatientId = PatientId;
    }

    public Timestamp getTimeStarted() {
        return TimeStarted;
    }

    public void setTimeStarted(Timestamp TimeStarted) {
        this.TimeStarted = TimeStarted;
    }

    public Timestamp getTimeEnded() {
        return TimeEnded;
    }

    public void setTimeEnded(Timestamp TimeEnded) {
        this.TimeEnded = TimeEnded;
    }

    public String getPrescriptions() {
        return Prescriptions;
    }

    public void setPrescriptions(String Prescriptions) {
        this.Prescriptions = Prescriptions;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public String getTreatmentSchedule() {
        return TreatmentSchedule;
    }

    public void setTreatmentSchedule(String TreatmentSchedule) {
        this.TreatmentSchedule = TreatmentSchedule;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
}
