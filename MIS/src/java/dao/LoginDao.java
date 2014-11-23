/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.AddressModel;
import Model.UserModel;
import ViewModel.UserProfileVM;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
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
    
    public UserProfileVM Login(String userName, String password)
    {
        Statement stmt = null;
        ResultSet rs = null;
        //ResultSet rs = null;
        int userType = 0;
        String passwordInDatabase = null;
        //String query = "SELECT * FROM users where UserId = '" + userName + "'";
        String query = "SELECT * FROM users X INNER JOIN "
                + "address Y ON " 
                + "X.AddressId=Y.AddressId "  
                + "where UserId = '" + userName + "'";

        Security checkPassword = new Security();
        String hashedPassword = checkPassword.hashedPassword(password);
        UserModel user = new UserModel();
        AddressModel address = new AddressModel();
        UserProfileVM viewModel = new UserProfileVM();
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
                address.setAddressId(rs.getInt("AddressId"));
                address.setStreetNumber(Integer.parseInt(rs.getString("StreetNumber")));
                address.setStreetName(rs.getString("StreetName"));
                address.setCity(rs.getString("City"));
                address.setProvince(rs.getString("Province"));
                address.setCountry(rs.getString("Country"));
                address.setPostalCode(rs.getString("PostalCode"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        } 
        if(hashedPassword.equals(passwordInDatabase))
        {
            viewModel.setAddress(address);
            viewModel.setUser(user);
            return viewModel;
        }
        else 
            return null;
    }
}
