/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.DbUtil;
import Model.PatientModel;
import java.util.List;
/**
 *
 * @author TheKey
 */

public class PatientDao {
    private Connection connection;
    
    public PatientDao() {
        connection = DbUtil.getConnection();
    }
    
    public PatientModel getPatient(int id)
    {
        
        return null;
    }
    
    public void addPatient(PatientModel patient)
    {
        
    }
    
    public void updatePatient(PatientModel patient)
    {
        
    }
    
    public void deletePatient(int id)
    {
        
    }
    
    public List<PatientModel> getAllPatients(){
        
        return null;
    }
}
