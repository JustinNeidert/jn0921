/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Calendar;

import java.time.LocalDate;
import java.time.Month;

/**
 * This class represents the Labor Day holiday.
 * 
 * @author Justin Neidert
 */
public class LaborDay extends Holiday {
    
    /**
     * This function will get the date of Labor Day within the provided year.
     * @param year The year within which to get the date of Labor Day.
     * @return This returns the date of Labor Day within the provided year.
     */
    @Override
    public LocalDate getDate(int year) {
        LocalDate laborDay = LocalDate.of(year, Month.SEPTEMBER, 01); //Start with first day of September
        
        //Determine number of days between Sept 1st and Labor Day (Monday)
        int daysFromLaborDay = 0;
        
        switch (laborDay.getDayOfWeek()) {
            case SUNDAY:
                daysFromLaborDay = 1;
                break;
            case MONDAY:
                daysFromLaborDay = 0;
                break;
            case TUESDAY:
                daysFromLaborDay = 6;
                break;
            case WEDNESDAY:
                daysFromLaborDay = 5;
                break;
            case THURSDAY:
                daysFromLaborDay = 4;
                break;
            case FRIDAY:
                daysFromLaborDay = 3;
                break;
            case SATURDAY:
                daysFromLaborDay = 2;
                break;
            default:
                break;
        }
        
        laborDay = laborDay.plusDays(daysFromLaborDay); //Advance to Labor Day
        
        return laborDay;        
    }
    
}
