
package Model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitationRecordsModel {
    private int RecordId;
    private int OriginalRecordId;
    private int ProcedureId;
    private String PatientId;
    private String DoctorId;
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

    public int getProcedureId() {
        return ProcedureId;
    }

    public void setProcedureId(int ProcedureId) {
        this.ProcedureId = ProcedureId;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String PatientId) {
        this.PatientId = PatientId;
    }

    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String DoctorId) {
        this.DoctorId = DoctorId;
    }

    public String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(TimeStarted);
    }
    public Timestamp getTimeStarted() {
        return TimeStarted;
    }
    
    public String getTimeStartedUI() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); 
        return sdf.format(TimeStarted);
    }

    public void setTimeStarted(Timestamp TimeStarted) {
        this.TimeStarted = TimeStarted;
    }

    public Timestamp getTimeEnded() {
        return TimeEnded;
    }
    
    public String getTimeEndedUI() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); 
        return sdf.format(TimeEnded);
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
