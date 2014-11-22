/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;
import util.Security;

/**
 *
 * @author TheKey
 */
public class LoginDao {
    private Connection connection;

    public LoginDao()
    {
        connection = DbUtil.getConnection();
    }
    
    public UserModel Login(String userName, String password)
    {
        Statement stmt = null;
        ResultSet rs = null;
        //ResultSet rs = null;
        int userType = 0;
        String passwordInDatabase = null;
        String query = "SELECT * FROM users where UserId = '" + userName + "'";
        /*String query2 = "SELECT * FROM users X INNER JOIN "
                + "patients Y ON " 
                + "X.UserId=Y.PatientId "  
                + "where UserId = '" + userName + "'";*/

        Security checkPassword = new Security();
        String hashedPassword = checkPassword.hashedPassword(password);
        UserModel user = new UserModel();
        
        try
        {
            stmt = DbUtil.getConnection().createStatement();
            rs = stmt.executeQuery(query); 
            DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT);
            while (rs.next()) 
            {
                passwordInDatabase = rs.getString("Password");
                userType = rs.getInt("UserType");
                user.setUserId(userName);
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setGender(Boolean.parseBoolean(rs.getString("Gender")));
                user.setDateOfBirth(rs.getTimestamp("DateOfBirth"));
                user.setUserType(userType);
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setEmergencyContactName(rs.getString("EmergencyContactName"));
                user.setEmergencyContactPhoneNumber(rs.getString("EmergencyContactPhoneNumber"));
                user.setAddressId(Integer.parseInt(rs.getString("AddressId")));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        } 
        if(hashedPassword.equals(passwordInDatabase))
            return user;
        else 
            return null;
    }
}
