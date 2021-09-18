/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the StringFormatter class.
 * 
 * @author Justin Neidert
 */
public class StringFormatterTest {
    
    public StringFormatterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of dateToString method, of class StringFormatter.
     */
    @Test
    public void testDateToString() {
        System.out.println("dateToString");
        
        LocalDate date = LocalDate.of(2021, Month.MARCH, 20);
        String format = "MM/dd/YYYY";
        String expResult = "03/20/2021";
        String result = StringFormatter.dateToString(date, format);
        assertEquals(expResult, result);
        
        date = LocalDate.of(2020, Month.FEBRUARY, 29);
        format = "MM/dd/YYYY";
        expResult = "02/29/2020";
        result = StringFormatter.dateToString(date, format);
        assertEquals(expResult, result);
    }

    /**
     * Test of centsToCurrencyString method, of class StringFormatter.
     */
    @Test
    public void testCentsToCurrencyString() {
        System.out.println("centsToCurrencyString");
        
        int cents = 1234567;
        String expResult = "$12,345.67";
        String result = StringFormatter.centsToCurrencyString(cents);
        assertEquals(expResult, result);
        
        cents = 1234567890;
        expResult = "$12,345,678.90";
        result = StringFormatter.centsToCurrencyString(cents);
        assertEquals(expResult, result);
        
        cents = 100;
        expResult = "$1.00";
        result = StringFormatter.centsToCurrencyString(cents);
        assertEquals(expResult, result);
        
        cents = 50;
        expResult = "$0.50";
        result = StringFormatter.centsToCurrencyString(cents);
        assertEquals(expResult, result);
        
        cents = 0;
        expResult = "$0.00";
        result = StringFormatter.centsToCurrencyString(cents);
        assertEquals(expResult, result);
    }

    /**
     * Test of percentToString method, of class StringFormatter.
     */
    @Test
    public void testPercentToString() {
        System.out.println("percentToString");
        
        int percent = 0;
        String expResult = "0%";
        String result = StringFormatter.percentToString(percent);
        assertEquals(expResult, result);
        
        percent = 10;
        expResult = "10%";
        result = StringFormatter.percentToString(percent);
        assertEquals(expResult, result);
        
        percent = 99;
        expResult = "99%";
        result = StringFormatter.percentToString(percent);
        assertEquals(expResult, result);
        
        percent = 100;
        expResult = "100%";
        result = StringFormatter.percentToString(percent);
        assertEquals(expResult, result);
        
        percent = 101;
        expResult = "101%";
        result = StringFormatter.percentToString(percent);
        assertEquals(expResult, result);
    }
    
}
