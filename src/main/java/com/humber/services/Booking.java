/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.services;

import com.humber.database.BookingsDao;
import com.humber.database.ClassesDao;
import com.humber.models.BookingClass;
import com.humber.utils.Utils;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService(endpointInterface = "com.humber.interfaces.IBooking")
public class Booking {

    public String createBooking(int userID, String scheduledDayString, int classID, String location) {
        try {
            BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
            ClassesDao classesDao = ClassesDao.getClassesDaoInstance();
      
            String className = classesDao.getClassNameByID(classID);
            String bookingDate = Utils.parseDateString(scheduledDayString);
            BookingClass booking = new BookingClass(-1, location, bookingDate, userID, className);
            int creationStatus = bookingsDao.createBooking(booking);
            if (creationStatus == 1) {
                return "success"; //User Created
            }
            return "failed";
        } catch (Exception e) {
            System.out.println("Create Booking Method Error: "+ e.toString());
        }
        return "failed";
    }
    
    public boolean deleteBooking(int bookingID) {
        BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
        return bookingsDao.deleteBooking(bookingID);
    }
    
     public List<BookingClass> getUserBookings(int userID) {
        BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
        return bookingsDao.getUserBookings(userID);
    }

}
