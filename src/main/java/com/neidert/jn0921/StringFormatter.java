/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class contains all of the utility functions relating to translating some object into
 * its desirable String counterpart.
 * 
 * @author Justin Neidert
 */
public class StringFormatter {
    
    /**
     * This function converts a date to a string.
     * @param date This is the date to convert to a string.
     * @param format This describes the format to which the date should be converted.
     * @return This returns the String representation of date in the provided format.
     */
    public static String dateToString(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * This function converts a cent value to a currency string of format "$99,999.99".
     * @param cents This is the cent value to convert to a string.
     * @return This returns the currency String representation of cents.
     */
    public static String centsToCurrencyString(int cents) {        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String currencyStr = formatter.format(((double)cents)/100.0d);
        return currencyStr;
    }
    
    /**
     * This function converts a percent value to a string of format "99%".
     * @param percent This is the percent value to convert to a string.
     * @return This returns the String representation of percent.
     */
    public static String percentToString(int percent) {
        return percent + "%";
    }
}
