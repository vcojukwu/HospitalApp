/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DbUtil;

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
    
    public int Login(String userName, String password)
    {
        Statement stmt = null;
        ResultSet rs = null;
        int userType = 0;
        String passwordInDatabase = null;
        String query = "SELECT password,usertype FROM users where UserId = '" + userName + "'";
        
        try{
            stmt = DbUtil.getConnection().createStatement();
            rs = stmt.executeQuery(query); 
            while (rs.next()) {
                passwordInDatabase = rs.getString("Password");
                userType = Integer.parseInt(rs.getString("UserType"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        
        if(password.equals(passwordInDatabase))
            return userType;
        else 
            return -1;
    }
}
