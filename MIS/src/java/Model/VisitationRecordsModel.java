
package Model;

import java.sql.Timestamp;

public class VisitationRecordsModel {
    int RecordId;
    int OriginalRecordId;
    int ProcedureId;
    String PatientId;
    String DoctorId;
    Timestamp DateTime;
    Timestamp DateTimeEnded;
    String Prescriptions;
    String Diagnosis;
    String TreatmentSchedule;
    String Notes;
}
