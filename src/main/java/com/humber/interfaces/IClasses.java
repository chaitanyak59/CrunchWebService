/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.interfaces;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService
public interface IClasses {
    @WebMethod(operationName = "getClassNameByID")
    public String getClassNameByID(int classID);  
}
