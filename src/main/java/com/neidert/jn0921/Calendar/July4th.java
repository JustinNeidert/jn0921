/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Calendar;

import java.time.LocalDate;
import java.time.Month;

/**
 * This class represents the July 4th holiday.
 * 
 * @author Justin Neidert
 */
public class July4th extends Holiday {
    
    /**
     * This function will get the date of July 4th within the provided year.
     * @param year The year within which to get date of July 4th.
     * @return This returns the date of July 4th within the provided year.
     */
    @Override
    public LocalDate getDate(int year) {
        return LocalDate.of(year, Month.JULY, 4);
    }
    
}
