/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Calendar;

import com.neidert.jn0921.Calendar.Holiday;
import com.neidert.jn0921.Calendar.LaborDay;
import com.neidert.jn0921.Calendar.July4th;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Holds all utility functions relating to calendar days comparison and 
 * manipulation not already available in the LocalDate class
 * 
 * @author Justin Neidert
 */
public class CalendarUtility {
    /**
     * Array of holidays with potential for no charge.
     */
    private static Holiday[] holidays = new Holiday[]{new July4th(), new LaborDay()};
    
    /**
     * This function returns true if @date is on or between firstDay and lastDay, and false otherwise. 
     * @param date This is the date to check if in range.
     * @param firstDay This is the first day of the range (inclusive).
     * @param lastDay This is the last day of the range (inclusive).
     * @return This is true if date is on or between firstDay and lastDay, and false otherwise. 
     */
    private static boolean isInRange(LocalDate date, LocalDate firstDay, LocalDate lastDay) {
        return !(date.isBefore(firstDay) || date.isAfter(lastDay));
    }
    
    /**
     * This function counts the number of weekdays on or between firstDay and lastDay.
     * @param firstDay This is the first day of the range to count.  The range includes this date.
     * @param lastDay This is the last day of the range to count.  The range includes this date.
     * @return This is the number of weekdays on or between firstDay and lastDay.
     */
    public static int countWeekdaysInRange(LocalDate firstDay, LocalDate lastDay) {
        int weekdays = 0;
        
        //Advance first day to the next Sunday (if first day isn't already Sunday)
        switch (firstDay.getDayOfWeek()) {
            case MONDAY:
                firstDay = firstDay.plusDays(6);
                weekdays += 5;
                break;
            case TUESDAY:
                firstDay = firstDay.plusDays(5);
                weekdays += 4;
                break;
            case WEDNESDAY:
                firstDay = firstDay.plusDays(4);
                weekdays += 3;
                break;
            case THURSDAY:
                firstDay = firstDay.plusDays(3);
                weekdays += 2;
                break;
            case FRIDAY:
                firstDay = firstDay.plusDays(2);
                weekdays ++;
                break;
            case SATURDAY:
                firstDay = firstDay.plusDays(1);
                break;
            default:
                break;
        }            
        
        //Advance last day to the next Sunday (if last day isn't already Sunday)
        switch (lastDay.getDayOfWeek()) {
            case MONDAY:
                lastDay = lastDay.plusDays(6);
                weekdays -= 4;
                break;
            case TUESDAY:
                lastDay = lastDay.plusDays(5);
                weekdays -= 3;
                break;
            case WEDNESDAY:
                lastDay = lastDay.plusDays(4);
                weekdays -= 2;
                break;
            case THURSDAY:
                lastDay = lastDay.plusDays(3);
                weekdays --;
                break;
            case FRIDAY:
                lastDay = lastDay.plusDays(2);
                break;
            case SATURDAY:
                lastDay = lastDay.plusDays(1);
                break;
            default:
                break;
        } 
        
        //Add 5 days per week in the new range
        weekdays += 5 * (DAYS.between(firstDay, lastDay) / 7);
            
        return weekdays;
    }
    
    /**
     * This function counts the number of Saturdays and Sundays on or between firstDay and lastDay.
     * @param firstDay This is the first day of the range to count.  The range includes this date.
     * @param lastDay This is the last day of the range to count.  The range includes this date.
     * @return This is the number of Saturdays and Sundays on or between firstDay and lastDay.
     */
    public static int countWeekendDaysInRange(LocalDate firstDay, LocalDate lastDay) {
        int weekendDays = 0;
        
        //Advance first day to the next Sunday (if first day isn't already Sunday)
        switch (firstDay.getDayOfWeek()) {
            case SUNDAY:
                firstDay = firstDay.plusDays(1);
                weekendDays++;
                break;
            case TUESDAY:
                firstDay = firstDay.plusDays(6);
                weekendDays += 2;
                break;
            case WEDNESDAY:
                firstDay = firstDay.plusDays(5);
                weekendDays += 2;
                break;
            case THURSDAY:
                firstDay = firstDay.plusDays(4);
                weekendDays += 2;
                break;
            case FRIDAY:
                firstDay = firstDay.plusDays(3);
                weekendDays += 2;
                break;
            case SATURDAY:
                firstDay = firstDay.plusDays(2);
                weekendDays += 2;
                break;
            default:
                break;
        }            
        
        //Advance last day to the next Sunday (if last day isn't already Sunday)
        switch (lastDay.getDayOfWeek()) {
            case SUNDAY:
                lastDay = lastDay.plusDays(1);
                break;
            case TUESDAY:
                lastDay = lastDay.plusDays(6);
                weekendDays -= 2;
                break;
            case WEDNESDAY:
                lastDay = lastDay.plusDays(5);
                weekendDays -= 2;
                break;
            case THURSDAY:
                lastDay = lastDay.plusDays(4);
                weekendDays -= 2;
                break;
            case FRIDAY:
                lastDay = lastDay.plusDays(3);
                weekendDays -= 2;
                break;
            case SATURDAY:
                lastDay = lastDay.plusDays(2);
                weekendDays--;
                break;
            default:
                break;
        } 
        
        //Add 2 days per week in the new range
        weekendDays += 2 * (DAYS.between(firstDay, lastDay) / 7);
            
        return weekendDays;
    }
    
    /**
     * This function counts the number of holidays (defined by the array, holidays) on or between firstDay and lastDay.
     * @param firstDay This is the first day of the range to count.  The range includes this date.
     * @param lastDay This is the last day of the range to count.  The range includes this date.
     * @return This is the number of holidays (defined by the array, holidays) on or between firstDay and lastDay.
     */
    public static int countHolidaysInRange(LocalDate firstDay, LocalDate lastDay) {
        int holidayCount = 0;
        
        LocalDate currentHoliday;
        for(Holiday holiday : holidays) {
            for(int year = firstDay.getYear(); year <= lastDay.getYear(); year++) {
                currentHoliday = getNearestWeekday(holiday.getDate(year));
                if(isInRange(currentHoliday, firstDay, lastDay))
                    holidayCount++;
            }
        }
        
        return holidayCount;
    }
    
    /**
     * This function counts the total number of days on or between firstDay and lastDay.
     * @param firstDay This is the first day of the range to count.  The range includes this date.
     * @param lastDay This is the last day of the range to count.  The range includes this date.
     * @return This is the total number of days on or between firstDay and lastDay.
     */
    public static int daysInRange(LocalDate firstDay, LocalDate lastDay) {
        return (int)DAYS.between(firstDay.minusDays(1), lastDay);
    }
    
    /**
     * This function will return the date of the weekday nearest to the provided date. Saturdays 
     * yield the preceding Friday, and Sunday yields the following Monday.
     * @param date The date to find the nearest weekday to. 
     * @return If date is a weekday, this returns date.  If date is a Saturday, this returns the 
     * preceding Friday.  If date is a Sunday, this returns the following Monday.
     */
    private static LocalDate getNearestWeekday(LocalDate date) {
        LocalDate weekday;
        
        switch (date.getDayOfWeek()) {
            case SUNDAY:
                weekday = date.plusDays(1);
                break;
            case SATURDAY:
                weekday = date.minusDays(1);
                break;
            default :
                weekday = date;
        }
        
        return weekday;
    }
}
