
package Model;

public class DoctorModel {
    private String DoctorId;
    private String DoctorType;
    private String FirstName;
    private String LastName;
    
    public String getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(String DoctorId) {
        this.DoctorId = DoctorId;
    }

    public String getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(String DoctorType) {
        this.DoctorType = DoctorType;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    
    public String getLastName(){
        return LastName;
    }
    
    public void setLastName(String LastName){
        this.LastName = LastName;
    } 
}
