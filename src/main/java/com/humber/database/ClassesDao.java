package com.humber.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chaitanya
 */
public class ClassesDao {
    private static ClassesDao instance;

    private Connection connection;

    public ClassesDao() {
        DBConnection db = new DBConnection();
        connection = db.getConnection();
    }

    //SingleTon
    public static ClassesDao getClassesDaoInstance() {
        if (instance == null) {
            return new ClassesDao();
        }
        return instance;
    }
    
    public String getClassNameByID(int classID) {
        String className = "";
        try {
            String sqlQuery = "SELECT name from classes where id=?";
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, classID);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                className = rs.getString(1);
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return className;
        
    }
}
