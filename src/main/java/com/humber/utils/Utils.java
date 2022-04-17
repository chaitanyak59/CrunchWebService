/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.humber.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chaitanya
 */
public class Utils {

    public static String generateHash(String input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(input.getBytes());
            return new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public static String parseDateString(String inputDate) {
        try {
            if(inputDate == null) {
                return null;
            }
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            Date date = (Date)formatter.parse(inputDate); 
            return date.toString();
        } catch (Exception e) {
            System.out.print(e.toString());
            return null;
        }

    }
}
