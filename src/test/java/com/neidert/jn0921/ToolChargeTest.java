/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the ToolCharge class.
 * 
 * @author Justin Neidert
 */
public class ToolChargeTest {
    
    public ToolChargeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getDailyChargeString method, of class ToolCharge.
     */
    @Test
    public void testGetDailyChargeString() {
        System.out.println("getDailyChargeString");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        String expResult = "$1.99";
        String result = instance.getDailyChargeString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getToolType method, of class ToolCharge.
     */
    @Test
    public void testGetToolType() {
        System.out.println("getToolType");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        String expResult = "Ladder";
        String result = instance.getToolType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDailyChargeCents method, of class ToolCharge.
     */
    @Test
    public void testGetDailyChargeCents() {
        System.out.println("getDailyChargeCents");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        int expResult = 199;
        int result = instance.getDailyChargeCents();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWeekdayCharge method, of class ToolCharge.
     */
    @Test
    public void testIsWeekdayCharge() {
        System.out.println("isWeekdayCharge");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        boolean expResult = true;
        boolean result = instance.isWeekdayCharge();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWeekendCharge method, of class ToolCharge.
     */
    @Test
    public void testIsWeekendCharge() {
        System.out.println("isWeekendCharge");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        boolean expResult = true;
        boolean result = instance.isWeekendCharge();
        assertEquals(expResult, result);
    }

    /**
     * Test of isHolidayCharge method, of class ToolCharge.
     */
    @Test
    public void testIsHolidayCharge() {
        System.out.println("isHolidayCharge");
        
        ToolCharge instance = new ToolCharge("Ladder", 199, true, true, false);
        boolean expResult = false;
        boolean result = instance.isHolidayCharge();
        assertEquals(expResult, result);
    }
    
}
