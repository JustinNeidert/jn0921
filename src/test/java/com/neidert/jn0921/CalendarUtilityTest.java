/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Calendar.CalendarUtility;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the CalendarUtility class.
 * 
 * @author Justin Neidert
 */
public class CalendarUtilityTest {
    
    public CalendarUtilityTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of countWeekendDaysInRange method, of class CalendarUtility.
     */
    @org.junit.jupiter.api.Test
    public void testCountWeekendDaysInRange() {
        System.out.println("countWeekendDaysInRange");
        
        LocalDate firstDay = LocalDate.of(2021, Month.OCTOBER, 2);
        LocalDate lastDay = LocalDate.of(2021, Month.OCTOBER, 3);
        int expResult = 2;
        int result = CalendarUtility.countWeekendDaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 3);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 3);
        expResult = 1;
        result = CalendarUtility.countWeekendDaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 5);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 7);
        expResult = 0;
        result = CalendarUtility.countWeekendDaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 4);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 15);
        expResult = 2;
        result = CalendarUtility.countWeekendDaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);        
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 5);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 5);
        expResult = 0;
        result = CalendarUtility.countWeekendDaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
    }

    /**
     * Test of countHolidaysInRange method, of class CalendarUtility.
     */
    @org.junit.jupiter.api.Test
    public void testCountHolidaysInRange() {
        System.out.println("countHolidaysInRange");
        
        LocalDate firstDay = LocalDate.of(2021, Month.MARCH, 1);
        LocalDate lastDay = LocalDate.of(2021, Month.OCTOBER, 1);
        int expResult = 2;
        int result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.MARCH, 1);
        lastDay = LocalDate.of(2021, Month.AUGUST, 1);
        expResult = 1;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.AUGUST, 1);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 1);
        expResult = 1;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);   
        assertEquals(expResult, result);     
        
        firstDay = LocalDate.of(2021, Month.JULY, 4);
        lastDay = LocalDate.of(2021, Month.JULY, 4);
        expResult = 0;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);  
        assertEquals(expResult, result);   
        
        firstDay = LocalDate.of(2021, Month.JULY, 5);
        lastDay = LocalDate.of(2021, Month.JULY, 5);
        expResult = 1;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);  
        assertEquals(expResult, result);   
        
        firstDay = LocalDate.of(2021, Month.SEPTEMBER, 6);
        lastDay = LocalDate.of(2021, Month.SEPTEMBER, 6);
        expResult = 1;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.JANUARY, 1);
        lastDay = LocalDate.of(2021, Month.JULY, 3);
        expResult = 0;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay); 
        assertEquals(expResult, result);    
        
        firstDay = LocalDate.of(2021, Month.JULY, 4);
        lastDay = LocalDate.of(2025, Month.JULY, 4);
        expResult = 9;
        result = CalendarUtility.countHolidaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysInRange method, of class CalendarUtility.
     */
    @org.junit.jupiter.api.Test
    public void testDaysInRange() {
        System.out.println("daysInRange");
        LocalDate firstDay = LocalDate.of(2021, Month.OCTOBER, 4);
        LocalDate lastDay = LocalDate.of(2021, Month.OCTOBER, 6);
        int expResult = 3;
        int result = CalendarUtility.daysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 4);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 4);
        expResult = 1;
        result = CalendarUtility.daysInRange(firstDay, lastDay);
        assertEquals(expResult, result);       
        
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 4);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 3);
        expResult = 0;
        result = CalendarUtility.daysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
    }

    /**
     * Test of countWeekdaysInRange method, of class CalendarUtility.
     */
    @Test
    public void testCountWeekdaysInRange() {
        System.out.println("countWeekdaysInRange");
        
        LocalDate firstDay = LocalDate.of(2021, Month.OCTOBER, 2);
        LocalDate lastDay = LocalDate.of(2021, Month.OCTOBER, 3);
        int expResult = 0;
        int result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 3);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 3);
        expResult = 0;
        result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 5);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 5);
        expResult = 1;
        result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 3);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 16);
        expResult = 10;
        result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);        
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 2);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 17);
        expResult = 10;
        result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
        
        firstDay = LocalDate.of(2021, Month.OCTOBER, 6);
        lastDay = LocalDate.of(2021, Month.OCTOBER, 11);
        expResult = 4;
        result = CalendarUtility.countWeekdaysInRange(firstDay, lastDay);
        assertEquals(expResult, result);
    }
    
}
