/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;

/**
 *
 * @author Ish
 */
public class Security {
    private MessageDigest md = null;    
    private byte byteData[] = null;
    StringBuffer sb = new StringBuffer();
    public String hashedPassword(String password){
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();        
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (Exception e){
            e.printStackTrace();
        }        
        return sb.toString();
    }   
}
