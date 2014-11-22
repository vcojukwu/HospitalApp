/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.AddressModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DbUtil;

/**
 *
 * @author Ish
 */
public class UserDao {
    private Connection connection;
    public UserDao()
    {
        connection = DbUtil.getConnection();
    }
    
    public void AddUser(UserModel user, AddressModel address){
        Statement stmt  = null;
        String query    = null;
        ResultSet rs    = null;

        try{
            stmt = DbUtil.getConnection().createStatement();
            
            query = "INSERT INTO address ( StreetNumber, StreetName, City, Province, Country, PostalCode) " + 
                    "VALUES ( " + address.getStreetNumber() + ", '" + address.getStreetName() + "' , '" +
                    address.getCity() + "', '" + address.getProvince() + "', '" + address.getCountry() +
                    "', '" + address.getPostalCode() + "');";           
            stmt.executeUpdate(query);
            
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID() as last_id"); 
            int addressId = -1;
            while (rs.next()) {
                addressId = rs.getInt("last_id");
            }
            
            query = "INSERT INTO users ( UserId, FirstName, LastName, Gender, DateOfBirth, UserType, "
                    + "Password, PhoneNumber, AddressId, EmergencyContactName, EmergencyContactPhoneNumber) "
                    + "VALUES ( '" + user.getUserId() + "', '" + user.getFirstName() + "' , '" +
                    user.getLastName() + "'," + user.isGender()+ ", '" + user.getDateOfBirth() +
                    "', '" + user.getUserType() + "', '" + user.getPassword()+ 
                    "', '" + user.getPhoneNumber() + "' ,'" + addressId + "' ,'" +
                    user.getEmergencyContactName() + "', '" + user.getEmergencyContactPhoneNumber() + "')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }    
}
