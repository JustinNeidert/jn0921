/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Calendar;

import java.time.LocalDate;

/**
 * This class represents a holiday, defined solely by a function to get its date within a provided year.
 * 
 * @author Justin Neidert
 */
public abstract class Holiday {
    
    /**
     * This function will get the date of this holiday within the provided year.
     * @param year The year within which to get the date of this holiday.
     * @return This returns the date of this holiday within the provided year.
     */
    public abstract LocalDate getDate(int year);
}
