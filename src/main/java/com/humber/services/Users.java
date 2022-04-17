/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.services;

import com.humber.database.BookingsDao;
import com.humber.database.UsersDao;
import com.humber.models.BookingClass;
import com.humber.models.User;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService(endpointInterface = "com.humber.interfaces.IUsers")
public class Users {

    public List<User> getAllUsers(int currentUserID) {
        UsersDao usersDao = UsersDao.getUsersDaoInstance();
        return usersDao.getAllUsers(currentUserID);
    }

    public boolean deleteUser(int userID) {
        return true; //Not implemented
    }

    public boolean addMembership(int userID, int membershipID) {
        UsersDao usersDao = UsersDao.getUsersDaoInstance();
        return usersDao.addMembership(userID, membershipID);
    }
}
