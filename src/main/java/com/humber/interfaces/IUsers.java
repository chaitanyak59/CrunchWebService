/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.interfaces;

import com.humber.models.User;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService
public interface IUsers {
    @WebMethod(operationName = "getAllUsers")
    public List<User> getAllUsers(int currentUserID);
    
    @WebMethod(operationName = "deleteUser")
    public boolean deleteUser(int userID);
    
    @WebMethod(operationName = "addMembership")
    public boolean addMembership(int userID, int membershipID);
    
}
