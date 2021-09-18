/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Calendar.LaborDay;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the LaborDay class.
 * 
 * @author Justin Neidert
 */
public class LaborDayTest {
    
    public LaborDayTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getDate method, of class LaborDay.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        int year = 2021;
        LaborDay instance = new LaborDay();
        LocalDate expResult = LocalDate.of(2021, Month.SEPTEMBER, 6);
        LocalDate result = instance.getDate(year);
        assertEquals(expResult, result);
        
        year = 2022;
        instance = new LaborDay();
        expResult = LocalDate.of(2022, Month.SEPTEMBER, 5);
        result = instance.getDate(year);
        assertEquals(expResult, result);
        
        year = 2025;
        instance = new LaborDay();
        expResult = LocalDate.of(2025, Month.SEPTEMBER, 1);
        result = instance.getDate(year);
        assertEquals(expResult, result);
    }
    
}
