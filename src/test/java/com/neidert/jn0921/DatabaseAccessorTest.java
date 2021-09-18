/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import com.neidert.jn0921.Exception.ToolTypeInvalidException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the DatabaseAccessor class.
 * 
 * @author Justin Neidert
 */
public class DatabaseAccessorTest {
    
    public DatabaseAccessorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getToolWithCharge method, of class DatabaseAccessor.
     */
    @Test
    public void testGetToolWithCharge() {
        System.out.println("getToolWithCharge");
        
        
        String toolCode = "LADW";
        ToolCharge charge = new ToolCharge("Ladder", 199, true, true, false);
        Tool expResult = new Tool("LADW", "Ladder", "Werner");
        expResult.setCharge(charge);
        try {
            Tool result = DatabaseAccessor.getToolWithCharge(toolCode);
            assertTrue(toolsAreEqual(expResult, result));

            toolCode = "CHNS";
            charge = new ToolCharge("Chainsaw", 149, true, false, true);
            expResult = new Tool("CHNS", "Chainsaw", "Stihl");
            expResult.setCharge(charge);
            result = DatabaseAccessor.getToolWithCharge(toolCode);
            assertTrue(toolsAreEqual(expResult, result));

            toolCode = "JAKR";
            charge = new ToolCharge("Jackhammer", 299, true, false, false);
            expResult = new Tool("JAKR", "Jackhammer", "Ridgid");
            expResult.setCharge(charge);
            result = DatabaseAccessor.getToolWithCharge(toolCode);
            assertTrue(toolsAreEqual(expResult, result));

            toolCode = "JAKD";
            charge = new ToolCharge("Jackhammer", 299, true, false, false);
            expResult = new Tool("JAKD", "Jackhammer", "DeWalt");
            expResult.setCharge(charge);
            result = DatabaseAccessor.getToolWithCharge(toolCode);
            assertTrue(toolsAreEqual(expResult, result));
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getMessage());
        }
        
        boolean exceptionCaught = false;
        try {
            toolCode = "ABCD";
            Tool result = DatabaseAccessor.getToolWithCharge(toolCode);
        } catch (ToolCodeInvalidException ex) {
            exceptionCaught = true;
        } catch (ToolTypeInvalidException ex) {
            fail("ToolTypeInvalidException thrown: " + ex.getMessage());
        }
        assertTrue(exceptionCaught);
    }

    /**
     * Test of getTool method, of class DatabaseAccessor.
     */
    @Test
    public void testGetTool() {
        System.out.println("getTool");
        
        try {
            String toolCode = "LADW";
            Tool expResult = new Tool("LADW", "Ladder", "Werner");
            Tool result = DatabaseAccessor.getTool(toolCode);
            assertTrue(toolsAreEqualWithoutCharge(expResult, result));

            toolCode = "CHNS";
            expResult = new Tool("CHNS", "Chainsaw", "Stihl");
            result = DatabaseAccessor.getTool(toolCode);
            assertTrue(toolsAreEqualWithoutCharge(expResult, result));

            toolCode = "JAKR";
            expResult = new Tool("JAKR", "Jackhammer", "Ridgid");
            result = DatabaseAccessor.getTool(toolCode);
            assertTrue(toolsAreEqualWithoutCharge(expResult, result));

            toolCode = "JAKD";
            expResult = new Tool("JAKD", "Jackhammer", "DeWalt");
            result = DatabaseAccessor.getTool(toolCode);
            assertTrue(toolsAreEqualWithoutCharge(expResult, result));
        } catch(Exception ex) {
            fail("Exception thrown: " + ex.getMessage());
        }
        
        boolean exceptionCaught = false;
        try {
            String toolCode = "ABCD";
            Tool result = DatabaseAccessor.getTool(toolCode);
        } catch (ToolCodeInvalidException ex) {
            exceptionCaught = true;
        } 
        assertTrue(exceptionCaught);
    }

    /**
     * Test of getToolCharge method, of class DatabaseAccessor.
     */
    @Test
    public void testGetToolCharge() {
        System.out.println("getToolCharge");
        
        try {
            String toolType = "Ladder";
            ToolCharge expResult = new ToolCharge("Ladder", 199, true, true, false);
            ToolCharge result = DatabaseAccessor.getToolCharge(toolType);
            assertTrue(chargesAreEqual(expResult, result));

            toolType = "Chainsaw";
            expResult = new ToolCharge("Chainsaw", 149, true, false, true);
            result = DatabaseAccessor.getToolCharge(toolType);
            assertTrue(chargesAreEqual(expResult, result));

            toolType = "Jackhammer";
            expResult = new ToolCharge("Jackhammer", 299, true, false, false);
            result = DatabaseAccessor.getToolCharge(toolType);
            assertTrue(chargesAreEqual(expResult, result));
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getMessage());            
        }        
        
        boolean exceptionCaught = false;
        try {
            String toolType = "abcdefgh";
            ToolCharge result = DatabaseAccessor.getToolCharge(toolType);
        } catch (ToolTypeInvalidException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);        
    }
    
    public static boolean chargesAreEqual(ToolCharge charge1, ToolCharge charge2) {
        return (charge1.isHolidayCharge() == charge2.isHolidayCharge()) 
                && (charge1.isWeekdayCharge() == charge2.isWeekdayCharge())
                && (charge1.isWeekendCharge() == charge2.isWeekendCharge())
                && (charge1.getDailyChargeCents() == charge2.getDailyChargeCents())
                && (charge1.getToolType().equals(charge2.getToolType()));
    }
    
    private boolean toolsAreEqual(Tool tool1, Tool tool2) {
        return toolsAreEqualWithoutCharge(tool1, tool2) && chargesAreEqual(tool1.getCharge(), tool2.getCharge());
    }
    
    private boolean toolsAreEqualWithoutCharge(Tool tool1, Tool tool2) {
        return (tool1.getToolType().equals(tool2.getToolType())
                && tool1.getToolBrand().equals(tool2.getToolBrand()));
    }
}
