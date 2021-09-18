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
 * Tests for the Tool class.
 * 
 * @author Justin Neidert
 */
public class ToolTest {
    
    public ToolTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getToolType method, of class Tool.
     */
    @Test
    public void testGetToolType() {
        System.out.println("getToolType");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        String expResult = "Ladder";
        String result = instance.getToolType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getToolBrand method, of class Tool.
     */
    @Test
    public void testGetToolBrand() {
        System.out.println("getToolBrand");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        String expResult = "Werner";
        String result = instance.getToolBrand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharge method, of class Tool.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        ToolCharge expResult = charge;
        ToolCharge result = instance.getCharge();
        assertTrue(DatabaseAccessorTest.chargesAreEqual(expResult, result));
    }

    /**
     * Test of setCharge method, of class Tool.
     */
    @Test
    public void testSetCharge() {
        System.out.println("setCharge");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        ToolCharge expResult = charge;
        ToolCharge result = instance.getCharge();
        assertTrue(DatabaseAccessorTest.chargesAreEqual(expResult, result));
    }

    /**
     * Test of getDailyChargeCents method, of class Tool.
     */
    @Test
    public void testGetDailyChargeCents() {
        System.out.println("getDailyChargeCents");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        int expResult = 199;
        int result = instance.getDailyChargeCents();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWeekdayCharge method, of class Tool.
     */
    @Test
    public void testIsWeekdayCharge() {
        System.out.println("isWeekdayCharge");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        boolean expResult = true;
        boolean result = instance.isWeekdayCharge();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWeekendCharge method, of class Tool.
     */
    @Test
    public void testIsWeekendCharge() {
        System.out.println("isWeekendCharge");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        boolean expResult = true;
        boolean result = instance.isWeekendCharge();
        assertEquals(expResult, result);
    }

    /**
     * Test of isHolidayCharge method, of class Tool.
     */
    @Test
    public void testIsHolidayCharge() {
        System.out.println("isHolidayCharge");
        
        Tool instance = new Tool("LADW", "Ladder", "Werner");
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        instance.setCharge(charge);
        boolean expResult = false;
        boolean result = instance.isHolidayCharge();
        assertEquals(expResult, result);
    }
    
}
