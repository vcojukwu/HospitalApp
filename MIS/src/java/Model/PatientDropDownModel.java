/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ish
 */
public class PatientDropDownModel {
    
    private String PatientId;
    private String FirstName;
    private String LastName;
    
    public String getPatientId(){
        return PatientId;
    }
    
    public void setPatientId(String PatientId){
        this.PatientId = PatientId;
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
