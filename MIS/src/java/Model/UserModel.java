
package Model;

import java.util.Date;

public class UserModel {
    private String UserId;
    private String FirstName;
    private String LastName;
    private boolean Gender;
    private Date DateOfBirth;
    private int UserType;
    private String Password;
    private String PhoneNumber;
    private int AddressId;	
    private String EmergencyContactName;
    private String EmergencyContactPhoneNumber;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public String getEmergencyContactName() {
        return EmergencyContactName;
    }

    public void setEmergencyContactName(String EmergencyContactName) {
        this.EmergencyContactName = EmergencyContactName;
    }

    public String getEmergencyContactPhoneNumber() {
        return EmergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String EmergencyContactPhoneNumber) {
        this.EmergencyContactPhoneNumber = EmergencyContactPhoneNumber;
    }
    
}
