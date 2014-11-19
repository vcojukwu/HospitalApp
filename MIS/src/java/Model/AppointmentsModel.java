
package Model;

import java.sql.Timestamp;

public class AppointmentsModel {
    private int AppointmentId;
    private String PatientId;
    private String DoctorId;
    private Timestamp TimeScheduled;
    private int DurationScheduled;

    public int getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(int AppointmentId) {
        this.AppointmentId = AppointmentId;
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

    public Timestamp getTimeScheduled() {
        return TimeScheduled;
    }

    public void setTimeScheduled(Timestamp TimeScheduled) {
        this.TimeScheduled = TimeScheduled;
    }

    public int getDurationScheduled() {
        return DurationScheduled;
    }

    public void setDurationScheduled(int DurationScheduled) {
        this.DurationScheduled = DurationScheduled;
    }
    
}
