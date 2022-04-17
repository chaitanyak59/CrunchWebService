/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.database;

import com.humber.models.BookingClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chaitanya
 */
public class BookingsDao {

    private static BookingsDao instance;

    private Connection connection;

    public BookingsDao() {
        DBConnection db = new DBConnection();
        connection = db.getConnection();
    }

    //SingleTon
    public static BookingsDao getBookingsDaoInstance() {
        if (instance == null) {
            return new BookingsDao();
        }
        return instance;
    }

    public int createBooking(BookingClass booking) {
        String sqlQuery = "INSERT INTO registration(user_id, scheduled_day, location, class_name) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sqlQuery);
            pstmt.setInt(1, booking.getUserID());
            pstmt.setString(2, booking.getScheduledDate());
            pstmt.setString(3, booking.getLocation());
            pstmt.setString(4, booking.getClass_name());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public List<BookingClass> getUserBookings(int currentUserID) {
        PreparedStatement pstmt;
        ResultSet rs = null;
        List<BookingClass> bookings = new ArrayList();
        try {
            String searchQuery;
            if (currentUserID == -1) {
                searchQuery = "SELECT * FROM registration";
                pstmt = connection.prepareStatement(searchQuery);
                rs = pstmt.executeQuery();
            } else {
                searchQuery = "SELECT * FROM registration where user_id=?";
                pstmt = (PreparedStatement) connection.prepareStatement(searchQuery);
                pstmt.setInt(1, currentUserID);
                rs = pstmt.executeQuery();
            }
            while (rs !=null && rs.next()) {
                BookingClass booking = new BookingClass();
                booking.setId(rs.getInt("id"));
                booking.setUserID(rs.getInt("user_id"));
                booking.setScheduledDate(rs.getString("scheduled_day"));
                booking.setLocation(rs.getString("location"));
                booking.setClass_name(rs.getString("class_name"));
                bookings.add(booking);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public boolean deleteBooking(int bookingID) {
        try {
            String query = "DELETE FROM registration WHERE AND id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookingID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
}
