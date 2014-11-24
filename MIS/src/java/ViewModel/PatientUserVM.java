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
public class PatientUserVM {
    private UserModel User;
    private PatientModel Patient;
    
    public UserModel getUser() {
        return User;
    }

    public void setUser(UserModel User) {
        this.User = User;
    }

    public PatientModel getPatient() {
        return Patient;
    }

    public void setPatient(PatientModel Patient) {
        this.Patient = Patient;
    }
}
