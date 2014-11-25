/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;
import Model.*;
/**
 *
 * @author Anish
 */
public class DoctorVisitationRecordVM {
    private UserModel User;
    private VisitationRecordsModel VisitationRecord;
    
     public UserModel getUser() {
        return User;
    }

    public void setUser(UserModel User) {
        this.User = User;
    }
    
    public VisitationRecordsModel getVisitationRecord() {
        return VisitationRecord;
    }

    public void setVisitationRecord(VisitationRecordsModel VisitationRecord) {
        this.VisitationRecord = VisitationRecord;
    }
}
