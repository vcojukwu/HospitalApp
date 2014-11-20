/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
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
    
    public boolean Login(string userName, string password)
    {
        
        return false;
    }
}
