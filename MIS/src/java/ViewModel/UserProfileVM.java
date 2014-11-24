/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;
import Model.*;
/**
 *
 * @author TheKey
 */
public class UserProfileVM {
    private UserModel User;
    private AddressModel Address;

    public UserModel getUser() {
        return User;
    }

    public void setUser(UserModel User) {
        this.User = User;
    }

    public AddressModel getAddress() {
        return Address;
    }

    public void setAddress(AddressModel Address) {
        this.Address = Address;
    }
    
}
