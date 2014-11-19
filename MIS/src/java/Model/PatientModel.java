
package Model;

public class PatientModel {
    private String PatientId;
    private String DoctorId;
    private int HealthStateId;
    private int HealthCardNumber;
    private int SocialInsuranceNumber;
    private int NumberOfVisits;
    private boolean IsActive;
    private String PatientNotes;

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

    public int getHealthStateId() {
        return HealthStateId;
    }

    public void setHealthStateId(int HealthStateId) {
        this.HealthStateId = HealthStateId;
    }

    public int getHealthCardNumber() {
        return HealthCardNumber;
    }

    public void setHealthCardNumber(int HealthCardNumber) {
        this.HealthCardNumber = HealthCardNumber;
    }

    public int getSocialInsuranceNumber() {
        return SocialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(int SocialInsuranceNumber) {
        this.SocialInsuranceNumber = SocialInsuranceNumber;
    }

    public int getNumberOfVisits() {
        return NumberOfVisits;
    }

    public void setNumberOfVisits(int NumberOfVisits) {
        this.NumberOfVisits = NumberOfVisits;
    }

    public boolean isIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public String getPatientNotes() {
        return PatientNotes;
    }

    public void setPatientNotes(String PatientNotes) {
        this.PatientNotes = PatientNotes;
    }
    
}
